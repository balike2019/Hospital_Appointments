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
@Table(name="Patient")
@Entity
@Component
public class PatientBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private Long phoneNumber;

    public PatientBean(long l, String john) {
    }
}
