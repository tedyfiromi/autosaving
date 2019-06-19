package com.santander.autosavings.middleware.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.santander.autosavings.middleware.model.Goal;
import com.santander.autosavings.middleware.model.OperationVO;
import com.santander.autosavings.middleware.model.GoalHistory;
import com.santander.autosavings.middleware.repository.GoalTransactionRepository;
import com.santander.autosavings.middleware.utils.UrlRest;

@Service
public class GoalTransactionService {

	@Autowired
	private GoalTransactionRepository transactGoalRepository;
	public List<GoalHistory> listTransactions;
	public GoalHistory transaction;
	public GoalHistory transactioned;

	@Transactional
	public GoalHistory addMoney(final OperationVO operation) {

		if (amountIsAvailable(operation.getValue(), operation.getAccount())) {

			Goal goal = clientGoalById(operation);
			List<GoalHistory> transactions = goal.getTransactionGoals();

			GoalHistory transactioned = saveTransaction(operation.value);
			transactions.add(transactioned);

			goal.setTransactionGoal(transactions);
			Goal goalEdited = addInGoal(goal, operation);

			clientUpdateGoal(goalEdited);
		} else {
			throw new RuntimeException("TODO");
		}
		return transactioned;
	}

	@Transactional
	public GoalHistory withDrawMoney(final OperationVO operation) {

		if (amountIsAvailable(operation.getValue(), operation.getAccount())) {

			Goal goal = clientGoalById(operation);
			List<GoalHistory> transactions = goal.getTransactionGoals();

			GoalHistory transactioned = saveTransaction(operation.value);
			transactions.add(transactioned);

			goal.setTransactionGoal(transactions);
			Goal goalEdited = withDrawInGoal(goal, operation);

			clientUpdateGoal(goalEdited);

		} else {
			throw new RuntimeException("TODO");
		}
		return transactioned;
	}

	public GoalHistory saveTransaction(double value) {
		GoalHistory transaction = setValueInTransaction(value);
		return transactGoalRepository.save(transaction);
	}

	public GoalHistory setValueInTransaction(double value) {
		GoalHistory transaction = new GoalHistory();
		transaction.setValue(value);
		return transaction;
	}

	public Goal addInGoal(Goal goal, OperationVO operation) {
		goal.setSaved(calcAdd(goal.getSaved(), operation.getValue()));
		return goal;
	}

	public Goal withDrawInGoal(Goal goal, OperationVO operation) {
		goal.setSaved(calcWithDraw(goal.getSaved(), operation.getValue()));
		return goal;
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
		return restTempGoalId.getForObject(UrlRest.URL_BASE + UrlRest.GOAL + UrlRest.FIND_BY_ID, Goal.class, params);
	}

	public Goal clientUpdateGoal(Goal goal) {
		RestTemplate restTempGoalId = new RestTemplate();
		return restTempGoalId.postForObject(UrlRest.URL_BASE + UrlRest.GOAL + UrlRest.UPDATE, goal, Goal.class);
	}

}
