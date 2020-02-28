package com.internousdev.rosso.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rosso.dao.UserInfoDAO;
import com.internousdev.rosso.util.CommonUtility;
import com.internousdev.rosso.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String newPassword;
	private String newConfirmPassword;
	private String tmpNewPassword;
	private List<String> loginUserIdErrorMessageList;
	private List<String> loginPasswordErrorMessageList;
	private List<String> newPasswordErrorMessageList;
	private List<String> newConfirmPasswordErrorMessageList;
	private String newUserAndPasswordExistenseErrorMessageList;
	private Map<String, Object> session;
	private String newPasswordMatchesList;
	private String errorMessage;

	public String execute() {

		String result = ERROR;
		session.put("loginUserId", loginUserId);

		//入力チェック(未入力、桁数、文字種)を行う
		InputChecker inputChecker = new InputChecker();

		loginUserIdErrorMessageList = inputChecker.doCheck("ユーザーID",loginUserId,1,8,true,false,false,true,false,false);
		loginPasswordErrorMessageList = inputChecker.doCheck("現在のパスワード", loginPassword, 1, 16, true, false, false,true, false, false);
		newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード", newPassword, 1, 16, true, false, false,true, false, false);
		newConfirmPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード（再確認）", newConfirmPassword, 1, 16, true, false, false, true, false, false);
		//エラーが発生した場合は、自画面に遷移して、対象のエラーメッセージを表示する
		if(loginUserIdErrorMessageList.size() > 0
				|| loginPasswordErrorMessageList.size() > 0
				|| newPasswordErrorMessageList.size() > 0
				|| newConfirmPasswordErrorMessageList.size() > 0) {
			return result;
		}

		//エラーがない場合は、「【処理】パスワード一致確認」を行う
		newPasswordMatchesList = inputChecker.doPasswordCheck(newPassword, newConfirmPassword);

		//一致しない場合は、自画面に遷移し、エラーメッセージを表示する
		if(newPasswordMatchesList != null) {
			return result;
		}

		//一致する場合は、「【処理】ユーザーの存在チェック」を行う
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		boolean userCheck = userInfoDAO.isCheckUserInfo(loginUserId, loginPassword);

		if(!userCheck) {
			newUserAndPasswordExistenseErrorMessageList = "ユーザーIDまたはパスワードが異なります。";
		} else {

			//パスワード再設定確認画面に遷移する
			CommonUtility commonUtility = new CommonUtility();
			session.put("newPassword", newPassword);
			tmpNewPassword = commonUtility.concealPassword(newPassword);
			result = SUCCESS;
		}

		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewConfirmPassword() {
		return newConfirmPassword;
	}

	public void setNewConfirmPassword(String newConfirmPassword) {
		this.newConfirmPassword = newConfirmPassword;
	}

	public String getTmpNewPassword() {
		return tmpNewPassword;
	}

	public void setTmpNewPassword(String tmpNewPassword) {
		this.tmpNewPassword = tmpNewPassword;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public List<String> getLoginUserIdErrorMessageList() {
		return loginUserIdErrorMessageList;
	}

	public void setLoginUserIdErrorMessageList(List<String> loginUserIdErrorMessageList) {
		this.loginUserIdErrorMessageList = loginUserIdErrorMessageList;
	}

	public List<String> getLoginPasswordErrorMessageList() {
		return loginPasswordErrorMessageList;
	}

	public void setLoginPasswordErrorMessageList(List<String> loginPasswordErrorMessageList) {
		this.loginPasswordErrorMessageList = loginPasswordErrorMessageList;
	}

	public List<String> getNewPasswordErrorMessageList() {
		return newPasswordErrorMessageList;
	}

	public void setNewPasswordErrorMessageList(List<String> newPasswordErrorMessageList) {
		this.newPasswordErrorMessageList = newPasswordErrorMessageList;
	}

	public String getNewPasswordMatchesList() {
		return newPasswordMatchesList;
	}

	public void setNewPasswordMatchesList(String newPasswordMatchesList) {
		this.newPasswordMatchesList = newPasswordMatchesList;
	}

	public List<String> getNewConfirmPasswordErrorMessageList() {
		return newConfirmPasswordErrorMessageList;
	}

	public void setNewConfirmPasswordErrorMessageList(List<String> newConfirmPasswordErrorMessageList) {
		this.newConfirmPasswordErrorMessageList = newConfirmPasswordErrorMessageList;
	}

	public String getNewUserAndPasswordExistenseErrorMessageList() {
		return newUserAndPasswordExistenseErrorMessageList;
	}

	public void setNewUserAndPasswordExistenseErrorMessageList(String newUserAndPasswordExistenseErrorMessageList) {
		this.newUserAndPasswordExistenseErrorMessageList = newUserAndPasswordExistenseErrorMessageList;
	}

}
