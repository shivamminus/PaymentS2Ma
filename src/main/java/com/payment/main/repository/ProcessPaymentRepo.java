package com.payment.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.main.model.ProcessDetailStatus;

public interface ProcessPaymentRepo extends JpaRepository<ProcessDetailStatus, Integer> {

}
