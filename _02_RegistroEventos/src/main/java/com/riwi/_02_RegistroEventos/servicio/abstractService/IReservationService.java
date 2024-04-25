package com.riwi._02_RegistroEventos.servicio.abstractService;

import java.util.List;

import org.springframework.data.domain.Page;

import com.riwi._02_RegistroEventos.entities.Reservation;


public interface IReservationService {


    public List<Reservation> getAll();
    public Reservation getById(String id);
    public Reservation create(Reservation objReservation);
    public Reservation update(Reservation objReservation);
    public void delete(String id);
    public Page<Reservation> findAllReservation(int page, int size);
}
