package com.sg.mq;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@DisplayName("bms分布式锁")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RedissionTest {


    @Autowired
    RedissonClient prodRedisson;

    String BMS_LOCK_BILL_DETAIL = "bms_lock_bill_detail";


    @RepeatedTest(1)
    void testBmsLock(){

        RLock lock = prodRedisson.getLock(BMS_LOCK_BILL_DETAIL + "3" );
        boolean tryLock;
        try {
            //tryLock = lock.tryLock();
            //等待5秒，-1续时
            tryLock = lock.tryLock(5,-1, TimeUnit.SECONDS);
            if (tryLock){
                Thread.sleep(3000);
                System.out.println("暂停10秒，获取锁成功！");
            }else {
                System.out.println("获取锁失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("释放锁！");
            lock.unlock();
        }

    }
}
