package com.formdesk.hotelapi.controller;

import com.formdesk.hotelapi.api.ClientsApi;
import com.formdesk.hotelapi.mapper.ClientRepMapper;
import com.formdesk.hotelapi.model.Clients;
import com.formdesk.hotelcore.dto.CostumerDto;
import com.formdesk.hotelcore.service.CostumerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ClientController implements ClientsApi {

    private final CostumerService costumerService;
    private final ClientRepMapper clientRepMapper;

    @Override
    public ResponseEntity<Clients> createClient(Clients clients) {
        log.atInfo().log("Le client :: {}",clients);
        CostumerDto costmerDto = clientRepMapper.clientsToCostumerDto(clients);
        costumerService.createCostumer(costmerDto);

        return new ResponseEntity<>(clients, HttpStatus.OK);
    }
}