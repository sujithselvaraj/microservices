package com.sujith.servicetwo.service;

import com.sujith.servicetwo.model.ApiResponseDTO;
import com.sujith.servicetwo.model.ServiceoneDTO;
import com.sujith.servicetwo.model.ServicetwoDTO;
import com.sujith.servicetwo.model.ServicetwoModel;
import com.sujith.servicetwo.repository.ServicetwoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class ServicetwoService
{
    private ServicetwoRepository servicetwoRepository;
    private RestTemplate restTemplate;

    public String save(ServicetwoModel servicetwoModel)
    {
        ServicetwoModel servicetwoModel1 = new ServicetwoModel(
                servicetwoModel.getId(),
                servicetwoModel.getEmail(),
                servicetwoModel.getUserId()
        );
        servicetwoRepository.save(servicetwoModel1);
        return "Saved Successfully!";
    }

    public ApiResponseDTO get(Long id)
    {
        ServicetwoModel servicetwoModel=servicetwoRepository.findById(id).get();
        String url="http://localhost:8080/api/one/"+servicetwoModel.getUserId();

        ResponseEntity<ServiceoneDTO> responseEntity= restTemplate.exchange(url, HttpMethod.GET,null, ServiceoneDTO.class);
        ServiceoneDTO serviceoneDTO=responseEntity.getBody();

        ServicetwoDTO servicetwoDTO=new ServicetwoDTO(
                servicetwoModel.getId(),
                servicetwoModel.getEmail(),
                servicetwoModel.getUserId()
        );
        ApiResponseDTO apiResponseDTO=new ApiResponseDTO();
        apiResponseDTO.setServicetwoDTO(servicetwoDTO);
        apiResponseDTO.setServiceoneDTO(serviceoneDTO);
        return apiResponseDTO;
    }


}
