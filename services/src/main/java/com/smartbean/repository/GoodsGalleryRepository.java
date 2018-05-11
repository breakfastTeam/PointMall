package com.smartbean.repository;

import com.smartbean.domain.Goods;
import com.smartbean.domain.GoodsGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GoodsGalleryRepository extends JpaRepository<GoodsGallery, Long>, JpaSpecificationExecutor<GoodsGallery> {
    public List<GoodsGallery> findByGoodsId(long goodsId);
}
