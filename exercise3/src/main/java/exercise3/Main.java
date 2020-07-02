package exercise3;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	 static Scanner scan = new Scanner(System.in);
	    
	    public static void main(String[] args) {
	        int choose;
	        
	        do {
	            showMenu();
	            choose = Integer.parseInt(scan.nextLine());
	            
	            switch(choose) {
	                case 1:
	                    showUser();
	                    break;
	                case 2:
	                    insertUser();
	                    break;
	                case 3:
	                    updateUser();
	                    break;
	                case 4:
	                    deleteUser();
	                    break;
	                case 5:
	                    System.out.println("Exit!!!");
	                    break;
	                default:
	                    System.out.println("Failed!!!");
	                    break;
	            }
	        } while(choose != 5);
	    }
	    
	    static void showMenu() {
	        System.out.println("1. Show User");
	        System.out.println("2. Insert");
	        System.out.println("3. Update");
	        System.out.println("4. Delete");
	        System.out.println("5. Exit");
	        System.out.println("Choose: ");
	    }

	    private static void showUser() {
	        Connection con = null;
	        
	        PreparedStatement pr = null;
	        try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise3", "root", "1211");
	            
	            String sql = "select * from user";
	            pr = con.prepareStatement(sql);
	            ResultSet resultSet = pr.executeQuery();
	            while(resultSet.next()) {
	                user us = new user(resultSet.getInt("id"),
	                		resultSet.getString("userName"), 
	                        resultSet.getString("fullName"), 
	                        resultSet.getString("phone"));
	                us.show();
	            }
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        } finally {
	            if(pr != null) {
	                try {
	                    pr.close();
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	                }
	            }
	            if(con != null) {
	                try {
	                    con.close();
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	                }
	            }
	        }
	    }

	    private static void insertUser() {
	        user us = new user();
	        us.input();
	        
	        Connection con = null;
	        PreparedStatement pr = null;
	        try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise3", "root", "1211");
	            
	            String sql = "insert into user(id, userName, fullName, phone)"
	                    + " values (?, ?, ?, ?)";
	            pr = con.prepareStatement(sql);
	            pr.setInt(1, us.getId());
	            pr.setString(2, us.getUserName());
	            pr.setString(3, us.getFullName());
	            pr.setString(4, us.getPhone());
	            pr.execute();
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        } finally {
	            if(pr != null) {
	                try {
	                	pr.close();
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	                }
	            }
	            if(con != null) {
	                try {
	                    con.close();
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	                }
	            }
	        }
	    }

	    private static void updateUser() {
	        System.out.println("Sửa thông tin sinh vien theo MSV");
	        
	        user us = new user();
	        us.input();
	        
	        Connection con = null;
	        PreparedStatement pr = null;
	        try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise3", "root", "1211");
	            
	            String sql = "update user set userName = ?, fullName = ?, phone = ?"
	                    + " where id = ?";
	            pr = con.prepareStatement(sql);
	            pr.setString(1, us.getUserName());
	            pr.setString(2, us.getFullName());
	            pr.setString(3, us.getPhone());
	            pr.setInt(4, us.getId());
	            
	            pr.executeUpdate();
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        } finally {
	            if(pr != null) {
	                try {
	                	pr.close();
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	                }
	            }
	            if(con != null) {
	                try {
	                    con.close();
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	                }
	            }
	        }
	    }

	    private static void deleteUser() {
	        System.out.println("Nhap MSV can xoa: ");
	        int id = scan.nextInt();
	        scan.nextLine();
	        
	        
	        Connection con = null;
	        PreparedStatement pr = null;
	        try {
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercise3", "root", "1211");
	            
	            String sql = "delete from user where id = ?";
	            pr = con.prepareStatement(sql);
	            pr.setInt(1, id);
	            pr.executeUpdate();
	        } catch (SQLException ex) {
	        	ex.printStackTrace();
	        } finally {
	            if(pr != null) {
	                try {
	                	pr.close();
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	                }
	            }
	            if(con != null) {
	                try {
	                    con.close();
	                } catch (SQLException ex) {
	                	ex.printStackTrace();
	                }
	            }
	        }
	    }
}
