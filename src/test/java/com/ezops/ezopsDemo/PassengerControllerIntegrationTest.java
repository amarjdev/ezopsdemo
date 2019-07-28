package com.ezops.ezopsDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.ezops.ezopsDemo.bean.Passenger;

import org.junit.runner.RunWith;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EzopsDemoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PassengerControllerIntegrationTest {
	@Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }
    @Test
    public void contextLoads() {

    }
    @Test
    public void testGetAllPassengers() {
    	HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<Passenger> response = restTemplate.exchange(getRootUrl() + "/titanic/all",
        HttpMethod.GET, entity, Passenger.class);  
        assertNotNull(response.getBody());
 
    }
    @Test
    public void testUpdatePassenger() {
    	Passenger titanic = new Passenger();
    	titanic.setAge(30);
    	titanic.setName("Amar");
        restTemplate.postForEntity(getRootUrl() + "/titanic/save", titanic,Passenger.class);
        Passenger updatedTitanic = restTemplate.getForObject(getRootUrl() + "/titanic/save", Passenger.class);
        assertNotNull(updatedTitanic);
 
    }
    @Test
    public void testDeletePassenger() {
    	int id = 2;
    	Passenger titanic = restTemplate.getForObject(getRootUrl() + "/titanic/get/" + id, Passenger.class);
        assertNotNull(titanic);
        restTemplate.delete(getRootUrl() + "/employees/" + id);
        try {
             titanic = restTemplate.getForObject(getRootUrl() + "/titanic/get/" + id, Passenger.class);
        } catch (final HttpClientErrorException e) {
             assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }

        
        
 
    }
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
