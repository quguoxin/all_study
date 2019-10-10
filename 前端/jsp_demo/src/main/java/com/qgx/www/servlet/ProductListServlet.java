package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.PageBean;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Product;
import com.qgx.www.service.ProductListService;
import com.qgx.www.service.impl.ProductListServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/getProductList.s")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //接收参数
     String pageNo=req.getParameter("pageNo");
     String product_type=req.getParameter("product_type");
     String orderType=req.getParameter("orderType");

     int pageSize=100;
    //调用业务
     ProductListService productListService=new ProductListServiceImpl();
     List<Product> list =productListService.findProductByPageNo(Integer.parseInt(pageNo),pageSize,product_type,orderType);
     int totalCount = productListService.findCount(product_type,orderType);//在数据库中执行统计查询
     int totalPage = (totalCount % pageSize == 0) ? (totalCount / pageSize) : ((totalCount / pageSize) + 1);
    //返回结果
      ResponseBody responseBody=new ResponseBody();
      PageBean<Product> pageBean =new PageBean<Product>(Integer.parseInt(pageNo),pageSize,totalCount,totalPage,list);
      responseBody.setCode(200);
      responseBody.setData(pageBean);
      responseBody.setMsg("商品详情");
      PrintWriter printWriter=resp.getWriter();
      printWriter.write(JSON.toJSONString(responseBody));
    }
}
