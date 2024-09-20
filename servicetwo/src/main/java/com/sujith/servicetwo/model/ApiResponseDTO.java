package com.sujith.servicetwo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseDTO
{

    private ServiceoneDTO serviceoneDTO;
    private ServicetwoDTO servicetwoDTO;
}
