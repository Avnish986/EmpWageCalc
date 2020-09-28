package com.get_wage;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpWageCalc implements ComputeEmpWageInterface{
	
	public static final int IS_FULL_TIME = 1;
	public static final int IS_PART_TIME = 2;
   
	private ArrayList<EmpWageComp> EmpWageCompList;
	private Map<String, EmpWageComp> companyToEmpWageMap;
	
    public EmpWageCalc() {
    	EmpWageCompList = new ArrayList<>();
    	companyToEmpWageMap = new HashMap<>();
    }
    @Override
    public void addCompanyEmpWage(String company, int empRatePerHour,int numOfWorkingDays, int maxHoursPerMonth ) {
		EmpWageComp EmpWageComp = new EmpWageComp(company, empRatePerHour, numOfWorkingDays, maxHoursPerMonth);
		EmpWageCompList.add(EmpWageComp);
		companyToEmpWageMap.put(company, EmpWageComp);

    }
    @Override
	public void computeWage() {
    	for(int i = 0; i < EmpWageCompList.size(); i++){
		EmpWageComp EmpWageComp = EmpWageCompList.get(i);
		EmpWageComp.setTotalEmpWage(this.computeEmpWage(EmpWageComp));
		System.out.println(EmpWageComp);
      }
	}
	private int computeEmpWage(EmpWageComp EmpWageComp) {
		int empHours = 0, totalEmpHours = 0, totalWorkingDays = 0;


		while (totalEmpHours <= EmpWageComp.maxHoursPerMonth && totalWorkingDays < EmpWageComp.numOfWorkingDays) {
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
       return totalEmpHours * EmpWageComp.empRatePerHour;

	}
	
	@Override
	public int getTotalWage(String company) {
		return 0;
	}
	 public static void main(String[] args) {
		 EmpWageCalc empWageBuilder = new EmpWageCalc();
		 empWageBuilder.addCompanyEmpWage("Reliance",  20,  5,  10);
		 empWageBuilder.addCompanyEmpWage("BigBasket",  10,  4,  20);
		 empWageBuilder.computeWage();
	 }
	
}