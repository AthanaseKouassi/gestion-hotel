package com.formdesk.hotelcore.mapper;

import com.formdesk.hotelcore.dto.CostumerDto;
import com.formdesk.hotelcore.models.Costumer;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CostumerMapper {

    CostumerDto clientsToClientsDto(Costumer costumer);
    Costumer clientsDtoToClients(CostumerDto dto);
}