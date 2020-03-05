package com.example.sree.cloud.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;




@Entity
@Table
public class ExchangeValue {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="currence_from")
	private String from;
	
	@Column(name="currence_to")
	private String to;
	
	private BigDecimal conversionMultiple;
	private int port;
	
	public ExchangeValue() {
		
	}
	
	public ExchangeValue(long id, String from, String to,
			BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}
	
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public long getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	
	

}
