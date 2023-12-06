package com.efeak.MiniProject.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequestDto {
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private String department;
}
