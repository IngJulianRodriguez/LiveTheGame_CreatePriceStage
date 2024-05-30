package com.livethegame.CreatePriceStage.common;

import com.livethegame.CreatePriceStage.dto.PriceStageResponse;
import com.livethegame.CreatePriceStage.entities.PriceStages;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface PriceStageResponseMapper {
    PriceStageResponse PriceStagesToPriceStageResponse(PriceStages source);
}
