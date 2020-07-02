package com.example.mybatisplus.thread;

import com.example.mybatisplus.mapper.IppMapper;
import com.example.mybatisplus.mapper.MyMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;


/**
 * 全国分地区主要工业产品生产完成情况（二）
 * @author xufeng
 * @version 1.0
 * @date 2020/07/02
 **/
@Component
public class ZYGYCPSCQKTTwentyOneDataThread extends Thread {
    public static Integer getPageNum() {
        return pageNum;
    }

    public static void setPageNum(Integer pageNum) {
        ZYGYCPSCQKTTwentyOneDataThread.pageNum = pageNum;
    }

    static Integer pageNum = 1;

    public static Integer getMaxPage() {
        return maxPage;
    }

    public static void setMaxPage(Integer maxPage) {
        ZYGYCPSCQKTTwentyOneDataThread.maxPage = maxPage;
    }

    static Integer maxPage = 0;//记录最大页数

    public synchronized static int nextPage() {
        int i = getPageNum();
        maxPage = Math.max(maxPage, i);
        setPageNum(i+1);
        return i;
    }

    public ZYGYCPSCQKTTwentyOneDataThread(IppMapper ippMapper, MyMapper myMapper) {
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
            List<HashMap<String, String>> list = myMapper.selectZYGYCPWCQKTwoData21();
            //超过页数时跳出
            if (list == null || list.size() == 0) {
                break;
            }
            for (HashMap theMap:list) {
                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("MONTH_MTH_START_DATE", theMap.get("MONTH_MTH_START_DATE").toString().substring(0,10));
                theMap.put("MONTH_END_DATE", theMap.get("MONTH_END_DATE").toString().substring(0,10));
                theMap.put("ROW", String.valueOf(theMap.get("ROW1") == null ? "":theMap.get("ROW1")));
                theMap.put("LYID", "20200702002");
                theMap.put("ENROL_ID", theMap.get("DIM_ID"));
                theMap.put("ENROL_NAME", "水泥产量累计");
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "水泥产量本月");
                theMap.put("ROW", String.valueOf(theMap.get("ROW2") == null ? "":theMap.get("ROW2")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "水泥产量累计同比增长");
                theMap.put("ROW", String.valueOf(theMap.get("ROW3") == null ? "":theMap.get("ROW3")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "水泥产量本月同比增长");
                theMap.put("ROW", String.valueOf(theMap.get("ROW4") == null ? "":theMap.get("ROW4")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "平板玻璃累计");
                theMap.put("ROW", String.valueOf(theMap.get("ROW5") == null ? "":theMap.get("ROW5")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "平板玻璃本月");
                theMap.put("ROW", String.valueOf(theMap.get("ROW6") == null ? "":theMap.get("ROW6")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "平板玻璃累计同比增长");
                theMap.put("ROW", String.valueOf(theMap.get("ROW7") == null ? "":theMap.get("ROW7")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "平板玻璃本月同比增长");
                theMap.put("ROW", String.valueOf(theMap.get("ROW8") == null ? "":theMap.get("ROW8")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "十种有色金属累计");
                theMap.put("ROW", String.valueOf(theMap.get("ROW9") == null ? "":theMap.get("ROW9")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "十种有色金属本月");
                theMap.put("ROW", String.valueOf(theMap.get("ROW10") == null ? "":theMap.get("ROW10")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "十种有色金属累计同比增长");
                theMap.put("ROW", String.valueOf(theMap.get("ROW11") == null ? "":theMap.get("ROW11")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "十种有色金属本月同比增长");
                theMap.put("ROW", String.valueOf(theMap.get("ROW12") == null ? "":theMap.get("ROW12")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "汽车累计");
                theMap.put("ROW", String.valueOf(theMap.get("ROW13") == null ? "":theMap.get("ROW13")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "汽车本月");
                theMap.put("ROW", String.valueOf(theMap.get("ROW14") == null ? "":theMap.get("ROW14")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "汽车累计同比增长");
                theMap.put("ROW", String.valueOf(theMap.get("ROW15") == null ? "":theMap.get("ROW15")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "汽车本月同比增长");
                theMap.put("ROW", String.valueOf(theMap.get("ROW16") == null ? "":theMap.get("ROW16")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "其中：轿车累计");
                theMap.put("ROW", String.valueOf(theMap.get("ROW17") == null ? "":theMap.get("ROW17")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "其中：轿车本月");
                theMap.put("ROW", String.valueOf(theMap.get("ROW18") == null ? "":theMap.get("ROW18")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "其中：轿车累计同比增长");
                theMap.put("ROW", String.valueOf(theMap.get("ROW19") == null ? "":theMap.get("ROW19")));
                ippMapper.insertToDataMove(theMap);

                theMap.put("ID", UUID.randomUUID().toString().replace("-", ""));
                theMap.put("ENROL_NAME", "其中：轿车本月同比增长");
                theMap.put("ROW", String.valueOf(theMap.get("ROW20") == null ? "":theMap.get("ROW20")));
                ippMapper.insertToDataMove(theMap);
            }
        }
        System.out.println("I AM FINISHING ++++" + Thread.currentThread().getName());
    }
}
