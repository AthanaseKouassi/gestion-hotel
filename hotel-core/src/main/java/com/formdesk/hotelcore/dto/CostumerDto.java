package com.formdesk.hotelcore.dto;

import lombok.Builder;

@Builder
public record CostumerDto(Long id, String firstName, String lastName, String domicile, String phone, String mail) {
}