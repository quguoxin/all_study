package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.PageBean;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Buy_product;
import com.qgx.www.entity.Orders;
import com.qgx.www.entity.Product;
import com.qgx.www.service.HistoryBuyService;
import com.qgx.www.service.impl.HistoryBuyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@WebServlet(urlPatterns = "/doHistoryBuy.s")
public class HistoryBuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //获取参数
        //从登陆接收phone即用户名
        HttpSession session=req.getSession();
        String phone= (String) session.getAttribute("loginUser");//phone
        int pageSize=3;//一页显示的条数
        String pageNo=req.getParameter("pageNo");

        //业务处理
        HistoryBuyService historyBuyService=new HistoryBuyServiceImpl();
        List<Product> productList=historyBuyService.getHistoryProduct(Integer.parseInt(pageNo),pageSize,phone);
        int totalCount=historyBuyService.grtCount(phone);
        int totalPage=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);//总页码
        PageBean<Product> pageBean=new PageBean<Product>(Integer.parseInt(pageNo),pageSize,totalPage,totalCount,productList);


        //响应
        ResponseBody responseBody=new ResponseBody();
        responseBody.setMsg("所有购买过得商品");
        responseBody.setCode(200);
        responseBody.setData(pageBean);
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(JSON.toJSONString(responseBody));
    }

}
