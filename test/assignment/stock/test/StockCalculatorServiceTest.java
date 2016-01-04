package assignment.stock.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import assignment.stock.beans.Stock;
import assignment.stock.beans.Trade;
import assignment.stock.services.StockCalculatorService;
import assignment.stock.utils.Constants;

public class StockCalculatorServiceTest {

	List<Stock> stocks = new ArrayList<Stock>();
	List<Trade> trade = new ArrayList<Trade>();
	Stock stock = null;


	Date date = new Date();

	@Before
	public void setup() throws Exception {
		Stock tea = new Stock("TEA", Constants.STOCK_TYPE_COMMON, 0, 0, 100, 110);
		Stock pop = new Stock("POP", Constants.STOCK_TYPE_COMMON, 8, 0, 100, 120);
		Stock ale = new Stock("ALE", Constants.STOCK_TYPE_COMMON, 23, 0, 60, 55);
		Stock gin = new Stock("GIN", Constants.STOCK_TYPE_PREFERRED, 8, 2, 100, 100);
		Stock joe = new Stock("JOE", Constants.STOCK_TYPE_COMMON, 13, 0, 250, 216.12);

		this.stocks.add(tea);
		this.stocks.add(pop);
		this.stocks.add(ale);
		this.stocks.add(gin);
		this.stocks.add(joe);

		Trade first = new Trade(tea, date, "C", 10, 200);
		Trade second = new Trade(pop, date, "C", 30, 300);
		Trade third = new Trade(ale, date, "P", 40, 100);
		Trade fourth = new Trade(gin, date, "P", 50, 200);
		Trade fifth = new Trade(joe, date, "C", 10, 200);

		this.trade.add(first);
		this.trade.add(second);
		this.trade.add(third);
		this.trade.add(fourth);
		this.trade.add(fifth);
				
	}

	@Test
	public void calculateDividentYieldComman() {
		double result = StockCalculatorService.calculateDividendYieldCommon(40, 80);
		assertEquals(0, Double.compare(result, 2));
	}

	@Test
	public void calculateDividendYieldPreferredTest() {
		double result = StockCalculatorService.calculateDividendYieldPreferred(50, 2, 70);
		assertEquals(0, Double.compare(result, 2.8));
	}

	@Test
	public void calculatePERatioTest() {
		double result = StockCalculatorService.calculatePeRatio(50, 8);
		assertEquals(0, Double.compare(result, 6.25));
	}

	@Test
	public void allShareIndexTest() {
		double allShareIndex = StockCalculatorService.allShareIndex(stocks);
		assertEquals(0, Double.compare(allShareIndex, 3.5957727391032535));
	}

	@Test
	public void calculateGeometricMeanByStocksTest() {
		double geometricMeanByStocks = StockCalculatorService.calculateGeometricMean(stocks);
		assertEquals(0, Double.compare(geometricMeanByStocks, 0.17938927757244394));
	}

	@Test
	public void calculateStockPriceTest() {
		double result = StockCalculatorService.calculateStockPrice(trade);
		assertEquals(0, Double.compare(result, 192.30769230769232));
	}

}
