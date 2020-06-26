package models;

public class CSVSaleData implements CSVData {

	private Integer id;
	private String[] products;
	private String salespersonName;
	
	public CSVSaleData() {

	}

	@Override
	public boolean loadData(String[] data) {
		try {
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

}
