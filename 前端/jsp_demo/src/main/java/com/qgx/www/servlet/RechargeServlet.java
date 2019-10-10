package com.qgx.www.servlet;


import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.entity.Userinfo;
import com.qgx.www.service.IncomeStatementService;
import com.qgx.www.service.UserinfoService;
import com.qgx.www.service.impl.IncomeStatementServiceImpl;
import com.qgx.www.service.impl.UserinfoServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/recharge.s")
public class RechargeServlet extends HttpServlet{


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String money = req.getParameter("money");
        HttpSession session=req.getSession();
        String cardNo= (String) session.getAttribute( "loginUser" );
        System.out.println(cardNo);
        //获取账户余额
        UserinfoService userinfoService=new UserinfoServiceImpl();
        double rmb_balance=userinfoService.findUserinfoDetail(cardNo).getRmb_balance();
        //修改客户余额
        userinfoService.updateRmbBlance(cardNo, Double.parseDouble(money)+rmb_balance);
        IncomeStatementService incomeStatementService=new IncomeStatementServiceImpl();
        //添加明细表数据
        int num= incomeStatementService.recharge( cardNo, Double.parseDouble(money),rmb_balance);
        if(num<=0){
            return;
        }


      /*  Income_statement income_statement=new Income_statement( );
        income_statement.setCardNo(cardNo );*/


        System.out.println(num);
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setMsg("充值");
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(JSON.toJSONString(responseBody));

    }
}
