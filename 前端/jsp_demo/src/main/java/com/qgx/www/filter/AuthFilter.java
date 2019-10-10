package com.qgx.www.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(this.getClass().getName()+"--权限过滤器--初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(this.getClass().getName()+"--权限过滤器--doFilter");
        //获取请求名称
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        System.out.println(uri);

        //通过判断得知哪些资源是可以放行，哪些是必须要登录才可以放行
        if (uri.endsWith("login.jsp")
                ||uri.endsWith("register.jsp")
                ||uri.endsWith("doLogin.s")
                ||uri.endsWith("doRegister.s")
                ||uri.endsWith("vCode.s")
                ||uri.toLowerCase().endsWith(".gif")
                ||uri.toLowerCase().endsWith(".jpg")
                ||uri.toLowerCase().endsWith(".png")
                ||uri.toLowerCase().endsWith(".jpeg")
                ||uri.toLowerCase().endsWith(".css")
                ||uri.toLowerCase().endsWith(".js")){
            //是公共资源则放行到下一个环节
            filterChain.doFilter(request,response);
        }else {
            //不是公共资源但是获得了登录会话令牌：loginUser
            if (session.getAttribute("loginUser")!=null){
                filterChain.doFilter(request,response);
            }else {
                //不是公共资源且没获得登录会话令牌，则强制跳转到登录界面
                response.sendRedirect("login.jsp");
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println(this.getClass().getName()+"--权限过滤器--销毁");
    }
}
