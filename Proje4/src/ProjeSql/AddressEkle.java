package ProjeSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
import Proje.Address;

public class AddressEkle {
		 
	 public int AdresEkle(String adressCode, String adressType, String adress, String district, String zipcode,  String city) {
			 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection conn = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/intecon", "root", "1234");
			 
			String query = "INSERT INTO address_table(ADDRCODE,ADDRTYPE, ADDRESS, DISTRICT, ZIPCODE, CITY) VALUES (?,?,?,?,?,?)";
			 
			 PreparedStatement preStmt = conn.prepareStatement(query);
			 preStmt.setString(1, adressCode);
			 preStmt.setString(2, adressType);
			 preStmt.setString(3, adress);
			 preStmt.setString(4, district);
			 preStmt.setString(5, zipcode);
			 preStmt.setString(6, city);
			 return preStmt.executeUpdate();
			 
			 }catch (Exception e) {
			 e.printStackTrace();
			 }
			 
			 return 0;
			 }
}
