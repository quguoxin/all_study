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

@WebServlet(urlPatterns = "/update.s",initParams ={@WebInitParam(name="encoding",value = "utf-8")})
public class UpdateSerlet extends HttpServlet {
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
        //创建作用域
        //HttpSession session=req.getSession();
        //接收参数
        String goodname=req.getParameter("goodname");
        double goodprice= Double.parseDouble(req.getParameter("goodprice"));
        int goodnum= Integer.parseInt(req.getParameter("goodnum"));
        int goodno= Integer.parseInt(req.getParameter("id2"));//编号
        Goods goods=new Goods(goodno,goodname,goodprice,goodnum);//实例化对象
        GoodsService goodsService=new GoodsServiceImpl();
        boolean m = goodsService.alter(goods);//调用方法判断修改
        //再次查询返回给初始页面
        //创建作用域对象
        HttpSession session=req.getSession();
        List<Goods> list=new ArrayList<Goods>();
        list=goodsService.show();//保存在集合中
        session.setAttribute("goodslist",list);
        session.setAttribute("time",new Date());
        if(m){
           resp.sendRedirect("goods.jsp");//修改成功跳显示页面
        }else {
            req.getRequestDispatcher("/WEB-INF/update.jsp").forward(req,resp);//修改失败跳继续修改
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {
        encoding=super.getInitParameter("encoding");//获取编码
    }
}
