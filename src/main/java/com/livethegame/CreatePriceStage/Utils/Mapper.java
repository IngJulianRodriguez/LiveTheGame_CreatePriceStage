package com.livethegame.CreatePriceStage.Utils;

import com.livethegame.CreatePriceStage.dto.PriceStageRequest;
import com.livethegame.CreatePriceStage.entities.PriceStages;
import com.livethegame.CreatePriceStage.entities.Services;

public  class Mapper {
    public static PriceStages PriceStageRequestToPriceStage(PriceStageRequest source, Services service){
        PriceStages priceStages = new PriceStages();
        priceStages.setPrice(source.getPrice());
        priceStages.setName(source.getName());
        priceStages.setStarts_at(source.getStarts_at());
        priceStages.setService(service);
        priceStages.setFinish_at(source.getFinish_at());
        priceStages.setService_id_value(source.getService_id_value());
        return priceStages;
    };
}
