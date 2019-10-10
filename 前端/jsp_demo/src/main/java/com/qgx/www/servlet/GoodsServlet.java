package com.qgx.www.servlet;

import com.qgx.www.entity.Goods;
import com.qgx.www.service.GoodsService;
import com.qgx.www.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@WebServlet(urlPatterns = "/showAll.s",initParams ={@WebInitParam(name="encoding",value = "utf-8")})
public class GoodsServlet extends HttpServlet {
    private GoodsService goodsService=new GoodsServiceImpl();
    private String encoding;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding(encoding);
        //创建作用域对象
        HttpSession session=req.getSession();
        //展示列表功能
        List<Goods> list=new ArrayList<Goods>();
        list=goodsService.show();//保存在集合中
        session.setAttribute("goodslist",list);
        session.setAttribute("time",new Date());
        resp.sendRedirect("goods.jsp");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {
        encoding=super.getInitParameter("encoding");//获取编码
    }
}
