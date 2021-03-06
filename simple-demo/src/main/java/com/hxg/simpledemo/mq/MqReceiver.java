package com.hxg.simpledemo.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqReceiver {

    @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void receiverMyQueue(String message) {
        log.info("receiverMyQueue: {}", message);
    }

}
