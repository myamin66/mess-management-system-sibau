package com.iba.messmanagementsystem.repositories;

import com.iba.messmanagementsystem.dto.PaymentDetailsDto;
import com.iba.messmanagementsystem.models.Payments;
import com.iba.messmanagementsystem.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface PaymentsRepository extends JpaRepository<Payments, Integer> {

    @Override
    @Query("SELECT payment FROM Payments payment WHERE payment.visible=true")
    List<Payments> findAll();

    @Query("SELECT payment FROM Payments payment WHERE payment.visible=false")
    List<Payments> findAllDeleted();

    @Query("SELECT sum(payment.collected) FROM Payments payment")
    public Double getTotalCollectedAmount();

    @Query("SELECT sum(price.daily_expence) FROM DailyUnitPrice price")
    public Double getTotalExpendituresAmount();

    @Query("SELECT sum(price.daily_expence/price.totalDailyUnits) FROM DailyUnitPrice price")
    public Double getUnitCost();

    @Transactional
    @Modifying
    @Query("UPDATE Payments payment SET payment.visible=false where payment.id=?1")
    public void deletePaymentByVisible(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Payments payment SET payment.visible=true where payment.id=?1")
    public void recoverPaymentByVisible(Integer id);
}
