package com.qgx.www.myframework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
    String SUCCESS = "success";
    String NONE ="none";
    String ERROR = "error";
    String INPUT = "input";
    String LOGIN = "login";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
