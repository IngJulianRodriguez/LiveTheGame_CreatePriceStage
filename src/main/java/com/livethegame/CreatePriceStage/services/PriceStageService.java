package com.livethegame.CreatePriceStage.services;

import com.livethegame.CreatePriceStage.Utils.Mapper;
import com.livethegame.CreatePriceStage.common.PriceStageResponseMapper;
import com.livethegame.CreatePriceStage.dto.PriceStageRequest;
import com.livethegame.CreatePriceStage.dto.PriceStageResponse;
import com.livethegame.CreatePriceStage.entities.*;
import com.livethegame.CreatePriceStage.exception.ServiceNotFoundException;
import com.livethegame.CreatePriceStage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class PriceStageService {

    @Autowired
    PriceStageRepository priceStageRepository;
    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    PriceStageResponseMapper priceStageResponseMapper;

    public PriceStageResponse createPriceStage(PriceStageRequest priceStageRequest){
        Optional<Services> optionalService = servicesRepository.findById(priceStageRequest.getService_id());
        if (optionalService.isEmpty()) {
            throw new ServiceNotFoundException("Servicio no encontrado con ID: " + priceStageRequest.getService_id());
        }
        PriceStages priceStageRequestToPriceStage = Mapper.PriceStageRequestToPriceStage(priceStageRequest,optionalService.get());
        PriceStages save = priceStageRepository.save(priceStageRequestToPriceStage);
        PriceStageResponse priceStageResponse= priceStageResponseMapper.PriceStagesToPriceStageResponse(save);

        return priceStageResponse;
    }

}
