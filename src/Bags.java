import java.util.Arrays;
import java.util.Random;


public class Bags<T> {								//generic type T
	protected T[] anArray;							//Creates a generic array called anArray
	protected int ArraySize;

	public Bags(T[] anArray){
		this.anArray=(T[]) new Object[52];
		this.anArray=anArray;						//Stores the elements into the bag.

	}

	//public <T> T[] getArray(int size,T[] Array) {
	//T[] anArray = (T[])new Object[size];		//Creates an array object
	//anArray=Array;
	//return anArray;
	//}
	public void showArray(){
		for(T element:anArray){
			System.out.print(element);
		}
	}
	public  int getCurrentSize(){
		return (int) (this.anArray.length);
	}
	public int getArraySize(){
		ArraySize=anArray.length;
		for(int i=0;i<anArray.length;i++){
			if(anArray[i]==null)
				ArraySize--;
		}
		return ArraySize;
	}
	public boolean isFull(){
		boolean full=true;
		if(full){
			for(int i=0;i<anArray.length;i++){
				if(anArray[i]==null){
					full=false;
				}
			}
		}
		return full;
	}

	public boolean isEmpty(){
		boolean empty=false;
		for(int i=0;i<anArray.length;i++){
			if(anArray[i]!=null)
				empty=false;
			else 
				empty=true;
		}
		return empty;
	}
	public boolean add(T item) {
		boolean add=true;
		ArraySize=10;
		System.out.println(ArraySize);
		if(ArraySize==anArray.length){
			resize();
			add=false;
		}
		anArray[ArraySize++]=item;
		return add;
	}
	public void resize(){
		int temp=anArray.length*2;
		T[] tempArray=(T[]) new Object[temp];
		for(int i=0;i<anArray.length;i++){
			tempArray[i]=anArray[i];
		}

		anArray=tempArray;



	}

	public boolean remove(T item){
		int index=0;
		boolean found=false;

		if(!found){
			for(index=0;index<anArray.length;index++){
				if(anArray[index]==item){
					anArray[index]=null;
					found=true;
					index++;
				}
			}	
		}
		if(found){
			while(index<anArray.length){
				anArray[index--]=anArray[index];
				index++;
			}
		}
		System.out.println();
		for(T element: anArray){
			System.out.print(element);			
		}
		return found;
	}

	public void clear(){
		Arrays.fill(anArray,null);
		//alternate
		/*
		 * for(int i-0;i<=anArray.length;i++){
		 * anArray[i]=null;
		 * }
		 */


	}

	public boolean contains(T item){
		int index=0;
		boolean found=false;

		if(!found){
			for(index=0;index<anArray.length;index++){
				if(anArray[index]==item){
					found=true;
					index++;
				}
			}
		}
		return found;
	}

	public T grab(){
		Random rdn=new Random();
		int item=rdn.nextInt(anArray.length);

		T element= anArray[item];
		return element;
	}

	public int getFrequency(T item){
		boolean found=false;
		int index=0;
		int frequency=1;
		if(index<=anArray.length){
			if(anArray[index]==item){
				found=true;
				index++;
				frequency++;
			}
		}
		return frequency;
	}

	/*public <T> int getSize(){
		int currentSize=anArray.length;
		return currentSize;1
	}*/

	public String ToString(){
		return "The size of the array: "+ getCurrentSize()+"\nThe Array is full:"+ isFull()+"\nThe Bag is empty:"+isEmpty();

	}
}

