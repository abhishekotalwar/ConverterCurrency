/**
 * 
 */
package com.currencyconverter.action.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.currencyconverter.action.TransactionHistoryAction;
import com.currencyconverter.mediator.TransactionHistoryMediator;
import com.currencyconverter.view.TransactionHistoryPageData;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class TransactionHistoryActionImpl implements TransactionHistoryAction {

	@Inject
	TransactionHistoryMediator transactionHistoryMediator;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public TransactionHistoryPageData getTransactionHistoryPageDataForUser(String userName) {
		return transactionHistoryMediator.getTransactionHistoryPageDataForUser(userName);
	}

}
