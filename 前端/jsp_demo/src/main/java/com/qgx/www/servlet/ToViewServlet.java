package com.qgx.www.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/toview.s")
public class ToViewServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vn=req.getParameter("vn");
        String path="";
        if(vn.equals("myOrder")){
            path="/WEB-INF/myOrder.jsp";
        }else if(vn.equals("accountBalance")){
            path="/WEB-INF/accountBalance.jsp";
        }else if(vn.equals("address")){
            path="/WEB-INF/address.jsp";
        }else if(vn.equals("myDiscountCoupon")){
            path="/WEB-INF/myDiscountCoupon.jsp";
        }else if(vn.equals("personalData")){
            path="/WEB-INF/personalData.jsp";
        }else if(vn.equals("main")){
            path="/WEB-INF/main.jsp";
        }else if(vn.equals("orderDetail")){
            path="/WEB-INF/orderDetail.jsp";
        }else if(vn.equals("historyBuy")){
            path="/WEB-INF/historyBuy.jsp";
        }else if(vn.equals("myCollects")){
            path="/WEB-INF/myCollects.jsp";
        }else if(vn.equals("productList")){
            path="/WEB-INF/productList.jsp";
        }else if(vn.equals("youbi")){
            path="/WEB-INF/youbi.jsp";
        }else if(vn.equals("income_statement")){
            path="/WEB-INF/income_statement.jsp";
        }else if(vn.equals("recharge")){
            path="/WEB-INF/income_recharge.jsp";
        }else if(vn.equals("income")){
            path="/WEB-INF/income_statement.jsp";
        }else if(vn.equals("gouwuche")){
            path="/WEB-INF/myshopping.jsp";
        }else if(vn.equals("takegood")){
            path="/WEB-INF/takegood.jsp";
        }
        req.getRequestDispatcher(path).forward(req,resp);
    }
}
