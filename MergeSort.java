package mergesort;

public class MergeSort {

	private int[]	numbers;
	
	//ctor
	public MergeSort(int[] numbers) {
		this.numbers = numbers;
	}
	
	//sorts the array using merge sort
	public int[] sort() {
		mergeSortRecurse(numbers);
		return numbers;
	}
	
	//recursive method that sorts the array
	private void mergeSortRecurse(int [] vals) {
		if(vals.length <= 1) {
			return;
		}
		
		int[] left = new int[vals.length/2]; //splitting the array, first half 
		int[] right = new int[vals.length - vals.length/2]; //second half
		
		int k = 0; //counter
		//populating left and right array
		for(int i = 0; i < left.length; i++) {
			left[i] = vals[i];
			k++;
		}
		for(int j = 0; j < right.length; j++) {
			right[j] = vals[k];
			k++;
		}
		
		//calling itself on the 2 new arrays
		mergeSortRecurse(left);
		mergeSortRecurse(right);
		
		//sort & put the arrays back into one
		merge(vals, left, right);
	}
	
	private void merge(int[] v, int[] l, int[] r) {
		int x = 0; 
		int y = 0; 
		int z = 0; 
		
		while(l.length > x && r.length > y) {
			if(l[x] >= r[y]) { //check to see which one is bigger
				v[z] = l[x]; //place the bigger one first in v
				x++;
				z++;
				
			} 
			
			else { //check to see which one is bigger
				v[z] = r[y]; //place the bigger one first in v
				y++; 
				z++; 
			}
		}
		
		//populating the rest in the order cause they are already sorted
		while(x < l.length) {
			v[z] = l[x]; 
			z++;
			x++; 
		}
		
		while(y < r.length) {
			v[z] = r[y];
			z++; 
			y++; 
		}
	}	
		
	
	public static void main(String[] args) {
		int[] first1 = {5,4,8,1,3}; //should print : 8 5 4 3 1 
		MergeSort a = new MergeSort(first1);
		int [] first = a.sort();
		for(int i: first) {
			System.out.print(i + " ");
		}
		System.out.println(); 
		int[] second2 = {3, 6, 9, 8, 4}; //should print : 9 8 6 4 3
		MergeSort b = new MergeSort(second2);
		int [] second = b.sort();
		for(int i: second) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] third3 = {-1, -5, -10, 0}; //should print : 0 -1 -5 -10
		MergeSort c = new MergeSort(third3);
		int [] third = c.sort();
		for(int i: third) {
			System.out.print(i + " ");
		}
		
	}
}
