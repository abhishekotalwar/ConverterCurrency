/**
 * 
 */
package com.currencyconverter.activity.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import com.currencyconverter.activity.TransactionHistoryActivity;
import com.currencyconverter.activity.impl.TransactionHistoryActivityImpl;
import com.currencyconverter.model.CurrencyTransactionHistory;
import com.currencyconverter.service.CurrencyTransactionHistoryService;
import com.currencyconverter.service.impl.CurrencyTransactionHistoryServiceImpl;

/**
 * @author abhishek.kotalwar
 *
 */
public class TransactionHistoryActivityTest {
	private TransactionHistoryActivity transactionHistoryActivity;
	private CurrencyTransactionHistoryService currencyTransactionHistoryServiceMock;

	@Before
	public void setUp() {
		currencyTransactionHistoryServiceMock = EasyMock.createMock(CurrencyTransactionHistoryServiceImpl.class);

		TransactionHistoryActivityImpl transactionHistoryActivityImpl = new TransactionHistoryActivityImpl();
		ReflectionTestUtils.setField(transactionHistoryActivityImpl, "currencyTransactionHistoryService",
				currencyTransactionHistoryServiceMock);
		transactionHistoryActivity = transactionHistoryActivityImpl;
	}

	@Test
	public void testGetTransactionHistoryPageDataForUser() {
		String userName = "testUser";
		CurrencyTransactionHistory currencyTransactionHistory = new CurrencyTransactionHistory();
		List<CurrencyTransactionHistory> listOfHistryTranscation = new ArrayList<CurrencyTransactionHistory>();
		listOfHistryTranscation.add(currencyTransactionHistory);

		EasyMock.expect(currencyTransactionHistoryServiceMock.findLast10CurrencyTransactionHistory(userName))
				.andReturn(listOfHistryTranscation).anyTimes();
		EasyMock.replay(currencyTransactionHistoryServiceMock);
		
		assertNotNull(transactionHistoryActivity.getTransactionHistoryPageDataForUser(userName));
	}
}
