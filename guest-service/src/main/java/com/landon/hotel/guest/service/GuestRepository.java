package com.landon.hotel.guest.service;

import com.landon.hotel.guest.service.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Frank P. Moley III.
 */
@Repository
public interface GuestRepository extends JpaRepository<Guest, Long> {
}
