package com.ibm.demo.test.demo.zijilianxi.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {
	// 源文件目录
	private String srcPath;
	// 目标文件目录
	private String destPath;
	// 分成多少块
	private int size;
	// 每块多大
	private long blockSize;
	// 每块的名称
	private List<String> blockPath;
	// 源文件名称
	private String fileName;
	// 源文件大小
	private long fileLength;

	public SplitFile() {

	}

	public SplitFile(String srcPath, String destPath, long blockSize) {
		this.srcPath = srcPath;
		this.destPath = destPath;
		this.blockSize = blockSize;
		blockPath = new ArrayList<String>();
		init();
	}

	public void init() {
		File src = new File(srcPath);
		if (null == srcPath || src == null || !src.exists()) {
			System.out.println("目录不存在或目录为空");
			return;
		}
		if (src.isDirectory()) {
			System.out.println("不能分割文件夹");
			return;
		}

		this.fileLength = src.length();
		this.size = (int) (fileLength * 1.0 / blockSize);

		this.fileName = src.getName();
		getSubFileName();
	}

	public void getSubFileName() {
		for (int i = 0; i < size; i++) {
			this.blockPath.add(destPath + "/" + this.fileName + ".parts" + i
					+ ".txt");
		}
	}

	public void splitFile() {
		long actualLength = 0L;
		for (int i = 0; i < size; i++) {
			if (i == (size - 1)) {
				actualLength = fileLength - blockSize * i;
			} else {
				actualLength = blockSize;
			}
			splitFileDetail(blockSize * i, i, actualLength);
		}
	}

	public void splitFileDetail(long begin, int idx, long actualLength) {
		RandomAccessFile r = null;
		OutputStream os = null;
		try {
			r = new RandomAccessFile(new File(srcPath), "r");
			os = new BufferedOutputStream(new FileOutputStream(new File(
					this.blockPath.get(idx))));
			r.seek(begin);
			int len = 0;
			byte[] flush = new byte[1024];
			while (-1 != (len = r.read(flush))) {
				if (actualLength - len >= 0) {
					os.write(flush, 0, len);
					actualLength -= len;
				} else {
					os.write(flush, 0, (int) actualLength);
					break;
				}
			}
			os.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			TestCloseable.close(os, r);
		}
	}

	public void hebinFile(String path) {
		OutputStream os=null;
		try {
			os= new BufferedOutputStream(new FileOutputStream(
					new File(path), true));
			for(String p:this.blockPath){
				InputStream is=new BufferedInputStream(new FileInputStream(new File(p)));
				int len=0;
				byte[] flush=new byte[1024];
				while(-1!=(len=is.read(flush))){
					os.write(flush, 0, len);
				}
				os.flush();
				TestCloseable.close(is);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			TestCloseable.close(os);
		}
	}
	
	public void mergeFile(String path) {
		OutputStream os=null;
		SequenceInputStream sis=null;
		Vector<InputStream> v=new Vector<InputStream>();
		try {
			os= new BufferedOutputStream(new FileOutputStream(
					new File(path), true));
			for(String p:this.blockPath){
				v.add(new BufferedInputStream(new FileInputStream(new File(p))));
			}
			sis=new SequenceInputStream(v.elements());
			int len=0;
			byte[] flush=new byte[1024];
			while(-1!=(len=sis.read(flush))){
				os.write(flush, 0, len);
			}
			os.flush();
			TestCloseable.close(sis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			TestCloseable.close(os);
		}
	}

	public static void main(String[] args) {
		SplitFile sf = new SplitFile("C:/aa/bb/cc/1.txt", "C:/aa/bb/cc", 50);
//		sf.splitFile();
//		sf.hebinFile("C:/aa/bb/cc/8.txt");
		sf.mergeFile("C:/aa/bb/cc/9.txt");
	}
}
