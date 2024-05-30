package com.livethegame.CreatePriceStage.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel()
public class PriceStageResponse {

    @ApiModelProperty(name = "Id", required = true,example = "", value = "")
    private Long id;

    public PriceStageResponse(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
