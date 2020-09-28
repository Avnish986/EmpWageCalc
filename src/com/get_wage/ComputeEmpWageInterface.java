package com.get_wage;

public interface ComputeEmpWageInterface {
	public void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth);
    public void computeWage();
    public int getTotalWage(String company);
}
