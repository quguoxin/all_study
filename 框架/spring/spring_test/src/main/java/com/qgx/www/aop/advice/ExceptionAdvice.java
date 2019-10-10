package com.qgx.www.aop.advice;
import com.qgx.www.bean.MyResponseBody;
import com.qgx.www.ex.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(Exception.class)//出现了自定义异常则执行该方法
    @ResponseBody //返回对象
    public MyResponseBody handlerException(Exception e){
        e.printStackTrace();
        if(e instanceof MyException){
            System.out.println("我抛出了自定义异常");
        }
        MyResponseBody myResponseBody=new MyResponseBody();
        myResponseBody.setCode(-1);
        myResponseBody.setMsg(e.getMessage());
        return myResponseBody;
    }
}
