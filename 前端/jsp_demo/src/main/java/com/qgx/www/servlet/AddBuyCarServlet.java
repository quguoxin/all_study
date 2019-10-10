package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Product;
import com.qgx.www.service.HistoryBuyDelService;
import com.qgx.www.service.impl.HistoryBuyDelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/addBuyCar.s")
public class AddBuyCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        int productNum=1;
        HttpSession session=req.getSession();
        String phone= (String) session.getAttribute("loginUser");//phone
        String product_code=req.getParameter("obj");
        productNum= Integer.parseInt(req.getParameter("productNum"));

        //业务
        //Product product=new Product(id,product_code,product_name,price,prodect_img);//封装商品对象
        HistoryBuyDelService historyBuyDelService=new HistoryBuyDelServiceImpl();
        Product product=historyBuyDelService.getProduct(product_code);
        int uid=historyBuyDelService.getUserinfo(phone).getId();//获取用户uid

        int a=historyBuyDelService.addByCar(uid,product,productNum);//执行添加
        if(a!=1){
            return;
        }

        //响应
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("单个添加购物车");
        responseBody.setData(null);
        printWriter.write(JSON.toJSONString(responseBody));
    }
}
