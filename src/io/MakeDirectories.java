package io;

import java.io.File;

public class MakeDirectories {

	private static void usage(){
		System.err.println("Usage: makeDirectory path1 ...\n" +
				"Create each path ...\n"+
				"Usage: makeDirectory -d path1 ...\n" +
				"Deletes each path ...\n"+
				"Usage: makeDirectory -r path1 path2...\n" +
				"Renames from path1 to path2\n");
		System.exit(1);
		
	}
	
	private static void fileData(File file){
		System.out.println("AbsolutePath:"+file.getAbsolutePath()
				+"\n CanRead:"+file.canRead()+"\n CanWrite:"+file.canWrite()
				+"\n Name:"+file.getName()+"\n Parent:"+file.getParent()
				+"\n LastModify:"+file.lastModified());
		if(file.isFile())
			System.out.println(file.getName()+" is File");
		else if(file.isDirectory())
			System.out.println(file.getName()+" is Directory!");
		
	}
	
	public static void main(String[] args) {
		if(args.length==0)
			usage();
		else if(args[0].equals("-r")){
			if(args.length!=3)
				usage();
			File old = new File(args[1]);
			File rname = new File(args[2]);
			old.renameTo(rname);
			fileData(old);
			fileData(rname);
			return ;
		}
		int count =0;
		boolean del = false;
		if(args[0].equals("-d")){
			count++;
			del = true;
		}
		count --;
		while(++count<args.length){
			File f = new File(args[count]);
			if(f.exists()){
				System.out.println(f+" exits");
				if(del){
					System.out.println(f+"  deleteing...");
					f.delete();
				}
			}else {
				if(!del){
					f.mkdirs();
					System.out.println("Create "+f);
				}
			}
			fileData(f);	
		}
		
	}
	
	
	
	
	
	
	
	
	
	
}
