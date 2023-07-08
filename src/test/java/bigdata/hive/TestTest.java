package bigdata.hive;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

/**
 * @author zhaoyipc
 * @company QLONG
 * @date 2022-07-25 14:58
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Slf4j
public class TestTest {
    @BeforeAll
    public void init(){
        log.info("init===");
    }
    @AfterAll
    public void destory(){
        log.info("destory===");
    }
    @Order(1)
    @Test
    public void test1(){
        log.info("test1 runing");
    }
}
