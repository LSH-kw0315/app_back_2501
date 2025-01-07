package com.ll.chatai.global.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfigure implements WebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws/chat")
                .setAllowedOriginPatterns("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //클라이언트가 /app/chat을 구독하면, 브로커는 해당 경로에 전달된 메시지를 브로드캐스트합니다.
        registry.enableSimpleBroker("/app");

        //클라이언트가 서버로 보낼 메시지의 경로를 설정합니다.
        registry.setApplicationDestinationPrefixes("/topic");
    }
}
