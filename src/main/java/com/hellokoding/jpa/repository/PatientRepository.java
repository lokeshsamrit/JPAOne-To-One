package com.hellokoding.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellokoding.jpa.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
