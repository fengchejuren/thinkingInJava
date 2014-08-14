/**
 * 
 */
package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Enumeration;
import java.util.jar.JarFile;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**用Zip接口进行多文件的保存
 * @author Administrator
 *
 */
public class ZipCompress {

	public static void main(String[] args) throws Exception {
		String[] strings = {"opt.txt","bak_opt.txt","large.txt"};
		compressFiles(strings);
		
		decompressFiles(strings);
	}
	
	/**压缩多个文件
	 * 对于每一个要加入压缩档案的文件，都要调用putNextEntity(),并将其传递给ZipEntity()对象
	 * ZipEntity对象包含了一个很广泛的接口，允许你获取和设置Zip文件内该特定项上所有可利用的数据：名字，压缩的和未压缩的文件的大小，日期，CRC校验和，
	 * 额外字段数据、注释、压缩方法以及它是否是一个文件目录的入口等
	 * @param args
	 * @throws Exception
	 */
	public static void compressFiles(String[] args) throws  Exception{
		FileOutputStream f = new FileOutputStream("test.zip");
		CheckedOutputStream coStream = new CheckedOutputStream(f, new Adler32());
		ZipOutputStream zoStream = new ZipOutputStream(coStream);
		BufferedOutputStream out = new BufferedOutputStream(zoStream);
		zoStream.setComment("a zip test compress");
		for(String s:args){
			System.out.println("write file "+s);
			BufferedReader in = new BufferedReader(new FileReader(s));
			zoStream.putNextEntry(new ZipEntry(s));
			int c;
			while((c=in.read())!=-1)
				out.write(c);
			in.close();
			out.flush();
		}
		out.close();
		System.out.println("checkSum "+coStream.getChecksum().getValue());
		
	}
	
	// 读取多个文件的压缩包
	public static void decompressFiles(String[] args) throws Exception{
		System.out.println("----------------reading file");
		FileInputStream fi = new FileInputStream("test.zip");
		CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
		ZipInputStream in2 = new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(in2);
		ZipEntry ze;
		while((ze=in2.getNextEntry())!=null){
			System.out.println("-----------read file "+ze+"--------------");
			int x;
			while((x=bis.read())!=-1)
				System.out.write(x);
			System.out.println();
		}
		if(args.length==1)
			System.out.println("checkSum:"+csumi.getChecksum().getValue());
		bis.close();
		
		ZipFile zf = new ZipFile("test.zip");
		Enumeration enumeration = zf.entries();
		while(enumeration.hasMoreElements()){
			ZipEntry ze2 = (ZipEntry) enumeration.nextElement();
			System.out.println("file "+ze2);
			
		}
		
	}
	
	
	
	
}
