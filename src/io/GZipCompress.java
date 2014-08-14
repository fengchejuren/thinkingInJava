/**
 * 
 */
package io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 用GZip接口进行简单的压缩
 * 压缩的使用非常简单，直接将输出流封装成GZipOutputStream或者ZipOutputStream
 * 将输入流封装成GZipInputStream或者ZipInputStream
 * @author Administrator
 * 
 */
public class GZipCompress {

	public static void main(String[] args) throws Exception {

		String file[] = new String[] { "large.txt" };
		compressWithGZip(file);
	}

	public static void compressWithGZip(String[] args) throws IOException {
		if (args.length == 0) {
			System.out
					.println("Usage:\nGZip compress file\n"
							+ "\t Use GZip compression to compress the file to test.gz");
			System.exit(1);
		}
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream(args[0] + ".gz")));
		System.out.println("Write file:");
		int c;
		while ((c = in.read()) != -1)
			out.write(c);
		in.close();
		out.close();
		System.out.println("Reading file");
		BufferedReader into = new BufferedReader(new InputStreamReader(
				new GZIPInputStream(new FileInputStream(args[0] + ".gz"))));
		String s;
		while((s=into.readLine())!=null)
			System.out.print(s);
		into.close();
	}

}
