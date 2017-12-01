/**
 * 
 */
package com.currencyconverter.mediator.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.currencyconverter.activity.TransactionHistoryActivity;
import com.currencyconverter.mediator.TransactionHistoryMediator;
import com.currencyconverter.view.TransactionHistoryPageData;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class TransactionHistoryMediatorImpl implements TransactionHistoryMediator {

	@Inject
	TransactionHistoryActivity transactionHistoryActivity;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TransactionHistoryPageData getTransactionHistoryPageDataForUser(String userName) {
		return transactionHistoryActivity.getTransactionHistoryPageDataForUser(userName);
	}

}
