package com.kowalski.damian.geiger.model;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Curiosity {

    @SerializedName("id")
    private Long id;

    @SerializedName("text")
    private String text;
}
