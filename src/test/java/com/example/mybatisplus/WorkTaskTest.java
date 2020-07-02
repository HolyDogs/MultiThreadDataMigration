package com.example.mybatisplus;

import com.example.mybatisplus.mapper.IppMapper;
import com.example.mybatisplus.mapper.MyMapper;
import com.example.mybatisplus.thread.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 简单的测试增删改查
 */
@RunWith(SpringRunner.class)
@EnableAsync
@SpringBootTest
public class WorkTaskTest {

    @SuppressWarnings("all")
    @Autowired
    private MyMapper myMapper;

    @SuppressWarnings("all")
    @Autowired
    private IppMapper ippMapper;

    /**
     * 重点工业园区主要经济指标
     * 20200629005
     * @throws InterruptedException
     */
    @Test
    public void insert062905() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<5;i++) {
            System.out.println("thread" + i);
            ZDGYYQDataThread thread = new ZDGYYQDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(ZDGYYQDataThread.getMaxPage());
        }
    }

    /**
     * 重点企业产销总值及主要产品产量
     * 20200629006
     * @throws InterruptedException
     */
    @Test
    public void insert062906() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<5;i++) {
            System.out.println("thread" + i);
            ZDQYCXDataThread thread = new ZDQYCXDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(ZDQYCXDataThread.getMaxPage());
        }
    }

    /**
     * 重点企业主要产品销售、库存、订货及价格
     * 20200630001
     * @throws InterruptedException
     */
    @Test
    public void insert063001() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<8;i++) {
            System.out.println("thread" + i);
            ZDQYCPXSDataThread thread = new ZDQYCPXSDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(ZDQYCPXSDataThread.getMaxPage());
        }
    }

    /**
     * 重点企业主要经济指标月报表
     * 20200630002
     * @throws InterruptedException
     */
    @Test
    public void insert063002() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            ZDQYJJZBDataThread thread = new ZDQYJJZBDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(ZDQYJJZBDataThread.getMaxPage());
        }
    }

    /**
     * 园区工业企业主要经济指标
     * 20200630003
     * @throws InterruptedException
     */
    @Test
    public void insert063003() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            YQGYQYJJZBDataThread thread = new YQGYQYJJZBDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(YQGYQYJJZBDataThread.getMaxPage());
        }
    }

    /**
     * 各设区市主要经济指标
     * 20200630004
     * @throws InterruptedException
     */
    @Test
    public void insert063004() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<8;i++) {
            System.out.println("thread" + i);
            SQJJZBElevenDataThread thread = new SQJJZBElevenDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(SQJJZBElevenDataThread.getMaxPage());
        }
    }

    /**
     * 工业企业主要经济指标
     * 20200630005
     * @throws InterruptedException
     */
    @Test
    public void insert063005() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            GYJJZBTwelveDataThread thread = new GYJJZBTwelveDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(GYJJZBTwelveDataThread.getMaxPage());
        }
    }

    /**
     * 工业园区主要经济指标
     * 20200701001
     * @throws InterruptedException
     */
    @Test
    public void insert070101() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            GYYQZYJJZBThirteenDataThread thread = new GYYQZYJJZBThirteenDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(GYYQZYJJZBThirteenDataThread.getMaxPage());
        }
    }

    /**
     * 工业增加值完成情况
     * 20200701002
     * @throws InterruptedException
     */
    @Test
    public void insert070102() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            GYZJZFourteenDataThread thread = new GYZJZFourteenDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(GYZJZFourteenDataThread.getMaxPage());
        }
    }

    /**
     * 工业主要产品产量
     * 20200701003
     * @throws InterruptedException
     */
    @Test
    public void insert070103() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            GYZYCPCLFifteenDataThread thread = new GYZYCPCLFifteenDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(GYZYCPCLFifteenDataThread.getMaxPage());
        }
    }

    /**
     * 江西省工业分县（市、区）主要经济指标
     * 20200701004
     * @throws InterruptedException
     */
    @Test
    public void insert070104() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            JXSGYFXJJZBSixteenDataThread thread = new JXSGYFXJJZBSixteenDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(JXSGYFXJJZBSixteenDataThread.getMaxPage());
        }
    }

    /**
     * 全国各地区工业增加值（只抽江西的）
     * 20200701005
     * @throws InterruptedException
     */
    @Test
    public void insert070105() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            QGGYZJZSevenTDataThread thread = new QGGYZJZSevenTDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(QGGYZJZSevenTDataThread.getMaxPage());
        }
    }

    /**
     * 全国各地区工业产品销售率（只抽江西的）
     * 20200701006
     * @throws InterruptedException
     */
    @Test
    public void insert070106() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            QGGDGYCPXSLEightTDataThread thread = new QGGDGYCPXSLEightTDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(QGGDGYCPXSLEightTDataThread.getMaxPage());
        }
    }

    /**
     * 全国各地区工业产品销售率（只抽江西的）
     * 20200701007
     * @throws InterruptedException
     */
    @Test
    public void insert070107() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            GYZJZCPXSLNineTDataThread thread = new GYZJZCPXSLNineTDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(GYZJZCPXSLNineTDataThread.getMaxPage());
        }
    }

    /**
     * 全国分地区主要工业产品生产完成情况（一）
     * 20200702001
     * @throws InterruptedException
     */
    @Test
    public void insert070201() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            ZYGYCPSCQKTwentyDataThread thread = new ZYGYCPSCQKTwentyDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(ZYGYCPSCQKTwentyDataThread.getMaxPage());
        }
    }

    /**
     * 全国分地区主要工业产品生产完成情况（二）
     * 20200702002
     * @throws InterruptedException
     */
    @Test
    public void insert070202() throws InterruptedException {
        //FHYGYDataThread.setPageNum(1);
        for (int i=0;i<6;i++) {
            System.out.println("thread" + i);
            ZYGYCPSCQKTTwentyOneDataThread thread = new ZYGYCPSCQKTTwentyOneDataThread(ippMapper, myMapper);
            thread.start();
        }
        while (true) {
            Thread.sleep(20000);
            System.out.println(ZYGYCPSCQKTTwentyOneDataThread.getMaxPage());
        }
    }

    @Test
    public void myStrTest() {
        String str = "粗<FONT></FONT><FONT>钢</FONT>";
        System.out.println(str.replaceAll("<FONT>", "").replaceAll("</FONT>", ""));
    }

}
