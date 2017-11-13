package com.internousdev.login.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	//データベースにアクセスするためのJDBCドライバのクラス名
	private static String driverName ="com.mysql.jdbc.Driver";
	private static String url= "jdbc:mysql://localhost/openconnect";

	private static String user ="root";
	private static String password = "mysql";

	public Connection getConnection(){
		//接続を表すConnectionオブジェクトを初期化
		Connection con = null;

		try{
			//クラスローダによりJDBCドライバを読み込む。
			Class.forName(driverName);
			//DriverManagerクラスのgetConnectionメソッドを使ってDBに接続
			con =(Connection)DriverManager.getConnection(url, user, password);
		//ドライバを読み込めなかった時の例外処理
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		//他のSQLの例外処理
		}catch(SQLException e){
			e.printStackTrace();
		}
		//接続であるconを呼び出し元に返す
		//接続できていなければnull値が入っている
		return con;
	}
}
