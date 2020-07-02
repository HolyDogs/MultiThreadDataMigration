package com.example.mybatisplus;

import com.baomidou.mybatisplus.plugins.Page;

import com.example.mybatisplus.entity.UserSpace;
import com.example.mybatisplus.mapper.IppMapper;
import com.example.mybatisplus.mapper.MyMapper;
import com.example.mybatisplus.thread.*;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * 简单的测试增删改查
 */
@RunWith(SpringRunner.class)
@EnableAsync
@SpringBootTest
public class MybatisplusSpringbootApplicationTests {

    @Autowired
    private MyMapper myMapper;

    @Autowired
    private IppMapper ippMapper;

    @Test
    public void test(){
        PageHelper.startPage(70, 5);
        List list = ippMapper.findData();
        System.out.println(list);
    }
/*

    @Test
    public void pageHelp(){
        PageHelper.startPage(1,5);
        List<UserSpace> ippMap = ippMapper.findData();
        PageInfo<UserSpace> pageInfo = new PageInfo<>(ippMap);
        System.out.println(123);
        List lsit = ippMapper.findData();
        System.out.println(123);
        PageHelper.startPage(2,3);
        List myMap = myMapper.findData();
        System.out.println(123);
    }
*/

    @Test
    public void testThread() throws InterruptedException {
        List<Runnable> list = new ArrayList();
        for (int i=0;i<=100;i++){
            System.out.println("thread" + i);
            DataMoveThread dataMoveThread = new DataMoveThread();
            dataMoveThread.start();
            System.out.println("111111");
        }
        Thread.sleep(20000000);
    }


    @Test
    public void testData() {
        PageHelper.startPage(1,200);
        List list = myMapper.selectNeedData();
        System.out.println("123");
    }


    @Test
    public void testInsert() throws InterruptedException {
        for (int i=0;i<=5;i++){
            System.out.println("thread" + i);
            GYJCDataThread dataMoveThread = new GYJCDataThread(ippMapper, myMapper);
            dataMoveThread.start();
        }
        Thread.sleep(2000000);
    }

    @Test
    public void testNullValue(){
        HashMap hashMap = new HashMap();
        hashMap.put("ID", UUID.randomUUID().toString().substring(10));
        hashMap.put("MONTH_MTH_START_DATE", " ");
        ippMapper.insertToDataMove(hashMap);

    }

    @Test
    public void testInsert100000() throws InterruptedException {
        //GYJCDataThread.setPageNum(501);
        GYJCDataThread.setPageNum(501);
        for (int i=0;i<50;i++){
            System.out.println("thread" + i);
            GYJCDataThread dataMoveThread = new GYJCDataThread(ippMapper, myMapper);
            //dataMoveThread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(GYJCDataThread.getMaxPage());
        }
    }


    /**
     * 重点企业财务状况主要经济指标
     * 20200628001
     * @throws InterruptedException
     */
    @Test
    public void testInsert123() throws InterruptedException {
        //GYJCDataThread.setPageNum(501);
        GYJCDataThread1.setPageNum(501);
        for (int i=0;i<5;i++){
            System.out.println("thread" + i);
            //GYJCDataThread1 dataMoveThread = new GYJCDataThread1(ippMapper, myMapper);
            //dataMoveThread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(GYJCDataThread1.getMaxPage());
        }
    }


    /**
     * 分行业工业企业主要经济指标
     * 20200629001
     * @throws InterruptedException
     */
    @Test
    public void insert062901() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<5;i++) {
            System.out.println("thread" + i);
            FHYGYDataThread fhygyDataThread = new FHYGYDataThread(ippMapper, myMapper);
            //fhygyDataThread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(FHYGYDataThread.getMaxPage());
        }
    }

    /**
     * 分行业工业生产者出厂价格指数
     * 20200629002
     * @throws InterruptedException
     */
    @Test
    public void insert062902() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<5;i++) {
            System.out.println("thread" + i);
            FHYSCZDataThread fhysczDataThread = new FHYSCZDataThread(ippMapper, myMapper);
            //fhysczDataThread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(FHYSCZDataThread.getMaxPage());
        }
    }


    /**
     * 全社会用电分类（全口径）
     * 20200629003
     * @throws InterruptedException
     */
    @Test
    public void insert062903() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<5;i++) {
            System.out.println("thread" + i);
            QSHYDDataThread qshydDataThread = new QSHYDDataThread(ippMapper, myMapper);
            qshydDataThread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(QSHYDDataThread.getMaxPage());
        }
    }

    /**
     * 中国制造业采购经理指数
     * 20200629004
     * @throws InterruptedException
     */
    @Test
    public void insert062904() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<5;i++) {
            System.out.println("thread" + i);
                ZGZZCGDataThread zgzzcgDataThread = new ZGZZCGDataThread(ippMapper, myMapper);
            zgzzcgDataThread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(ZGZZCGDataThread.getMaxPage());
        }
    }














    @Test
    public void mytest() {
        HashMap hss = new HashMap();
        List list = new ArrayList();
        list.add(hss);
        hss.put("hssKey", "123");
        HashMap zz = (HashMap) hss.clone();
        zz.put("zzKey", "456");
        list.add(zz);
        System.out.println(list);
    }

}
