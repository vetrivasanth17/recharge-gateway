package com.telecom.rechargegateway.controller;

import com.telecom.rechargegateway.entity.Recharge;
import com.telecom.rechargegateway.service.RechargeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recharges")
public class RechargeController {

    private final RechargeService rechargeService;

    public RechargeController(RechargeService rechargeService) {
        this.rechargeService = rechargeService;
    }

    @PostMapping
    public Recharge createRecharge(@RequestBody Recharge recharge) {
        return rechargeService.createRecharge(recharge);
    }

    @GetMapping
    public List<Recharge> getAllRecharges() {
        return rechargeService.getAllRecharges();
    }

    @GetMapping("/{id}")
    public Recharge getRechargeById(@PathVariable Long id) {
        return rechargeService.getRechargeById(id);
    }

    @PutMapping("/{id}/cancel")
    public Recharge cancelRecharge(@PathVariable Long id) {
        return rechargeService.cancelRecharge(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRecharge(@PathVariable Long id) {

        rechargeService.deleteRecharge(id);

        return "Recharge Deleted Successfully";
    }

    @GetMapping("/status/{status}")
    public List<Recharge> getRechargeByStatus(@PathVariable String status) {
        return rechargeService.getRechargeByStatus(status);
    }

}