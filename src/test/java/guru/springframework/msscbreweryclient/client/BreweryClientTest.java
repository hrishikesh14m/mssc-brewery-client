package guru.springframework.msscbreweryclient.client;

import guru.springframework.msscbreweryclient.web.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById() {

        BeerDto dto = client.getBeerById(UUID.randomUUID());

        assertNotNull(dto);

    }

    @Test
    void testNewSavedBeer() {
        BeerDto beerDto = BeerDto.builder().beerName("corona").build();
        URI uri = client.savedPostBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdatedBeer(){
        BeerDto beerDto = BeerDto.builder().beerName("Kingfisher").build();
        client.updateBeer(UUID.randomUUID(),beerDto);
    }


    @Test
    void testDeleteBeer(){
        client.deleteBeer(UUID.randomUUID());
    }
}