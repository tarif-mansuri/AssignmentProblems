package com.tarif.day041.dsa.searching2.binarysearchproblems;

import java.util.ArrayList;
import java.util.List;

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
