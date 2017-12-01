/**
 * 
 */
package com.currencyconverter.activity;

import com.currencyconverter.view.TransactionHistoryPageData;

/**
 * @author abhishek.kotalwar
 *
 */
public interface TransactionHistoryActivity {

	/**
	 * This method will return transaction history data for user
	 * 
	 * @param userName
	 * @return
	 */
	TransactionHistoryPageData getTransactionHistoryPageDataForUser(String userName);

}
