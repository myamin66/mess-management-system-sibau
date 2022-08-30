package com.iba.messmanagementsystem.repositories;

import com.iba.messmanagementsystem.dto.StudentWithUnits;
import com.iba.messmanagementsystem.models.On_OFF;
import com.iba.messmanagementsystem.models.Units;
import com.iba.messmanagementsystem.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface UnitsRepository extends JpaRepository<Units, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Units units SET units.visible=false where units.id=?1")
    public void deleteUnitsByVisible(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Units units SET units.visible=true where units.id=?1")
    public void recoverUnitsByVisible(Integer id);
}
