package org.example.spring.cloud.msorder.input.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderResto {

    @NotBlank
    private String customerName;
    @NotEmpty
    @Size(min = 9, max = 12)
    private String customerNumber;
    private String order;

}
