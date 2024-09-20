package com.sujith.servicetwo.controller;

import com.sujith.servicetwo.model.ApiResponseDTO;
import com.sujith.servicetwo.model.ServicetwoModel;
import com.sujith.servicetwo.service.ServicetwoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/two")
@AllArgsConstructor
public class ServicetwoController
{
    private ServicetwoService servicetwoService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ServicetwoModel servicetwoModel)
    {
        String servicetwoModel1 = servicetwoService.save(servicetwoModel);
        return new ResponseEntity<>(servicetwoModel1, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> getId(@PathVariable("id") Long id)
    {
        ApiResponseDTO apiResponseDTO=servicetwoService.get(id);
        return new ResponseEntity<>(apiResponseDTO,HttpStatus.OK);

    }
}
