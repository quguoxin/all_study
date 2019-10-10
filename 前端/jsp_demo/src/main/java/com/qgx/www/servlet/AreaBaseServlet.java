package com.qgx.www.servlet;


import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.AreaBaseInfo;
import com.qgx.www.service.impl.AreaBaseInfoServersImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet(urlPatterns = "/areabase.s")
public class AreaBaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String p=req.getParameter("p");
        String area_code=req.getParameter("area_code");
        AreaBaseInfoServersImpl servers=new AreaBaseInfoServersImpl();
        List<AreaBaseInfo> list=null;
        if(p==null) {
             list = servers.findProvince();
        }else {
            list = servers.findCityOrCity(area_code);
        }
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setData(list);

        PrintWriter printWriter=resp.getWriter();
        printWriter.write(JSON.toJSONString(responseBody));

    }
}
