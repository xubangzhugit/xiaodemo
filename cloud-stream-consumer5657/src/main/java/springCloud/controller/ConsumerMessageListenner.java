package springCloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

@Slf4j
@EnableBinding(Sink.class)
public class ConsumerMessageListenner {


    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
            log.info("consumer"+message.getPayload());
    }
}
