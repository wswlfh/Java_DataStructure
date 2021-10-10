package com.newcoder.huawei;

import java.util.*;
 class HJ3 {
     public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         while(sc.hasNext()){
             int[] array = new int[1000];
             int l = sc.nextInt();
             for(int i=0;i<l;i++){
                 int num = sc.nextInt();
                 array[num-1] = 100;
             }

             for(int i=0;i<array.length;i++){
                 if(array[i] == 100){
                     System.out.println(i+1);
                 }
             }
         }
     }
}
