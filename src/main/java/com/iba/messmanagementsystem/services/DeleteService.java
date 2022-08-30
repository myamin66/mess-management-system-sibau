package com.iba.messmanagementsystem.services;

import com.iba.messmanagementsystem.models.MessMenue;
import com.iba.messmanagementsystem.models.Students;
import com.iba.messmanagementsystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteService {

    @Autowired
    private CookHelperRepository cookHelperRepository;

    @Autowired
    private DailyUnitPriceRepository dailyUnitPriceRepository;

    @Autowired
    private MessManagerRepository messManagerRepository;

    @Autowired
    private MessMenueRepository messMenueRepository;

    @Autowired
    private On_OFFRepository on_offRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private UnitsRepository unitsRepository;

    public void deleteCookHelperById(Integer id) throws Exception {
        cookHelperRepository.deleteByUpdateVisible(id);
    }
    public void deleteHelperById(Integer id) throws Exception {
        cookHelperRepository.deleteByUpdateVisible(id);
    }

    public void deleteDailyUnits(Integer id) throws Exception {
        dailyUnitPriceRepository.deleteByVisible(id);
    }

    public void deleteMessManager(Integer id) throws Exception {
        dailyUnitPriceRepository.deleteByVisible(id);
    }

    public void deleteMessMenu(Integer id) throws Exception {
        messMenueRepository.deleteMenuByVisible(id);
    }

    public void deleteOnOff(Integer id) throws Exception {
        on_offRepository.deleteByVisible(id);
    }

    public void deletePaymentsDetails(Integer id) throws Exception {
        paymentsRepository.deletePaymentByVisible(id);
    }

    public void deleteStudent(Integer id) throws Exception {
        studentsRepository.deleteStudentByVisible(id);
    }

    public void deleteUnits(Integer id) throws Exception {
        unitsRepository.deleteUnitsByVisible(id);
    }
}
