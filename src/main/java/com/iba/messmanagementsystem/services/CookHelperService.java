package com.iba.messmanagementsystem.services;

import com.iba.messmanagementsystem.models.Cook_Helpers;
import com.iba.messmanagementsystem.repositories.CookHelperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class CookHelperService {
    @Autowired
    private CookHelperRepository cookHelperRepository;
    public void saveDetails(Cook_Helpers cook_helpers) throws SQLIntegrityConstraintViolationException {
        cookHelperRepository.save(cook_helpers);
    }
}
