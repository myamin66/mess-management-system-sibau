package com.iba.messmanagementsystem.services;
import com.iba.messmanagementsystem.models.*;
import com.iba.messmanagementsystem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.MessageDigest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Optional;
@Service
public class UpdateService {

    @Autowired
    private CookHelperRepository cookHelperRepository;

    @Autowired
    private MessMenueRepository messMenueRepository;

    @Autowired
    private StudentsRepository studentsRepository;

    @Autowired
    private On_OFFRepository on_offRepository;

    @Autowired
    private PaymentsRepository paymentsRepository;

    @Autowired
    private MessTimingRepository messTimingRepository;

    //cook update business logic
    public Cook_Helpers getCookToUpdate(Integer id) {
        Optional<Cook_Helpers> cook = cookHelperRepository.findById(id);
        Cook_Helpers cook1 = null;
        if(cook.isPresent()){
            cook1 = cook.get();
        }else {
            throw new RuntimeException("Category not found for id "+cook);
        }
        return cook1;
    }
    public void saveCook(Cook_Helpers cook) throws SQLIntegrityConstraintViolationException {
        cookHelperRepository.save(cook);
    }
    //helper update business logic
    public Cook_Helpers getHelperToUpdate(Integer id) {
        Optional<Cook_Helpers> helper = cookHelperRepository.findById(id);
        Cook_Helpers helper1 = null;
        if(helper.isPresent()){
            helper1 = helper.get();
        }else {
            throw new RuntimeException("Category not found for id "+helper);
        }
        return helper1;
    }
    public void saveHelper(Cook_Helpers helper) throws SQLIntegrityConstraintViolationException {
        cookHelperRepository.save(helper);
    }
    //mess menu update logic
    public MessMenue getMessMenu(Integer id) {
        Optional<MessMenue> messMenue = messMenueRepository.findById(id);
        MessMenue menu1 = null;
        if(messMenue.isPresent()){
            menu1 = messMenue.get();
        }else {
            throw new RuntimeException("Category not found for id "+messMenue);
        }
        return menu1;
    }
    public void saveMenu(MessMenue messMenue) throws SQLIntegrityConstraintViolationException {
        messMenueRepository.save(messMenue);
    }//save all updates of mess menu and exit your journey
    // students update business logic service
    public Students getStudent(Integer id) {
        Optional<Students> students = studentsRepository.findById(id);
        Students students1 = null;
        if(students.isPresent()){
            students1 = students.get();
        }else {
            throw new RuntimeException("Student not found for id "+students);
        }
        return students1;
    }
    public void saveStudent(Students student) throws SQLIntegrityConstraintViolationException {
        studentsRepository.save(student);
    }
    //students update logic
    public On_OFF getOnOff(Integer id) {
        Optional<On_OFF> on_off = on_offRepository.findById(id);
        On_OFF on_off1 = null;
        if(on_off.isPresent()){
            on_off1 = on_off.get();
        }else {
            throw new RuntimeException("Student not found for id "+on_off);
        }
        return on_off1;
    }
    public void saveOnOffStatus(On_OFF on_off) throws SQLIntegrityConstraintViolationException {
        on_offRepository.save(on_off);
    }

    //students payment status checkout update business logic
    public Payments getStudentPaymentStatusByIdToUpdate(Integer id) {
        Optional<Payments> payments = paymentsRepository.findById(id);
        Payments payments1 = null;
        if(payments.isPresent()){
            payments1 = payments.get();
        }else {
            throw new RuntimeException("Student not found for id "+payments);
        }
        return payments1;
    }
    public void savePaymentStatus(Payments payments) throws SQLIntegrityConstraintViolationException {
        paymentsRepository.save(payments);
    }

    // Mess timings status checkout update business logic
    public MessTimings getMessTimingsToUpdate(Integer id) {
        Optional<MessTimings> messTimings = messTimingRepository.findById(id);
        MessTimings messTimings1 = null;
        if(messTimings.isPresent()){
            messTimings1 = messTimings.get();
        }else {
            throw new RuntimeException("Mess Timings not found for id "+messTimings);
        }
        return messTimings1;
    }
    public void saveMessTimingsStatus(MessTimings messTimings) throws SQLIntegrityConstraintViolationException {
        messTimingRepository.save(messTimings);
    }

}
