package com.anxl.bms;

import com.anxl.bms.interfaces.supplier.constant.RedissonConstant;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.redisson.RedissonClient;
import org.redisson.RedissonExt;
import org.redisson.core.RLock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Slf4j
@DisplayName("bms分布式锁")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RedissionTest {

    @Resource
    private RedissonExt prodRedisson;

    @Resource
    RedissonClient prodRedisson2;


    @RepeatedTest(10)
    void testBmsLock(){

        RLock lock = prodRedisson.getLock(RedissonConstant.BMS_LOCK_BILL_DETAIL + "3" );
        boolean tryLock;
        try {
            //tryLock = lock.tryLock();
            tryLock = lock.tryLock(500,1000, TimeUnit.SECONDS);
            if (tryLock){
                System.out.println("获取锁成功！");
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
