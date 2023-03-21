package com.renatowagner.payment.adapters.out.repository;

import com.renatowagner.payment.adapters.out.repository.entity.PaymentEntity;
import com.renatowagner.payment.adapters.out.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
}
