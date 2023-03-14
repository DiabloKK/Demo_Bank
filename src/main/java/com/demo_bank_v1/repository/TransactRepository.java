package com.demo_bank_v1.repository;

import com.demo_bank_v1.models.Transact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactRepository extends JpaRepository<Transact, Integer> {


}
