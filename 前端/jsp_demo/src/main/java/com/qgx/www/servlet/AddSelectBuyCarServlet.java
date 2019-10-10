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
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/addSelectBuyCar.s")
public class AddSelectBuyCarServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        HttpSession session=req.getSession();
        String[] pruduct_codeArray = req.getParameter("obj1").split("-");
        String phone= (String) session.getAttribute("loginUser");//phone



        //处理业务
        List<Product> productList=new ArrayList<Product>();
        HistoryBuyDelService historyBuyDelService=new HistoryBuyDelServiceImpl();
        for(int i=0;i<pruduct_codeArray.length;i++){
            productList.add(historyBuyDelService.getProduct(pruduct_codeArray[i]));
        }
        int uid=historyBuyDelService.getUserinfo(phone).getId();
        int ok=historyBuyDelService.addSelectBuyCar(uid,productList);
        if(ok<=0){
            return;
        }

        //响应
        //响应
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("批量添加购物车");
        responseBody.setData(null);
        printWriter.write(JSON.toJSONString(responseBody));
    }
}
