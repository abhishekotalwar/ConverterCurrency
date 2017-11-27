/**
 * 
 */
package com.currencyconverter.activity.test;

import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import com.currencyconverter.activity.LoginActivity;
import com.currencyconverter.activity.impl.LoginActivityImpl;
import com.currencyconverter.model.CurrencyTransactionHistory;
import com.currencyconverter.model.LoginFormData;
import com.currencyconverter.model.UserData;
import com.currencyconverter.service.CurrencyTransactionHistoryService;
import com.currencyconverter.service.UserService;
import com.currencyconverter.service.impl.CurrencyTransactionHistoryServiceImpl;
import com.currencyconverter.service.impl.UserServiceImpl;

/**
 * @author abhishek.kotalwar
 *
 */
public class LoginActivityTest {
	private LoginActivity loginActivity;
	private CurrencyTransactionHistoryService currencyTransactionHistoryServiceMock;
	private UserService userServiceMock;

	@Before
	public void setUp() {
		currencyTransactionHistoryServiceMock = EasyMock.createMock(CurrencyTransactionHistoryServiceImpl.class);
		userServiceMock = EasyMock.createMock(UserServiceImpl.class);

		LoginActivityImpl loginActivityImpl = new LoginActivityImpl();
		ReflectionTestUtils.setField(loginActivityImpl, "currencyTransactionHistoryService",
				currencyTransactionHistoryServiceMock);
		ReflectionTestUtils.setField(loginActivityImpl, "userService", userServiceMock);
		loginActivity = loginActivityImpl;
	}

	@Test
	public void testUserLogOut() {
		HttpSession sessionMock = EasyMock.createMock(HttpSession.class);
		HttpServletResponse responseMock = EasyMock.createMock(HttpServletResponse.class);

		loginActivity.userLogOut(sessionMock, responseMock);
	}

	@Test
	public void testUserLoggedIn() {
		String userName = "userName";
		LoginFormData loginFormData = new LoginFormData();
		loginFormData.setUserName("userName");

		HttpSession sessionMock = EasyMock.createMock(HttpSession.class);
		HttpServletRequest requestMock = EasyMock.createMock(HttpServletRequest.class);
		EasyMock.expect(requestMock.getSession()).andReturn(sessionMock);
		EasyMock.replay(requestMock);

		CurrencyTransactionHistory currencyTransactionHistory = new CurrencyTransactionHistory();
		List<CurrencyTransactionHistory> listOfHistryTranscation = new ArrayList<CurrencyTransactionHistory>();
		listOfHistryTranscation.add(currencyTransactionHistory);

		EasyMock.expect(currencyTransactionHistoryServiceMock.findLast10CurrencyTransactionHistory(userName))
				.andReturn(listOfHistryTranscation).anyTimes();
		EasyMock.replay(currencyTransactionHistoryServiceMock);

		assertNotNull(loginActivity.userLoggedIn(loginFormData, sessionMock, requestMock));
	}

	@Test
	public void testGetUserByUserName() {
		String userName = "testUser";
		UserData user = new UserData();
		EasyMock.expect(userServiceMock.getUserByUserName(userName)).andReturn(user);
		EasyMock.replay(userServiceMock);
		assertNotNull(loginActivity.getUserByUserName(userName));
	}
}
