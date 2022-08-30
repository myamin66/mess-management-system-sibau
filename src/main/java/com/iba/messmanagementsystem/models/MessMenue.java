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
@Table(name = "mess_menue")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessMenue {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "monday")
    private String monday;

    @Column(name = "tuesday")
    private String tuesday;

    @Column(name = "wednesday")
    private String wednesday;

    @Column(name = "thursday")
    private String thursday;

    @Column(name = "friday")
    private String friday;

    @Column(name = "saturday")
    private String saturday;

    @Column(name = "sunday")
    private String sunday;

    @Column(name = "visible")
    private Boolean visible = true;

    @CreatedDate//it will add date automatically when user will enter the any information for the adding the product in the tabl //but user will not be able to enter the date according to his own
    @CreationTimestamp
    @Column(name = "date")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Date date;


}
