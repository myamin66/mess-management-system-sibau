package com.iba.messmanagementsystem.controllers.show;

import com.iba.messmanagementsystem.dto.CookHelperDto;
import com.iba.messmanagementsystem.models.On_OFF;
import com.iba.messmanagementsystem.models.Students;
import com.iba.messmanagementsystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShowDeletedRecordsController {

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private DailyUnitPriceRepository dailyUnitPriceRepository;

    @Autowired
    private MessTimingRepository messTimingRepository;

    @Autowired
    private MessMenueRepository messMenueRepository;

    @Autowired
    private On_OFFRepository on_offRepository;

    @Autowired
    private CookHelperRepository cookHelperRepository;

    @Autowired
    private MessManagerRepository managerRepository;

    public List<String> getCookDetails(){
        CookHelperDto cookHelper = cookHelperRepository.getCookDeletedDetails();
        List<String> cook = new ArrayList<>();
        if(cookHelper == null){
            cook.add("none");
            cook.add("none");
            cook.add("none");
            return cook;
        }else {
            cook.add(cookHelper.getName());
            cook.add(cookHelper.getPhone());
            cook.add(cookHelper.getId().toString());
            return cook;
        }
    }

    public List<String> getHelperDetails(){
        CookHelperDto cookHelper = cookHelperRepository.getHelperDeletedDetails();
        List<String> cook = new ArrayList<>();
        if(cookHelper == null){
            cook.add("none");
            cook.add("none");
            cook.add("none");
            return cook;
        }else {
            cook.add(cookHelper.getName());
            cook.add(cookHelper.getPhone());
            cook.add(cookHelper.getId().toString());
            return cook;
        }
    }

    public List<Students> getAllStudents(){
        return  studentsRepository.findAllDeleted();
    }

    public List<On_OFF> getOnOff() {
        return on_offRepository.findAllDeleted();
    }

    @RequestMapping("/deletedData")
    public String goDeleteRecords(Model model){
        List<Students> students = getAllStudents();

        model.addAttribute("cookDetails", getCookDetails());
        model.addAttribute("helperDetails", getHelperDetails());

        model.addAttribute("numStudents", students.size());//200ok
        model.addAttribute("collected", paymentsRepository.getTotalCollectedAmount());//200ok
        model.addAttribute("expenditures", paymentsRepository.getTotalExpendituresAmount());//200ok
        model.addAttribute("unitcost", paymentsRepository.getUnitCost());//200ok

        model.addAttribute("menulist", messMenueRepository.findDeletedAll());//200ok

        model.addAttribute("students", studentsRepository.findAllDeleted());//200ok

        model.addAttribute("on_off_list", getOnOff());//200ok

        model.addAttribute("paymentList", paymentsRepository.findAllDeleted());//200ok

        model.addAttribute("messTimings", messTimingRepository.findAllDeleted());

        model.addAttribute("messManagers", messMenueRepository.findDeletedAll());
        return "deleted";
    }
}
