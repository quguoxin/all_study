package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Area_base;
import com.qgx.www.service.AreaBaseService;
import com.qgx.www.service.impl.AreaBaseServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/getProvinceCityArea.s")
public class ProvinceCityAreaServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //接收参数
        String p= req.getParameter("p");//获取类型
        String area_code =req.getParameter("area_code");
        ResponseBody responseBody=new ResponseBody();
        //调用业务
        AreaBaseService areaBaseService=new AreaBaseServiceImpl();
        List<Area_base> provinceCityArea=new ArrayList<Area_base>();//创建集合
        if(p==null){//省
            responseBody.setMsg("所有省的列表");
            provinceCityArea=areaBaseService.findAllProvience();
        }else if(p.equals("city")){//市
            responseBody.setMsg("市的列表");
            provinceCityArea=areaBaseService.findCityByProvience(area_code);
        }else if(p.equals("area")){//区
            responseBody.setMsg("区的列表");
            provinceCityArea=areaBaseService.findAreaByCity(area_code);
        }
        //响应
        PrintWriter printWriter=resp.getWriter();
        responseBody.setCode(200);
        responseBody.setData(provinceCityArea);//传数据
        printWriter.write(JSON.toJSONString(responseBody));


    }
}