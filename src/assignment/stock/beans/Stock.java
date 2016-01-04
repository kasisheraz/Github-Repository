package assignment.stock.beans;

import assignment.stock.utils.Constants;

public class Stock {

	private String stockSymbol = null;
	private String type = Constants.TRADE_TYPE_BUY;
	private double lastDividend = 0;
	private double fixedDividend = 0;
	private double parValue = 0;
	private double price = 0;
	
	public Stock(){}
	
	public Stock(String symbol , String type, double lastDividend, double fixedDividend, double parValue, double price){
		this.stockSymbol = symbol;
		this.type = type;
		this.lastDividend = lastDividend;
		this.fixedDividend = fixedDividend;
		this.parValue = parValue;
		this.price = price;
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getLastDividend() {
		return lastDividend;
	}
	public void setLastDividend(double lastDividend) {
		this.lastDividend = lastDividend;
	}
	public double getFixedDividend() {
		return fixedDividend;
	}
	public void setFixedDividend(double fixedDividend) {
		this.fixedDividend = fixedDividend;
	}
	public double getParValue() {
		return parValue;
	}
	public void setParValue(double parValue) {
		this.parValue = parValue;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stock [stockSymbol=" + stockSymbol + ", type=" + type
				+ ", lastDividend=" + lastDividend + ", fixedDividend="
				+ fixedDividend + ", parValue=" + parValue + ", price=" + price
				+ "]";
	}
	
	
}
