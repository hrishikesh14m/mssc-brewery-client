package guru.springframework.msscbreweryclient.client;

import guru.springframework.msscbreweryclient.web.CustomerDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class CustomerClient {

    private final String CUSTOMER_PATH_V1="/api/v1/customer";

    private String apiPost;

    private RestTemplate restTemplate;

    public CustomerClient(ApiProperies apiProperies, RestTemplateBuilder restTemplateBuilder) {
        this.apiPost = apiProperies.getApiHost();
        this.restTemplate = restTemplateBuilder.build();
    }

    public CustomerDto getCustomer(UUID uuid){
        return restTemplate.getForObject(apiPost + CUSTOMER_PATH_V1 + "/"+uuid.toString(),CustomerDto.class);
    }

    public URI  postCustomer(UUID uuid, CustomerDto customerDto){
       return  restTemplate.postForLocation(apiPost + CUSTOMER_PATH_V1+"/"+uuid.toString(),customerDto);
    }

    public void updateCustomer(UUID uuid , CustomerDto customerDto){
         restTemplate.put(apiPost+CUSTOMER_PATH_V1+"/" +uuid.toString(),customerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apiPost +CUSTOMER_PATH_V1+"/"+uuid.toString());
    }


}
