package com.sg.mq;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    static volatile Map<String,Boolean> contractKey = new ConcurrentHashMap();

    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        // 加锁来判断 合同编码+项目编码 是否重复
        try {
            //contractKey.put("123",true);
            lock.lock();
            if(contractKey.get("123") != null){
                //log.info("{} syncBiContract contractKey={} 已存在",Thread.currentThread().getName() ,i.getContractscode()+"-"+bi.getTwoBookProjectCode());
                System.out.println("已存在");
                return;
            }
            contractKey.put("123",true);
            System.out.println("save");
        } finally {
            lock.unlock();
            System.out.println("unlock");
        }
        System.out.println("end");
    }
}
