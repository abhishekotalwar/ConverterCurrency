/**
 * 
 */
package com.currencyconverter.action;

import com.currencyconverter.view.TransactionHistoryPageData;

/**
 * @author abhishek.kotalwar
 *
 */
public interface TransactionHistoryAction {

	/**
	 * This method will return transaction history data for user
	 * 
	 * @param userName
	 * @return
	 */
	TransactionHistoryPageData getTransactionHistoryPageDataForUser(String userName);


}
