/**
 * 
 */
package utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import utils.Directory.TreeInfo;

/**
 * @author Administrator
 *
 */
public class BinaryFile {

	public static byte[] read(File bFile) throws IOException{
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
		byte[] data;
		try {
			data = new byte[bf.available()];
			bf.read(data);
			return data;
		} finally{
			bf.close();
		}
	}
	
	public static byte[] read(String fileName) throws Exception{
		return read(new File(fileName).getAbsoluteFile());
	}
	
	public static void main(String[] args) throws Exception {
		TreeInfo treeInfo = Directory.walk(new File("F:\\workspace\\bin\\utils"));
		List<File> files = treeInfo.files;
		for(File file:files){
			System.out.println(BinaryFile.read(file));
		}
		
	}
	
	
}
