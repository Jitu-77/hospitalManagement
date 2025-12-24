package com.example.hospitalManagement;

import com.example.hospitalManagement.entity.Insurance;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

//@SpringBootTest
//public class InsuranceTests {
//    @Autowired
//    private InsuranceService insuranceService;
//
//    @Test
//    public void testInsurance(){
//        Insurance insurance = Insurance.builder()
//                .policyNumber("HDFC_12234")
//                .provider("HDFC")
//                .validUntil(LocalDate.of(2030,2,12))
//                .build();
//        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);
//        System.out.println("PATIENT"+patient);
//
//        var newPatient = insuranceService.disassociateInsuranceFromPatient(patient.getId());
//        System.out.println(newPatient);
//    }
//}
