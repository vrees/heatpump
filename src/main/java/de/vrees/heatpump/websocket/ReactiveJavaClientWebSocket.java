package de.vrees.heatpump.websocket;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import org.springframework.web.reactive.socket.client.WebSocketClient;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;

public class ReactiveJavaClientWebSocket {

    public static void main(String[] args) throws InterruptedException {

        WebSocketClient client = new ReactorNettyWebSocketClient();

        client.execute(URI.create("ws://localhost:8080/event-emitter"), )

        client.execute(
                URI.create("ws://localhost:8080/event-emitter"),
                session -> session.send(
                        Mono.just(session.textMessage("event-spring-reactive-client-websocket")))
                        .thenMany(session.receive()
                                .map(WebSocketMessage::getPayloadAsText)
                                .log())
                        .then())
                .block(Duration.ofSeconds(10L));
    }

    public class MyWebSocketHandler implements WebSocketHandler {

        @Override
        public Mono<Void> handle(WebSocketSession session) {
            return session.send(Mono.just(session.textMessage("event-spring-reactive-client-websocket")));
        }
    }
}
