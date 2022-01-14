package it.com.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author majj
 * @create 2021-12-27 13:58
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //服务器通知浏览器不要缓存
        response.setHeader("pragma","no-cache");
        response.setHeader("cache-control","no-cache");
        response.setHeader("expires","0");

        //在内存中创建一个长80，宽30的图片，默认黑色背景
        //参数一：长
        //参数二：宽
        //参数三：颜色
        int width = 80;
        int height = 30;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics graphics = image.getGraphics();
        //设置画笔颜色为灰色
        graphics.setColor(Color.gray);
        //填充图片
        graphics.fillRect(0,0,width,height);

        //产生4个随机验证码，12Ey
        String checkCode = getCheckCode();

        //将验证码放入HttpSession中
        request.getSession().setAttribute("checkcode_service",checkCode);

        //设置画笔颜色为黄色
        graphics.setColor(Color.yellow);
        //设置字体的小大
        graphics.setFont(new Font("黑体",Font.BOLD,24));
        //向图片上写入验证码
        graphics.drawString(checkCode,15,25);
        //将内存中的图片输出到浏览器
        //参数一：图片对象
        //参数二：图片的格式，如PNG,JPG,GIF
        //参数三：图片输出到哪里去
        ImageIO.write(image,"PNG",response.getOutputStream());

    }

    private String getCheckCode() {
        StringBuffer sb = new StringBuffer();
        String base = "0123456789ABCDEFGabcdefg";
        int len = base.length();
        Random random = new Random();
        for (int i = 0; i <4; i++) {
            int nextInt = random.nextInt(len);
            char str = base.charAt(nextInt);
            sb.append(str);
        }
        return sb.toString();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
