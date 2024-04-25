package com.riwi._02_RegistroEventos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi._02_RegistroEventos.entities.Reservation;
import com.riwi._02_RegistroEventos.repositorys.ReservationRepository;
import com.riwi._02_RegistroEventos.servicio.abstractService.IReservationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationService implements IReservationService {
    
    @Autowired
    private final ReservationRepository objRepository;

    @Override
    public Reservation create(Reservation objReservation) {
        return this.objRepository.save(objReservation);
    }

    @Override
    public void delete(String id) {
        Reservation objReservation = this.objRepository.findById(id).orElseThrow();
        this.objRepository.delete(objReservation);
    }

    @Override
    public List<Reservation> getAll() {
        return this.objRepository.findAll();
    }

    @Override
    public Reservation getById(String id) {
        return this.objRepository.findById(id).orElse(null);
    }

    @Override
    public Reservation update(Reservation objReservation) {
        return this.objRepository.save(objReservation);
    }

    // Realización de la paginación
    @Override
    public Page<Reservation> findAllReservation(int page, int size) {
        if (page < 0) {
            page = 0;
        }
        Pageable objPage = PageRequest.of(page, size);
        return this.objRepository.findAll(objPage);
    }
}
