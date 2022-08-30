package com.iba.messmanagementsystem.controllers.update;
import com.iba.messmanagementsystem.models.*;
import com.iba.messmanagementsystem.repositories.StudentsRepository;
import com.iba.messmanagementsystem.services.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UpdateControllerImpl extends UpdateController{

    @Autowired
    private UpdateService updateService;
    Date cookDate = null;


    @Autowired
    private StudentsRepository studentsRepository;

    @PostConstruct
    public List<String> getAllStudents(){
        List<String> students = new ArrayList<>();
        for(Students student:studentsRepository.findAll())
            students.add(student.getId()+"-"+student.getStudentName());
        return students;
    }

    @GetMapping("/showFormForUpdateCook/{id}")
    @Override
    public String showFormForUpdateCookDetails(@PathVariable( value = "id") Integer id, Model model) {
        try {
            Cook_Helpers cookDetails = updateService.getCookToUpdate(id);
            cookDate = cookDetails.getRegisteredDate();
            model.addAttribute("cookDetails", cookDetails);
            return "forms/update/update_cook_details";
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: cook/helper does not Exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" cook/helper does not exists");
            model.addAttribute("error","cook/helper does not exist");
            return "common/ErrorPage";
        }
    }

    @Override
    @PostMapping("/cook/saveUpdate")
    public String saveUpdateCook(@ModelAttribute("cookDetails") Cook_Helpers cookDetails, Model model) {
        try {
            Date date = new Date();
            System.out.println(date.getTime());
            cookDetails.setRegisteredDate(date);
            System.out.println("Cook Details are going to update with "+ cookDetails);
            updateService.saveCook(cookDetails);
            return "redirect:/";
        }
        catch(DataIntegrityViolationException e){
            model.addAttribute("error","Cook Already Exist");
            return "forms/update/update_cook_details";
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+": may be phone is going to be repeat");
        }
        return "forms/update/update_cook_details";
    }

    @GetMapping("/showFormForUpdateHelper/{id}")
    @Override
    public String showFormForUpdateHelperDetails(@PathVariable( value = "id") Integer id, Model model) {
        try {
            Cook_Helpers helperDetails = updateService.getHelperToUpdate(id);
            model.addAttribute("helperDetails", helperDetails);
            return "forms/update/update_helper_details";
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: helper does not Exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" cook/helper does not exists");
            model.addAttribute("error","cook/helper does not exist");
            return "common/ErrorPage";
        }
    }

    @Override
    @PostMapping("/helper/saveUpdate")
    public String saveUpdateHelper(@ModelAttribute("helperDetails") Cook_Helpers helperDetails, Model model) {
        try {
            Date date=java.util.Calendar.getInstance().getTime();
            System.out.println(date);
            helperDetails.setRegisteredDate(date);
            helperDetails.setRegisteredDate(helperDetails.getRegisteredDate());
            updateService.saveHelper(helperDetails);
            return "redirect:/";
        }
        catch(DataIntegrityViolationException e){
            model.addAttribute("error","Helper Already Exist");
            return "forms/update/update_helper_details";
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+": may be something is going to be repeat");
        }
        return "forms/update/update_helper_details";
    }

    @GetMapping("/showFormForMessMenu/{id}")
    public String showFormForUpdateMessMenu(@PathVariable( value = "id") Integer id, Model model) {
        try {
            MessMenue messMenu = updateService.getMessMenu(id);
            model.addAttribute("messMenu", messMenu);
            return "forms/update/update_mess_menu";
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: helper does not Exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" Menu does not exists");
            model.addAttribute("error","Menu does not exist");
            return "common/ErrorPage";
        }
    }

    @PostMapping("/menu/saveUpdate")
    public String saveUpdateMessMenu(@ModelAttribute("messMenu") MessMenue messMenu, Model model) {
        try {
            Date date=java.util.Calendar.getInstance().getTime();
            System.out.println(date);
            messMenu.setDate(date);
            updateService.saveMenu(messMenu);
            return "redirect:/";
        }
        catch(DataIntegrityViolationException e){
            model.addAttribute("error","Menu Already Exist");
            return "forms/update/update_mess_menu";
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+": may be something is going to be repeat");
        }
        return "forms/update/update_mess_menu";
    }

    @GetMapping("/showFormForUpdateStudent/{id}")
    public String showFormForUpdateStudent(@PathVariable( value = "id") Integer id, Model model) {
        try {
            Students student = updateService.getStudent(id);
            model.addAttribute("student", student);
            return "forms/update/update_student";
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: student does not Exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" student does not exists");
            model.addAttribute("error","student does not exist");
            return "common/ErrorPage";
        }
    }

    @PostMapping("/student/saveUpdate")
    public String saveStudent(@ModelAttribute("student") Students student, Model model) {
        try {
            Date date=java.util.Calendar.getInstance().getTime();
            System.out.println(date);
            student.setDate(date);
            updateService.saveStudent(student);
            return "redirect:/";
        }
        catch(DataIntegrityViolationException e){
            model.addAttribute("error","Student info like phone or mail in another record already Exist");
            return "forms/update/update_student";
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+": may be phone is going to be repeat");
        }
        return "forms/update/update_student";
    }

    @GetMapping("/showFormForMessOnOffStatus/{id}")
    public String showFormForUpdateOnOff(@PathVariable( value = "id") Integer id, Model model) {
        try {
            On_OFF on_off = updateService.getOnOff(id);
            model.addAttribute("students", getAllStudents());
            model.addAttribute("on_off", on_off);
            return "forms/update/update_on_off";
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: student does not Exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" student does not exists");
            model.addAttribute("error","student does not exist");
            return "common/ErrorPage";
        }
    }

    @PostMapping("/onOff/saveUpdate")
    public String saveOnOff(@ModelAttribute("on_off") On_OFF on_off, Model model) {
        try {
            Date date=java.util.Calendar.getInstance().getTime();
            System.out.println(date);
            on_off.setDate(date);
            updateService.saveOnOffStatus(on_off);
            return "redirect:/";
        }
        catch(DataIntegrityViolationException e){
            model.addAttribute("error","Student info like phone or mail in another record already Exist");
            return "forms/update/update_on_off";
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+": may be phone is going to be repeat");
        }
        return "forms/update/update_on_off";
    }

    @GetMapping("/showFormForUpdatePaymentStatus/{id}")
    public String showFormForUpdatePayment(@PathVariable( value = "id") Integer id, Model model) {
        try {
            Payments payments = updateService.getStudentPaymentStatusByIdToUpdate(id);
            model.addAttribute("students", getAllStudents());
            model.addAttribute("payments", payments);
            return "forms/update/update_payments";
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: student does not Exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" student does not exists");
            model.addAttribute("error","student does not exist");
            return "common/ErrorPage";
        }
    }

    @PostMapping("/payment/saveUpdate")
    public String savePayment(@ModelAttribute("on_off") Payments payments, Model model) {
        try {
            Date date=java.util.Calendar.getInstance().getTime();
            System.out.println(date);
            payments.setDate(date);
            updateService.savePaymentStatus(payments);
            return "redirect:/";
        }
        catch(DataIntegrityViolationException e){
            model.addAttribute("error","Student info like phone or mail in another record already Exist");
            return "common/ErrorPage";
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+": may be phone is going to be repeat");
            return "forms/update/update_payments";
        }
    }

    @GetMapping("/showFormForUpdateMessTimingsStatus/{id}")
    public String showFormForUpdateMessTimings(@PathVariable( value = "id") Integer id, Model model) {
        try {
            MessTimings messTimings = updateService.getMessTimingsToUpdate(id);
            model.addAttribute("students", getAllStudents());
            model.addAttribute("messTimings", messTimings);
            return "forms/update/update_mess_timings";
        }catch (RuntimeException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: student does not Exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" student does not exists");
            model.addAttribute("error","student does not exist");
            return "common/ErrorPage";
        }
    }

    @PostMapping("/timings/saveUpdate")
    public String saveMessTimings(@ModelAttribute("messTimings") MessTimings messTimings, Model model) {
        try {
            Date date=java.util.Calendar.getInstance().getTime();
            System.out.println(date);
            messTimings.setDate(date);
            updateService.saveMessTimingsStatus(messTimings);
            return "redirect:/";
        }
        catch(DataIntegrityViolationException e){
            model.addAttribute("error","Something is went wrong in mess timings");
            return "common/ErrorPage";
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+": Something is went wrong in mess timings");
            return "forms/update/update_payments";
        }
    }


}
