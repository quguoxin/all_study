package com.qgx.www.action;
import com.qgx.www.ex.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/ex")
public class ExceptionAction {
    @RequestMapping(value = "/myException")
    public String myException(int i) throws MyException {
        if(i>0){
            throw new MyException(666,"新哥抛出异常了");
        }
        return "main";
    }
}
