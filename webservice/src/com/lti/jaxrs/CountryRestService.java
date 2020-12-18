package com.lti.jaxrs;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lti.bean.Country;
import com.lti.services.CountryService;
@Path("/countries")
public class CountryRestService {
	CountryService countryService = new CountryService();//service layer

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List getCountries() {
		List<Country> listOfCountries = new ArrayList<>();
//		listOfCountries1=this.createCountryList();
//		return listOfCountries;
		
		//service layer
		listOfCountries = countryService.getAllCountries();
		return listOfCountries;
	}
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Country getCountryById( @PathParam("id") int id) {
		//without service layer
//		List<Country> listOfCountries = new ArrayList<>();
//		listOfCountries=this.createCountryList();
//		for(Country country :listOfCountries) {
//			if(country.getId()==id) {
//				return country;
//			}
//		}
//		return null;
		//with service layer
		return countryService.getCountry(id);
		
	}
	//without service layer in serv layer done in countryservice class
//	public List createCountryList() {
//		Country c1 = new Country(1,"India");
//		Country c2 = new Country(2,"uk");
//		Country c3 = new Country(3,"us");
//		
//		List<Country> listOfCountries = new ArrayList<>();
//		listOfCountries.add(c1);
//		listOfCountries.add(c2);
//		listOfCountries.add(c3);
//		return listOfCountries;
//	}
	void useless(){
		int a=0;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Country addCountry(Country country) {
		return countryService.addCountry(country);
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteCountry(@PathParam("id") int id) {
		countryService.deleteCountry(id);
	}
	
	
	
}
