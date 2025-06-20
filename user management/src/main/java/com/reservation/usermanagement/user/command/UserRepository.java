package com.reservation.usermanagement.user.command;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : El-Merjani Mohamed
 * Date : 5/26/2025
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
