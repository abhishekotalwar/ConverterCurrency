/**
 * 
 */
package com.currencyconverter.activity.test;

import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import com.currencyconverter.activity.RegisterActivity;
import com.currencyconverter.activity.impl.RegisterActivityImpl;
import com.currencyconverter.model.RegisterFormData;
import com.currencyconverter.model.UserData;
import com.currencyconverter.service.UserService;
import com.currencyconverter.service.impl.UserServiceImpl;

/**
 * @author abhishek.kotalwar
 *
 */
public class RegisterActivityTest {
	private RegisterActivity registerActivity;
	private UserService userServiceMock;

	@Before
	public void setUp() {
		userServiceMock = EasyMock.createMock(UserServiceImpl.class);

		RegisterActivityImpl registerActivityImpl = new RegisterActivityImpl();
		ReflectionTestUtils.setField(registerActivityImpl, "userService", userServiceMock);

		registerActivity = registerActivityImpl;
	}

	@Test
	public void testvalidateRegistrationData() {
		String userName = "testUser";
		RegisterFormData registerFormData = new RegisterFormData();
		registerFormData.setUserName("testUser");
		registerFormData.setPassword("passoword");
		registerFormData.setReEnterPassword("password");
		registerFormData.setEmail("test@email.com");

		UserData user = new UserData();
		EasyMock.expect(userServiceMock.getUserByUserName(userName)).andReturn(user).anyTimes();
		EasyMock.expect(userServiceMock.getUserByEmail(registerFormData.getEmail())).andReturn(user).anyTimes();
		EasyMock.replay(userServiceMock);
		assertNotNull(registerActivity.validateRegistrationData(registerFormData));
	}

	@Test
	public void testRegisterUser() {
		RegisterFormData registerFormData = new RegisterFormData();
		registerFormData.setEmail("test@test.com");
		registerFormData.setFirstName("name");
		registerFormData.setLastName("lname");
		registerFormData.setUserName("testUser");
		registerFormData.setPassword("password");

		registerActivity.registerUser(registerFormData);
	}
}
