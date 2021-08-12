package it.olly.springbootkafkadocker.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class GenericProducer {

	private static final Logger logger = LoggerFactory.getLogger(GenericProducer.class);

	private final KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	GenericProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void produceMessage(String topic, String message) {
		logger.info(String.format("#### Producing message: [%s] %s", topic, message));
		this.kafkaTemplate.send(topic, message);
	}
}