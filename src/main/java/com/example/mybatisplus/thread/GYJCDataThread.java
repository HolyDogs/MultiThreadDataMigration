package com.example.mybatisplus.thread;

import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.example.mybatisplus.mapper.IppMapper;
import com.example.mybatisplus.mapper.MyMapper;
import com.github.pagehelper.PageHelper;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;


/**
 * @author xufeng
 * @version 1.0
 * @date 2020/6/23 上午 11:50
 **/
@Component
public class GYJCDataThread extends Thread {
    public static Integer getPageNum() {
        return pageNum;
    }

    public static void setPageNum(Integer pageNum) {
        GYJCDataThread.pageNum = pageNum;
    }

    static Integer pageNum = 1;

    public static Integer getMaxPage() {
        return maxPage;
    }

    public static void setMaxPage(Integer maxPage) {
        GYJCDataThread.maxPage = maxPage;
    }

    static Integer maxPage = 0;//记录最大页数

    public synchronized static int nextPage() {
        int i = getPageNum();
        maxPage = Math.max(maxPage, i);
        setPageNum(i+1);
        return i;
    }

    public GYJCDataThread(IppMapper ippMapper, MyMapper myMapper) {
        this.myMapper = myMapper;
        this.ippMapper = ippMapper;
    }

    static int max;

    private IppMapper ippMapper;

    private MyMapper myMapper;

    public void run(){
        while (true) {
            int i = nextPage();
            //分页查询
            PageHelper.startPage(i, 1000);
            List<HashMap<String, String>> list = myMapper.selectNeedData();
            //超过页数时跳出
            if (list == null || list.size() == 0) {
                break;
            }
            for (HashMap theMap:list) {
                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ZBMCFZ", "1-本月");
                theMap.put("MONTH_MTH_START_DATE", theMap.get("MONTH_MTH_START_DATE").toString().substring(0,10));
                theMap.put("MONTH_END_DATE", theMap.get("MONTH_END_DATE").toString().substring(0,10));
                theMap.put("ROW", String.valueOf(theMap.get("ROW1") == null ? "":theMap.get("ROW1")));
                theMap.put("LYID", "20200628001");
                ippMapper.insertToDataMove(theMap);
                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ZBMCFZ", "上年同期");
                theMap.put("ROW", String.valueOf(theMap.get("ROW2") == null ? "":theMap.get("ROW2")));
                ippMapper.insertToDataMove(theMap);
            }
        }
    }
}
