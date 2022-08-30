package com.iba.messmanagementsystem.controllers.show;

import com.iba.messmanagementsystem.dto.CookHelperDto;
import com.iba.messmanagementsystem.models.Cook_Helpers;
import com.iba.messmanagementsystem.models.MessMenue;
import com.iba.messmanagementsystem.models.On_OFF;
import com.iba.messmanagementsystem.models.Students;
import com.iba.messmanagementsystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ShowAllControllerData {

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

    @PostConstruct
    public List<String> getCookDetails(){
        CookHelperDto cookHelper = cookHelperRepository.getCookDetails();
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
    @PostConstruct
    public List<String> getHelperDetails(){
        CookHelperDto cookHelper = cookHelperRepository.getHelperDetails();
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
    @PostConstruct
    public List<Students> getAllStudents(){
        return  studentsRepository.findAll();
    }
    @PostConstruct
    public List<On_OFF> getOnOff() {
        return on_offRepository.findAll();
    }

    @RequestMapping("/")
    public String goHome(Model model){
        List<Students> students = getAllStudents();

        model.addAttribute("cookDetails", getCookDetails());
        model.addAttribute("helperDetails", getHelperDetails());

        model.addAttribute("numStudents", students.size());//200ok
        model.addAttribute("collected", paymentsRepository.getTotalCollectedAmount());//200ok
        model.addAttribute("expenditures", paymentsRepository.getTotalExpendituresAmount());//200ok
        model.addAttribute("unitcost", paymentsRepository.getUnitCost());//200ok

        model.addAttribute("menulist", messMenueRepository.findAll());//200ok

        model.addAttribute("students", studentsRepository.findAll());//200ok

        model.addAttribute("on_off_list", getOnOff());//200ok

        model.addAttribute("paymentList", paymentsRepository.findAll());//200ok

        model.addAttribute("messTimings", messTimingRepository.findAll());

        model.addAttribute("messManagers", messMenueRepository.findAll());
        return "index";
    }

    @GetMapping("/goToFilter")
    public String goFilter(Model model){
        model.addAttribute("students", studentsRepository.findAll());
        return "forms/filterPages/filteredStudents";
    }

    @RequestMapping("/showAllStudentsFiltered")
    public String showStudentFilteredData(Model model, @RequestParam(value = "keyword", required = false) String keyword){
        model.addAttribute("filter by", keyword);
        model.addAttribute("students", studentsRepository.getStudentByFilter(keyword));
        return "forms/filterPages/filteredStudents";
    }

    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/403")
    public String accessDenied(){
        return "deniedaccess";
    }

    @RequestMapping("/logout-success")
    public String logout(){
        return "redirect:/";
    }


}
