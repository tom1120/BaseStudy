package com.kito.jvm;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static org.junit.Assert.*;

/**
 * Created by zhaoyipc on 2021-05-07.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//注解Contest寻找配置文件
//@ContextConfiguration("classpath:spring.xml") // 寻找的是测试包
@ContextConfiguration(locations = {"file:src/main/resources/spring.xml"})
@Ignore
public class ScheduleTest {
    @Autowired
    Schedule schedule;
    @Test
    public void test1() throws Exception {
        schedule.test();
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String s=reader.readLine();
        System.out.println("s = " + s);
        reader.close();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("调度结束");

    }
}