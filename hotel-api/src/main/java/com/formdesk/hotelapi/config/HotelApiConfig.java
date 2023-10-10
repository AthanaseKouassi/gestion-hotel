package com.formdesk.hotelapi.config;

import com.formdesk.hotelcore.config.HotelCoreConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@ComponentScan(basePackages = "com.formdesk.hotelapi")
@Import({ HotelCoreConfig.class})
public class HotelApiConfig {
}