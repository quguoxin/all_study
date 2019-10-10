package com.qgx.www.dao.impl;

import com.qgx.www.bean.OptionBean;
import com.qgx.www.dao.OptionDao;
import com.qgx.www.util.DBUtils;

import java.util.List;

public class OptionDaoImpl extends DBUtils implements OptionDao {
    @Override
    public List<OptionBean> show() {
        String sql="select * from selects";
        return super.getAll(OptionBean.class,sql);
    }

    @Override
    public int del(int id) {
        String sql="DELETE  FROM selects WHERE id=?";
        int a=super.update(sql,id);
        int b=0;
        return a;
    }

    @Override
    public int add(OptionBean optionBean) {
        String[] array=optionBean.getOption().split("-");
        String title=optionBean.getTitle();
        String type=optionBean.getType();
        String sql="INSERT INTO selects (title,`option`,`type`) VALUES (";
        for(int i=0;i<array.length;i++){
            if(i==array.length-1){
                sql+=title+","+array[i]+","+type+")";
            }else{
                sql+=title+","+array[i]+","+type+"),(";
            }
        }
        return super.update(sql);
    }
}
