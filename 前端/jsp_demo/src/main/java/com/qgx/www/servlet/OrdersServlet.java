package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.PageBean;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Orders;
import com.qgx.www.service.OrdersService;
import com.qgx.www.service.impl.OrdersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/getOrders.s")
public class OrdersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        String pageNo=req.getParameter("pageNo");
        //从登陆接收phone即用户名
        HttpSession session=req.getSession();
        String phone= (String) session.getAttribute("loginUser");
        String order_statu=req.getParameter("order_statu");//订单状态
        int pageSize=2;//一页显示的条数

        //调用业务
        //查询登录用户的订单
        OrdersService ordersService=new OrdersServiceImpl();
        List<Orders> list=ordersService.findOrdersListByPageNo(Integer.parseInt(pageNo),pageSize,phone,order_statu);

        //总数据结果条数
        int totalCount=ordersService.findCount(phone,order_statu);
        //转化为总页码
        int totalPage=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
        //由于responseBody不能同时传递这么多属性，
        // 创建PageBean将信息都封装到PageBean中，再利用responseBody将所有数据传过去
        PageBean<Orders> pageBean=new PageBean<Orders>(Integer.parseInt(pageNo),pageSize,totalPage,totalCount,list);
        //响应结果
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("订单信息");
        responseBody.setData(pageBean);
        printWriter.write(JSON.toJSONString(responseBody));
    }
}
