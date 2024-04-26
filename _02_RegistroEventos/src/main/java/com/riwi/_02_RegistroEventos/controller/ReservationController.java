package com.riwi._02_RegistroEventos.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riwi._02_RegistroEventos.entities.Reservation;
import com.riwi._02_RegistroEventos.servicio.abstractService.IReservationService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/reservations")
public class ReservationController {

    @Autowired
    private final IReservationService objIReservationService;

    @GetMapping("/{page}/{size}")
    public ResponseEntity<Page<Reservation>> findAll(@PathVariable int page, @PathVariable int size ){
        Page<Reservation> objReservation = this.objIReservationService.findAllReservation(page, size);
        return ResponseEntity.ok(objReservation);
    }

    @PostMapping
    public ResponseEntity<Reservation> create(@RequestBody Reservation objReservation){
        if (objReservation.getDate().isAfter(LocalDate.now())) {
            if (objReservation.getMaxCapacity() > 0) {
                return ResponseEntity.ok(this.objIReservationService.create(objReservation)); 
            }else {
                return ResponseEntity.noContent().build();
            }
        }else {
            return ResponseEntity.noContent().build();
        }
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getById(@PathVariable String id){
        return ResponseEntity.ok(this.objIReservationService.getById(id));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Reservation> update(@RequestBody Reservation objReservation, @PathVariable String id){
        objReservation.setId(id);
        return ResponseEntity.ok(this.objIReservationService.update(objReservation));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.objIReservationService.delete(id);
        return ResponseEntity.noContent().build();  
    }
}
