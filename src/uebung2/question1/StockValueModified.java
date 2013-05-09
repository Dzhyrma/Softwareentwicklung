package uebung2.question1;

import io.Input;

/**
 * @author Andrii Dzhyrma
 */
public class StockValueModified {

	/**
	 * Request constant string for the stock price
	 */
	private static final String REQUEST_STOCK_PRICE = "Enter stock price: ˆ ";
	/**
	 * Request constant string for the share number
	 */
	private static final String REQUEST_SHARE_NUMBER = "Enter number of shares: ";
	/**
	 * Request constant string for the commission rate
	 */
	private static final String REQUEST_COMMISSION_RATE = "Enter commission rate (as a percentage): ";

	/**
	 * Request constant error string for the stock price
	 */
	private static final String REQUEST_STOCK_PRICE_ERROR = "Not a valid stock price, please re-enter.";
	/**
	 * Request constant error string for the number of shares
	 */
	private static final String REQUEST_SHARE_NUMBER_ERROR = "Not a valid entry for number of shares, please re-enter.";
	/**
	 * Request constant error string for the commission rate
	 */
	private static final String REQUEST_COMMISSION_RATE_ERROR = "Not a valid commission rate, please re-enter.";

	/**
	 * Output format string for the summary
	 */
	private static final String SUMMARY_FORMAT_STRING = "%nSUMMARY%nStock price: ˆ %.2f%nNumber of shares: %d%nCommission rate: %.2f%n";
	/**
	 * Output format string for the result
	 */
	private static final String RESULT_FORMAT_STRING = "%nValue of share: ˆ %.2f%nCommission: ˆ %.2f%nNet proceeds: ˆ %.2f%n";

	/**
	 * Stock price
	 */
	private static float stockPrice;
	/**
	 * Commission rate
	 */
	private static float commissionRate;
	/**
	 * Value of share
	 */
	private static float shareValue;
	/**
	 * Commission
	 */
	private static float commission;
	/**
	 * Net proceeds
	 */
	private static float netProceeds;
	/**
	 * Number of shares
	 */
	private static int shareNumber;

	/**
	 * @param args
	 *            - no arguments will evaluate
	 */
	public static void main(String[] args) {
		// Reading all the necessary information
		System.out.print(REQUEST_STOCK_PRICE);
		stockPrice = Input.readFloat();
		while (stockPrice < 0) {
			System.out.println(REQUEST_STOCK_PRICE_ERROR);
			System.out.print(REQUEST_STOCK_PRICE);
			stockPrice = Input.readFloat();
		}
		System.out.print(REQUEST_SHARE_NUMBER);
		shareNumber = Input.readInt();
		while (shareNumber < 0) {
			System.out.println(REQUEST_SHARE_NUMBER_ERROR);
			System.out.print(REQUEST_SHARE_NUMBER);
			shareNumber = Input.readInt();
		}
		System.out.print(REQUEST_COMMISSION_RATE);
		commissionRate = Input.readFloat();
		while (commissionRate < 0 || commissionRate > 100) {
			System.out.println(REQUEST_COMMISSION_RATE_ERROR);
			System.out.print(REQUEST_COMMISSION_RATE);
			commissionRate = Input.readFloat();
		}

		// Printing summary information
		System.out.printf(SUMMARY_FORMAT_STRING, stockPrice, shareNumber, commissionRate);

		// Calculating all the result values
		shareValue = stockPrice * shareNumber;
		commission = shareValue * commissionRate / 100;
		netProceeds = shareValue - commission;

		// Printing the result
		System.out.printf(RESULT_FORMAT_STRING, shareValue, commission, netProceeds);
	}
}
