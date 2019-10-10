package com.qgx.www.servlet;


import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.PageBean;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Address;
import com.qgx.www.service.TakeGoodService;
import com.qgx.www.service.impl.TakeGoodServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/takegood.s")
public class TakeGoodServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TakeGoodService takeGoodService=new TakeGoodServiceImpl();

        HttpSession session=req.getSession();
        String phone= (String) session.getAttribute("loginUser");//phone
        String pageNo = req.getParameter("pageNo");
        int pageSize=2;

        List<Address> list=takeGoodService.findPageNo(Integer.parseInt(pageNo),pageSize,phone);
//        Address two= list.get(1);
//        System.out.println(two.getId());
        int totalCount = takeGoodService.findCount( phone);
        int totalPage=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
        PageBean<Address> pageData=new PageBean<Address>(Integer.parseInt(pageNo),pageSize,phone,list,totalPage);

        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setData(pageData);
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(JSON.toJSONString(responseBody));
    }
}
