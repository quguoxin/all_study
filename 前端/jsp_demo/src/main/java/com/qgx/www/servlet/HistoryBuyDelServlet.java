package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.service.HistoryBuyDelService;
import com.qgx.www.service.impl.HistoryBuyDelServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/delHistoryBuy.s")
public class HistoryBuyDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String id=req.getParameter("id");
        //业务
        HistoryBuyDelService historyBuyDelService=new HistoryBuyDelServiceImpl();
        Boolean isok=historyBuyDelService.delHistoryBuy(Integer.parseInt(id));
        if(!isok){
            return;
        }
        //响应
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("删除购买过得商品里面的商品");
        responseBody.setData(null);
        printWriter.write(JSON.toJSONString(responseBody));
    }
}
