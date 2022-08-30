package com.iba.messmanagementsystem.controllers.delete;

import com.iba.messmanagementsystem.services.DeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DeleteController {

    @Autowired
    private DeleteService deleteService;

    @GetMapping("/deleteCook/{id}")
    public String deleteCookOrHelper(@PathVariable(value = "id") Integer id, Model model) {
        try {
            this.deleteService.deleteCookHelperById(id);
            return "redirect:/";
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: Cook/Helper may not exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" student does not exists");
            model.addAttribute("error","cook/helper does not exist");
            return "common/ErrorPage";
        }
    }


    @GetMapping("/deleteHelper/{id}")
    public String deleteHelper(@PathVariable(value = "id") Integer id, Model model) throws Exception {
        try {
            this.deleteService.deleteHelperById(id);
            return "redirect:/";
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: Cook/Helper may not exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" student does not exists");
            model.addAttribute("error","cook/helper does not exist");
            return "common/ErrorPage";
        }
    }


    @GetMapping("/deleteDailyUnits/{id}")
    public String deleteDailyUnits(@PathVariable(value = "id") Integer id, Model model) throws Exception {
        try {
            this.deleteService.deleteUnits(id);
            return "redirect:/";
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: units may not exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" units does not exists");
            model.addAttribute("error","units does not exist");
            return "common/ErrorPage";
        }
    }

    @GetMapping("/deleteMessMenu/{id}")
    public String deleteMessMenu(@PathVariable(value = "id") Integer id, Model model) throws Exception {
        try {
            this.deleteService.deleteMessMenu(id);
            return "redirect:/";
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: menu may not exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" units does not exists");
            model.addAttribute("error","units does not exist");
            return "common/ErrorPage";
        }
    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") Integer id, Model model) throws Exception {
        try {
            this.deleteService.deleteStudent(id);
            return "redirect:/";
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: menu may not exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" units does not exists");
            model.addAttribute("error","units does not exist");
            return "common/ErrorPage";
        }
    }

    @GetMapping("/deleteStudentPayment/{id}")
    public String deletePayment(@PathVariable(value = "id") Integer id, Model model) {
        try {
            this.deleteService.deletePaymentsDetails(id);
            return "redirect:/";
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: menu may not exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" units does not exists");
            model.addAttribute("error","units does not exist");
            return "common/ErrorPage";
        }
    }

    @GetMapping("/deleteMessTimings/{id}")
    public String deleteMessTimings(@PathVariable(value = "id") Integer id, Model model) throws Exception {
        try {
            this.deleteService.deleteMessMenu(id);
            return "redirect:/";
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            model.addAttribute("error","404: menu may not exist for id="+id);
            return "common/ErrorPage";
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage()+" units does not exists");
            model.addAttribute("error","units does not exist");
            return "common/ErrorPage";
        }
    }

}
