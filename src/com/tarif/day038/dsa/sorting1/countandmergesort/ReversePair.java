package com.tarif.day038.dsa.sorting1.countandmergesort;

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
