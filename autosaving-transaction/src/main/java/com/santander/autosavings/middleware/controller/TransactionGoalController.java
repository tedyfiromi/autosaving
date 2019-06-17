package com.santander.autosavings.middleware.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.autosavings.middleware.model.OperationVO;
import com.santander.autosavings.middleware.model.TransactionGoal;
import com.santander.autosavings.middleware.service.TransactionGoalService;
import com.santander.autosavings.middleware.utils.UrlRest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(UrlRest.BASE)
@Api(value="Transaction Monetary")
public class TransactionGoalController {
	
	public static final String ADD_MONEY = "money/add";
	public static final String WITHDRAW_MONEY = "money/withdraw";
	
	@Autowired
	public TransactionGoalService transactionGoalService;
	
	@ApiOperation(value="Post Add money transaction", response=String.class, notes="This operation save in mongodb a new transaction")
	@PostMapping(value=ADD_MONEY)
	public TransactionGoal addMoney(@RequestBody OperationVO operation){
		return transactionGoalService.addMoney(operation);
	}	
	
	@ApiOperation(value="Post WithDraw money transaction", response=String.class, notes="This operation save in mongodb a new transaction")
	@PostMapping(value=WITHDRAW_MONEY)
	public TransactionGoal withDrawMoney(@RequestBody OperationVO operation) {
		return transactionGoalService.withDrawMoney(operation);		
	}	

}
