package com.qgx.www.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EncodingFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(this.getClass().getName()+"过滤器--初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println(this.getClass().getName());
        HttpServletRequest req=(HttpServletRequest) request;
        req.setCharacterEncoding("UTF-8");
        //设置页面格式
        HttpServletResponse resp= (HttpServletResponse) response;
        resp.setContentType("text/html;charset=UTF-8");
        //继续执行后续资源：后续过滤器或原来发起的请求
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        //System.out.println(this.getClass().getName()+"过滤器--销毁");
    }
}
