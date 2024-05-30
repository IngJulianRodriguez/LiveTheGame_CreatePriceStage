package com.livethegame.CreatePriceStage;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.livethegame.CreatePriceStage.common.PriceStageResponseMapper;
import com.livethegame.CreatePriceStage.controller.CreatePriceStageRestController;
import com.livethegame.CreatePriceStage.dto.PriceStageRequest;
import com.livethegame.CreatePriceStage.dto.PriceStageResponse;
import com.livethegame.CreatePriceStage.repository.PriceStageRepository;
import com.livethegame.CreatePriceStage.services.PriceStageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Base64;

@WebMvcTest(CreatePriceStageRestController.class)
@AutoConfigureMockMvc
class CreatePriceStageApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PriceStageRepository priceStageRepository;


    @MockBean
    private PriceStageService priceStageService;
    @MockBean
    private PriceStageResponseMapper priceStageResponseMapper;

    private static final String PASSWORD = "admin";
    private static final String PriceStage = "admin";


    public void testCreatePriceStage_Success() throws Exception {
        PriceStageRequest request = new PriceStageRequest();
        PriceStageResponse response = new PriceStageResponse();
        response.setId(1L);
        mockMvc.perform(MockMvcRequestBuilders.post("/priceStages/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testCreatePriceStage_Business_ServiceNotFound() throws Exception {

    }


    @Test
    public void testCreatePriceStage_Business_WithoutAuthorization() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/priceStages/create")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void testCreatePriceStage_Business_testUnauthorizedAccess() throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodingParaUsuarioSinPermiso = encoder.encodeToString(("usuario" + ":" + "password").getBytes());
        mockMvc.perform(MockMvcRequestBuilders.get("/priceStages/create")
                        .header("Authorization", "Basic " + encodingParaUsuarioSinPermiso)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
    private String asJsonString(Object obj) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

}
