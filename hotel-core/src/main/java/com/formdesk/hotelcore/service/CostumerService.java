package com.formdesk.hotelcore.service;

import com.formdesk.hotelcore.dto.CostumerDto;
import com.formdesk.hotelcore.mapper.CostumerMapper;
import com.formdesk.hotelcore.models.Costumer;
import com.formdesk.hotelcore.repository.CostumerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class CostumerService {

    private final CostumerRepository costumerRepository;
    private final CostumerMapper costumerMapper;


    public void createCostumer(CostumerDto costumerDto){

        log.atInfo().log("****** Le service ******");
        Costumer  costumer = costumerMapper.clientsDtoToClients(costumerDto);
        costumerRepository.save(costumer);

        log.atInfo().log("Le client : \n{}, \na été enregistrer  avec succès ",costumer.toString());

    }

}