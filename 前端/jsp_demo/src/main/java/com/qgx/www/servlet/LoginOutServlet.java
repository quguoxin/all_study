package com.qgx.www.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/loginOut.s",initParams ={@WebInitParam(name="encoding",value = "utf-8")} )
public class LoginOutServlet extends HttpServlet{
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
        ServletContext application=req.getServletContext();
        //先用Map集合保存一次的注销信息
        Map<String,Object> map=new HashMap<String, Object>();
   // DateUtil dateUtil=new DateUtil();
        map.put("loginDate",new Date());
        map.put("loginName",session.getAttribute("loginUser"));
        map.put("loginNumber",1);
        map.put("doType","注销");
        //用list集合记录多次注销的信息
        List<Map> tongJiList=null;
        if(application.getAttribute("tongji")==null){//判断是不是首次操作
            tongJiList=new ArrayList<Map>();//是则创建集合
        }else {//不是则获取原先集合并做添加
            tongJiList=(List<Map>) application.getAttribute("tongji");
        }
        tongJiList.add(map);
        //记录用户注销信息，用application全局变量
        application.setAttribute("tongji",tongJiList);
        //清除所有保存在会话中的信息
        session.removeAttribute("loginUser");//按key删除
        //清除监听
        session.removeAttribute("session_listener");
        session.invalidate();//注销所有session信息
        //跳转页面
        resp.sendRedirect("login.jsp");
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init() throws ServletException {
        encoding=super.getInitParameter("encoding");//获取编码
    }
}
