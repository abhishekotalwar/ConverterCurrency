/**
 * 
 */
package com.currencyconverter.activity.test;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import com.currencyconverter.activity.CurrencyConverterActivity;
import com.currencyconverter.activity.impl.CurrencyConverterActivityImpl;
import com.currencyconverter.converter.CurrencyConvector;
import com.currencyconverter.converter.impl.CurrencyConvectorImpl;
import com.currencyconverter.enums.CurrencyEnum;
import com.currencyconverter.model.CurrencyConvertData;
import com.currencyconverter.model.CurrencyTransactionHistory;
import com.currencyconverter.service.CurrencyTransactionHistoryService;
import com.currencyconverter.service.impl.CurrencyTransactionHistoryServiceImpl;
import com.currencyconverter.view.FormErrorMessages;

/**
 * @author abhishek.kotalwar
 *
 */
public class CurrencyConverterActivityTest {
	private CurrencyConverterActivity currencyConverterActivity;
	private CurrencyTransactionHistoryService currencyTransactionHistoryServiceMock;
	private CurrencyConvector currencyConvectorMock;

	@Before
	public void setUp() {
		currencyTransactionHistoryServiceMock = EasyMock.createMock(CurrencyTransactionHistoryServiceImpl.class);
		currencyConvectorMock = EasyMock.createMock(CurrencyConvectorImpl.class);

		CurrencyConverterActivityImpl currencyConverterActivityImpl = new CurrencyConverterActivityImpl();
		ReflectionTestUtils.setField(currencyConverterActivityImpl, "currencyTransactionHistoryService",
				currencyTransactionHistoryServiceMock);
		ReflectionTestUtils.setField(currencyConverterActivityImpl, "currencyConvector", currencyConvectorMock);

		currencyConverterActivity = currencyConverterActivityImpl;
	}

	@Test
	public void testGetValidationFailedData() {
		String userName = "testUser";
		CurrencyTransactionHistory currencyTransactionHistory = new CurrencyTransactionHistory();
		List<CurrencyTransactionHistory> listOfHistryTranscation = new ArrayList<CurrencyTransactionHistory>();
		listOfHistryTranscation.add(currencyTransactionHistory);

		EasyMock.expect(currencyTransactionHistoryServiceMock.findLast10CurrencyTransactionHistory(userName))
				.andReturn(listOfHistryTranscation).anyTimes();
		EasyMock.replay(currencyTransactionHistoryServiceMock);

		assertNotNull(currencyConverterActivity.getValidationFailedData(userName));
	}

	@Test
	public void testValidateCurrencyDataForNullDate() {
		CurrencyConvertData currencyConvertData = new CurrencyConvertData();
		assertNotNull(currencyConverterActivity.validateCurrencyData(currencyConvertData));
	}

	@Test
	public void testValidateCurrencyDataForValidDate() {
		CurrencyConvertData currencyConvertData = new CurrencyConvertData();
		currencyConvertData.setDateValue("2017-11-27");
		assertNotNull(currencyConverterActivity.validateCurrencyData(currencyConvertData));
	}

	@Test
	public void testPersistCurrencyConversionData() {
		String userName = "testUser";
		BigDecimal conversionResult = BigDecimal.ONE;
		CurrencyConvertData currencyConvertData = getCurrencyConvertObjectWithData();

		currencyConverterActivity.persistCurrencyConversionData(conversionResult, currencyConvertData, userName);
	}

	@Test
	public void testExtractCurrencyConverterPageData() {
		String userName = "testUser";
		BigDecimal conversionResult = BigDecimal.ONE;
		CurrencyTransactionHistory currencyTransactionHistory = new CurrencyTransactionHistory();
		List<CurrencyTransactionHistory> listOfHistryTranscation = new ArrayList<CurrencyTransactionHistory>();
		listOfHistryTranscation.add(currencyTransactionHistory);

		EasyMock.expect(currencyTransactionHistoryServiceMock.findLast10CurrencyTransactionHistory(userName))
				.andReturn(listOfHistryTranscation).anyTimes();
		EasyMock.replay(currencyTransactionHistoryServiceMock);

		CurrencyConvertData currencyConvertData = getCurrencyConvertObjectWithData();

		assertNotNull(currencyConverterActivity.extractCurrencyConverterPageData(conversionResult, currencyConvertData,
				userName));
	}

	@Test
	public void testGetResult() {
		BigDecimal conversionResult = BigDecimal.ONE;
		CurrencyConvertData currencyConvertData = getCurrencyConvertObjectWithData();
		EasyMock.expect(currencyConvectorMock.getConvertedValue(EasyMock.anyString(),
				EasyMock.anyObject(BigDecimal.class), EasyMock.anyObject(CurrencyEnum.class),
				EasyMock.anyObject(CurrencyEnum.class), EasyMock.anyObject(Calendar.class)))
				.andReturn(conversionResult);
		EasyMock.replay(currencyConvectorMock);

		assertNotNull(currencyConverterActivity.getResult(currencyConvertData));
	}

	@Test
	public void testGetCurrencyConverterValidationFailedData() {
		String userName = "testUser";
		FormErrorMessages formErrorMessages = new FormErrorMessages();
		CurrencyTransactionHistory currencyTransactionHistory = new CurrencyTransactionHistory();
		List<CurrencyTransactionHistory> listOfHistryTranscation = new ArrayList<CurrencyTransactionHistory>();
		listOfHistryTranscation.add(currencyTransactionHistory);

		EasyMock.expect(currencyTransactionHistoryServiceMock.findLast10CurrencyTransactionHistory(userName))
				.andReturn(listOfHistryTranscation).anyTimes();
		EasyMock.replay(currencyTransactionHistoryServiceMock);

		assertNotNull(currencyConverterActivity.getCurrencyConverterValidationFailedData(userName, formErrorMessages));
	}

	private CurrencyConvertData getCurrencyConvertObjectWithData() {
		BigDecimal conversionResult = BigDecimal.ONE;
		CurrencyConvertData currencyConvertData = new CurrencyConvertData();
		currencyConvertData.setAmount(conversionResult);
		currencyConvertData.setDateValue("2017-11-27");
		currencyConvertData.setDestinationCurrency("USD");
		currencyConvertData.setSourceCurrency("INR");
		currencyConvertData.setType("C");
		return currencyConvertData;
	}
}
