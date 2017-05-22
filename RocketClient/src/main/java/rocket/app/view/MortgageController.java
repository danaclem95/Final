package rocket.app.view;

import eNums.eAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

import java.text.DecimalFormat;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class MortgageController {

	@FXML int txtCreditScore;
	@FXML String txtMortgageAmt;
	@FXML double txtHouseCost;
	@FXML double txtDownPayment;
	@FXML double txtAnnualIncome;
	@FXML double txtMonthlyExpenses;
	@FXML String lblMortgagePayment;

	
	private ObservableList<Integer> TermOptions = FXCollections.observableArrayList(15,30);
	final ComboBox<Integer> ComboBoxThing = new ComboBox<Integer>(TermOptions);
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Action boop = new Action(eAction.CalculatePayment);
		LoanRequest LQ = new LoanRequest();
		
		
		LQ.setExpenses(txtMonthlyExpenses);
		LQ.setiTerm(ComboBoxThing.getValue());
		LQ.setiCreditScore(txtCreditScore);
		LQ.setiDownPayment(txtDownPayment);
		LQ.setIncome(txtAnnualIncome);
		LQ.setdAmount(txtHouseCost - txtDownPayment);
		
		boop.setLoanRequest(LQ);
	}
	
	public void HandleLoanRequestDetails(LoanRequest Request)
	{
		double payment = Request.getdPayment();
		double lower = 0.28 * Request.getIncome();
		double higher = 0.36 * Request.getIncome();
		
		if (payment>lower | payment>higher){
			lblMortgagePayment = "House is too pricy.";
		}
		else{
			DecimalFormat decimal_format = new DecimalFormat(".00");
			String a = decimal_format.format(payment);
			lblMortgagePayment = a;
	
	}
	}}
