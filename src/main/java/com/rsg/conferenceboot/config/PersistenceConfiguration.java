package com.rsg.conferenceboot.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
	
	@Bean
	public DataSource dataSource()
	{
		DataSourceBuilder<?> builder = DataSourceBuilder.create(); 
		System.out.println("My customr datasource");
		return builder.url("jdbc:postgresql://localhost:5432/conference_app").build();
	}

}
