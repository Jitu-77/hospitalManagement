package com.example.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

//    Appointment to Patient is many to one
//    Appointment cannot be there without Patient
//    Patient to Appointment --many to one
    //same concept for doctor


    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "patient_id", nullable = false)  // patient is required and not nullable
    private Patient patient;

//    @ManyToOne
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(nullable = false)  // doctor is required and not nullable
    private Doctor doctor;
}
