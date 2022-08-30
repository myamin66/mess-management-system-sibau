package com.iba.messmanagementsystem.repositories;

import com.iba.messmanagementsystem.models.MessMenue;
import com.iba.messmanagementsystem.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MessMenueRepository extends JpaRepository<MessMenue, Integer> {

    @Override
    @Query("SELECT menu from MessMenue menu where menu.visible=true")
    List<MessMenue> findAll();

    @Query("SELECT menu from MessMenue menu where menu.visible=false")
    List<MessMenue> findDeletedAll();


    @Query("SELECT COUNT(menu) from MessMenue menu where menu.visible=true")
    public Long getTotal();


    @Query("SELECT mess.monday FROM MessMenue  mess")
    List<String> getMondayMenue();

    @Query("SELECT mess.tuesday FROM MessMenue  mess")
    List<String> getTuesdayMenue();

    @Query("SELECT mess.wednesday FROM MessMenue  mess")
    List<String> getWednesdayMenue();

    @Query("SELECT mess.thursday FROM MessMenue  mess")
    List<String> getThursdayMenue();

    @Query("SELECT mess.friday FROM MessMenue  mess")
    List<String> getFridayMenue();

    @Query("SELECT mess.saturday FROM MessMenue  mess")
    List<String> getSaturdayMenue();

    @Query("SELECT mess.sunday FROM MessMenue  mess")
    List<String> getSundayMenue();

    @Transactional
    @Modifying
    @Query("UPDATE MessMenue mess SET mess.visible=false where mess.id=?1")
    public void deleteMenuByVisible(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE MessMenue mess SET mess.visible=true where mess.id=?1")
    public void recoverMenuByVisible(Integer id);
}
