package com.qgx.www.action;

import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.OptionBean;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.service.OptionService;
import com.qgx.www.service.impl.OptionServiceImpl;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OptionAction extends BaseAction{

    public String show(){
        OptionService optionService=new OptionServiceImpl();
        List<OptionBean> list=optionService.show();
        ResponseBody responseBody=new ResponseBody();
        responseBody.setMsg("显示数据库内容！");
        responseBody.setCode(200);
        responseBody.setData(list);
        HttpServletResponse response= ServletActionContext.getResponse();
        try {
            PrintWriter printWriter=response.getWriter();
            printWriter.write(JSON.toJSONString(responseBody));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //删除
    private int id;
    public String del(){
        OptionService optionService=new OptionServiceImpl();
        int a = optionService.del(id);
        ResponseBody responseBody=new ResponseBody();
        responseBody.setMsg("删除！");
        responseBody.setCode(200);
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.write(JSON.toJSONString(responseBody));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String str;
    private String title;
    private String type;
    public String add(){
        OptionBean optionBean=new OptionBean();
        optionBean.setOption(str);
        optionBean.setTitle(title);
        optionBean.setType(type);
        OptionService optionService=new OptionServiceImpl();
        int b=optionService.add(optionBean);
        ResponseBody responseBody2=new ResponseBody();
        responseBody2.setMsg("增加！");
        responseBody2.setCode(200);
        try {
            PrintWriter printWriter = response.getWriter();
            printWriter.write(JSON.toJSONString(responseBody2));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
     }


    //////////////////////////////////////////////////////////////////


    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
