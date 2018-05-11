package com.smartbean.repository;

import com.smartbean.domain.GoodsGallery;
import com.smartbean.domain.GoodsSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GoodsSpecificationRepository extends JpaRepository<GoodsSpecification, Long>, JpaSpecificationExecutor<GoodsSpecification> {
    public List<GoodsSpecification> findByGoodsId(long goodsId);
}
