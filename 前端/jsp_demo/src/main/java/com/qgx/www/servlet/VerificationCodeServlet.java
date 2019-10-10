package com.qgx.www.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
@WebServlet(urlPatterns = "/verificationCode.s")
public class VerificationCodeServlet  extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        //生成验证码图片
        BufferedImage bufferedImage= new BufferedImage(62,42,BufferedImage.TYPE_INT_RGB);
        //创建画布
        Graphics g=bufferedImage.getGraphics();
        g.fillRect(0,0,62,42);//填充指定矩形
        g.setFont(new Font("",Font.BOLD+Font.ITALIC,20));//设置字体
        StringBuffer stringBuffer=new StringBuffer();
        //生成4位随机数字
        for(int i=0;i<4;i++){
            int ch=(int)(Math.random()*10);//生成一位随机数
            stringBuffer.append(ch);
            //给数字添加颜色，方位，背景
            g.setColor(new Color((int)(Math.random()*100),(int)(Math.random()*200),(int)(Math.random()*255)));
            g.drawString(ch+"",i*15+3,28);//将数字画到画布上并设定位置
        }
        //储存随机数字到会话中
        session.setAttribute("verificationCode",stringBuffer.toString());
        //输出到页面
        ImageIO.write(bufferedImage,"JPG",resp.getOutputStream());
    }
}
