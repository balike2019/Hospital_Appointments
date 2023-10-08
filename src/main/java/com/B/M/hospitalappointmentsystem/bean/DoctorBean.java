package com.B.M.hospitalappointmentsystem.bean;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Table(name="Doctor")
@Entity
@Component
public class DoctorBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String specialization;

    @Column(nullable = false)
    private Long phoneNumber;
}
