package com.get_wage;
import java.util.Random;

public class EmpWageCalc {

	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;

   
	public int numOfCompany = 0;
	private EmpWageComp[] empWageCompArray;
	
    public EmpWageCalc() {
    	empWageCompArray = new EmpWageComp[5];
    }
    private void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth ) {
    	empWageCompArray[numOfCompany] = new EmpWageComp(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
    numOfCompany++;
    }
    
	private void computeEmpWage() {
		for(int i =0; i < numOfCompany; i++) {
			empWageCompArray[i].setTotalEmpWage(this.computeWage(empWageCompArray[i]));
		System.out.println(empWageCompArray[i]);
		}
	}
	private int computeWage(EmpWageComp companyEmpWage) {
		int empHours = 0, totalEmpHours = 0, totalWorkingDays = 0;


		while (totalEmpHours <= companyEmpWage.maxHoursPerMonth && totalWorkingDays < companyEmpWage.numOfWorkingDays) {
			totalWorkingDays++;
            int empCheck = (int)Math.floor(Math.random()* 10)% 3;

			switch (empCheck) {
			case IS_PART_TIME:
				empHours = 4;
				break;
			case IS_FULL_TIME:
				empHours = 8;
				break;
			default:
				empHours = 0;
			}


			totalEmpHours += empHours;
			System.out.println("Day: " + totalWorkingDays + " Emp Hr:  " + empHours);
		}
       return totalEmpHours * companyEmpWage.empRatePerHour;

	}
	 public static void main(String[] args) {
		 EmpWageCalc empWageBuilder = new EmpWageCalc();
		 empWageBuilder.addCompanyEmpWage("Reliance",  20,  2,  10);
		 empWageBuilder.addCompanyEmpWage("BigBazar",  10,  4,  20);
		 empWageBuilder.computeEmpWage();
	 }
	
}
