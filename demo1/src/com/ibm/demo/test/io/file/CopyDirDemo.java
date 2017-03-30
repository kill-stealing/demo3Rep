package com.ibm.demo.test.io.file;

import java.io.File;
import java.io.IOException;

/*
 * 文件夹的拷贝
 * 1.文件 直接复制 copyFile
 * 2.文件夹 创建 mkdirs
 * 3.递归查找子孙级
 */
public class CopyDirDemo {
	public static void main(String[] args) {
		String srcPath="C:/aa1/aa";
		String destPath="C:/aa1/aa/bb";
		
		File src=new File(srcPath);
		File dest=new File(destPath);
		copyDir(src,dest);
		
	}
	
	public static void copyDir(File src,File dest){
		if(src.isDirectory()){//文件夹
			dest=new File(dest,src.getName());
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				System.out.println("父目录不能拷贝到子目录中");
			}
		}
		copyDirDetail(src,dest);
	}
	
	public static void copyDirDetail(File src,File dest){
		if(src.isFile()){
			try {
				FileUtil.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(src.isDirectory()){
			//确保目标文件夹存在
			dest.mkdirs();
			for(File sub:src.listFiles()){
				copyDirDetail(sub,new File(dest,sub.getName()));
			}
		}
	}
}
