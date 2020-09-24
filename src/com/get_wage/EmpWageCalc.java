package com.get_wage;

public class EmpWageCalc {

	public static void main(String[] args) {
		int Is_Full_Time=1;
		double empCheck=Math.floor(Math.random()*10)%2;
		if(empCheck==Is_Full_Time)
		System.out.println("Employee Present");
		else
		System.out.println("Employee Absent");
	}

}
