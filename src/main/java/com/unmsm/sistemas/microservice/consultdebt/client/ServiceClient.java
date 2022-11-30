package com.unmsm.sistemas.microservice.consultdebt.client;

import com.unmsm.sistemas.microservice.consultservice.model.ServiceEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "consult-service")
public interface ServiceClient {
    @GetMapping("/api/services/customer/{id}")
    List<ServiceEntity> getByCustomerId(@PathVariable("id") Integer id);

    @GetMapping("/api/services/{id}")
    ServiceEntity getByServiceId(@PathVariable("id") Integer id);
}
