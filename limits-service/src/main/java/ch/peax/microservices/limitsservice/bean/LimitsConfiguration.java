package ch.peax.microservices.limitsservice.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LimitsConfiguration {

    private int minimum;
    private int maximum;

}
