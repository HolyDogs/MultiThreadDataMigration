package com.example.mybatisplus.thread;

import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author xufeng
 * @version 1.0
 * @date 2020/6/23 上午 10:04
 **/
public class DataMoveThread extends Thread {

    public static int getNum() {
        return num;
    }

    public static void setNum(Integer num) {
        DataMoveThread.num = num;
    }

    public synchronized static int doNum(){
        int i = getNum();
        setNum(i+1);
        return i;
    }

    static Integer num = 0;

    static ArrayList arrayList = new ArrayList();

    public void run() {
        while(true) {
            int i = doNum();
            if (arrayList.contains(i)) {
                System.out.println("ERROR!!!!!!!!!!!!!!!!!!!!!!!!!!\nERROR!!!!!!!!!!!!!!!!!!!!!!!!!!\nERROR!!!!!!!!!!!!!!!!!!!!!!!!!!\nERROR!!!!!!!!!!!!!!!!!!!!!!!!!!\nERROR!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
            } else {
                arrayList.add(i);
            }
            System.out.println(i + "========" + Thread.currentThread().getName());

            try {
                Thread.sleep(new Random().nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
