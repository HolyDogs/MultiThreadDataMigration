package com.example.mybatisplus.task;

import com.example.mybatisplus.mapper.IppMapper;
import com.example.mybatisplus.mapper.MonthMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * @author xufeng
 * @version 1.0
 * @date 2020/7/2 上午 9:44
 **/
@Component
@Slf4j
public class UpdateDataTask {

    @SuppressWarnings("all")
    @Autowired
    private MonthMapper monthMapper;

    @SuppressWarnings("all")
    @Autowired
    private IppMapper ippMapper;

    @Scheduled(cron = "0 0 0 1 7/1 ?")
    public void dataUpdate() {
        log.info("RUNNING!!!!!!!!!!!{}", LocalDateTime.now().toString());
        String start = LocalDate.now().minusMonths(1).toString();
        List<HashMap<String, String>> dataList = monthMapper.findByTimeDataOne(start);
        for (HashMap theMap:dataList) {
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



    //@Scheduled(cron = "1/1 * * * * ?")
    public void dataUpdate1() {
        log.info("RUNNING!!!!!!!!!!!{},{}"
                , LocalDateTime.now().toString()
                , DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.withMonth(localDateTime.getMonthValue() - 1);
        log.info("ZZZZZZZZZZZZZZZZZZZZ{},{}"
                , localDateTime.toString()
                , LocalDate.now().minusMonths(1).toString());
        String start = LocalDate.now().minusMonths(1).minusDays(1).toString();
        List<HashMap<String, String>> dataList = monthMapper.findByTimeDataOne(start);
    }

}
