package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import rocketDomain.RateDomainModel;

public class Rate_Test {
	
	@BeforeClass
	public static void DoThisFirst(){
		RateDomainModel radomo = new RateDomainModel();
	}
	
	@Test
	public void TestOne(RateDomainModel radomo){
		radomo.setiMinCreditScore(600);
		assert(radomo.getdInterestRate() == 5);
	}

	@Test
	public void TestTwo (RateDomainModel radomo){
		
		ArrayList<RateDomainModel> radomoList = RateDAL.getAllRates();
		
		try{
			radomo.setiMinCreditScore(550); // not in the table
			fail("The value isn't in the table, so an exception should be thrown!");
		}
		catch(Exception thing){
			assertTrue(thing.getClass() == RateException.class); 
		}
		
	}


}
