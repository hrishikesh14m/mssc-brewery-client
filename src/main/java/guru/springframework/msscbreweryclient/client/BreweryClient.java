package guru.springframework.msscbreweryclient.client;

import guru.springframework.msscbreweryclient.web.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer";
    private String apiPost;
    private final RestTemplate restTemplate;

    public BreweryClient(ApiProperies apiProperies, RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiPost = apiProperies.getApiHost();
    }

    public BeerDto getBeerById(UUID uuid) {
        return restTemplate.getForObject(apiPost + BEER_PATH_V1 + uuid.toString(), BeerDto.class);
    }

    public URI savedPostBeer(BeerDto beerDto) {
        return restTemplate.postForLocation(apiPost + BEER_PATH_V1, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto) {
        restTemplate.put(apiPost + BEER_PATH_V1 + "/" + uuid.toString(), beerDto);
    }

    public void deleteBeer(UUID uuid) {
        restTemplate.delete(apiPost + BEER_PATH_V1 + "/" + uuid.toString());
    }

}
