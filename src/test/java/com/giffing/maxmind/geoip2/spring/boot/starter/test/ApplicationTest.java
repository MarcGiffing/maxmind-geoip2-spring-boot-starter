package com.giffing.maxmind.geoip2.spring.boot.starter.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.giffing.maxmind.geoip2.spring.boot.starter.services.GeoIPService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Autowired
	private GeoIPService service;
	
	@Test
	public void test() {
		String countryCode = service.countryIsoCode("172.0.0.1");
		System.out.println(countryCode);
	}
	
}
