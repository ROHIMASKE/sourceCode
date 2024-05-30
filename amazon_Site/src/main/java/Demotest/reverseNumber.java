package Demotest;

import java.util.Scanner;

public class reverseNumber {
	public static void main(String args[]) {
		int rev=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter h number here:");
		int num = sc.nextInt();
		while(num!=0)
		{
			rev=rev*10+num%10;//0+5
			num=num/10;//234
		}
		System.out.println(rev);
	
	}
}
