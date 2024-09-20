package com.sujith.servicetwo.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicetwoDTO
{
    private Long id;
    @Column(nullable = false,unique = true)
    private String email;
    private String userId;
}
