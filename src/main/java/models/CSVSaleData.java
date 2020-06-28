package models;

import java.util.Arrays;

public class CSVSaleData extends CSVData {

	private Integer id;
	private String[] products;
	private String salespersonName;
	
	public CSVSaleData() {

	}

	@Override
	public boolean loadData(String[] data) {
		try {
			this.code = data[0];
			this.id = Integer.valueOf(data[1]);
			this.products = data[2].replace("[", "")
					               .replace("]", "")
					               .split(",");
			this.salespersonName = data[3];
			return true;
		}
		catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
	}

	public Integer getId() {
		return id;
	}

	public String[] getProducts() {
		return products;
	}

	public String getSalespersonName() {
		return salespersonName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(products);
		result = prime * result + ((salespersonName == null) ? 0 : salespersonName.hashCode());
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
		CSVSaleData other = (CSVSaleData) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(products, other.products))
			return false;
		if (salespersonName == null) {
			if (other.salespersonName != null)
				return false;
		} else if (!salespersonName.equals(other.salespersonName))
			return false;
		return true;
	}

}
