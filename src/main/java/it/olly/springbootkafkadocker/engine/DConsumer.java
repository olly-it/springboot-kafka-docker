package it.olly.springbootkafkadocker.engine;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DConsumer {
	private final Logger logger = LoggerFactory.getLogger(DConsumer.class);

	@KafkaListener(topics = "D")
	public void consume(String message) throws IOException {
		logger.info(String.format("#### Consumed  message: [%s] %s", "D", message));
		try {
			long starTime = Long.parseLong(message.substring(0, message.indexOf('|')));
			long totalTime = System.currentTimeMillis() - starTime;
			logger.info(String.format("#### TOTAL TIME: %s ms", totalTime));
		} catch (Exception e) {
		}
	}
}