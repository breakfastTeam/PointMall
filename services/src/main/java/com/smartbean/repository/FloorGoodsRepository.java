package com.smartbean.repository;

import com.smartbean.domain.Floor;
import com.smartbean.domain.FloorGoods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface FloorGoodsRepository extends JpaRepository<FloorGoods, Long>, JpaSpecificationExecutor<FloorGoods> {
    public List<FloorGoods> findByFloorId(Long floorId);
}
