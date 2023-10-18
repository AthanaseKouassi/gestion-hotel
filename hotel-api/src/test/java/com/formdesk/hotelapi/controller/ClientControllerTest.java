package com.formdesk.hotelapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.formdesk.hotelapi.mapper.ClientRepMapper;
import com.formdesk.hotelapi.model.Clients;
import com.formdesk.hotelcore.dto.CostumerDto;
import com.formdesk.hotelcore.service.CostumerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@ContextConfiguration(classes={ ClientController.class})
@WebMvcTest( ClientController.class)
public class ClientControllerTest {

    @MockBean
    private ClientRepMapper clientRepMapper;
    @MockBean
    private CostumerService costumerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void createClient_should_return_create() throws Exception {
        // Objet Clients à envoyer en tant que demande
        Clients clients = new Clients();
        clients.setFirstName("Alain");
        clients.setLastName("Koné");
        clients.setAddresse("belle rue");
        clients.setMail("mail@gmail.com");
        clients.setPhone("01020102");

        CostumerDto costumerDto = CostumerDto.builder()
                .firstName("Alain")
                .lastName("Koné")
                .mail("mail@gmail.com")
                .domicile("belle rue")
                .phone("01020102").build();


        // Convertir l'objet en JSON
        // Possibilité de mettre final le type car la variable n'est plus modifié
        final String clientsJson = objectMapper.writeValueAsString(clients);

        when(clientRepMapper.clientsToCostumerDto(clients)).thenReturn(costumerDto);

        // Effectuez la demande POST vers /api/clients
        final ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/api/clients")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(clientsJson))
                .andDo(print());
        response.andExpect(jsonPath("$").isMap());
        response.andExpect(jsonPath("$.firstName").value(costumerDto.firstName()));
        response.andExpect(jsonPath("$.lastName").value(costumerDto.lastName()));
        response.andExpect(jsonPath("$.addresse").value(costumerDto.domicile()));
        response.andExpect(jsonPath("$.mail").value(costumerDto.mail()));
        response.andExpect(jsonPath("$.phone").value(costumerDto.phone()));
        response.andExpect(header().string(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
        response.andExpect(status().isOk());
        // Ajoutez d'autres assertions selon vos besoins pour vérifier le comportement attendu

        verify(clientRepMapper,times(1)).clientsToCostumerDto(clients);
        verify(costumerService,times(1)).createCostumer(costumerDto);

    }

}