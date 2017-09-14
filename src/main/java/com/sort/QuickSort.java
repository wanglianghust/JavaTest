package com.sort;

import java.util.Arrays;

public class QuickSort {

	private static int mark = 0;
	 
	 /**
	  * 辅助交换方法
	  * 
	  * @param array
	  * @param a
	  * @param b
	  */
	 private static void swap(int[] array, int a, int b) {
	  if (a != b) {
	   int temp = array[a];
	   array[a] = array[b];
	   array[b] = temp;
	   // 找到符合的，对调
	   //System.out.println("对调" + array[a] + "与" + array[b] + ",得到");
	   //for (int i : array) {
	    //System.out.print(i + " ");
	   //}
	   //System.out.println();
	  }
	 }
	 
	 /**
	  * 新一轮分隔
	  * 
	  * @param array
	  * @param low
	  * @param high
	  * @return
	  */
	 private static int partition(int array[], int low, int high) {
	  int base = array[low];
	  mark++;
	  //System.out.println("正在进行第" + mark + "轮分隔，区域：" + low + "-" + high);
	  while (low < high) {
	   while (low < high && array[high] >= base) {
	    high--;
	    //System.out.println("从右往左找比" + base + "小的，指针变动：" + low + "-" + high);
	   }
	   swap(array, low, high);
	   while (low < high && array[low] <= base) {
	    low++;
	    //System.out.println("从左往右找比" + base + "大的，指针变动：" + low + "-" + high);
	   }
	   swap(array, low, high);
	  }
	  StringBuffer sbf = new StringBuffer();
	  for (int i : array) {
		  sbf.append(i+"").append(" ");
	  }
	  System.out.println("正在进行第" + mark + "轮分隔，区域："+sbf.toString());
	  return low;
	 }
	 
	 /**
	  * 对数组进行快速排序，递归调用
	  * 
	  * @param array
	  * @param low
	  * @param heigh
	  * @return
	  */
	 private static int[] quickSort(int[] array, int low, int heigh) {
	  if (low < heigh) {
	   int division = partition(array, low, heigh);
	   quickSort(array, low, division - 1);
	   quickSort(array, division + 1, heigh);
	  }
	  return array;
	 }
	 
	 /**
	  * 快排序
	  * 
	  * @param array
	  * @return
	  */
	 public static int[] sort(int[] array) {
	  return quickSort(array, 0, array.length - 1);
	 }
}
