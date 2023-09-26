package com.formdesk.hotelapi;

import com.formdesk.hotelcore.config.HotelCoreConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(HotelCoreConfig.class)
public class HotelApiApplication {
    public static void main(String[] args){
        SpringApplication.run(HotelApiApplication.class, args);

    }
}