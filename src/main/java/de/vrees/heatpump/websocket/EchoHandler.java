package de.vrees.heatpump.websocket;

import de.vrees.heatpump.mapper.ProcessdataMapper;
import de.vrees.heatpump.model.ProcessdataResource;
import de.vrees.heatpump.slaves.beckhoff.EL1008;
import de.vrees.heatpump.slaves.beckhoff.EL3122;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.server.WebSocketService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Component
//@AllArgsConstructor
public class EchoHandler implements WebSocketHandler {

//    private WebSocketSession session;

    private WebSocketService webSocketService;

    private ProcessdataMapper mapper;

    @Override
    public Mono<Void> handle(WebSocketSession aSsession) {

//        session = aSsession;

        Flux<WebSocketMessage> receiveFlux = aSsession.receive();
        log.info("Received: " + receiveFlux);

        Flux<WebSocketMessage> flux = receiveFlux
                .map(msg -> "RECEIVED ON SERVER :: " + msg.getPayloadAsText())
                .map(aSsession::textMessage);

        return aSsession.send(flux);
    }

    public Mono<Void> sendProcessdata(EL1008 el1008, EL3122 el3122) {
        ProcessdataResource resource = mapper.map(el1008, el3122);

        WebSocketMessage message = session.textMessage("Hallo Hallo");
        Publisher<WebSocketMessage> pub = Mono.just(message);
        return  session.send(pub);
    }
}
