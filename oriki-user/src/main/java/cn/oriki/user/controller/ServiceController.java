package cn.oriki.user.controller;

import cn.oriki.commons.response.Responses;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 服务状态检测 Controller
 *
 * @author oriki
 */
@RestController
@RequestMapping(value = "/service")
public class ServiceController {

    private final DiscoveryClient discoveryClient;

    @Autowired
    public ServiceController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping(value = "/query-services")
    public String queryServices() {
        // 获取 服务端注册的微服务
        List<String> serviceNames = this.discoveryClient.getServices();
        return serviceNames.toString();
    }

    @GetMapping(value = "/check-service-state")
    public String queryServiceStateByServiceId(String serviceId) {
        try {
            this.discoveryClient.getInstances(serviceId).forEach(e -> {
                InstanceInfo.InstanceStatus status = ((EurekaDiscoveryClient.EurekaServiceInstance) e).getInstanceInfo().getStatus();
                assert InstanceInfo.InstanceStatus.UP.equals(status);
            });
            return Responses.responseSuccess("success");
        } catch (Exception e) {
            return Responses.responseFail("fail");
        }
    }

}
