package fdm.com.java.AndyCollinsElectrical;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "stockList")
public class StockItem {

	@Id
	@Column(name = "stock_id", length = 8)
	private int stockId;
	@Column(name = "item_name", length = 100)
	private String itemName;
	@Column(name = "quantity", length = 9)
	private double quantity;
	@Column(name = "category", length = 50)
	private String category;
	@Column(name = "purchase_price", length = 9)
	private double purchasePrice;
	@Column(name = "sell_price", length = 9)
	private double sellPrice;
	@Column(name = "archived", length = 4)
	private boolean archieved;
	
	
	public StockItem() {
	}


	public StockItem(String itemName, int stockId) {
		super();
		this.stockId = stockId;
		this.itemName = itemName;
	}

	public StockItem(String itemName, double quantity, String category, double purchasePrice, double sellPrice, boolean archieved) {
		super();
		this.itemName = itemName;
		this.quantity = quantity;
		this.category = category;
		this.purchasePrice = purchasePrice;
		this.sellPrice = sellPrice;
		this.archieved = archieved;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public boolean isArchieved() {
		return archieved;
	}

	public void setArchieved(boolean archieved) {
		this.archieved = archieved;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (archieved ? 1231 : 1237);
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(purchasePrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(quantity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(sellPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + stockId;
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
		StockItem other = (StockItem) obj;
		if (archieved != other.archieved)
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (Double.doubleToLongBits(purchasePrice) != Double.doubleToLongBits(other.purchasePrice))
			return false;
		if (Double.doubleToLongBits(quantity) != Double.doubleToLongBits(other.quantity))
			return false;
		if (Double.doubleToLongBits(sellPrice) != Double.doubleToLongBits(other.sellPrice))
			return false;
		if (stockId != other.stockId)
			return false;
		return true;
	}

	
	

}
