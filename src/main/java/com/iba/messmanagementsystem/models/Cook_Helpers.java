package com.iba.messmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cook_helpers")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cook_Helpers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone", unique = true, length = 11)
    private String phone;

    @Column(name = "status")
    private String status;

    @Column(name = "visible")
    private Boolean visible = true;

    @CreatedDate//it will add date automatically when user will enter the any information for the adding the product in the tabl //but user will not be able to enter the date according to his own
    @CreationTimestamp
    @Column(name = "registered_date")
//    @UpdateTimestamp
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Date registeredDate;

    @Column(name = "updated_on")
    private String updatedDate;
}
