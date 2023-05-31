package com.sg.mq.listener.consumer;

import com.sg.mq.domain.thread.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 消息接收类
 *
 * @author zmzhou
 * @version 1.0
 * @title KafkaConsumer
 * @date 2021/4/1 22:33
 */
@Slf4j
@Component
public class KafkaConsumer {

	@KafkaListener(topics = {Constants.KAFKA_TOPIC})
	public void listener(ConsumerRecord<?, ?> record) {
		Optional<?> kafkaMessage = Optional.ofNullable(record.value());
		if (kafkaMessage.isPresent()) {
			Object message = kafkaMessage.get();
			log.info("----kafka record = {}", record);
			log.info("---- kafka message = {}", message);
		}

	}
}
