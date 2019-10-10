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

@WebServlet(urlPatterns = "/myCollectDelAll.s")
public class MyCollectDelAll extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String[] product_idArray=req.getParameter("obj3").split("-");


        //业务
        HistoryBuyDelService historyBuyDelService=new HistoryBuyDelServiceImpl();
        Boolean ok=historyBuyDelService.delAlldelMyCollects(product_idArray);
        if(!ok){
            return;
        }

        //响应
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("删除收藏商品");
        responseBody.setData(null);
        printWriter.write(JSON.toJSONString(responseBody));
    }
}
