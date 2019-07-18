package fdm.com.java.AndyCollinsElectrical;

import java.util.ArrayList;

public class StockList {
	
	private ArrayList <StockItem> stock;

	public StockList(ArrayList<StockItem> stock) {
		super();
		this.stock = stock;
	}

	public ArrayList<StockItem> getStock() {
		return stock;
	}

	public void setStock(ArrayList<StockItem> stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
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
		StockList other = (StockList) obj;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		return true;
	}
	
	

}
