package com.qgx.www.myframework;

/**
 * 存储result配置信息
 */
public class Result {
    private String name;//result的name
    private boolean isRedirect;//result的重定向(redirect)
    private String viewPath;//result的跳转地址

    public Result() {
    }

    public Result(String name, boolean isRedirect, String viewPath) {
        this.name = name;
        this.isRedirect = isRedirect;
        this.viewPath = viewPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isRedirect() {
        return isRedirect;
    }

    public void setRedirect(boolean redirect) {
        isRedirect = redirect;
    }

    public String getViewPath() {
        return viewPath;
    }

    public void setViewPath(String viewPath) {
        this.viewPath = viewPath;
    }
}
