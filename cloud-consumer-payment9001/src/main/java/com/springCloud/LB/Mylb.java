package com.springCloud.LB;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class Mylb implements LBInterface {


    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * CAS自旋
     *
     * @return
     */
    public final int getAndInc() {
        int current;
        int next;
        for (; ; ) {
            current = this.atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
            if (this.atomicInteger.compareAndSet(current, next)) {
                log.info("当前值是：" + next);
                return next;
            }
        }
    }

    @Override
    public ServiceInstance serviceinstance(List<ServiceInstance> serviceInstances) {
        int index = getAndInc() % serviceInstances.size();
        return serviceInstances.get(index);//轮询返回服务器实例
    }
}
