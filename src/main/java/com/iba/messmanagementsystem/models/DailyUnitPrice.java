package com.iba.messmanagementsystem.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "daily_unit_price")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DailyUnitPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "daily_expence")
    private Double daily_expence;

    @Column(name = "total_daily_units")
    private Long totalDailyUnits;

    @Column(name = "unit_cost")
    private Long unitCost;

    @Column(name = "visible")
    private Boolean visible = true;

    @CreatedDate//it will add date automatically when user will enter the any information for the adding the product in the tabl //but user will not be able to enter the date according to his own
    @CreationTimestamp
    @Column(name = "date")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Date date;
}
