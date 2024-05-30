package com.tarif.day038.dsa.sorting1.countandmergesort;

public class InversionCountInArray {
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
                ans =(ans%1000000007+(n1-i)%1000000007)%1000000007;
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
		int[] A = {2,4,6,1,8,9};
		ans = 0;
		InversionCountInArray inCountArray = new InversionCountInArray();
		inCountArray.divide(A, 0, A.length-1);
		System.out.println(ans);
		for(int i=0; i<A.length; i++) {
			System.out.print(A[i]+" ");
		}
	}

}
