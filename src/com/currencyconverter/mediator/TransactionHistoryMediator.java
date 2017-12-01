/**
 * 
 */
package com.currencyconverter.mediator;

import com.currencyconverter.view.TransactionHistoryPageData;

/**
 * @author abhishek.kotalwar
 *
 */
public interface TransactionHistoryMediator {

	/**
	 * This method will return transaction history data for user
	 * 
	 * @param userName
	 * @return
	 */
	TransactionHistoryPageData getTransactionHistoryPageDataForUser(String userName);

}
