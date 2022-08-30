package com.iba.messmanagementsystem.repositories;

import com.iba.messmanagementsystem.models.DailyUnitPrice;
import com.iba.messmanagementsystem.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface DailyUnitPriceRepository extends JpaRepository<DailyUnitPrice, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE DailyUnitPrice daily SET daily.visible=false where daily.id=?1")
    public void deleteByVisible(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE DailyUnitPrice daily SET daily.visible=true where daily.id=?1")
    public void recoverByVisible(Integer id);

}
