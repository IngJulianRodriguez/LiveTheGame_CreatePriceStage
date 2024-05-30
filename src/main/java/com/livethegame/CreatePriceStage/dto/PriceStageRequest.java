package com.livethegame.CreatePriceStage.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

@ApiModel()
public class PriceStageRequest {

    @ApiModelProperty(name = "Fecha inicio de etapa de precios", required = false,example = "", value = "")
    private LocalDate starts_at;
    @ApiModelProperty(name = "Fecha fin de etapa de precios", required = false,example = "", value = "")
    private LocalDate finish_at;
    @ApiModelProperty(name = "Nombre de la etapa", required = false,example = "", value = "")
    private String name;
    @ApiModelProperty(name = "Precio del servicio", required = true,example = "", value = "")
    private long price;
    @ApiModelProperty(name = "id del servicio", required = true, example = "", value = "")
    private long service_id;
    @ApiModelProperty(name = "id del torneo o transmision", required = true, example = "", value = "")
    private Long service_id_value;
    public PriceStageRequest(){
    }

    public LocalDate getStarts_at() {
        return starts_at;
    }

    public void setStarts_at(LocalDate starts_at) {
        this.starts_at = starts_at;
    }

    public LocalDate getFinish_at() {
        return finish_at;
    }

    public void setFinish_at(LocalDate finish_at) {
        this.finish_at = finish_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getService_id() {
        return service_id;
    }

    public void setService_id(long service_id) {
        this.service_id = service_id;
    }

    public Long getService_id_value() {
        return service_id_value;
    }

    public void setService_id_value(Long service_id_value) {
        this.service_id_value = service_id_value;
    }
}
