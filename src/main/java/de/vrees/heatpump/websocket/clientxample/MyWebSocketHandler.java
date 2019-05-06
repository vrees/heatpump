package de.vrees.heatpump.websocket.clientxample;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;


public class MyWebSocketHandler implements WebSocketHandler {

    public MyWebSocketHandler() {
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.send(Mono.just(session.textMessage("event-spring-reactive-client-websocket")))
                .thenMany(session.receive()
                        .map(WebSocketMessage::getPayloadAsText)
                        .log())
                .then()
                ;
    }
}
