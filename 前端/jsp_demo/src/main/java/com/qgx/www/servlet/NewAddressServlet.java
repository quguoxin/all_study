package com.qgx.www.servlet;


import com.alibaba.fastjson.JSON;
import com.qgx.www.bean.ResponseBody;
import com.qgx.www.service.AddressService;
import com.qgx.www.service.impl.AddressServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/newAddress.s")
public class NewAddressServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AddressService addressService=new AddressServiceImpl();
        String name=req.getParameter("consigneeName");
        String phone=req.getParameter("phoneNumber");
        String detail_address=req.getParameter("detail_address");
        String fix_telephone=req.getParameter("telephone");
        String postcode=req.getParameter("postalCode");
        String address=req.getParameter("address");


        if(address==null) {
            String provinceCode=req.getParameter("province");
            String cityCode=req.getParameter("city");
            String areaCode=req.getParameter("area");
            String province=addressService.findAddress(provinceCode);
            String city=addressService.findAddress(cityCode);
            String area=addressService.findAddress(areaCode);
            address = province + city + area;
        }

       int num= addressService.insert(name,address,detail_address,phone,postcode,fix_telephone);
        ResponseBody responseBody=new ResponseBody();
        responseBody.setCode(200);
        responseBody.setData(num);
        PrintWriter printWriter=resp.getWriter();
        printWriter.write(JSON.toJSONString(responseBody));
//        resp.sendRedirect("takegood.jsp");




    }
}
