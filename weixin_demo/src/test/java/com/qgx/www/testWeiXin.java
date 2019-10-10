package com.qgx.www;

import com.qgx.www.service.WeiXinServiceImpl;
import org.junit.Test;

public class testWeiXin {

    @Test
    public void testSendMsg(){
        WeiXinServiceImpl weiXinService = new WeiXinServiceImpl();
        System.out.println(weiXinService.sendKfMsg());
    }

    @Test
    public void testGetAccessRoken(){
        System.out.println(WeiXinServiceImpl.getAccessRoken());
    }


    @Test
    public void testAddMenu(){
        WeiXinServiceImpl weiXinService = new WeiXinServiceImpl();
        System.out.println(weiXinService.addMenu());
    }

    @Test
    public void testGouMai(){
        WeiXinServiceImpl weiXinService = new WeiXinServiceImpl();
        System.out.println(weiXinService.goumai());
    }
}