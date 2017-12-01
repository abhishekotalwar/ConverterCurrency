/**
 * 
 */
package com.currencyconverter.activity.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.currencyconverter.activity.TransactionHistoryActivity;
import com.currencyconverter.model.CurrencyTransactionHistory;
import com.currencyconverter.service.CurrencyTransactionHistoryService;
import com.currencyconverter.view.TransactionHistoryPageData;

/**
 * @author abhishek.kotalwar
 *
 */
@Service
public class TransactionHistoryActivityImpl implements TransactionHistoryActivity {

	@Inject
	CurrencyTransactionHistoryService currencyTransactionHistoryService;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TransactionHistoryPageData getTransactionHistoryPageDataForUser(String userName) {
		List<CurrencyTransactionHistory> listOfHistryTranscation = currencyTransactionHistoryService
				.findLast10CurrencyTransactionHistory(userName);

		TransactionHistoryPageData transactionHistoryPageData = new TransactionHistoryPageData();
		transactionHistoryPageData.setHistoryList(listOfHistryTranscation);
		transactionHistoryPageData.setUserName(userName);
		return transactionHistoryPageData;
	}
}
