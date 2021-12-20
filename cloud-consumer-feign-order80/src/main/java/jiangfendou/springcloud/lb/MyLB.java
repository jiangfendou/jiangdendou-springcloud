package jiangfendou.springcloud.lb;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAtomicInteger() {
        int current;
        int next;
        do {
            // 获取当前的值
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 : current + 1;
        } while(!this.atomicInteger.compareAndSet(current, next));
        System.out.println("************next" + next);

        return next;
    }
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index =  this.getAtomicInteger() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
