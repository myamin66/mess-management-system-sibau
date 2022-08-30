package com.iba.messmanagementsystem.repositories;

import com.iba.messmanagementsystem.models.MessMenue;
import com.iba.messmanagementsystem.models.MessTimings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface MessTimingRepository extends JpaRepository<MessTimings, Integer> {

    @Override
    @Query("SELECT mess FROM MessTimings mess WHERE mess.visible=true")
    List<MessTimings> findAll();

    @Query("SELECT mess FROM MessTimings mess WHERE mess.visible=false")
    List<MessTimings> findAllDeleted();

    @Transactional
    @Modifying
    @Query("UPDATE MessTimings timing set timing.visible=false where timing.id=?1")
    public void deleteByVisible(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE MessTimings timing set timing.visible=true where timing.id=?1")
    public void recoverByVisible(Integer id);


}
