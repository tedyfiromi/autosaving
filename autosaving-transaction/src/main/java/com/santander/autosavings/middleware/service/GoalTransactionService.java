package com.santander.autosavings.middleware.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.santander.autosavings.middleware.model.Goal;
import com.santander.autosavings.middleware.model.OperationVO;
import com.santander.autosavings.middleware.model.TransactionGoal;
import com.santander.autosavings.middleware.repository.TransactionGoalRepository;
import com.santander.autosavings.middleware.utils.UrlRest;

@Service
public class TransactionGoalService {

	@Autowired
	private TransactionGoalRepository transactGoalRepository;
	public List<TransactionGoal> listTransactions = new ArrayList<>();
	public TransactionGoal transaction;
	public TransactionGoal transactioned;
	

	public TransactionGoal addMoney(final OperationVO operation) {

		if (amountIsAvailable(operation.getValue(), operation.getAccount())) {

			Goal goal = clientGoalById(operation);
			saveTransaction(operation.getValue());

			clientUpdateGoal(addInGoal(goal, operation));

			return transactioned;
		}
		return null;
	}

	public TransactionGoal withDrawMoney(final OperationVO operation) {

		if (amountIsAvailable(operation.getValue(), operation.getAccount())) {

			Goal goal = clientGoalById(operation);
			saveTransaction(operation.getValue());

			clientUpdateGoal(withDrawInGoal(goal, operation));

			return transactioned;
		}
		return null;

	}
	
	public Goal addInGoal(Goal goal, OperationVO operation) {
		goal.setSaved(calcAdd(goal.getSaved(), operation.getValue()));
		goal.setTransactionGoal(listTransactions);
		return goal;
	}

	public Goal withDrawInGoal(Goal goal, OperationVO operation) {
		goal.setSaved(calcWithDraw(goal.getSaved(), operation.getValue()));
		goal.setTransactionGoal(listTransactions);
		return goal;
	}

	public void saveTransaction(double value) {
		transaction = new TransactionGoal();
		transaction.setValue(value);
		
		transactioned = new TransactionGoal();
		transactioned = transactGoalRepository.save(transaction);
		
		listTransactions.add(transactioned);
	}

	public double totalAmount(String acount) {
		double available = 5000.00;
		return available;
	}

	public double calcAdd(double salvedMoney, double addValue) {
		return salvedMoney += addValue;
	}

	public double calcWithDraw(double salvedMoney, double withDraw) {
		return salvedMoney -= withDraw;
	}

	public boolean amountIsAvailable(double addValue, String account) {
		return totalAmount(account) > addValue;
	}

	public Goal clientGoalById(OperationVO addTransaction) {
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("id", addTransaction.getIdGoal());

		RestTemplate restTempGoalId = new RestTemplate();
		return restTempGoalId.getForObject( UrlRest.URL_BASE + UrlRest.GOAL + UrlRest.FIND_BY_ID , Goal.class, params);
	}

	public Goal clientUpdateGoal(Goal goal) {
		RestTemplate restTempGoalId = new RestTemplate();
		return restTempGoalId.postForObject(UrlRest.URL_BASE + UrlRest.GOAL + UrlRest.UPDATE, goal, Goal.class);
	}

}
