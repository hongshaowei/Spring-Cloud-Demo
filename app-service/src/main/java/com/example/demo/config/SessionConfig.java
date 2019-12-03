package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

@Configuration
@EnableRedisHttpSession
public class SessionConfig extends AbstractHttpSessionApplicationInitializer {

	// Spring Boot build JedisConnectionFactory for us
		// if standard Spring session needs to define the factory bean as below
		
//		@Bean
//		public JedisConnectionFactory jedisConnectionFactory() {
//			return new JedisConnectionFactory();
//		}
	
}
