package ProjeSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Proje.Address;

public class AddressSql {
	public List<Address> getirTumListe() {
		 List<Address> r = new ArrayList<Address>();
		 try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/intecon", "root", "1234");
		 String query = "Select * from address_table";
		 PreparedStatement psmt = conn.prepareStatement(query);
		 ResultSet rs = psmt.executeQuery();
		 
		while (rs.next()) {
		Address addr = new Address(rs.getInt("IDX"), rs.getString("ADDRCODE"), rs.getString("ADDRTYPE"), rs.getString("ADDRESS"), rs.getString("DISTRICT"), rs.getString("ZIPCODE"), rs.getString("CITY"));
		 r.add(addr);
		 }
		 
		} catch (Exception e) {
		 e.printStackTrace();
		 }
		 return r;
		 }
}