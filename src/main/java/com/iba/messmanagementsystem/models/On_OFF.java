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

@Entity
@Table(name = "on_off_mess")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class On_OFF {
    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "breakfast")
    private Boolean breakfast = true;

    @Column(name = "lunch")
    private Boolean lunch = true;

    @Column(name = "dinner")
    private Boolean dinner = true;

    @Column(name = "visible")
    private Boolean visible = true;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "date_insertion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Date date;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "student")
    private Students student;


}
