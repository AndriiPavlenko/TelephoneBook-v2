package com.woolfer.telephonebook.db;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.woolfer.telephonebook.contact.Contact;

public class DBOperation {

	public static int addToDB(String Firstname, String LastName,
			String PhoneNumber) throws SQLException, IOException {
		int isTrue = 0;
		PreparedStatement prStAddToDB = null;
		String query = "INSERT INTO `mobilephone` VALUES (?, ?, ?, null)";

		Connection conn = DBConnection.getConnection();
		try {
			conn.setAutoCommit(false);
			prStAddToDB = conn.prepareStatement(query);
			prStAddToDB.setString(1, Firstname);
			prStAddToDB.setString(2, LastName);
			prStAddToDB.setString(3, PhoneNumber);
			isTrue = prStAddToDB.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			if (conn != null) {
				try {
					System.err.print("Transaction is being rolled back");
					conn.rollback();
				} catch (SQLException excep) {
					excep.printStackTrace();
				}
			}
		} finally {
			if (prStAddToDB != null)
				prStAddToDB.close();
			conn.setAutoCommit(true);
			if (conn != null)
				conn.close();
		}
		return isTrue;
	}

	public static List getPhoneBook() {

		Connection conn = null;
		List<Contact> listPhoneBook = null;
		try {
			conn = DBConnection.getConnection();

			String query = "SELECT * FROM  `mobilephone`";

			Statement stat = conn.createStatement();
			ResultSet result = stat.executeQuery(query);

			int numberOfRecords = 0;
			if (result.first()) {
				numberOfRecords = result.getRow();
				listPhoneBook = new ArrayList<Contact>(numberOfRecords);

				do {
					listPhoneBook.add(new Contact(result.getString(1), result.getString(2), result.getString(3), result.getInt(4)));
				} while (result.next());
				result.close();

			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listPhoneBook;
	}

	public static boolean delRow(String id) throws SQLException, IOException {
		boolean isDel = false;
		PreparedStatement prStDelRow = null;
		String query = "DELETE FROM `mobilephone` WHERE id=?";
		Connection conn = DBConnection.getConnection();

		try {
			conn.setAutoCommit(false);
			prStDelRow = conn.prepareStatement(query);
			prStDelRow.setString(1, id);
			if (prStDelRow.executeUpdate() == 1)
				isDel = true;
			conn.commit();

		} catch (SQLException e) {
			if (conn != null) {
				try {
					System.err.print("Transaction is being rolled back");
					conn.rollback();
				} catch (SQLException excep) {
					excep.printStackTrace();
				}
			}
		} finally {
			if (prStDelRow != null)
				prStDelRow.close();
			conn.setAutoCommit(true);
			if (conn != null)
				conn.close();
		}
		return isDel;
	}

	public static Contact getRow(String id) {
		Connection conn = null;
		Contact contactID = null;
		PreparedStatement prStGetRow = null;
		String query = "SELECT * FROM `mobilephone` WHERE id=?";

		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			prStGetRow = conn.prepareStatement(query);
			prStGetRow.setString(1, id);
			ResultSet result = prStGetRow.executeQuery();
			if (result.first()) {
				contactID = new Contact(result.getString(1),
						result.getString(2), result.getString(3),
						result.getInt(4));
			}
			conn.commit();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (prStGetRow != null)
					prStGetRow.close();
				if (conn != null) {
					conn.setAutoCommit(true);
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contactID;
	}

	public static boolean changeRow(String id, String FirstName,
			String LastName, String PhoneNumber) {
		boolean isChange = false;
		Connection conn = null;
		PreparedStatement prStChangeRow = null;
		String query = "UPDATE `mobilephone` SET `firstname`=?,`lastname`=?,`mobilephone`=? WHERE `id`=?";

		try {
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			prStChangeRow = conn.prepareStatement(query);
			prStChangeRow.setString(1, FirstName);
			prStChangeRow.setString(2, LastName);
			prStChangeRow.setString(3, PhoneNumber);
			prStChangeRow.setString(4, id);
			if (prStChangeRow.executeUpdate() == 1) {
				isChange = true;
			}
			conn.commit();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (prStChangeRow != null)
					prStChangeRow.close();
				if (conn != null) {
					conn.setAutoCommit(true);
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return isChange;
	}
}
