package com.sujith.serviceone.controller;

import com.sujith.serviceone.model.ServiceoneModel;
import com.sujith.serviceone.service.ServiceoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/one")
@AllArgsConstructor
public class ServiceoneController
{
    private ServiceoneService serviceoneService;

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ServiceoneModel serviceoneModel)
    {
        String serviceoneModel1=serviceoneService.save(serviceoneModel);
        return new ResponseEntity<>(serviceoneModel1,HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<ServiceoneModel> get(@PathVariable("userId") String userId)
    {
        ServiceoneModel serviceoneModel= serviceoneService.get(userId);
        return new ResponseEntity<>(serviceoneModel,HttpStatus.OK);
    }
}
