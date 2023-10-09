package com.formdesk.hotelapi.mapper;


import com.formdesk.hotelapi.model.Clients;
import com.formdesk.hotelcore.dto.CostumerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClientRepMapper {
    @Mapping(target = "domicile", source = "addresse")
    CostumerDto clientsToCostumerDto(Clients clients);
}