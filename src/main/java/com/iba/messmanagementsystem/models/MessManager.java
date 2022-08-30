package com.iba.messmanagementsystem.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mess_manager")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class MessManager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone", length = 11, unique = true)
    private String phone;

    @Column(name = "room_no", nullable = false)
    private String roomNo;

    @Column(name = "visible")
    private Boolean visible = true;

    @CreatedDate               //it will add date automatically when user will enter the any information for the adding the product in the tabl //but user will not be able to enter the date according to his own
    @CreationTimestamp
    @Column(name = "reg_date")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Date date;
}
