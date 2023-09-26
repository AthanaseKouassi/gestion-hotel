package com.formdesk.hotelcore.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan( basePackages = {"com.formdesk.hotelcore"} )
@ComponentScan(basePackages = "com.formdesk.hotelcore")
@EnableJpaRepositories(basePackages = "com.formdesk.hotelcore")
public class HotelCoreConfig {

}