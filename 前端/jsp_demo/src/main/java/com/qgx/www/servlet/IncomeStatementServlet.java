package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Income_statement;
import com.qgx.www.service.IncomeStatementService;
import com.qgx.www.service.UserinfoService;
import com.qgx.www.service.impl.IncomeStatementServiceImpl;
import com.qgx.www.service.impl.UserinfoServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/getIncomeStatement.s")
public class IncomeStatementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost( req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收数据
        HttpSession session=req.getSession();
        String cardNo= (String) session.getAttribute( "loginUser" );//接收卡号

        //调用业务
        IncomeStatementService discountCouponService=new IncomeStatementServiceImpl();
        List<Income_statement> list= discountCouponService.findCardNoByIncomeStatement(cardNo);

        //响应结果
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody(  );
        responseBody.setCode( 200 );
        responseBody.setMsg( "订单列表信息" );
        responseBody.setData(list);
        printWriter.write( JSON.toJSONString(responseBody) );

    }
}
