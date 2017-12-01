/**
 * 
 */
package com.currencyconverter.view;

import java.util.List;

import com.currencyconverter.model.CurrencyTransactionHistory;

/**
 * @author abhishek.kotalwar
 *
 */
public class TransactionHistoryPageData {
	private List<CurrencyTransactionHistory> historyList;
	private String userName;

	/**
	 * @return the historyList
	 */
	public List<CurrencyTransactionHistory> getHistoryList() {
		return historyList;
	}

	/**
	 * @param historyList
	 *            the historyList to set
	 */
	public void setHistoryList(List<CurrencyTransactionHistory> historyList) {
		this.historyList = historyList;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
