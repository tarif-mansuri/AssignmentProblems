package com.tarif.day038.dsa.sorting1.countandmergesort;

//	Given an array of integers A, we call (i, j) an important reverse pair if i < j and A[i] > 2*A[j].
//	Return the number of important reverse pairs in the given array A.
//	
//	
//	
//	Problem Constraints
//	1 <= length of the array <= 105
//	
//	-2 * 109 <= A[i] <= 2 * 109
//	
//	
//	
//	Input Format
//	The only argument given is the integer array A.
//	
//	
//	
//	Output Format
//	Return the number of important reverse pairs in the given array A.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = [1, 3, 2, 3, 1]
//	Input 2:
//	
//	 A = [4, 1, 2]
//	
//	
//	Example Output
//	Output 1:
//	
//	 2
//	Output 2:
//	
//	 1
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 There are two pairs which are important reverse pair 
//	 i.e  (1, 4) => A[1] > 2 * A[4] => 3 > 2 * 1 => 3 > 2 and
//	      (3, 4) => A[3] > 2 * A[4] => 3 > 2 * 1 => 3 > 2.
//	Explanation 2:
//	
//	 There is only one pair 
//	 i.e (0, 1) => A[0] > 2 * A[1] => 4 > 2 * 1 => 4 > 1


public class ReversePair {
	private static int ans = 0;
    public int solve(int[] A) {
        ans=0;
        divide(A, 0, A.length-1);
        return ans;
    }

    public void divide(int[] A, int l, int h) {
		if(l>=h) {
			return;
		}
		int mid = (l+h)/2;
		divide(A, l, mid);
		divide(A, mid+1, h);
		int i = l;
		int j = mid+1;
		while(i<=mid && j<=h){
			long a = A[i];
			long b = A[j];
			if(a>2*b){
				ans +=mid-i+1;
				j++;
			}else{
				i++;
			}
		}
		merge(A, l, mid, h);	
	}
	private void merge(int[] A, int l, int mid,  int h) {
		int n1 = mid-l+1;
		int n2 = h-mid;
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];
		
		for(int i=0; i<n1; i++) {
			arr1[i] = A[l+i];
		}
		for(int i=0; i<n2; i++) {
			arr2[i] = A[mid+1+i];
		}
		int i=0;
		int j=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i]<=arr2[j]) {
				A[l++] = arr1[i++];
			}else {
				A[l++] = arr2[j++];
			}
		}
		while(i<arr1.length) {
			A[l++] = arr1[i++];
		}
		while(j<arr2.length) {
			A[l++] = arr2[j++];
		}
		
	}
	
	public static void main(String[] args) {
		ReversePair rp = new ReversePair();
		int[] A = {2000000000,2000000000,-2000000000};
		System.out.println(rp.solve(A));
	}

}
