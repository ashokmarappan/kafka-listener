package kafka.listener;

import javax.inject.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.micronaut.configuration.kafka.annotation.KafkaListener;
import io.micronaut.configuration.kafka.annotation.Topic;
import io.micronaut.messaging.annotation.Body;

@Singleton
public class KafkaConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(groupId = "kafka-listener")
	@Topic(value = "TestTopic")
	public void process(@Body String message) {
		LOGGER.info("KafkaConsumer::process:STARTS");
		LOGGER.info("KafkaConsumer::process: Body: "+message);
		LOGGER.info("KafkaConsumer::process:ENDS");
	}
	
}
