package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.OrderDetailInfoBrean;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Address;
import com.qgx.www.entity.Product;
import com.qgx.www.service.OrderDetailService;
import com.qgx.www.service.impl.OrderDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/getOrderDetail.s")
public class OrderDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        //获取订单里面的商品集合字符串
        String product_list=req.getParameter("product_listNo");//先手动
        //获取用户
        HttpSession session=req.getSession();
        String phone= (String) session.getAttribute("loginUser");

        //调用业务
        //查地址
        OrderDetailService orderDetailService=new OrderDetailServiceImpl();
        List<Address> addressList=orderDetailService.getAddress(phone);
        //由商品编号集合查商品集合
        List<Product> productList=orderDetailService.grtProduct(product_list);

        //响应结果
        OrderDetailInfoBrean orderDetailInfoBrean=new OrderDetailInfoBrean(addressList,productList);
        ResponseBody responseBody=new ResponseBody();
        PrintWriter printWriter=resp.getWriter();
        responseBody.setCode(200);
        responseBody.setMsg("订单详情信息");
        responseBody.setData(orderDetailInfoBrean);
        printWriter.write(JSON.toJSONString(responseBody));
    }
}
