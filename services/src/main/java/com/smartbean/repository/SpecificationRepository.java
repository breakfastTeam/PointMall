package com.smartbean.repository;

import com.smartbean.domain.GoodsSpecification;
import com.smartbean.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SpecificationRepository extends JpaRepository<Specification, Long>, JpaSpecificationExecutor<Specification> {
}
