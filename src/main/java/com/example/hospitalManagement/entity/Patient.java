package com.example.hospitalManagement.entity;

import com.example.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name ="patient",
        uniqueConstraints= {
                @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
               @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "birthDate"})
        },
        indexes = {
            @Index(name = "idx_patient_birth_date", columnList = "birthDate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @ToString.Exclude()
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "blood_group")
    private BloodGroupType bloodGroup;

//    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true) // helps to disassociate child from parent
    //(cascade = {CascadeType.MERGE,CascadeType.PERSIST}) -- helps when I want to save a new insurance it will get automatically get created in the insurance
    //when we do any opt. on parent then how is this opt. gets propagated to the child  --cascading
    @JoinColumn(name="patient_insurance_id") //owning side
    private Insurance insurance;

    //This is biderectional mapping when we use mappedBy
    // what happens no column will be created in the Table
    //but JPA knows this and it will give a method
    //--patient.getAppointments()
//    @OneToMany(mappedBy = "patient" ,fetch = FetchType.EAGER ) -- we can also set fetchType Eager/Lazy

//    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true) // here die to OrphanRemoval se as true it will also delete the same entity from child Table also the whole entity
    //cascade = {CascadeType.REMOVE} -- as patient is parent so cascade is here , so that if we remove any patient,
    //automatically the respective app also gets removed.
    //orphanRemoval = true --- child cannot exist without Parent
//    @ToString.Exclude
    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Appointment> appointments = new ArrayList<>();
}
