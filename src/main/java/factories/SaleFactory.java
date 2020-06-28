package factories;

import java.util.ArrayList;
import java.util.List;

import builders.ProductBuilder;
import builders.SaleBuilder;
import builders.SaleProductBuilder;
import models.CSVData;
import models.CSVSaleData;
import models.PersistantModel;
import models.Product;
import models.SaleProduct;

public class SaleFactory extends PersistantModelFactory {

	@Override
	public PersistantModel createPersistantModel(CSVData data) {
		CSVSaleData saleData = 
				(CSVSaleData) data;
		List<SaleProduct> saleProducts = createProducts(saleData.getProducts());
		return new SaleBuilder()
					.setId(saleData.getId())
					.setProducts(saleProducts)			   
					.build();
	}

	private List<SaleProduct> createProducts(String[] products) {
		List<SaleProduct> saleProductsList = new ArrayList();
		for (String productString : products) {
			String[] productInfo = productString.split("-");
			Integer id = Integer.valueOf(productInfo[0]);
			Integer quantity = Integer.valueOf(productInfo[1]);
			Float price = Float.valueOf(productInfo[2]);
			Product product  = new ProductBuilder()
								.setId(id)
								.build();
			SaleProduct saleProduct = new SaleProductBuilder()
					.setQuantity(quantity)
					.setPrice(price)
					.setProduct(product)
					.build();
			saleProductsList.add(saleProduct);
		}
		return saleProductsList;
	}

}
