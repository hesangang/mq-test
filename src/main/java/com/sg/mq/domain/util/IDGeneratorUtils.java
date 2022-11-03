package com.sg.mq.domain.util;

import org.springframework.beans.factory.annotation.Value;

import java.util.Random;

/**
 * <P>
 * 用途:生成数字id
 * </p>
 *
 * @author: SanGang
 * @create: 2020-10-12 21:01
 **/
public class IDGeneratorUtils {
    @Value("${id.workerId}")
    private static long workerId;

    @Value("${id.datacenterId}")
    private static long datacenterId;

    public static final String CAR_CODE_PREFIX = "P";

    public static long getLongId(){
        final SnowflakeIdHelper snowflakeIdHelper = SnowflakeIdHelper.getInstance(workerId,datacenterId);
        long id = snowflakeIdHelper.nextId();
        return id;
    }

    public static String getId(){
        return getLongId()+"";
    }

    public static String getStrId() {
        Random random = new Random(System.currentTimeMillis());
        for (int j=0;j<20;j++){
            String uuid = "";
            for (int i=0;i<15;i++){
                int subNum = random.nextInt(9);
                uuid+=subNum;
            }
            return uuid;
        }
        return null;
    }

}
