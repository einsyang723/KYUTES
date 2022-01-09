package AB;

import java.io.*;
import java.util.*;


class Function {
	
	ArrayList<student_information> arry = new ArrayList<student_information>();

	public Function() 
	{
		this.readfile();
	}

	
	public int find(String str) {
		for (int i = 0; i < arry.size(); i++)
			if (arry.get(i).getStuID().equals(str))
				return i;
		return -1;
	}

	
	public void update(student_information stu) {
		int flag = find(stu.getStuID());
	}

	
	public boolean readfile() {
		String t = null;
		try {
			FileReader f1 = new FileReader("D:\\student.txt");
			BufferedReader br = new BufferedReader(f1);
			
			while ((t = br.readLine()) != null) {
				String[] s = t.split(",|\\s|;");
				student_information st = new student_information();
				arry.add(st);
				System.out.println("讀取文件：");
				System.out.println(s[0]);
			}
			f1.close();
			br.close();
			return true;
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	public boolean add(student_information stu) {
		System.out.println();
		System.out.println("要添加的學生");
		System.out.println(stu.fileString());
		System.out.println();
		if (find(stu.getStuID()) != -1)
			return false;
		arry.add(stu);
		return true;
	}

	
	public boolean writefile() {
		FileWriter fw = null;
		BufferedWriter out = null;
		try {
			fw = new FileWriter("D:\\student.txt");
			out = new BufferedWriter(fw);
			// 姓名学号等中间隔一个空格
			for (int i = 0; i < arry.size(); i++) {
				String s = arry.get(i).fileString();
				System.out.println("數組列表數據：");
				System.out.println(arry.get(i).fileString());
				out.write(s);
				out.newLine();
			}
			out.close();
			fw.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public boolean delete(String s) 
	{
		int pos = find(s);
		if (pos == -1)
			return false;

		arry.remove(pos);
		return true;
	}

}