package com.B.M.hospitalappointmentsystem.controller;

import com.B.M.hospitalappointmentsystem.bean.AppointmentBean;
import com.B.M.hospitalappointmentsystem.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;
    private final AppointmentBean appointmentBean;

    @Autowired
    public AppointmentController(AppointmentService appointmentService,AppointmentBean appointmentBean) {
        this.appointmentService = appointmentService;
        this.appointmentBean=appointmentBean;
    }

    // HTTP GET method to retrieve all appointments
    @GetMapping
    public List<AppointmentBean> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // HTTP GET method to retrieve appointments for a specific date
    /*@GetMapping("/{date}")
    public List<AppointmentBean> getAppointmentsForDate(@PathVariable LocalDateTime date) {
        return appointmentBean.getAppointmentDateTime(date);
    }
*/
    // HTTP POST method to create a new appointment
    @PostMapping
    public void createAppointment(@RequestBody AppointmentBean appointment) {
        appointmentService.scheduleAppointment(appointment);
    }

    // HTTP PUT method to update an existing appointment
    @PutMapping("/{id}")
    public void updateAppointment(@PathVariable Long id, @RequestBody AppointmentBean appointment) {
        appointmentService.updateAppointment(id, appointment);
    }

    // HTTP DELETE method to remove an appointment
   /* @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
    }

    */
}

