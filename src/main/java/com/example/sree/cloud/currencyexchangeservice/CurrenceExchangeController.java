package com.example.sree.cloud.currencyexchangeservice;

import io.micrometer.core.ipc.http.HttpSender.Method;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.lang.annotation.Annotation;
import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resource.AuthenticationType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CurrenceExchangeController {
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@Autowired
	private Dao dao;
	
	@PostMapping(path="/saveExchangeValues")
	public ResponseEntity saveValues(@RequestBody ExchangeValue exchanhevalues){
		
		
		ExchangeValue exchangevalue=dao.save(exchanhevalues);
		
		/*if(!exchangevalue.equals(null)){
			return ResponseEntity.status(201).body("Inserted Successfully");		
		}
		else{
			return ResponseEntity.status(404).body("Not Inserted");
		}*/
		
		
	
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").
				buildAndExpand(exchangevalue.getId()).
				toUri();
		return ResponseEntity.created(uri).build();
		
	}
	
	@SuppressWarnings("unused")
	@GetMapping(path="/currency-exchange/from/{from}/to/{to}")
	public org.springframework.hateoas.Resource<ExchangeValue> retriveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to ){
		ExchangeValue ExchangeValue=repository.findByFromAndTo(from, to);
		ExchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		
		if(ExchangeValue==null){
			throw new NotfoundExceptionto("from; and ; To:"+from+""+to);
		}
		
		org.springframework.hateoas.Resource<ExchangeValue> resource=new org.springframework.hateoas.Resource<ExchangeValue>(ExchangeValue);
		ControllerLinkBuilder linkto= linkTo(methodOn(this.getClass()).retriveAllExchangeValue());
		
		resource.add(linkto.withRel("all-exchanges-values"));
		return resource;
	} 
	
	@SuppressWarnings("unused")
	@GetMapping(path="/currency-exchange")
	public List<ExchangeValue> retriveAllExchangeValue( ){
		List<ExchangeValue> ExchangeValue=repository.findAll();
		
		return ExchangeValue;
	} 

}
