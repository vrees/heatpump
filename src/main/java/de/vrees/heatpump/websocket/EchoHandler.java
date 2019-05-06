package de.vrees.heatpump.websocket;

import de.vrees.heatpump.master.HeatpumpMaster;
import de.vrees.heatpump.model.ProcessdataResource;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@AllArgsConstructor
public class EchoHandler implements WebSocketHandler {

    private HeatpumpMaster master;


    @Override
    public Mono<Void> handle(WebSocketSession webSocketSession) {


        Flux<ProcessdataResource> flux =
                Flux.create(emitter -> {
                    ProcessdataListener listener = new ProcessdataListener() {
                        @Override
                        public void publishData(ProcessdataResource event) {

                        }

                        @Override
                        public void error(Throwable e) {

                        }
/*                        @Override
                        public void publishData(ProcessdataResource event) {
                            emitter.next(event);
//                            if (event.isLast()) {
//                                emitter.complete();
//                            }
                        }

                        @Override
                        public void error(Throwable e) {
                            emitter.error(e);
                        }*/
                    };
                    master.register(listener);
                }, FluxSink.OverflowStrategy.BUFFER);


        ConnectableFlux<ProcessdataResource> hot = flux.publish();

        return webSocketSession.send(hot
                .map(pd -> pd.toString())
                .map(webSocketSession::textMessage))
                .and(webSocketSession.receive()
                        .map(WebSocketMessage::getPayloadAsText)
                        .log());
    }

/*

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session
                .send(session.receive()
                        .map(msg -> "RECEIVED ON SERVER :: " + msg.getPayloadAsText())
                        .map(session::textMessage)
                );
    }
*/

}
