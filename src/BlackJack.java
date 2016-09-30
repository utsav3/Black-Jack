import java.util.Scanner;


public class BlackJack<T> {
	public static void main(String[] args){
		Integer[] Array={2,2,2,2,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,7,7,7,7,8,8,8,8,9,9,9,9,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,11,11,11,11};
		Scanner scan=new Scanner(System.in);


		Cards BlackJ=new Cards(Array);
		Bags  CardList=new Bags(Array);
		BlackJ.Display();
		BlackJ.shuffle();
		//BlackJ.ToString();
		System.out.println();
		BlackJ.deal();
		System.out.println(" ");BlackJ.DisplayDealerCard();
		System.out.println(" ");BlackJ.DisplayPlayerCard();
		System.out.println("\nPlayer sum:"+BlackJ.playerCalculations());
		BlackJ.dealerCalculations();

		do{
			System.out.println("Hit or Stay?");
			String Choice=scan.nextLine();
			if(Choice.equalsIgnoreCase("hit")){
				BlackJ.Hit();
				System.out.println(" ");BlackJ.DisplayPlayerCard();
				System.out.println("\nPlayer sum:"+BlackJ.playerCalculations());
				//BlackJ.playerCalculations();
				BlackJ.updateResult();

			}
			else {

				BlackJ.Stay();
				System.out.println("Dealer shows second card");
				BlackJ.dealerCalculations();
				System.out.println(" ");BlackJ.DisplayDealerCard();
				BlackJ.updateResult();
			}

			System.out.println(Cards.winner);
		}while(!Cards.winner);


	}
}
