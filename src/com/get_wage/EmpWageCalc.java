package com.get_wage;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpWageCalc implements ComputeEmpWageInterface{
	
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
   
	private ArrayList<EmpWageComp> companyEmpWageList;
	private Map<String, EmpWageComp> companyToEmpWageMap;
	
    public EmpWageCalc() {
    	companyEmpWageList = new ArrayList<>();
    	companyToEmpWageMap = new HashMap<>();
    }
    @Override
    public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth ) {
    	EmpWageComp companyEmpWage = new EmpWageComp(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		companyEmpWageList.add(companyEmpWage);
		companyToEmpWageMap.put(company, companyEmpWage);

    }
    @Override
	public void computeWage() {
    	for(int i = 0; i < companyEmpWageList.size(); i++){
    		EmpWageComp companyEmpWage = companyEmpWageList.get(i);
		companyEmpWage.setTotalEmpWage(this.computeWage(companyEmpWage));
		System.out.println(companyEmpWage);
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
	
	@Override
	public int getTotalWage(String company) {
		return companyToEmpWageMap.get(company).totalEmpWage;
	}
	 public static void main(String[] args) {
		 EmpWageCalc empWageBuilder = new EmpWageCalc();
		 empWageBuilder.addCompanyEmpWage("Reliance",  20,  5,  10);
		 empWageBuilder.addCompanyEmpWage("BigBasket",  10,  4,  20);
		 empWageBuilder.computeWage();
		 System.out.println("Total Wage for BigBasket: "+ empWageBuilder.getTotalWage( "BigBasket"));
	 }
	
}