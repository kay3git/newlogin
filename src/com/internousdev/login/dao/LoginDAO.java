package com.internousdev.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.login.dto.LoginDTO;
import com.internousdev.login.util.DBConnector;


public class LoginDAO {
///////＜修正↓＞selectメソッドにthrows追加
	public LoginDTO select(String name,String password) throws SQLException{
///////＜修正↑＞selectメソッドにthrows追加
		//////////自分で書き加えた1行
		LoginDTO dto=new LoginDTO();
//////////////////////////////
		//DBConnectorのインスタンスdbを作成
		DBConnector db = new DBConnector();
		//DBConnectorからの戻り値（接続できていればその接続、できていなければnull）をConnection型の変数conにセット
		Connection con = db.getConnection();
		//ユーザ名とパスワードをプレースホルダにしたSQL文（文字列）を変数sqlにセット
		String sql ="select * from user where user_name =? and password =?";

		//
		try{
			//prepareStatementメソッドを用いてPreparedStatementインターフェースのオブジェクトpsを作成
			//（引数はsqlにセットされたSQL文）
			//PreparedStatementオブジェクトはパラメータ付のSQLを実行するために使われる
			//事前にコンパイルが行われているので高速で実行できる
			PreparedStatement ps = con.prepareStatement(sql);
			//PreparedStatementオブジェクトのパラメータに値をセット
			//PreparedStatementインターフェースで用意されているsetStringメソッドを使用
			ps.setString(1,name);
			ps.setString(2,password);
			//SQLを実行し結果セットをrsに格納
			ResultSet rs = ps.executeQuery();

			if(rs.next()){
				//DBから取得した情報をDTOオブジェクトに格納
				dto.setName(rs.getString("user_name"));
				dto.setPassword(rs.getString("password"));
				}
		}catch(SQLException e){
				e.printStackTrace();
		}
////////自分で書き加えた/////////////////
//		try{
//			con.close();
//		}catch(SQLException e){
//			e.printStackTrace();
//		}
/////////////////////////////////////////
////////自分で消した/////////////////
		finally{
				con.close();
		}
/////////////////////////////////////////
		return dto;
	}
}
