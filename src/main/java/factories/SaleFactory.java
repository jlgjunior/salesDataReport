package factories;

import builders.SalespersonBuilder;
import models.CSVData;
import models.CSVSaleData;
import models.CSVSalespersonData;
import models.PersistantModel;

public class SaleFactory extends PersistantModelFactory {

	@Override
	public PersistantModel createPersistantModel(CSVData data) {
		CSVSaleData saleData = 
				(CSVSaleData) data;
		return new SaleBuilder()
					.setId(saleData.getId())
					.setProducts(saleData.getProducts())			   
					.build();
	}

}
