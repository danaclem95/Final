package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	private static double newrate;
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		ArrayList<RateDomainModel> rateArray = RateDAL.getAllRates();
		
		for (RateDomainModel rate : rateArray){
			if (rate.getiMinCreditScore() == GivenCreditScore){
				newrate = rate.getdInterestRate();
			}
		}
		
		return newrate;
		
	}
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
