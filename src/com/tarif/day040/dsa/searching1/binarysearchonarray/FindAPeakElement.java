package com.tarif.day040.dsa.searching1.binarysearchonarray;

public class FindAPeakElement {
	public int solve(int[] A) {
        int l=0;
        int h = A.length-1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if((mid == 0 || A[mid-1]<= A[mid]) && (mid == A.length-1 || A[mid]>=A[mid+1])){
                return A[mid];
            }
            if(A[mid+1]>=A[mid]){
                l=mid+1;
            }else{
                h = mid-1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] A = {1,1000000000,1000000000};
		FindAPeakElement fpe = new FindAPeakElement();
		System.out.println(fpe.solve(A));
	}

}
