package com.example.sree.cloud.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DaoImpl implements Dao {
	@Autowired
	private ExchangeValueRepository repository;

	@Override
	public ExchangeValue save(ExchangeValue exchangevalues) {
		// TODO Auto-generated method stub
		ExchangeValue ExchangeValue= repository.save(exchangevalues);
		 return ExchangeValue;

	}

}
