package assignment.stock.services;

import java.util.List;

import assignment.stock.beans.Stock;
import assignment.stock.beans.Trade;
import assignment.stock.utils.CommonUtils;

public class StockCalculatorService {

	public static double calculateDividendYieldCommon(double marketPrice, double lastDividend) {

		return lastDividend / marketPrice;
	}

	public static double calculateDividendYieldPreferred(double marketPrice, double parValue, double fixedDividend) {

		return (fixedDividend * parValue) / marketPrice;
	}

	public static double calculatePeRatio(double marketPrice, double lastDividend) {

		return marketPrice / lastDividend;
	}

	public static double allShareIndex(List<Stock> stocks) {
		double allShareIndex = 0.0;
		for (Stock stock : stocks) {
			allShareIndex += stock.getPrice();
		}
		return Math.pow(allShareIndex, 1.0 / stocks.size());
	}

	public static double calculateGeometricMean(List<Stock> stocks) {

		double[] tradesPrices = new double[stocks.size()];

		double totalParValues = 0;

		int i = 0;
		for (Stock stock : stocks) {

			totalParValues += stock.getParValue();

			tradesPrices[i] = stock.getPrice();

			i++;
		}

		return calculateGeometricMean(tradesPrices) / totalParValues;
	}

	private static double calculateGeometricMean(double... tradesPrices) {

		if (CommonUtils.isNullOrEmptyArray(tradesPrices)) {
			return 0;
		}

		double geometricMean = tradesPrices[0];

		for (int i = 1; i < tradesPrices.length; i++) {

			geometricMean *= tradesPrices[i];
		}

		Integer n = new Integer(tradesPrices.length);

		return Math.pow(geometricMean, 1 / n.doubleValue());
	}

	public static double calculateStockPrice(List<Trade> trades) {
		if (trades == null) {

			return 0;
		}

		double[] tradesPrices = new double[trades.size()];
		int[] tradesQuantities = new int[trades.size()];

		int i = 0;
		for (Trade trade : trades) {

			tradesPrices[i] = trade.getPrice();
			tradesQuantities[i] = trade.getQuantity();

			i++;
		}

		return calculateStockPrice(tradesPrices, tradesQuantities);
	}

	private static double calculateStockPrice(double[] tradesPrices, int[] tradesQuantities) {

		if (CommonUtils.isNullOrEmptyArray(tradesPrices)) {

			return 0;
		}

		if (tradesQuantities == null) {

			throw new RuntimeException("trades quantities array is null !");
		}

		if (tradesPrices.length != tradesQuantities.length) {

			throw new RuntimeException("trades prices and quantities arrays are not the same length !");
		}

		double pricesPerQuantities = 0;
		double quantities = 0;

		for (int i = 1; i < tradesPrices.length; i++) {

			pricesPerQuantities += tradesPrices[i] * tradesQuantities[i];

			quantities += tradesQuantities[i];
		}
		
		 return pricesPerQuantities / quantities;
	}

}
