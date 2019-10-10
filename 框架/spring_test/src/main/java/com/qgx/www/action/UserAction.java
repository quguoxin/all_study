package com.qgx.www.action;

import com.qgx.www.ioc.UserInfo;
import com.qgx.www.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//代表是控制器层，由spring管理
@Controller
@RequestMapping("/user")
public class UserAction {

    //调用业务层对象，通过注解自动注入方式，以下其他请求方法可以自由调用，且改业务对象是单例的
    //@Autowired
    private UserInfoService userInfoService;

    /**
     * 测试请求
     * @return
     */
    @RequestMapping(value = "/hello",method = RequestMethod.GET )//该注解为控制器指定可以处理的请求
    public String test(){
        return "main";//对于springmvc来说也是一个逻辑名，本身对应页面名称
        //eg:我要跳转到/WEB-INF/xxxx.jsp，我们需要返回的是xxxx
        //其中/WEB-INF/就是前缀，.jsp就是后缀
    }

    /**
     * 请求参数
     * @param username
     * @return
     */
    @RequestMapping(value = "/hello2",method = RequestMethod.GET )
    public String test2(@RequestParam String username){//传参数只需要和页面请求参数名相同
                                                       //@RequestParam可以写可以不写
        System.out.println(username);
        return "main";
    }


    /**
     * 请求对象
     * @return
     */
    @RequestMapping(value = "/hello3",method = RequestMethod.GET)
    @ResponseBody //将对象通过类型转换器转为json类型，等价于
                  //priterWriter+fastjson或等价于struts2的result=json
    public UserInfo test3(UserInfo userInfo){
        System.out.println(userInfo);
        return userInfo;
    }


}
