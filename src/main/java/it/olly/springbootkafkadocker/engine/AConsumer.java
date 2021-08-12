package it.olly.springbootkafkadocker.engine;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class AConsumer {
	private final Logger logger = LoggerFactory.getLogger(AConsumer.class);

	@Autowired
	private GenericProducer producer;

	@KafkaListener(topics = "A")
	public void consume(String message) throws IOException {
		logger.info(String.format("#### Consumed  message: [%s] %s", "A", message));
		producer.produceMessage("B", message + " to B");

	}
}