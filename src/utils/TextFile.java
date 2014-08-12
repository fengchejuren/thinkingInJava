/**
 * 
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Administrator
 *
 */
public class TextFile extends ArrayList<String> {
	
	public static String read(String fileName){
		StringBuilder builder = new StringBuilder();
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			String string;
			try {
				while((string=in.readLine())!=null){
					builder.append(string);
					builder.append("\n");
				}
			}finally{
				in.close();
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return builder.toString();
	}
	
	public static void write(String fileName,String text){
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally{
				out.close();
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public TextFile(String fileName,String splitter){
		super(Arrays.asList(read(fileName).split(splitter)));
		if(get(0).equals("")) remove(0);
		
	}
	
	public TextFile(String fileName){
		this(fileName, "\n");
	}
	
	public void write(String fileName){
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				for(String item:this){
					out.println(item);
				}
			} finally{
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	

	public static void main(String[] args) {
		String file = read("F:\\poems.txt");
		write("F:\\poems.java", file);
		TextFile textFile = new TextFile("F:\\poems.java");
		textFile.write("F:\\poems2.java");
		TreeSet<String> words = new TreeSet<String>(new TextFile("F:\\poems.txt","\\W+"));
		System.out.println(words.headSet("a"));
		
	}
	
}
