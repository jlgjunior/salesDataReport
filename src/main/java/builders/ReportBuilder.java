package builders;

import models.Report;

public class ReportBuilder {

	private Integer customersCount;
	private Integer salespeopleCount;
	private Long mostExpensiveSaleId;
	private String worstSalespersonName;
	
	public ReportBuilder() {
		
	}
	
	public Report build() {
		return new Report(this);
	}
	
	public Integer getCustomersCount() {
		return customersCount;
	}
	public ReportBuilder setCustomersCount(Integer customersCount) {
		this.customersCount = customersCount;
		return this;
	}
	public Integer getSalespeopleCount() {
		return salespeopleCount;
	}
	public ReportBuilder setSalespeopleCount(Integer salespeopleCount) {
		this.salespeopleCount = salespeopleCount;
		return this;
	}
	public Long getMostExpensiveSaleId() {
		return mostExpensiveSaleId;
	}
	public ReportBuilder setMostExpensiveSaleId(Long mostExpensiveSaleId) {
		this.mostExpensiveSaleId = mostExpensiveSaleId;
		return this;
	}
	public String getWorstSalespersonName() {
		return worstSalespersonName;
	}
	public ReportBuilder setWorstSalespersonName(String worstSalespersonName) {
		this.worstSalespersonName = worstSalespersonName;
		return this;
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
		ReportBuilder other = (ReportBuilder) obj;
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
}
