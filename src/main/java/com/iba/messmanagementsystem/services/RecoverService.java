package com.iba.messmanagementsystem.services;

import com.iba.messmanagementsystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecoverService {

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

    public void recoverCookHelperById(Integer id) throws Exception {
        cookHelperRepository.recoverCookByUpdateVisible(id);
    }
    public void recoverHelperById(Integer id) throws Exception {
        cookHelperRepository.recoverHelperByUpdateVisible(id);
    }

    public void recoverDailyUnits(Integer id) throws Exception {
        dailyUnitPriceRepository.recoverByVisible(id);
    }

    public void recoverMessManager(Integer id) throws Exception {
        dailyUnitPriceRepository.recoverByVisible(id);
    }

    public void recoverMessMenu(Integer id) throws Exception {
        messMenueRepository.recoverMenuByVisible(id);
    }

    public void recoverOnOff(Integer id) throws Exception {
        on_offRepository.recoverByVisible(id);
    }

    public void recoverPaymentsDetails(Integer id) throws Exception {
        paymentsRepository.recoverPaymentByVisible(id);
    }

    public void recoverStudent(Integer id) throws Exception {
        studentsRepository.recoverStudentByVisible(id);
    }

    public void recoverUnits(Integer id) throws Exception {
        unitsRepository.recoverUnitsByVisible(id);
    }
}
