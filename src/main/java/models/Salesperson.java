package models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import builders.SalespersonBuilder;

public class Salesperson extends Person<Salesperson> {

	private String cpf;
	private Float salary;
	private Float totalSold;
	private List<Sale> sales = new ArrayList<Sale>();

	public Salesperson() {
		name = "";
		cpf = "";
		salary = 0F;
		totalSold = 0F;
	}

	public Salesperson(SalespersonBuilder salespersonBuilder) {
		name = salespersonBuilder.getName();
		cpf = salespersonBuilder.getCpf();
		name = salespersonBuilder.getName();
		salary = salespersonBuilder.getSalary();
	}

	public String getCpf() {
		return cpf;
	}

	public Float getSalary() {
		return salary;
	}

	public List<Sale> getSales() {
		return sales ;
	}

	public void addSale(Sale sale) {
		sales.add(sale);
		totalSold += sale.getSaleValue();
	}

	public Float getTotalSold() {
		return totalSold;
	}
	

	@Override
	public int compareTo(Salesperson anotherSalesperson) {
		if (anotherSalesperson == null)
			return 0;
		return totalSold.compareTo(anotherSalesperson.getTotalSold());
	}
	
	public static Comparator<Salesperson> getComparator() {
		return new Comparator<Salesperson>() {
            @Override
            public int compare(Salesperson salesperson1, Salesperson salesperson2) {
                return salesperson1.compareTo(salesperson2);
            }
        };
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		result = prime * result + ((sales == null) ? 0 : sales.hashCode());
		result = prime * result + ((totalSold == null) ? 0 : totalSold.hashCode());
		return result;
	}

	public boolean worseSellerThan(Salesperson worstSalesperson) {
		if (worstSalesperson == null) {
			return false;
		}
		else {
			return worstSalesperson.getTotalSold() > totalSold;
		}	
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salesperson other = (Salesperson) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		if (sales == null) {
			if (other.sales != null)
				return false;
		} else if (!sales.equals(other.sales))
			return false;
		if (totalSold == null) {
			if (other.totalSold != null)
				return false;
		} else if (!totalSold.equals(other.totalSold))
			return false;
		return true;
	}
}
