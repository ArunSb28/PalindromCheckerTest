package com.palindromechecker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	@Value("${websocket.endpoint}")
	private String registryEndPoint;
	
	
	@Value("${websocket.broker}")
	private String simpleBroker;
	
	@Value("${websocket.prefix}")
	private String websockPrefix;
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint(registryEndPoint).withSockJS();
	}
	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		
		config.enableSimpleBroker(simpleBroker);
		config.setApplicationDestinationPrefixes(websockPrefix);
		
	}
	
}
