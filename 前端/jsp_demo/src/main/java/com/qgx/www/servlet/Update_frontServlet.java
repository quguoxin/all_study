package com.qgx.www.servlet;

import com.qgx.www.entity.Goods;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/update_front.s",initParams ={@WebInitParam(name="encoding",value = "utf-8")})
public class Update_frontServlet extends HttpServlet {
    private String encoding;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding(encoding);
        //创建作用域
        HttpSession session=req.getSession();
        int goodno= Integer.parseInt(req.getParameter("no"));
        String goodname=req.getParameter("name");
        double goodprice= Double.parseDouble(req.getParameter("price"));
        int goodnum= Integer.parseInt(req.getParameter("num"));
        Goods goods2=new Goods(goodno,goodname,goodprice,goodnum);
        session.setAttribute("goods2",goods2);
        req.getRequestDispatcher("/WEB-INF/update.jsp").forward(req,resp);
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {
        encoding=super.getInitParameter("encoding");//获取编码
    }
}
