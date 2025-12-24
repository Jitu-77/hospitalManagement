package com.example.hospitalManagement;

import com.example.hospitalManagement.entity.Appointment;
import com.example.hospitalManagement.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {

//    @Autowired
//    private AppointmentService appointmentService;
//
//    @Test
//    public void testCreateApp(){
//
//        Appointment appointment = Appointment.builder()
//                .appointmentTime(LocalDateTime.of(2025,12,30,13,14,00))
//                .reason("Check Up")
//                .build();
//        var newAppointment = appointmentService.createNewAppointment(appointment,3L,2L);
//        System.out.println(newAppointment);
//
//
//        var updatedAppointment =      appointmentService.reAssignAppointmentToAnotherDoctor(newAppointment.getId(),2L);
//        System.out.println(updatedAppointment);
//
//
//
//    }
}
