package assignment.stock.beans;

import java.util.Date;

import assignment.stock.utils.Constants;

public class Trade {
	
	private Stock stock = null;
	private Date timestamp = null;
	private String tradeType = Constants.TRADE_TYPE_SELL;
	private int quantity = 0; 
	private double price = 0;
	
	
	
	public Trade(Stock stock, Date timestamp, String tradeType, int quantity, double price) {
		this.stock = stock;
		this.timestamp = timestamp;
		this.tradeType = tradeType;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
