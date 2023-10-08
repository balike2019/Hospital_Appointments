package com.B.M.hospitalappointmentsystem.bean;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
@Table(name="Appointment")
@Entity
public class AppointmentBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorBean doctorBean;
    @Column(nullable = false)
    private LocalDateTime appointmentTime;
    @OneToOne
    @Column(name="patient_id",nullable = false)
    private PatientBean patientBean;
    @Column(nullable = false)
    private String appointmentStatus;

    @Column(nullable = false)
    private LocalDateTime appointmentDateTime;


}
 