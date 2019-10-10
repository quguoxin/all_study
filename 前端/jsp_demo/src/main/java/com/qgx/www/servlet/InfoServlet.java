package com.qgx.www.servlet;


import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.service.UserinfoService;
import com.qgx.www.service.impl.UserinfoServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/userinfos.s")
public class InfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        String username=req.getParameter("username");
        String phone=req.getParameter("phonename");

//        String phone="15073476468";
        String sex=req.getParameter("sex");

        if(sex.equals("man")){
            sex="男";
        }else {
            sex="女";
        }
        System.out.println(sex);
        String year=req.getParameter("year");
        int age=2018-Integer.parseInt(year);

        UserinfoService userInfoService=new UserinfoServiceImpl();
       int num= userInfoService.update(username,sex,age,phone);
        System.out.println(num);

        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setData(num);
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(JSON.toJSONString(responseBody));

    }
}
