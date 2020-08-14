package ch.peax.microservices.limitsservice;

import ch.peax.microservices.limitsservice.bean.LimitsConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LimitsConfigurationController {

    private final Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsFromConfiguration() {
        return new LimitsConfiguration(configuration.getMinimum(), configuration.getMaximum());
    }

    @GetMapping("/fault-tolerance-example")
    @HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
    public LimitsConfiguration retrieveConfiguration() {
        throw new RuntimeException("Not available");
    }

    public LimitsConfiguration fallbackRetrieveConfiguration() {
        return new LimitsConfiguration(111, 222);
    }
}
