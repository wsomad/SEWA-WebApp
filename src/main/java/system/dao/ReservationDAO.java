package system.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import system.model.*;

public class ReservationDAO {
	
	//Insert Reservation
	public int makeReservation(Reservation reservation) throws ClassNotFoundException {
		String insert_sql = "insert into Tenant_Vehicle (userid,vehicleid,pickup_date,drop_date,pickup_location,drop_location,passengers_num,special_req,rent_to_pay) values (?,?,?,?,?,?,?,?,?)";
		Class.forName("com.mysql.cj.jdbc.Driver");
		int rowCount = 0;
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(insert_sql);
			pst.setInt(1, reservation.getReservation_userid());
			pst.setInt(2, reservation.getReservation_vehicleid());
			pst.setString(3, reservation.getPickup_DateString());
			pst.setString(4, reservation.getDrop_DateString());
			pst.setString(5, reservation.getPickup_location());
			pst.setString(6, reservation.getDrop_location());
			pst.setInt(7, reservation.getPassengers_num());
			pst.setString(8, reservation.getSpecial_req());
			pst.setDouble(9, reservation.getRent_to_pay());
			
			rowCount = pst.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}
	
	public int makeReservationPayment(User user) throws ClassNotFoundException {
		String insert_sql = "update User set user_wallet = ? where userid = ?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		int rowCount = 0;
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(insert_sql);
			pst.setDouble(1, user.getUser_wallet());
			pst.setInt(2, user.getUserid());
			
			rowCount = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}
	
	public int makeVehicleUnavailable(Vehicle vehicle) throws ClassNotFoundException{
		String insert_sql = "update Vehicle set availability = ? where vehicleid = ?;";
		Class.forName("com.mysql.cj.jdbc.Driver");
		int rowCount = 0;
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://bxx0oim5clt3tz9xxlzj-mysql.services.clever-cloud.com:3306/bxx0oim5clt3tz9xxlzj?serverTimezone=Asia/Kuala_Lumpur", "uwaq62nkjirwnjub", "mRrDGZdA1u7UPAXYI5Rm");
			PreparedStatement pst = con.prepareStatement(insert_sql);
			pst.setBoolean(1, vehicle.getAvailability());
			pst.setInt(2, vehicle.getVehicleid());
			
			rowCount = pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rowCount;
	}
}
