package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Shopping;
import com.qgx.www.service.MyShoppingService;
import com.qgx.www.service.impl.MyShoppingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/getMyShopping.s")
public class MyShoppingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String pageNo=req.getParameter("pageNo");
        HttpSession session=req.getSession();
        String phone= (String) session.getAttribute("loginUser");//phone
        int pageSize=100;
        MyShoppingService myShoppingService=new MyShoppingServiceImpl();
       List<Shopping> list= myShoppingService.findMyShoppingList(Integer.parseInt(pageNo),pageSize,phone);
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("购物车信息列表");
        responseBody.setData(list);
        printWriter.write(JSON.toJSONString(responseBody));
    }
}
