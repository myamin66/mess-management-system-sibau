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
public class PaymentDetailsDto {
    private String studentName;
    private String roomNo;
    private String contact;
    private Double collectedAmmount;
    private Double monthlyCharges;
    private Double helperCharges;
}
