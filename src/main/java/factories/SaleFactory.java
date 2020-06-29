package factories;

import java.util.ArrayList;
import java.util.List;

import builders.ProductBuilder;
import builders.SaleBuilder;
import models.CSVData;
import models.CSVSaleData;
import models.Product;
import models.Sale;

public class SaleFactory extends PersistantModelFactory<Sale> {

	public SaleFactory() {
	
	}
	
	@Override
	public Sale createPersistantModel(CSVData data) {
		CSVSaleData saleData = 
				(CSVSaleData) data;
		List<Product> products = new ArrayList<Product>();
		Float saleValue = calculateValue(saleData.getProducts(), products);
		return new SaleBuilder()
					.setId(saleData.getId())
					.setProducts(products)
					.setSalespersonName(saleData.getSalespersonName())
					.setSaleValue(saleValue)
					.build();
	}

	private Float calculateValue(String[] products, List<Product> returnList) {
		Float saleValue = 0f;
		for (String productString : products) {
			String[] productInfo = productString.split("-");
			Long id = Long.valueOf(productInfo[0]);
			Integer quantity = Integer.valueOf(productInfo[1]);
			Float price = Float.valueOf(productInfo[2]);
			Product product  = new ProductBuilder()
								.setId(id)
								.setQuantity(quantity)
								.setPrice(price)
								.build();
			saleValue += (product.getPrice() * product.getQuantity());
			returnList.add(product);
		}
		return saleValue;
	}

}
