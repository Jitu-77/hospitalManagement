package com.example.hospitalManagement.service;

import com.example.hospitalManagement.entity.Insurance;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.repository.InsuranceRepository;
import com.example.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private  final PatientRepository patientRepository;

    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patient_id){
        Patient patient =  patientRepository.findById(patient_id)
                .orElseThrow(()-> new EntityNotFoundException("Patient not found with id:"+patient_id));
        patient.setInsurance(insurance);
        insurance.setPatient(patient); // bi-directional consistency
        // Need not write ,  patient.setInsurance(insurance); will take care of it
        // as this a Transactional so it will first save in insurance if insurance is not present and then it will attach in patient
        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Long patientiD){
        Patient patient = patientRepository.findById(patientiD).orElseThrow();
        patient.setInsurance(null);
        return patient;
    }

}
