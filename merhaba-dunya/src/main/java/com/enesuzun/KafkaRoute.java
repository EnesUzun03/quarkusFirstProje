package com.enesuzun;

import org.apache.camel.builder.RouteBuilder;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KafkaRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("timer:send?period=5000")
            .setBody().constant("Merhaba Kafka!")
            .log("Kafka'ya gönderiliyor: ${body}")
            .to("kafka:my-topic?brokers={{camel.component.kafka.brokers}}");
        
    }
}