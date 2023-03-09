package com.sg.mq;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

//https://blog.csdn.net/lijunliang2017/article/details/119863232
public class RobotTest {
    public static void main(String[] args) throws AWTException, InterruptedException {

        int x = 730;
        int y = 90;
        Integer h = 28;

        Thread.sleep(3000);
        new Robot(
                GraphicsEnvironment.getLocalGraphicsEnvironment()
                        .getDefaultScreenDevice());
        Robot robot = new Robot();
        Random random = new Random();
        int a = 0;
        robot.delay(1000);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        robot.mouseMove(x, y);

        a = Math.abs(random.nextInt())%100+50;
        robot.delay(a);
        for(int i=0;i<6;i++){
            //左键按下
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            //随机延迟
            a = Math.abs(random.nextInt())%50+50;
            robot.delay(a);
            //左键松开
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


            robot.mouseMove(1089, 365);
            //左键按下
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            //随机延迟
            a = Math.abs(random.nextInt())%50+50;
            robot.delay(a);
            //左键松开
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


            robot.mouseMove(604, 440);
            //左键按下
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            //随机延迟
            a = Math.abs(random.nextInt())%50+50;
            robot.delay(a);
            //左键松开
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);


            //随机延迟
            a = Math.abs(random.nextInt())%50+50;
            robot.delay(a);
            //左键按下
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            //随机延迟
            a = Math.abs(random.nextInt())%50+50;
            robot.delay(a);
            //左键松开
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            //下次坐标
            y=y+h;
            robot.mouseMove(x, y);


            //获取当前鼠标坐标
            PointerInfo pointerInfo = MouseInfo.getPointerInfo();
            //获取当前坐标颜色
            Color color = robot.getPixelColor( pointerInfo.getLocation().x ,
                    pointerInfo.getLocation().y );

            String format = LocalDateTime.now().format(formatter);
            System.out.println("第"+i+"次,时间："+format+"颜色："+color);
            Thread.sleep(1000);
        }

    }
}
