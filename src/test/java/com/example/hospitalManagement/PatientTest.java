package com.example.hospitalManagement;

import com.example.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.entity.type.BloodGroupType;
import com.example.hospitalManagement.repository.PatientRepository;
import com.example.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.List;

//@SpringBootTest
//public class PatientTest {
//    @Autowired
//    private PatientRepository patientRepository;
//
//    @Autowired
//    private PatientService  patientService;
//
//    @Test
//    public void testPatientRepository(){
////        List<Patient> patientList = patientRepository.findAll();
//        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
//        System.out.println(patientList);
//
//
//    }
//
//    @Test
//    public void testPatientMethods(){
////       Patient patient = patientService.getPatientById(1L);
////        System.out.println(patient);
//
////        Patient patient = patientRepository.findByName("Diya Patel");
//
////        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1988,3,15),"diya.patel@example.com");
////        List<Patient> patientList = patientRepository.findByBloodGroup(BloodGroupType.A_POSITIVE);
////        List<Patient> patientList = patientRepository.findByBornAfterDate(LocalDate.of(1988,3,14));
////        for (Patient patient:patientList){
////            System.out.println(patient);
////        }
////        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
////        for (Object[] objects:bloodGroupList){
////            System.out.println(objects[0]+" "+objects[1]);
////        }
//
////        List<BloodGroupCountResponseEntity> bloodGroupList = patientRepository.countEachBloodGroupType();
////        for (BloodGroupCountResponseEntity BloodGroupCountResponse:bloodGroupList){
////            System.out.println(BloodGroupCountResponse);
////        }
//
////                List<Patient> patientList = patientRepository.findAllPatients();
////                Page<Patient> patientList = patientRepository.findAllPatients(PageRequest.of(0,2));
////        for (Patient patient:patientList){
////            System.out.println(patient);
////        }
//
////                int rowsUpdated = patientRepository.updateNameWithId("Arav Sharma", 1L);
////                System.out.println(rowsUpdated);
//
//
//
//    }
//
//
//}
