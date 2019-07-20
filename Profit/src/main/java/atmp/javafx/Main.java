package atmp.javafx;

public class Main {

	public static void main(String[] args) {
		//запишіть суму вкладу
		int amountOfDeposit = 1000;
		//запишіть відсоткову ставку
		double p = 14.5;
		/*обчислення прибутку (переводимо число
		нарахування відсотків*/
		double profit = amountOfDeposit * p * 0.01;
		//податок на прибуток 15%
		double tax = profit * 0.15;
		//чистий прибуток
		double netProfit = profit - tax;
		System.out.println("прибуток: " + netProfit);
		double amountYear = amountOfDeposit + netProfit;
		System.out.println("сума на кінець року: " + amountYear);
	}

}
