package com.qgx.www.myframework;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 框架的核心控制器，控制请求交由谁处理且跳转哪个页面
 */
public class StrutsPrepareAndExcuteFilter implements Filter{
    @Override//初始化
    public void init(FilterConfig filterConfig) throws ServletException {
        //在初始化时读取解析核心配置文件，且只执行一次
        ActionMappingManager actionMappingManager=new ActionMappingManager();
        actionMappingManager.init("tlc_struts.xml");//该出已将配置文件名称写死
    }

    @Override//处理业务
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        //确定请求的ActionName;
        String uri=request.getRequestURI();//"/login.action"
        String contextPath=request.getContextPath();
        int dianIndex=uri.lastIndexOf(".");
        String actionName = uri.substring(18,dianIndex);
        //根据ActionName在actionMapperingMap集合中获取ActionMapping对象
        ActionMappering actionMappering=ActionMappingManager.actionMapperingMap.get(actionName);
        //利用反射机制根据actionMappering.getClassName()(类的类型)获取实例
        Action action=ActionManager.createAcrion(actionMappering.getClassName());//创建请求类的实例
        try {
            //由action里面的方法得出result里面的name
            String resultName =action.execute(request,response);
            //由上面的name可以确定是重定向还是转发，及跳转的页面
            Result result=actionMappering.getResultMap().get(resultName);
            if(result.isRedirect()){//重定向
                response.sendRedirect(result.getViewPath());
            }else {//转发
                request.getRequestDispatcher(result.getViewPath()).forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override//销毁
    public void destroy() {

    }
}
