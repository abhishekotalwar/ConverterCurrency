/**
 * 
 */
package com.currencyconverter.activity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.currencyconverter.model.LoginFormData;
import com.currencyconverter.model.UserData;
import com.currencyconverter.view.CurrencyConverterPageData;

/**
 * @author abhishek.kotalwar
 *
 */
public interface LoginActivity {

	/**
	 * This method will be used for user logout.
	 * 
	 * @param session
	 * @param response
	 */
	public void userLogOut(HttpSession session, HttpServletResponse response);

	/**
	 * This method will used when user logged in
	 * 
	 * @param loginFormData
	 * @param session
	 * @param request
	 * @return
	 */
	public CurrencyConverterPageData userLoggedIn(LoginFormData loginFormData, HttpSession session,
			HttpServletRequest request);

	/**
	 * This method will return the userDate for given userName
	 * 
	 * @param userName
	 * @return
	 */
	public UserData getUserByUserName(String userName);

}
