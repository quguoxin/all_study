package com.qgx.www.servlet;


import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.qgx.www.config.AlipayConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/buy.s")
public class PayServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(AlipayConfig.CHARSET);
        String out_trade_no = req.getParameter("out_trade_no");
        String total_amount = req.getParameter("total_amount");
        String subject = req.getParameter("subject");

        AlipayClient alipayClient = new DefaultAlipayClient(
                AlipayConfig.GATE_WAY,
                AlipayConfig.APPID,
                AlipayConfig.APP_PRIVATE_KEY,
                AlipayConfig.FORMAT,
                AlipayConfig.CHARSET,
                AlipayConfig.ALIPAY_PUBLIC_KEY,
                AlipayConfig.SIGN_TYPE
        );

        //支付
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.RETURN_URL);
        alipayRequest.setNotifyUrl(AlipayConfig.NOTIFY_URL);
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+out_trade_no+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+total_amount+"," +
                "    \"subject\":\""+subject+"\" " +
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        resp.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
        resp.getWriter().write(form);//直接将完整的表单html输出到页面
        resp.getWriter().flush();
        resp.getWriter().close();
    }
}
