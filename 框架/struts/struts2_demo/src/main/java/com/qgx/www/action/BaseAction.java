package com.qgx.www.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class BaseAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ServletResponseAware {
    protected Map<String,Object> request;
    protected Map<String,Object> session;
    protected Map<String,Object> application;
    protected HttpServletResponse response;
    @Override
    public void setApplication(Map<String, Object> map) {
        this.application=map;
    }

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request=map;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response=httpServletResponse;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session=map;
    }
}
