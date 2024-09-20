package com.sujith.serviceone.service;

import com.sujith.serviceone.model.ServiceoneModel;
import com.sujith.serviceone.repository.ServiceoneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceoneService
{
    private ServiceoneRepository serviceoneRepository;

    public String save(ServiceoneModel serviceoneModel)
    {
        ServiceoneModel service = new ServiceoneModel(
                serviceoneModel.getId(),
                serviceoneModel.getName(),
                serviceoneModel.getUserId()
        );
        serviceoneRepository.save(service);
        return "Saved Successfully";

    }

    public ServiceoneModel get(String userId)
    {
        ServiceoneModel serviceoneModel1=serviceoneRepository.findByUserId(userId);

         return serviceoneModel1;
    }

}
