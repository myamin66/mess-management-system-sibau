package com.iba.messmanagementsystem.rest_controllers;


import com.iba.messmanagementsystem.dto.CookHelperDto;
import com.iba.messmanagementsystem.dto.On_Off_StatusDto;
import com.iba.messmanagementsystem.dto.PaymentDetailsDto;
import com.iba.messmanagementsystem.dto.StudentWithUnits;
import com.iba.messmanagementsystem.models.*;
import com.iba.messmanagementsystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/show")
public class ShowAllController {

    @Autowired
    private MessMenueRepository messMenueRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;


    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private UnitsRepository unitsRepository;

    @Autowired
    private On_OFFRepository on_offRepository;

    @Autowired
    private CookHelperRepository cookHelperRepository;

    @Autowired
    private MessManagerRepository managerRepository;

    @GetMapping("/messMenue")
    private List<MessMenue> getMessMenue(){
        List<MessMenue> mess = messMenueRepository.findAll();
        return mess;
    }

    @GetMapping("/students")
    public List<Students> getAllStudents(){
        return studentsRepository.findAll();
    }

    @GetMapping("/filterStudents/{keyword}")
    public List<Students> filterStudentsByKeyword(@PathVariable("keyword") String keyword){
        return studentsRepository.getStudentByFilter(keyword);
    }

    @GetMapping("/on_off_status")
    public List<On_Off_StatusDto> getStudentsMessOnOffStatus(){
        return on_offRepository.getStatus();
    }

    @GetMapping("/cookDetails")
    public CookHelperDto getCookDetails(){
        return cookHelperRepository.getCookDetails();
    }

    @GetMapping("/helperDetails")
    public CookHelperDto getHelperDetails(){
        return cookHelperRepository.getHelperDetails();
    }

    @GetMapping("/messManagerDetails")
    public List<MessManager> getMessManagerDetails(){
        return managerRepository.findAll();
    }


}
