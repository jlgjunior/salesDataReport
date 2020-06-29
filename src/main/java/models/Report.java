package models;

import builders.ReportBuilder;

public class Report {

	private Integer customersCount;
	private Integer salespeopleCount;
	private Long mostExpensiveSaleId;
	private String worstSalespersonName;
	
	public Report() {
		customersCount = 0;
		salespeopleCount = 0;
		mostExpensiveSaleId = null;
		worstSalespersonName = "No salesperson found";
	}
	
	public Report(ReportBuilder reportBuilder) {
		customersCount = reportBuilder.getCustomersCount();
		salespeopleCount = reportBuilder.getSalespeopleCount();
		mostExpensiveSaleId = reportBuilder.getMostExpensiveSaleId();
		worstSalespersonName = reportBuilder.getWorstSalespersonName();
	}
	
	public Integer getCustomersCount() {
		return customersCount;
	}
	public Integer getSalespeopleCount() {
		return salespeopleCount;
	}
	public String getWorstSalespersonName() {
		return worstSalespersonName;
	}
	public Long getMostExpensiveSaleId() {
		return mostExpensiveSaleId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customersCount == null) ? 0 : customersCount.hashCode());
		result = prime * result + ((mostExpensiveSaleId == null) ? 0 : mostExpensiveSaleId.hashCode());
		result = prime * result + ((salespeopleCount == null) ? 0 : salespeopleCount.hashCode());
		result = prime * result + ((worstSalespersonName == null) ? 0 : worstSalespersonName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Report other = (Report) obj;
		if (customersCount == null) {
			if (other.customersCount != null)
				return false;
		} else if (!customersCount.equals(other.customersCount))
			return false;
		if (mostExpensiveSaleId == null) {
			if (other.mostExpensiveSaleId != null)
				return false;
		} else if (!mostExpensiveSaleId.equals(other.mostExpensiveSaleId))
			return false;
		if (salespeopleCount == null) {
			if (other.salespeopleCount != null)
				return false;
		} else if (!salespeopleCount.equals(other.salespeopleCount))
			return false;
		if (worstSalespersonName == null) {
			if (other.worstSalespersonName != null)
				return false;
		} else if (!worstSalespersonName.equals(other.worstSalespersonName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Report [customersCount=" + customersCount + ", salespeopleCount=" + salespeopleCount
				+ ", mostExpensiveSaleId=" + mostExpensiveSaleId + ", worstSalespersonName=" + worstSalespersonName
				+ "]";
	}	
	
	
}
