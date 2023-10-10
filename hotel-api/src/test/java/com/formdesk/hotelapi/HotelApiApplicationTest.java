package com.formdesk.hotelapi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HotelApiApplicationTest {
    @Test
    void contextLoads() {
        HotelApiApplication.main(new String[] {});
    }
}