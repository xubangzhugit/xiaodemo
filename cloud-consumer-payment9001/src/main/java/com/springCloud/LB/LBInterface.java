package com.springCloud.LB;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LBInterface {
    ServiceInstance serviceinstance(List<ServiceInstance> serviceInstances);
}
