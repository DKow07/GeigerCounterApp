package com.kowalski.damian.geiger.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Result {

    @SerializedName("id")
    private Long id;
    @SerializedName("dose")
    private Float dose;
    @SerializedName("voltage")
    private Float voltage;
    @SerializedName("unit_dose")
    private String unitDose;
    @SerializedName("unit_voltage")
    private String unitVoltage;
    @SerializedName("date_of_measurement")
    private String dateOfMeasurement;
}
