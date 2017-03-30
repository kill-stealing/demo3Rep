package com.ibm.demo.test.io.pattern;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SplitFile {

	private String filePathString;
	private String destBlockPath;
	private long blockSize;
	private long length;
	private int size;
	private List<String> blockPath;
	private String fileName;

	public SplitFile() {
		blockPath = new ArrayList<String>();
	}

	public SplitFile(String filePathString, String destBlockPath) {
		this(filePathString, 1024, destBlockPath);
	}

	public SplitFile(String filePathString, long blockSize, String destBlockPath) {
		this();
		this.filePathString = filePathString;
		this.blockSize = blockSize;
		this.destBlockPath = destBlockPath;
		init();
	}

	/**
	 * 初始化操作 计算 快数、确定文件名
	 */
	public void init() {
		File src = null;
		if (null == filePathString
				||!((src=new File(filePathString)).exists())) {
			return;
		}
		if (src.isDirectory()) {
			return;
		}
		this.fileName = src.getName();

		// 计算快数 实际大小 与每块大小
		this.length = src.length();
		if (this.blockSize > length) {
			this.blockSize = length;
		} else {

		}
		// 确定快数 这里乘以1.0是为了两个整数相除可能等于0，乘以1.0就会得到小数
		size = (int) (Math.ceil(length * 1.0 / this.blockSize));
		initPathName();
	}

	private void initPathName() {
		for (int i = 0; i < size; i++) {
			this.blockPath.add(destBlockPath + "/" + this.fileName + ".part"
					+ i + ".txt");
		}
	}

	/**
	 * 文件分割 1.起始位置 2。实际大小
	 */
	public void split(String destPath) {
		long beginPos = 0;
		long actualBlockSize = blockSize;

		// 计算所有
		for (int i = 0; i < size; i++) {
			if (i == size - 1) {
				actualBlockSize = this.length - beginPos;
			}
			splitDetail(i, beginPos, actualBlockSize);
			beginPos = beginPos + actualBlockSize;
		}
	}

	private void splitDetail(int idx, long beginPos, long actualBlockSize) {
		RandomAccessFile rd = null;
		BufferedOutputStream out = null;
		try {
			rd = new RandomAccessFile(new File(filePathString), "r");
			out = new BufferedOutputStream(new FileOutputStream(new File(
					this.blockPath.get(idx))));
			rd.seek(beginPos);
			byte[] flush = new byte[1024];
			int len = 0;
			while (-1 != (len = rd.read(flush))) {
				if (actualBlockSize - len >= 0) {
					out.write(flush, 0, len);
					actualBlockSize -= len;
				} else {
					out.write(flush, 0, (int) actualBlockSize);
					break;
				}
			}
			out.flush();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
				rd.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void mergeFileBySequence(String destPath) {
		// 创建源
		File dest = new File(destPath);
		//
		BufferedOutputStream out = null;
		Vector<InputStream> vi = new Vector<InputStream>();

		SequenceInputStream sq = null;
		try {
			for (int i = 0; i < this.blockPath.size(); i++) {
				vi.add(new FileInputStream(new File(
						this.blockPath.get(i))));
			}
			sq=new SequenceInputStream(vi.elements());
			out = new BufferedOutputStream(new FileOutputStream(dest, true));
			byte[] flush = new byte[1024];
			int len = 0;
			while (-1 != (len = sq.read(flush))) {
				out.write(flush, 0, len);
			}
			out.flush();
			if (null != sq) {
				sq.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != out) {
					out.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void mergeFile(String destPath) {
		// 创建源
		File dest = new File(destPath);
		//
		BufferedInputStream bis = null;
		BufferedOutputStream out = null;
		try {
			for (int i = 0; i < this.blockPath.size(); i++) {
				bis = new BufferedInputStream(new FileInputStream(new File(
						this.blockPath.get(i))));
				out = new BufferedOutputStream(new FileOutputStream(dest, true));
				byte[] flush = new byte[1024];
				int len = 0;
				while (-1 != (len = bis.read(flush))) {
					out.write(flush, 0, len);
				}
				out.flush();
				bis.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != out) {
					out.close();
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		SplitFile file = new SplitFile("C:/aa/bb/cc/1.txt", 50, "C:/aa/bb/cc");
		System.out.println(file.size);
		 file.split("C:/aa/bb/cc/");
//		file.mergeFile("C:/aa/bb/cc/merge.txt");
		file.mergeFileBySequence("C:/aa/bb/cc/mergeQ.txt");
	}
}
