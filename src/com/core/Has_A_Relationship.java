/*
 * 
 */
package com.core;
class Address_01{
	String city;
	String state;
	String country;
	double zipcode;
	Address_01(	String city,String state,String country,double zipcode){
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
}
class Student_01{
	int id;
	String name;
	Address_01 ad;	
	}

 
public class Has_A_Relationship {

	public static void main(String[] args) {
		
		Student_01 s = new Student_01();
		System.out.println(s);
		s.id = 486695;
		s.name = "Nikhil";
		Address_01 addr = new Address_01("BLR", "Karnataka", "IND",560078);
		s.ad = addr;
		System.out.println(s.ad.city);
		}

}
