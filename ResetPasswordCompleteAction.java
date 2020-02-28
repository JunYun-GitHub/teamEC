package com.internousdev.rosso.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rosso.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	//DBの会員情報テーブルのパスワードを入力値で更新する
	public String execute() throws SQLException {

		String result = ERROR;
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int updateFlg = userInfoDAO.resetPassword(
				session.get("loginUserId").toString(),
				session.get("newPassword").toString());

		if(updateFlg > 0) {
			result = SUCCESS;
		}

		session.remove("loginUserId");
		session.remove("newPassword");

		return result;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

}
