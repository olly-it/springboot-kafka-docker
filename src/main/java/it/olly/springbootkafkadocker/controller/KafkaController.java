package it.olly.springbootkafkadocker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.olly.springbootkafkadocker.engine.GenericProducer;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
	private final Logger logger = LoggerFactory.getLogger(KafkaController.class);
	private final GenericProducer producer;

	@Autowired
	KafkaController(GenericProducer producer) {
		this.producer = producer;
	}

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("message") String message, @RequestParam("topic") String topic) {
		logger.info(String.format("KafkaController - received request to publish: [%s] %s", topic, message));
		producer.produceMessage(topic, message);
	}

	@PostMapping(value = "/abcd")
	public void testABCD(@RequestParam("message") String message) {
		logger.info("KafkaController - received request to abcd (starts with topic A)");
		producer.produceMessage("A", System.currentTimeMillis() + "|" + message + " to A");
	}
}