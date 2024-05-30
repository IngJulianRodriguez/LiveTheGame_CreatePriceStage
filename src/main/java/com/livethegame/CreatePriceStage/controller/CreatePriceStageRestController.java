package com.livethegame.CreatePriceStage.controller;

import com.livethegame.CreatePriceStage.dto.PriceStageRequest;
import com.livethegame.CreatePriceStage.dto.PriceStageResponse;
import com.livethegame.CreatePriceStage.exception.*;
import com.livethegame.CreatePriceStage.services.MonitoringService;
import com.livethegame.CreatePriceStage.services.PriceStageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Api Create Price Stage")
@RestController
@RequestMapping("/priceStages")
public class CreatePriceStageRestController {

    @Autowired
    PriceStageService priceStageService;
    @Autowired
    MonitoringService monitoringService;

    @PostMapping("/create")
    public ResponseEntity<?> createPriceStage(@RequestBody PriceStageRequest input) {
        try {
            PriceStageResponse PriceStageResponse = priceStageService.createPriceStage(input);
            monitoringService.registerSuccessLog(String.valueOf(""),"/create "+input.toString()+" "+ PriceStageResponse);
            return ResponseEntity.ok(PriceStageResponse);
        } catch (ServiceNotFoundException e) {
            monitoringService.registerControlledExceptionLog("","/create "+input.toString()+" "+e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            monitoringService.registerNotControlledExceptionLog("","/create "+input.toString()+" "+e.getMessage());
            return ResponseEntity.status(500).body("Error interno del servidor");
        }
    }
    @GetMapping("/test-create")
    public ResponseEntity<?> testCreatePriceStage(){
        return ResponseEntity.ok().build();
    }
}
