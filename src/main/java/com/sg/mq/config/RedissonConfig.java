package com.sg.mq.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SentinelServersConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

//@Configuration
public class RedissonConfig {

    @Autowired
    private RedisProperties redisProperties;

    //添加redisson的bean
    @Bean(destroyMethod = "shutdown")
    public RedissonClient redissonClient() throws IOException {
        Config config = new Config();

        //1、哨兵配置
        SentinelServersConfig c = config.useSentinelServers()
                .setMasterName(redisProperties.getSentinel().getMaster())
                .setPassword(redisProperties.getSentinel().getPassword())
                //可以用"rediss://"来启用SSL连接
                /*.addSentinelAddress("redis://127.0.0.1:26379")
                .addSentinelAddress("redis://127.0.0.1:26380")
                .addSentinelAddress("redis://127.0.0.1:26381")*/;
        redisProperties.getSentinel().getNodes().forEach(i ->{
            c.addSentinelAddress("redis://" + i);
        });

        //2、主从配置
       /* config.useMasterSlaveServers()
                .setPassword("123456")
                //可以用"rediss://"来启用SSL连接
                .setMasterAddress("redis://127.0.0.1:6379")
                .addSlaveAddress("redis://127.0.0.1:6380")
                .addSlaveAddress("redis://127.0.0.1:6381");*/

        //3、配置文件读取配置
        //Config config = Config.fromYAML(new ClassPathResource("redisson.yml").getInputStream());

        RedissonClient redisson = Redisson.create(config);
        return redisson;
    }
}
