package com.ct.fse.unit_testing_junit_and_mockito;

public class DataService {

	private DataRepo repo;
	
	
	
	public DataRepo getRepo() {
		return repo;
	}

	public void setRepo(DataRepo repo) {
		this.repo = repo;
	}

	public int add(int a, int b) {
		return a-b;
	}
	
	public double divide(double a, double b) {
		if(b==0) {
			throw new ArithmeticException("Exception : value of b cannot be zero.");
		}
		return a/b;
	}
	
	public String addData() {
		return repo.addData();
	}
	
}
