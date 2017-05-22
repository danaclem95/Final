package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {
	
	// Attribute
	public RateDomainModel radomo = new RateDomainModel();
	
	// Create a constructor, passing in RateDomainModel
	public RateException(RateDomainModel radomo){
		super();
		this.radomo = radomo;
	}
	
	public RateDomainModel getradomo(){
		return radomo;
	}
}