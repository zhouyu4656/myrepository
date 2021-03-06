package com.imooc.ad.dao;

import com.imooc.ad.entity.AdPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdPlanRepository extends JpaRepository<AdPlan,Long> {

    AdPlan findByIdAndUserId(Long id,Long userId);
    List<AdPlan> findAllByIdInAndUserId(List<Long> id, Long userId);
    AdPlan findByUserIdAndPlanName(Long id,String planName);
    List<AdPlan> findAllByPlanStatus(Integer planStatus);
}
