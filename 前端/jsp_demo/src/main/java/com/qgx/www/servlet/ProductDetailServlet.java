package com.qgx.www.servlet;

import com.alibaba.fastjson.JSON;
import com.qgx.www.entity.Product;
import com.qgx.www.service.ProductDetailService;
import com.qgx.www.service.impl.ProductDetailServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/getProductDetail.s")
public class ProductDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        HttpSession session=req.getSession();
        String product_code= req.getParameter("qgx");
        //调用业务
        ProductDetailService productDetailService=new ProductDetailServiceImpl();
        Product p=productDetailService.findProductById(product_code);

        //返回结果
        session.setAttribute("product",p);
        req.getRequestDispatcher("WEB-INF/productDetail.jsp?product_code="+product_code).forward(req,resp);
       /* ResponeBody responeBody=new ResponeBody();
        responeBody.setCode(200);
        responeBody.setData(p);
        responeBody.setMsg("商品信息");
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(JSON.toJSONString(responeBody));*/

    }
}
