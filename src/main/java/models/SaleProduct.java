package models;

public class SaleProduct implements PersistantModel {

	private Integer id;
	private Sale sale;
	private Product product;
	
	@Override
	public void loadCSVData(CSVData data) {
		
	}

	public Sale getSale() {
		return sale;
	}

	public Integer getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

}
