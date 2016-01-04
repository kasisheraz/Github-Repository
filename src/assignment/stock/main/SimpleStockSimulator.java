package assignment.stock.main;

import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import assignment.stock.beans.Stock;
import assignment.stock.beans.Trade;
import assignment.stock.services.StockCalculatorService;
import assignment.stock.services.StockInputReceiver;
import assignment.stock.utils.Constants;

public class SimpleStockSimulator {

	public static void main(String[] args) {

		StringBuffer buff = null;
	    Formatter formatter = null;
	    try{
/*
		 	Stock tea = new Stock("TEA", Constants.STOCK_TYPE_COMMON, 0, 0, 100, 110);
	        Stock pop = new Stock("POP", Constants.STOCK_TYPE_COMMON, 8, 0, 100, 120);
	        Stock ale = new Stock("ALE", Constants.STOCK_TYPE_COMMON, 23, 0,60, 55);
	        Stock gin = new Stock("GIN", Constants.STOCK_TYPE_PREFERRED, 8, 2, 100, 100);
	        Stock joe = new Stock("JOE", Constants.STOCK_TYPE_COMMON, 13, 0,250, 216.12);
	      
	        List<Stock> stocks = new ArrayList<Stock>();
	        stocks.add(tea);
	        stocks.add(pop);
	        stocks.add(ale);
	        stocks.add(gin);
	        stocks.add(joe);
	      */
	    	List<Stock> stocks = StockInputReceiver.inputStocksInfo();
	        Stock stock = null;
	        Trade trade = null;
	        List<Trade> trades = null;
	      
	        Random rand = new Random();
	        
	        int numberOfTrades = rand.nextInt(50 - 5 + 1) + 5;
	      
	        Map<Stock, List<Trade>> stockTradeMap = new HashMap<Stock, List<Trade>>();
	      
	        for(int i = 0; i < numberOfTrades; i++) {
	          
	            stock = stocks.get(rand.nextInt(stocks.size()-1));
	          
	            trades = stockTradeMap.get(stock);
	          
	            if (trades == null) {
	              
	                trades = new ArrayList<Trade>();
	              
	                stockTradeMap.put(stock, trades);
	            }
	          
	            trade = new Trade(stock, new Date(),rand.nextBoolean() ? Constants.TRADE_TYPE_BUY : Constants.TRADE_TYPE_SELL, 
	            		(rand.nextInt(1000 -10 +1) + 10),(rand.nextDouble()*500 + 10));
	          
	            trades.add(trade);
	        }
	        
	        System.out.println("+--------+----------------+-----------+-------------+");
	        System.out.println("| Symbol | Dividend yield | P/E ratio | Stock price |");
	        System.out.println("+--------+----------------+-----------+-------------+");
	      
	        for(Stock stk : stocks) {
	          
	            trades = stockTradeMap.get(stk);
	          
	            buff = new StringBuffer();
	            formatter = new Formatter(buff);
	          
	            formatter.format("| %6s | %14.2f | %9.2f | %11.2f |",stk.getStockSymbol(),Constants.STOCK_TYPE_COMMON.equals(stk.getType())? 
	            		StockCalculatorService.calculateDividendYieldCommon(stk.getParValue(), 
	            				stk.getLastDividend()) :	StockCalculatorService.calculateDividendYieldPreferred(stk.getParValue(),
	            						stk.getParValue(), stk.getFixedDividend()),StockCalculatorService.calculatePeRatio(stk.getParValue(),
	            								stk.getLastDividend()),StockCalculatorService.calculateStockPrice(trades));
	            
	            System.out.println(buff);
	            System.out.println("+--------+----------------+-----------+-------------+");
	        }
	      
	        System.out.println();
	        System.out.println();
	      
	        System.out.println("+----------------+");
	        System.out.println("| GBCE All share |");
	        System.out.println("+----------------+");
	        
	        buff = new StringBuffer();
	        formatter = new java.util.Formatter(buff);
	          
	        formatter.format("| %14.2f |",StockCalculatorService.allShareIndex(stocks)
	                        );
	        System.out.println(buff);
	        System.out.println("+----------------+");
	        System.out.println();
	        System.out.println();
	   }finally{
		if(formatter!=null){
			formatter.close();
		}   
		   
	   }

	}
}
