package com.iba.messmanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Table(name = "students")
public class Students {
    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "student_name")
    private String studentName;

    @Column(name = "student_cms", unique = true)
    private String studentCMS;

    @Column(name = "student_phone", unique = true, length = 11)
    private String studentPhone;

    @Column(name = "student_room")
    private String studentRoom;

    @Column(name = "student_hostel")
    private String studentHostel;


    @Column(name = "student_semester")
    private String studentSemester;

    @Column(name = "visible")
    private Boolean visible = true;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "student_reg_date")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Date date;
//image
//    @Column(name = "file_name")
//    private String fileName;
//
//    @Column(name = "file_path")
//    private String filePath;
//
//    @Column(name = "file_type")
//    private String fileType;
//
//    @Column(name = "file_size")
//    private String fileSize;
//end image modeling
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Units> units;

    @OneToMany(mappedBy="student", cascade = CascadeType.ALL)
    private List<On_OFF> on_off;

    @OneToMany(mappedBy="student", cascade = CascadeType.ALL)
    private List<Payments> payments;
}
