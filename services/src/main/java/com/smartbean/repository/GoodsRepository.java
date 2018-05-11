package com.smartbean.repository;

import com.smartbean.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface GoodsRepository extends JpaRepository<Goods, Long>, JpaSpecificationExecutor<Goods> {
    public List<Goods> findTop6ByIsHot(long isHot);

    public List<Goods> findTop6ByIsNew(long isNew);

    public Goods findById(long goodsId);

    public List<Goods> findTop6ByCategoryId(long categoryId);
}
