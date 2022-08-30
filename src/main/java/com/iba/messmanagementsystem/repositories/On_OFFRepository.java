package com.iba.messmanagementsystem.repositories;

import com.iba.messmanagementsystem.dto.On_Off_StatusDto;
import com.iba.messmanagementsystem.models.On_OFF;
import com.iba.messmanagementsystem.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface On_OFFRepository extends JpaRepository<On_OFF, Integer> {

    @Override
    @Query("SELECT status from On_OFF status WHERE status.visible=true")
    List<On_OFF> findAll();

    @Query("SELECT status from On_OFF status WHERE status.visible=false")
    List<On_OFF> findAllDeleted();

    @Query("SELECT new com.iba.messmanagementsystem.dto.On_Off_StatusDto(student.studentName,student.studentRoom, on_off.breakfast, on_off.lunch, on_off.dinner, on_off.date) From On_OFF on_off join Students student on on_off.id=student.id")
    public List<On_Off_StatusDto> getStatus();

    @Transactional
    @Modifying
    @Query("UPDATE On_OFF on_off SET on_off.visible=false WHERE on_off.id=?1")
    public void deleteByVisible(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE On_OFF on_off SET on_off.visible=true WHERE on_off.id=?1")
    public void recoverByVisible(Integer id);
}
