package com.landon.hotel.guest.app.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String username);
}
