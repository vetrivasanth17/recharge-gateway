package com.telecom.rechargegateway.service;

import com.telecom.rechargegateway.entity.Recharge;
import com.telecom.rechargegateway.repository.RechargeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RechargeService {

    private final RechargeRepository rechargeRepository;

    public RechargeService(RechargeRepository rechargeRepository) {
        this.rechargeRepository = rechargeRepository;
    }

    public Recharge createRecharge(Recharge recharge) {

        recharge.setStatus("SUCCESS");
        recharge.setRechargeDate(LocalDateTime.now());

        return rechargeRepository.save(recharge);
    }

    public List<Recharge> getAllRecharges() {
        return rechargeRepository.findAll();
    }

    public Recharge getRechargeById(Long id) {
        return rechargeRepository.findById(id).orElse(null);
    }

    public Recharge cancelRecharge(Long id) {

        Recharge recharge = rechargeRepository.findById(id).orElse(null);

        if (recharge == null) {
            return null;
        }

        recharge.setStatus("CANCELLED");

        return rechargeRepository.save(recharge);
    }

    public void deleteRecharge(Long id) {
        rechargeRepository.deleteById(id);
    }

    public List<Recharge> getRechargeByStatus(String status) {
        return rechargeRepository.findByStatus(status);
    }

}