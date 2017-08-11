package com.giffing.maxmind.geoip2.spring.boot.starter.services;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;

public class GeoIPService {
	
	private DatabaseReader reader;

	public GeoIPService(DatabaseReader geoIpDatabaseReader) {
		this.reader = geoIpDatabaseReader;
	}

	public CountryResponse countryResponse(InetAddress inetAddress) {
		try {
			return reader.country(inetAddress);
		} catch (IOException e) {
		} catch (GeoIp2Exception e) {
		}
		
		return null;
	}
	
	public CountryResponse countryResponse(String ipAddress) {
		InetAddress inetAddress;
		try {
			inetAddress = InetAddress.getByName(ipAddress);
			return countryResponse(inetAddress);
		} catch (UnknownHostException e) {
		}
		return null;
	}
	
	
	public String countryIsoCode(String ipAddress) {
		CountryResponse countryResponse = countryResponse(ipAddress);
		if(countryResponse != null) {
			return countryResponse.getCountry().getIsoCode();
		}
		return null;
	}
	
	public String countryIsoCode(InetAddress inetAddress) {
		CountryResponse countryResponse = countryResponse(inetAddress);
		if(countryResponse != null) {
			return countryResponse.getCountry().getIsoCode();
		}
		return null;
	}
	
}
