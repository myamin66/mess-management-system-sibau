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
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class UserModel {
    @Id
    @Column(name = "id")
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    @Column(name = "visible")
    private Boolean visible = true;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "date")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Date date;

}
