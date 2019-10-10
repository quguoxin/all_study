package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Userinfo;
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

@WebServlet(urlPatterns = "/addMyCollects.s")
public class AddMyCollectsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接受参数
        int product_id= Integer.parseInt(req.getParameter("obj3"));
        HttpSession session=req.getSession();
        String phone= (String) session.getAttribute("loginUser");//phone

        //处理
        HistoryBuyDelService historyBuyDelService=new HistoryBuyDelServiceImpl();
        Userinfo userinfo= historyBuyDelService.getUserinfo(phone);
        Boolean ok=historyBuyDelService.addMyCollects(userinfo.getId(),product_id);
       if(!ok){
           return;
       }
        //响应
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("加入收藏");
        responseBody.setData(null);
        printWriter.write(JSON.toJSONString(responseBody));
    }
}
