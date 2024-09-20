package com.sujith.serviceone.repository;

import com.sujith.serviceone.model.ServiceoneModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceoneRepository extends JpaRepository<ServiceoneModel,Long>
{

    ServiceoneModel findByUserId(String userId);
}
