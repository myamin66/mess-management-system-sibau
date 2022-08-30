package com.iba.messmanagementsystem.controllers.delete;

import com.iba.messmanagementsystem.services.RecoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RecoverController {

    @Autowired
    private RecoverService recoverService;

    @GetMapping("/recoverCook/{id}")
    public String recoverCookOrHelper(@PathVariable(value = "id") Integer id, Model model) {
        try {
            this.recoverService.recoverCookHelperById(id);
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


    @GetMapping("/recoverHelper/{id}")
    public String recoverHelper(@PathVariable(value = "id") Integer id, Model model) throws Exception {
        try {
            this.recoverService.recoverHelperById(id);
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


    @GetMapping("/recoverDailyUnits/{id}")
    public String recoverDailyUnits(@PathVariable(value = "id") Integer id, Model model) throws Exception {
        try {
            this.recoverService.recoverUnits(id);
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

    @GetMapping("/recoverMessMenu/{id}")
    public String recoverMessMenu(@PathVariable(value = "id") Integer id, Model model) throws Exception {
        try {
            this.recoverService.recoverMessMenu(id);
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

    @GetMapping("/recoverStudent/{id}")
    public String recoverStudent(@PathVariable(value = "id") Integer id, Model model) throws Exception {
        try {
            this.recoverService.recoverStudent(id);
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

    @GetMapping("/recoverStudentPayment/{id}")
    public String recoverPayment(@PathVariable(value = "id") Integer id, Model model) {
        try {
            this.recoverService.recoverPaymentsDetails(id);
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

    @GetMapping("/recoverMessTimings/{id}")
    public String recoverMessTimings(@PathVariable(value = "id") Integer id, Model model) throws Exception {
        try {
            this.recoverService.recoverMessMenu(id);
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
