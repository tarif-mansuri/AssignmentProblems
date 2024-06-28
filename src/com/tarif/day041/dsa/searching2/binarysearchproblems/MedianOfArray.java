package com.tarif.day041.dsa.searching2.binarysearchproblems;

import java.util.ArrayList;
import java.util.List;


//	Problem Description
//	There are two sorted arrays A and B of sizes N and M respectively.
//	
//	Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
//	
//	NOTE:
//	
//	The overall run time complexity should be O(log(m+n)).
//	IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
//	
//	
//	Problem Constraints
//	1 <= N + M <= 2*106
//	
//	
//	
//	Input Format
//	The first argument is an integer array A of size N.
//	The second argument is an integer array B of size M.
//	
//	
//	
//	Output Format
//	Return a decimal value denoting the median of two sorted arrays.
//	
//	
//	
//	Example Input
//	Input 1:
//	
//	 A = [1, 4, 5]
//	 B = [2, 3]
//	Input 2:
//	
//	 A = [1, 2, 3]
//	 B = [4]
//	
//	
//	Example Output
//	Output 1:
//	
//	 3.0
//	Output 2:
//	
//	 2.5
//	
//	
//	Example Explanation
//	Explanation 1:
//	
//	 The median of both the sorted arrays will be 3.0.
//	Explanation 2:
//	
//	 The median of both the sorted arrays will be (2+3)/2 = 2.5.


public class MedianOfArray {
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if(a.size()>b.size()){
            return findMedianSortedArrays(b, a);
        }

        int m = a.size();
        int n = b.size();
        int l=0; 
        int h = m;
        while(l<=h){
            int mid1 = l + (h-l)/2;
            int mid2 = (n+m+1)/2 -mid1;
            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;
            
            if(mid1>0){
                l1 = a.get(mid1-1);
            }
            if(mid1<a.size()){
                r1 = a.get(mid1);
            }

            if(mid2>0){
                l2 = b.get(mid2-1);
            }
            if(mid2<b.size()){
                r2 = b.get(mid2);
            }
            if(l1<=r2 && l2<=r1){
                if((m+n)%2 == 1){
                    return (double)Math.max(l1, l2);
                }else{
                    return (double)((double)Math.max(l1, l2) + (double)Math.min(r1, r2))/2.0;
                }
            }else if(l1>r2){
                h = mid1-1;
            }else{
                l = mid1+1;
            }
            
        }
        return 0;
	}
	
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		b.add(20);
		a.add(21);
		MedianOfArray moa = new MedianOfArray();
		System.out.println(moa.findMedianSortedArrays(a, b));
	}

}
