package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.GetShopDataBean;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.service.GetShopDataService;
import com.qgx.www.service.impl.GetShopDataServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/getShopData.s")
public class GetShopDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetShopDataService getShopDataService=new GetShopDataServiceImpl();
        int totalNum=getShopDataService.getShopProductNum();
        String totalPrice=getShopDataService.getShopProductTotalPrice();


        //响应
        PrintWriter printWriter=resp.getWriter();
        GetShopDataBean getShopDataBean=new GetShopDataBean(totalNum,totalPrice);
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("获取购物车内总数量和价格");
        responseBody.setData(getShopDataBean);
        printWriter.write(JSON.toJSONString(responseBody));


    }


}
