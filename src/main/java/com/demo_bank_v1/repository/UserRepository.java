package com.demo_bank_v1.repository;

import com.demo_bank_v1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByTokenAndCode(String token, String code);
    boolean existsByToken(String token);
    boolean existsByEmail(String email);
    User getUserByEmail(String email);


}
