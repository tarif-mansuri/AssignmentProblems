package com.tarif.day040.dsa.searching1.binarysearchonarray;

public class SearchForARange {
	public int[] searchRange(final int[] A, int B) {
        int[] ans = new int[2];
        ans[0] = serachLeftMostOccurrance(A, 0, A.length-1, B);
        ans[1] = serachRightMostOccurrance(A, 0, A.length-1, B);
        return ans;
    }
    public int serachLeftMostOccurrance(int[] A, int l, int h, int target){
        while(l<=h){
            int mid = l+(h-l)/2;
            if(A[mid] == target && (mid==0 || A[mid-1] != target)){
                return mid;
            }
            if(target<=A[mid]){
                h = mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
    public int serachRightMostOccurrance(int[] A, int l, int h, int target){
        while(l<=h){
            int mid = l+(h-l)/2;
            if(A[mid] == target && (mid==A.length-1 || A[mid+1] != target)){
                return mid;
            }
            if(target<A[mid]){
                h = mid-1;
            }else{
                l=mid+1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	int[] A = {1};
    	SearchForARange app = new SearchForARange();
    	app.searchRange(A, 1);
    }

}
