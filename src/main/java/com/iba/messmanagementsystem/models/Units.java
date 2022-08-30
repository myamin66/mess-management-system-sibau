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
import java.util.List;

@Entity
@Table(name = "units")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Units {
    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "num_units")
    private Integer units;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "student")
    private Students student;

    @Column(name = "visible")
    private Boolean visible = true;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "unit_date")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Date unitDate;


}
