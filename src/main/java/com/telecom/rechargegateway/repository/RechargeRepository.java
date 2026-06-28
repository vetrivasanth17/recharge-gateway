package com.telecom.rechargegateway.repository;

import com.telecom.rechargegateway.entity.Recharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargeRepository extends JpaRepository<Recharge, Long> {

    List<Recharge> findByStatus(String status);

}