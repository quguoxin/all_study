package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.PageBean;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Userinfo;
import com.qgx.www.entity.YouBi;
import com.qgx.www.service.YouBiService;
import com.qgx.www.service.impl.YouBiServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(urlPatterns = "/getYoubi.s")
public class YouBiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost( req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收数据
        HttpSession session=req.getSession();
        String phone= (String) session.getAttribute( "loginUser" );//接收卡号
        String pageNo = req.getParameter( "pageNo" );
        int pageSize=10;//一页显示的条数
        //调用业务
        YouBiService youBiService=new YouBiServiceImpl();
        List<YouBi> list= youBiService.findListByPage( Integer.parseInt( pageNo ),pageSize );
        Userinfo userinfo=youBiService.findYbBalance(phone );
        double yb_balance=userinfo.getYb_balance();
        int totalCount=youBiService.findCount();
        int totalPage=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
        PageBean<YouBi> pageBean= new PageBean<YouBi>(Integer.parseInt( pageNo ),pageSize,totalPage,totalCount,list,yb_balance );
        //响应结果
        PrintWriter printWriter=resp.getWriter();
        ResponseBody responseBody=new ResponseBody(  );
        responseBody.setCode( 200 );
        responseBody.setMsg( "订单列表信息" );
        responseBody.setData(pageBean);
        printWriter.write( JSON.toJSONString(responseBody) );
    }
}
