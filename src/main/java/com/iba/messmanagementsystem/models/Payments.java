package com.iba.messmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Table(name = "payments")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Payments {
    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name ="collected_ammount")
    private Double collected;

    @Column(name ="remaining_ammount")
    private Double remaining;

    @Column(name ="monthly_charges")
    private Double monthly_charges;

    @Column(name ="helper_charges")
    private Double helper_charges;

    @Column(name = "visible")
    private Boolean visible = true;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "student")
    private Students student;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "date_insertion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Date date;


}
