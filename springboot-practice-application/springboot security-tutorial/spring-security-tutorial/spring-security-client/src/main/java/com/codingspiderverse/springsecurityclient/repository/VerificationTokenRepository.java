package com.codingspiderverse.springsecurityclient.repository;

import com.codingspiderverse.springsecurityclient.entity.User;
import com.codingspiderverse.springsecurityclient.entity.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

     VerificationToken findByToken(String token);


     VerificationToken findByUser(User user);
}
