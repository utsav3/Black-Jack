import java.util.Collections;
import java.util.Random;


public class Cards<T>{
	T[] Cards=(T[]) new Object[52];
	T[] Player=(T[]) new Object[52];
	T[] Dealer=(T[]) new Object[52];
	protected int playerSum, dealerSum;
	public static int numOfcards;
	public static boolean winner;
	public static boolean loop;
	protected int dealerShow;

	public Cards(T[] Array){
		Cards=Array; 
		playerSum=0;
		dealerSum=0;
		numOfcards=0;
		dealerShow=0;
		winner=false;
		loop=false;
	}
	public void Display(){
		for(T element:Cards){
			System.out.print(element);
		}
		System.out.println();
	}
	public T[] shuffle(){
		int index;
		T temp;
		Random rdn = new Random();
		for (int i =0; i < Cards.length; i++)
		{
			index = rdn.nextInt(Cards.length);
			temp = Cards[i];
			Cards[i] = Cards[index];
			Cards[index] = temp;
		}
		for(T element:Cards){
			System.out.print(element);
		}
		return Cards;
	}
	public int deal(){
		boolean isFull=false;

		Bags CardD=new Bags(Cards);

		Random rdn=new Random();
		int deal = rdn.nextInt(Cards.length);
		int deal2=rdn.nextInt(Cards.length);
		for(int i=0;i<2;i++){
			Player[i]=(T) CardD.grab();
			Dealer[i]=(T) CardD.grab();
			numOfcards+=i;	
		}
		return numOfcards;
	}

	public void DisplayPlayerCard(){
		for(int i=0;i<=numOfcards;i++){
			System.out.print("Player "+Player[i]);
		}
	}
	public void DisplayDealerCard(){

		dealerShow+=1;
		for(int i=0;i<dealerShow;i++){
			System.out.print("Dealer "+Dealer[i]);
		}		
	}

	public int playerCalculations(){
		playerSum=0;
		for(int i=0;i<=numOfcards;i++){
			playerSum+=((int)Player[i]);	
		}
		return playerSum;

	}
	public int dealerCalculations(){
		dealerSum=0;
		for(int i=0;i<=numOfcards;i++){
			dealerSum+=((int)Dealer[i]);	
		}
		return dealerSum;

	}
	public T[] Hit(){
		Random rdn=new Random();
		int random=rdn.nextInt(52);
		numOfcards+=1;
		Player[numOfcards]=Cards[random];
		return Player;


	}

	public T[] Stay(){
		Random rdn=new Random();
		int random=rdn.nextInt(52);
		numOfcards+=1;
		Dealer[numOfcards]=Cards[random];
		return Dealer;
	}

	public void updateResult(){
		winner=false;
		System.out.println("PS: " + playerSum + " DS: " + dealerSum);//Error in dealerSum.. fix that
		while(!winner){
			if(playerSum==21){
				System.out.println("You win with 21");
				winner=true;
			}
			else if(playerSum>21){
				System.out.println("You lose with"+playerSum);
				winner=true;
			}
			else if(dealerSum==21){
				System.out.println("Dealer wins"+dealerSum);
				winner=true;
			}
			else if(dealerSum>21){ 
				System.out.println("Dealer lost:"+dealerSum);
				winner=true;
			}
			else break;


		}
	}

	public String ToString (){
		//return "Player's Card:"+ DisplayPlayerCard()+"Dealer's Card:"+DisplayDealerCard();
		//return "Player Total:"+"playerCalculations()"+"\ndealerTotal:"+"dealerCalculations()";
		return null;
	}

}
