package com.smartbean.service.impl;

import com.google.common.collect.Lists;
import com.smartbean.domain.Ad;
import com.smartbean.domain.Floor;
import com.smartbean.domain.FloorGoods;
import com.smartbean.domain.Goods;
import com.smartbean.dto.FloorGoodsDTO;
import com.smartbean.repository.AdRepository;
import com.smartbean.repository.FloorGoodsRepository;
import com.smartbean.repository.FloorRepository;
import com.smartbean.repository.GoodsRepository;
import com.smartbean.service.AdService;
import com.smartbean.service.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorRepository floorRepository;

    @Autowired
    private FloorGoodsRepository floorGoodsRepository;

    @Autowired
    private GoodsRepository goodsRepository;




    @Override
    public Floor findOne(Long id) {
        return floorRepository.getOne(id);
    }

    @Override
    public Floor saveOrUpdate(Floor floor) {
        return floorRepository.saveAndFlush(floor);
    }

    @Override
    public Page<Floor> findAll(Floor floor, Pageable pageable) {
        return floorRepository.findAll(new Specification<Floor>() {
            @Override
            public Predicate toPredicate(Root<Floor> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (!StringUtils.isEmpty(floor.getName())) {
                    list.add(cb.like(root.get("name").as(String.class), "%"+floor.getName()+"%"));
                }

                Predicate[] p = new Predicate[list.size()];
                return cb.and(list.toArray(p));
            }
        }, pageable);
    }

    @Override
    public List<Floor> findAll() {
        return floorRepository.findAll();
    }

    @Override
    public List<FloorGoodsDTO> findAllFloorAndGoods() {

        List<FloorGoodsDTO> floorGoodsDTOS = Lists.newArrayList();
        List<Floor> floors = this.findAll();
        for(Floor floor:floors){
            List<FloorGoods> floorGoods = floorGoodsRepository.findByFloorId(floor.getId());
            List<Goods> goods = Lists.newArrayList();
            for(FloorGoods fg:floorGoods){
                Goods g = goodsRepository.getOne(fg.getGoodsId());
                goods.add(g);
            }
            FloorGoodsDTO floorGoodsDTO = new FloorGoodsDTO();
            floorGoodsDTO.setFloor(floor);
            floorGoodsDTO.setGoods(goods);
            floorGoodsDTOS.add(floorGoodsDTO);
        }
        return floorGoodsDTOS;
    }

}
