package com.iba.messmanagementsystem.controllers.update;

import com.iba.messmanagementsystem.models.Cook_Helpers;
import com.iba.messmanagementsystem.models.MessMenue;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class UpdateController {
    public String showFormForUpdateCookDetails(@PathVariable( value = "id") Integer id, Model model) {
        return null;
    }
    public String showFormForUpdateHelperDetails(@PathVariable( value = "id") Integer id, Model model) {
        return null;
    }
    public String saveUpdateCook(@ModelAttribute("cookDetails") Cook_Helpers cook_helpers, Model model) {
        return null;
    }
    public String saveUpdateHelper(@ModelAttribute("helperDetails") Cook_Helpers cook_helpers, Model model) {
        return null;
    }

    public String showFormForUpdateHelperDetails(){
        return null;
    }
    public String showFormForUpdateMessMenu(@ModelAttribute("id") Integer id, Model model) {
        return null;
    }
    public String saveMessMenuUpdate(@ModelAttribute("messMenue") MessMenue messMenue, Model model) {
        return null;
    }
    public String showFormForUpdateMessTimings(){
        return null;
    }
    public String showFormForUpdateStudentDetails(){
        return null;
    }
    public String showFormForUpdatePaymentDetails(){
        return null;
    }
}
