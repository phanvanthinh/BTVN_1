package exercise3;

import java.util.Scanner;

public class user {
	
	private int id;
	private String userName;
	private String fullName;
	private String phone;
	

	public user() {
	}
	
	public user(int id, String userName, String fullName, String phone) {
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.phone = phone;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Nhap id: ");
        id = scan.nextInt();
        scan.nextLine();
        System.out.println("Nhap userName: ");
        userName = scan.nextLine();
        System.out.println("Nhap fullName: ");
        fullName = scan.nextLine();
        System.out.println("Nhap phone: ");
        phone = scan.nextLine();
	}
	
	public void show(){
	       System.out.println("THÔNG TIN SV ");
	       System.out.println("id:"+id);
	       System.out.println("userName:"+userName);
	       System.out.println("fullName:"+fullName);
	       System.out.println("số phone:"+phone);
	   }
}
