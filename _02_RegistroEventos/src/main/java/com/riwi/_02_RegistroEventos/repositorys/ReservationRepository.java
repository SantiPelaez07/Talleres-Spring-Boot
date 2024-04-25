package com.riwi._02_RegistroEventos.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi._02_RegistroEventos.entities.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

}
