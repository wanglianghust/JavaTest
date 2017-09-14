package com.sort;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 10; i >= 0; i--) {
			list.add(i);
		}
		// System.out.println(list);
		System.out.println("快速排序QuickSort：" + QuickSort(list));
//		System.out.println("JAVA自带Collections.Sort排序：" + CollectionsSort(list));
//		System.out.println("冒泡排序bubbleSort：" + bubbleSort(list));
	}

	/**
	 * JAVA自带Collections.Sort排序
	 * 
	 * @param list
	 * @return
	 */
	public static String CollectionsSort(LinkedList<Integer> list) {
		long start = System.currentTimeMillis();
		Collections.sort(list);// Arrays.sort()使用的是"经过调优的快速排序法"
		// System.out.println("CollectionsSort后："+list);
		long end = System.currentTimeMillis();
		return (end - start) + "ms";
	}

	/**
	 * 冒泡 前后比较
	 * 
	 * @param list
	 * @return
	 */
	public static String bubbleSort(List<Integer> list) {
		Integer[] arr = (Integer[]) list.toArray(new Integer[list.size()]);
		long start = System.currentTimeMillis();
		Integer temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				temp = arr[j];
				if (arr[j] > arr[j + 1]) {
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		long end = System.currentTimeMillis();
		// System.out.println("bubbleSort后："+Arrays.asList(arr));
		return (end - start) + "ms";
	}
	
	
	
	/**
	 * 快速排序
	 * 
	 * @param list
	 * @return
	 */
	public static String QuickSort(LinkedList<Integer> list) {
		Integer[] arr = (Integer[]) list.toArray(new Integer[list.size()]);
		int[] intArray = new int[arr.length];
		for(int i=0; i < arr.length; i ++)
		{
		    intArray[i] = arr[i].intValue();
		}
		long start = System.currentTimeMillis();
		QuickSort.sort(intArray);
		// System.out.println("QuickSort后："+Arrays.asList(arr));
		long end = System.currentTimeMillis();
		return (end - start) + "ms";
	}



}
