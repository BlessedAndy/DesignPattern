package com.andy.designpattern.strategy;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Intent: 
 * Define a family of algorithms, encapsulate each one, and make them
 * interchangeable. Strategy lets the algorithm vary independently from clients
 * that use it. 
 * AKA: 
 * Policy 
 * Motivation:
 * Many algorithms exist for breaking a
 * stream of text into lines. Hard-wiring all such algorithms into the classes
 * that require them isn't desirable for several reasons: 
 * l Clients that need
 * linebreaking get more complex if they include the linebreaking code. That
 * makes clients bigger and harder to maintain, especially if they support
 * multiple linebreaking algorithms. 
 * l Different algorithms will be appropriate
 * at different times. We don't want to support multiple linebreaking algorithms
 * if we don't use them all. 
 * l It's difficult to add new algorithms and vary
 * existing ones when linebreaking is an integral part of a client. 
 * We can avoid
 * these problems by defining classes that encapsulate different linebreaking
 * algorithms. An algorithm that's encapsulated in this way is called a
 * strategy.
 * 
 * 1. 意图
定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。本模式使得算法可独
立于使用它的客户而变化。
2. 别名
政策（P o l i c y）
3. 动机
有许多算法可对一个正文流进行分行。将这些算法硬编进使用它们的类中是不可取的，
其原因如下:
• 需要换行功能的客户程序如果直接包含换行算法代码的话将会变得复杂，这使得客户程
序庞大并且难以维护, 尤其当其需要支持多种换行算法时问题会更加严重。
• 不同的时候需要不同的算法，我们不想支持我们并不使用的换行算法。
• 当换行功能是客户程序的一个难以分割的成分时,增加新的换行算法或改变现有算法将
十分困难。
我们可以定义一些类来封装不同的换行算法，从而避免这些问题。一个以这种方法封装
的算法称为一个策略( s t r a t e g y )，如下图所示。
 * 
 * @author Andy
 * @date Jan 29, 2014
 * @time 11:16:18 PM
 */

/*
 * 先把排序算法看一下再接着向下学。
 */
class DataSorter{
	public static void sort(int[] arg){
		for(int i=arg.length; i>0; i--){
			for(int j=0; j<i-1; j++){
				if(arg[j] > arg[j+1]){
					swap(arg, j , j+1);
				}
			}
		}
	}
	
	private static void swap(int[] arg, int x, int y) {
		int temp = arg[x];
		arg[x] = arg[y];
		arg[y] = temp;
	}

	public static void print(int[] arg){
		for(int i:arg){
			System.out.print("The element of i : "+i+".  ");
		}
	}
}

public class Test {
	public static void main(String[] args) {
	
		int[] a = {9,5,3,7,1};
		DataSorter.sort(a);
		DataSorter.print(a);
	}
}





















