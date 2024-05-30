package Demotest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Vector;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.graphbuilder.struc.LinkedList;

public class hashsetTo_removeDuplicates {
	public static void main(String args[]) {
	ArrayList<String> array= new ArrayList<String>();
		array.add("rohi");
		array.add("rohit");
		array.add("mahi");
		array.add("ruhi");
		array.add(3, "kam");
		array.add(null);
		array.add(null);
		array.add(null);
		array.add("rohi");
		
	LinkedHashSet<String> hash= new LinkedHashSet<String>();
	for(String str:array)
		
	{
	hash.add(str);
	}
	System.out.println("Duplicate removed"+hash);
}}