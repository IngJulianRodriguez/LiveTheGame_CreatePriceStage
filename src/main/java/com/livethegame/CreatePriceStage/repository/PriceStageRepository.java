package com.livethegame.CreatePriceStage.repository;

import com.livethegame.CreatePriceStage.entities.PriceStages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceStageRepository extends JpaRepository<PriceStages, Long> {
}
