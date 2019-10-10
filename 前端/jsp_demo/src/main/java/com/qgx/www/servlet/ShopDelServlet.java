package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;

import com.qgx.www.bean.ResponseBody;
import com.qgx.www.service.MyShoppingService;
import com.qgx.www.service.impl.MyShoppingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/shopDel.s")
public class ShopDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String ids=req.getParameter("ids");
        MyShoppingService myShoppingService=new MyShoppingServiceImpl();
        boolean isdel= myShoppingService.delBySelect(ids);
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("删除所选成功");
        responseBody.setData(null);
        printWriter.write(JSON.toJSONString(responseBody));
    }
}
