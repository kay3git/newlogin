package com.internousdev.login.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.login.dao.LoginDAO;
import com.internousdev.login.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String name;
	private String password;
	//変数sessionをMap型で定義
	//ジェネリクス機能により<>内の型パラメータにより格納できるオブジェクトの型を指定
	private Map<String,Object> session;


///////＜修正↓＞executeメソッドにthrows追加
	public String execute() throws SQLException{
///////＜修正↑＞executeメソッドにthrows追加
		String ret = ERROR;
		LoginDAO dao = new LoginDAO();
		LoginDTO dto = new LoginDTO();

		dto =dao.select(name,password);
		if(name.equals(dto.getName())){
				if(password.equals(dto.getPassword())){
					ret = SUCCESS;
				}
			}
	//putメソッドにより変数sessionにキーと値を設定
	session.put("name", dto.getName());
	//変数retの値を呼び出し元に返す
	//retの値：ユーザが入力したユーザ名とパスワードがともにDBの値と合致していればSUCCESS、いなければERROR
	return ret;
//////↓このカッコがスライドに抜けている//////
	}

//////////////////////////////////////////////
////////////////↓スライドにないがgetterとsetter入れてみる//////////////////////

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

/////////////// ↑スライドにないがgetterとsetter入れてみる//////////////////////
////////////////↓sessionのgetterとsetter//////////////////////
	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
////////////////↑sessionのgetterとsetter//////////////////////
}
