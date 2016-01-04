package assignment.stock.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignment.stock.beans.Stock;
import assignment.stock.utils.CommonUtils;
import assignment.stock.utils.Constants;

public class StockInputReceiver {

	public static List<Stock> inputStocksInfo(){
		List<Stock> stocks = new ArrayList<Stock>();
		Scanner scanner = new Scanner(System.in);
		String input = "Y";
		System.out.println("#################################################");
		System.out.println("#################   Stock Info   ################");
		System.out.println("#################################################");
		
		Stock stock = null;
		while("Y".equalsIgnoreCase(input)){
			stock = new Stock();
	        stock.setStockSymbol(getMandatoryField(scanner, "Stock Symbol :- "));
	        stock.setType(getOptionalField(scanner, "Stock Type (C = Common , P = Preferred):- ", Constants.STOCK_TYPE_COMMON));
			stock.setLastDividend(Double.parseDouble(getMandatoryField(scanner, "Last Dividend :- ")));
			stock.setFixedDividend(Double.parseDouble(Constants.STOCK_TYPE_PREFERRED.equalsIgnoreCase(stock.getType()) ? getMandatoryField(scanner, "Fixed Dividend :- ") : getOptionalField(scanner, "Fixed Dividend :- ", "0")));
			stock.setParValue(Double.parseDouble(getMandatoryField(scanner, "Par Value :- ")));
			stock.setPrice(Double.parseDouble(getMandatoryField(scanner, "Price :- ")));
			
			stocks.add(stock);
			
			System.out.println();
			System.out.print("Press Y to continue to add stock info...");
			input = scanner.nextLine();
		}
		
		return stocks;
	}
	
	
	public static String getMandatoryField(Scanner scanner, String textMsg){
		System.out.print(textMsg);
		String input = scanner.nextLine();
		while(CommonUtils.isNullOrEmptyStr(input)){
			System.out.println("Invalid or Empty input. Field is required. ");
			System.out.print(textMsg);
			input = scanner.nextLine();
		}
		return input;
	}
	
	
	public static String getOptionalField(Scanner scanner, String textMsg,String defaultValue){
		System.out.print(textMsg);
		String input = scanner.nextLine();
		if(CommonUtils.isNullOrEmptyStr(input)){
			System.out.println("Empty input. Going to set default value : "+defaultValue);
			input = defaultValue;
		}
		return input;
	}
}
