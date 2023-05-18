package guru.springframework.msscbreweryclient.client;

import guru.springframework.msscbreweryclient.web.BeerDto;
import guru.springframework.msscbreweryclient.web.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void testGetCustomer(){
     CustomerDto customerDto = client.getCustomer(UUID.randomUUID());
        assertNotNull(customerDto);
    }

    @Test
    void testPostCustomer(){
        CustomerDto customerDto = CustomerDto.builder().name("Hrishi").build();
        URI uri =  client.postCustomer(UUID.randomUUID(),customerDto);
        assertNotNull(uri);
    }

    @Test
    void testPutCustomer(){
        CustomerDto customerDto = CustomerDto.builder().name("Hrishi").build();
        client.updateCustomer(UUID.randomUUID(),customerDto);
    }

    @Test
    void testDeleteMapping(){
        client.deleteCustomer(UUID.randomUUID());
    }



}
