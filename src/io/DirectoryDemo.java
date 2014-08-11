package io;

import java.io.File;

import utils.Directory;
import utils.PPrint;

/**
 * @author Administrator
 *
 */
public class DirectoryDemo {

	public static void main(String[] args) {
		PPrint.pprint(Directory.walk(".\\thinkingInJava\\src\\utils").files);
		System.out.println("----------------------------------------------");
		for(File file : Directory.local(".", "Ge*\\.java"))
			System.out.println(file.getName());
		for(File file: Directory.walk("*Data.java"))
			System.out.println(file.getName());
	}
	
	
	
	
	
	
	
	
	
}
