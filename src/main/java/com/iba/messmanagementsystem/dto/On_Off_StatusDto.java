package com.iba.messmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class On_Off_StatusDto {
    private String name;
    private String roomNo;
    private Boolean breakfast;
    private Boolean lunch;
    private Boolean dinner;
    private Date date;

}
