package ProjeSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
 
import Proje.Address;
 
public class AddressDuzenle {
 
	 public Address getirId(int id) {
		 Address r = null;
		 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/intecon", "root", "1234");
		 
		String query = "Select * from address_table where IDX=?";
		 PreparedStatement psmt = conn.prepareStatement(query);
		 psmt.setInt(1, id);
		 ResultSet rs = psmt.executeQuery();
		 
		while (rs.next()) {
		 r = new Address(rs.getInt("IDX"), rs.getString("ADDRCODE"),
		 rs.getString("ADDRTYPE"), rs.getString("ADDRESS"),
		 rs.getString("DISTRICT"), rs.getString("ZIPCODE"), rs.getString("CITY"));
		 }
		 
		} catch (Exception e) {
		 e.printStackTrace();
		 }
		 return r;
		 }
 
 public List<Address> getirTumListe() {
 List<Address> r = new ArrayList<Address>();
 try {
 Class.forName("com.mysql.jdbc.Driver");
 Connection conn = DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/intecon", "root", "1234");
 String query = "Select * from address_table";
 PreparedStatement psmt = conn.prepareStatement(query);
 ResultSet rs = psmt.executeQuery();
 
 while (rs.next()) {
		Address addr = new Address (rs.getInt("IDX"), rs.getString("ADDRCODE"), rs.getString("ADDRTYPE"), rs.getString("ADDRESS"), rs.getString("DISTRICT"), rs.getString("ZIPCODE"), rs.getString("CITY"));

	 }
 
} catch (Exception e) {
 e.printStackTrace();
 }
 return r;
 }
 
 public int AddressSil(int id) {
 try {
 Class.forName("com.mysql.jdbc.Driver");
 Connection conn = DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/intecon", "root", "1234");
 
String query = "DELETE FROM address_table where IDX=?";
 
 PreparedStatement psmt = conn.prepareStatement(query);
 psmt.setInt(1, id);
 return psmt.executeUpdate();
 
 }catch (Exception e) {
 e.printStackTrace();
 }
 
 return 0;
 }
 
 public int AddressDuzenle(int id, String adressCode, String adressType, String adress, String district, String zipcode,  String city) {
 try {
 Class.forName("com.mysql.jdbc.Driver");
 Connection conn = DriverManager.getConnection(
 "jdbc:mysql://localhost:3306/intecon", "root", "1234");
 
String query = "UPDATE address_table SET ADDRCODE=?,ADDRTYPE=?,ADDRESS=?,DISTRICT=?,ZIPCODE=?,CITY=? where IDX=?";
 
 PreparedStatement preStmt = conn.prepareStatement(query);
 preStmt.setString(1, adressCode);
 preStmt.setString(2, adressType);
 preStmt.setString(3, adress);
 preStmt.setString(4, district);
 preStmt.setString(5, zipcode);
 preStmt.setString(6, city);
 preStmt.setInt(7, Integer.valueOf(id));
 return preStmt.executeUpdate();
 
 }catch (Exception e) {
 e.printStackTrace();
 }
 
 return 0;
 }
 
}