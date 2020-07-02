package com.example.mybatisplus.thread;

import com.example.mybatisplus.mapper.IppMapper;
import com.example.mybatisplus.mapper.MyMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;


/**
 * 全国各地区工业增加值（只抽江西的）
 * @author xufeng
 * @version 1.0
 * @date 2020/7/1
 **/
@Component
public class QGGYZJZSevenTDataThread extends Thread {
    public static Integer getPageNum() {
        return pageNum;
    }

    public static void setPageNum(Integer pageNum) {
        QGGYZJZSevenTDataThread.pageNum = pageNum;
    }

    static Integer pageNum = 1;

    public static Integer getMaxPage() {
        return maxPage;
    }

    public static void setMaxPage(Integer maxPage) {
        QGGYZJZSevenTDataThread.maxPage = maxPage;
    }

    static Integer maxPage = 0;//记录最大页数

    public synchronized static int nextPage() {
        int i = getPageNum();
        maxPage = Math.max(maxPage, i);
        setPageNum(i+1);
        return i;
    }

    @SuppressWarnings("ALL")
    public QGGYZJZSevenTDataThread(IppMapper ippMapper, MyMapper myMapper) {
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
            PageHelper.startPage(i, 10);
            List<HashMap<String, String>> list = myMapper.selectQGGDQGYZJZSevenTData17();
            //超过页数时跳出
            if (list == null || list.size() == 0) {
                break;
            }
            for (HashMap theMap:list) {
                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("MONTH_MTH_START_DATE", theMap.get("MONTH_MTH_START_DATE").toString().substring(0,10));
                theMap.put("MONTH_END_DATE", theMap.get("MONTH_END_DATE").toString().substring(0,10));
                theMap.put("ROW", String.valueOf(theMap.get("ROW1") == null ? "":theMap.get("ROW1")));
                theMap.put("ENROL_NAME", "工业增加值本月");
                theMap.put("ENROL_ID", theMap.get("CALLING_ID"));
                theMap.put("LYID", "20200701005");
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "工业增加值累计");
                theMap.put("ROW", String.valueOf(theMap.get("ROW2") == null ? "":theMap.get("ROW2")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "比去年同期增长本月");
                theMap.put("ROW", String.valueOf(theMap.get("ROW3") == null ? "":theMap.get("ROW3")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "比去年同期增长累计");
                theMap.put("ROW", String.valueOf(theMap.get("ROW4") == null ? "":theMap.get("ROW4")));
                ippMapper.insertToDataMove(theMap);
            }
        }
        System.out.println("I AM FINISHED~" + Thread.currentThread().getName());
    }
}
