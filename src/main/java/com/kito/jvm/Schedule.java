package com.kito.jvm;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyipc on 2021-05-07.
 */
@Slf4j
@Component
@EnableScheduling
public class Schedule {
    private static final List<Person> PERSON_CACHE=new ArrayList<>();
    @Scheduled(cron = "0/5 * * * * ?")
    public void test(){
        log.info("添加开始");
        for (int i = 0; i < 100000; i++) {
            Person person=new Person("person"+System.currentTimeMillis(),i);
            PERSON_CACHE.add(person);
        }
        log.info("添加结束size={}",PERSON_CACHE.size());
    }
}
