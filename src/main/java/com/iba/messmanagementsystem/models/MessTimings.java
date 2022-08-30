package com.iba.messmanagementsystem.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "tbl_messtimings")
public class MessTimings {
    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "breakfasttime")
    private String breakfasttime;

    @Column(name = "lunchtime")
    private String lunchtime;

    @Column(name = "dinnertime")
    private String dinnertime;

    @Column(name = "brunchtime")
    private String brunchtime;

    @Column(name = "visible")
    private Boolean visible = true;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "date_insertion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Date date;


}
