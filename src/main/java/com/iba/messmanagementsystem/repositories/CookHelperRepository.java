package com.iba.messmanagementsystem.repositories;

import com.iba.messmanagementsystem.dto.CookHelperDto;
import com.iba.messmanagementsystem.models.Cook_Helpers;
import com.iba.messmanagementsystem.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CookHelperRepository extends JpaRepository<Cook_Helpers, Integer> {

    @Query("SELECT new com.iba.messmanagementsystem.dto.CookHelperDto(ch.id, ch.name, ch.phone) FROM Cook_Helpers ch WHERE ch.visible=true and ch.status = 'Helper' ")
    public CookHelperDto getHelperDetails();

    @Query("SELECT new com.iba.messmanagementsystem.dto.CookHelperDto(ch.id, ch.name, ch.phone) FROM Cook_Helpers ch WHERE ch.status = 'Cook' and ch.visible=true")
    public CookHelperDto getCookDetails();

    @Query("SELECT new com.iba.messmanagementsystem.dto.CookHelperDto(ch.id, ch.name, ch.phone) FROM Cook_Helpers ch WHERE ch.visible=false and ch.status = 'Helper' ")
    public CookHelperDto getHelperDeletedDetails();

    @Query("SELECT new com.iba.messmanagementsystem.dto.CookHelperDto(ch.id, ch.name, ch.phone) FROM Cook_Helpers ch WHERE ch.status = 'Cook' and ch.visible=false")
    public CookHelperDto getCookDeletedDetails();

    @Query("SELECT COUNT(c) FROM Cook_Helpers c where c.visible=true")
    public Long getTotal();

    @Transactional
    @Modifying
    @Query("UPDATE Cook_Helpers ch set ch.visible=false where ch.id=?1")
    public void deleteByUpdateVisible(Integer id);//for cook

    @Transactional
    @Modifying
    @Query("UPDATE Cook_Helpers ch set ch.visible=false where ch.id=?1")
    public void deleteByUpdateVisibleHelper(Integer id);// for helper

    @Transactional
    @Modifying
    @Query("UPDATE Cook_Helpers ch set ch.visible=true where ch.id=?1")
    public void recoverCookByUpdateVisible(Integer id);//for cook

    @Transactional
    @Modifying
    @Query("UPDATE Cook_Helpers ch set ch.visible=true where ch.id=?1")
    public void recoverHelperByUpdateVisible(Integer id);// for helper

}
