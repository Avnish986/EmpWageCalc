package com.get_wage;

public class EmpWageCalc {

	public static final int isPartTime=1;
	public static final int isFullTime=2;
	public static final int empRatePerHr=20;
	public static final int numOfDays=20;
	public static final int maxHrPerMonth=100;
	public String attendance()
	{
		double empCheck=Math.floor(Math.random()*10)%2;
		if(empCheck==isFullTime)
			return "Employee Present";
		else
			return "Employee Absent";
	}
	public double empFullPartStatus()
	{
		double empCheck=Math.floor(Math.random()*10)%3;
		return empCheck;
	}
	public int totalWage()
	{
		int empHrs=0, totalEmpHrs=0, totalWorkingDays=0;
		while(totalEmpHrs<=maxHrPerMonth && totalWorkingDays<numOfDays)
		{
		totalWorkingDays++;
		int fullPartStatus=(int) empFullPartStatus();
		switch(fullPartStatus) {
		case isPartTime:
		empHrs=4;
		break;

		case isFullTime:
		empHrs=8;
		break;

		default:
		empHrs=0;
		}
		totalEmpHrs+=empHrs;
		System.out.println("Day#:"+totalWorkingDays+" EmpHrs: "+empHrs);
		}
		int totalEmpWage=totalEmpHrs*empRatePerHr;
		return totalEmpWage;
	}
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Wage Computation");
		EmpWageCalc empobj = new EmpWageCalc();
		//String status = empobj.attendance();
		//System.out.println(status);
		int totalWage = empobj.totalWage();
		System.out.println("Emp Total Wage : "+totalWage);
	}

}