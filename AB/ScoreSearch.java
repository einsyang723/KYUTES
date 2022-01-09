package AB;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ScoreSearch extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	Function fun = new Function();

	JLabel lb1 = new JLabel("查成績囉!");
	JLabel lb2 = new JLabel("提示：登入前請先輸入學號，根據學號查詢信息\n");

	JTextField ID, Name, Age, Phone, Password, Identity;// 基本訊息
	JRadioButton male, female;
	ButtonGroup group = null;
	JButton Login, Search, Delete, Fix, Show, Back;
	JPanel p1, p2, p3, p4, p5, p6, p7, pv, ph, pb;

	public ScoreSearch() {
		super("學生成績系统");
		ID = new JTextField(10);
		Name = new JTextField(10);
		Phone = new JTextField(15);
		Age = new JTextField(5);
		Password = new JTextField(15);
		Identity = new JTextField(18);

		group = new ButtonGroup();
		male = new JRadioButton("男");
		female = new JRadioButton("女");
		group.add(male);
		group.add(female);

		Search = new JButton("查看我的成績");
		Fix = new JButton("修改學生信息");
		Show = new JButton("顯示全部學生成績");
		Back = new JButton("返回");

		pb = new JPanel();
		pb.add(lb1, JLabel.CENTER);

		p1 = new JPanel();

		p1.add(lb2, JLabel.CENTER);
		p1.add(new JLabel("學號:", JLabel.CENTER));
		p1.add(ID);

		p2 = new JPanel();
		p2.add(new JLabel("姓名:", JLabel.CENTER));
		p2.add(Name);

		p3 = new JPanel();
		p3.add(new JLabel("性别:", JLabel.CENTER));
		p3.add(male);
		p3.add(female);

		p4 = new JPanel();
		p4.add(new JLabel("年齡:", JLabel.CENTER));
		p4.add(Age);

		p5 = new JPanel();
		p5.add(new JLabel("電話號碼:", JLabel.CENTER));
		p5.add(Phone);

		p6 = new JPanel();
		p6.add(new JLabel("密碼:", JLabel.CENTER));
		p6.add(Password);

		p7 = new JPanel();
		p7.add(new JLabel("身分證:", JLabel.CENTER));
		p7.add(Identity);

		pv = new JPanel();// 面板
		pv.setLayout(new GridLayout(7, 1)); // 把pv组件设置成第七行1列的网格布局

		pv.add(p1);// 把面板放到容器中,add()代表容器
		pv.add(p2);
		pv.add(p3);
		pv.add(p4);
		pv.add(p5);
		pv.add(p6);
		pv.add(p7);

		ph = new JPanel();
		ph.add(Search);
		ph.add(Fix);
		ph.add(Show);
		ph.add(Back);

		Container con = getContentPane();
		con.setLayout(new BorderLayout());

		con.add(pb, BorderLayout.NORTH);
		con.add(pv, BorderLayout.CENTER);
		con.add(ph, BorderLayout.SOUTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 450);

		setVisible(true);
		// student_information stu = new student_information();
		@SuppressWarnings("unused")
		ArrayList<student_information> arry = new ArrayList<student_information>();

		Show.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				 show_stuall all = new show_stuall();
				new show_allscore();
			}
		});
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sID = ID.getText();
				if (sID.equals(""))
					sID = "--";
				String sname = Name.getText();
				if (sname.equals(""))
					sname = "--";
				String sage = Age.getText();
				if (sage.equals(""))
					sage = "--";
				String scall = Phone.getText();
				if (scall.equals(""))
					scall = "--";
				String shome = Password.getText();
				if (shome.equals(""))
					shome = "--";
				String siden = Identity.getText();
				if (siden.equals(""))
					siden = "--";
				String ssex = null;
				if (male.isSelected()) {// 选择男女
					ssex = male.getText();
				} else {
					if (female.isSelected())
						ssex = female.getText();
					else {
						ssex = "--";
					}
				}
				FileWriter fw = null;
				BufferedWriter out = null;
				try {
					fw = new FileWriter("D:\\StudentScore1.txt");
					out = new BufferedWriter(fw);

					out.write(sID + "  ");
					out.write(sname + "  ");
					out.write(ssex + "  ");
					out.write(sage + "  ");
					out.write(scall + "  ");
					out.write(shome + "  ");
					out.write(siden + "  ");

					out.close();
					fw.close();

				} catch (IOException e1) {
					e1.printStackTrace();

				}

				new showonescore();

				ID.setText("");
				Name.setText("");
				Age.setText("");
				Phone.setText("");
				Password.setText("");
				Identity.setText("");
				group.clearSelection();

			}
		});

//		Fix.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String sID = ID.getText();
//				int flag = fun.find(sID);
//				if (flag == -1) {
//					JOptionPane.showMessageDialog(null, "未查找到該學號的學生！！！\n\n請重新輸入");
//					return;
//				} else
//					JOptionPane.showMessageDialog(null, "該系统中存在該學生數據\n\n,確認返回後請輸入需要修改後的數據");
//
//				String sage = Age.getText();
//				if (sage.equals(""))// 年龄为空，没有输入
//					sage = "--";
//				String scall = Phone.getText();
//				if (scall.equals(""))
//					scall = "--";
//				String shome = Password.getText();
//				if (shome.equals(""))
//					shome = "--";
//				String siden = Identity.getText();
//				if (siden.equals(""))
//					siden = "--";
//				String ssex = null;
//				if (male.isSelected()) {
//					ssex = male.getText();
//				} else {
//					ssex = female.getText();
//				}
//				String sname = Name.getText();
//
//				if (sname.equals("")) {
//					JOptionPane.showMessageDialog(null, "登入的學生姓名為空！！！\n\n請重新輸入");
//					return;
//				}
//				student_information stu = new student_information();
//				stu.setStuID(sID);
//				stu.setAge(sage);
//				stu.setName(sname);
//				stu.setSex(ssex);
//				stu.setCallnummber(scall);
//				stu.setHome_place(shome);
//				stu.setIdentityID(siden);
//
//				fun.update(stu); // 修改
//				fun.writefile();
//				JOptionPane.showMessageDialog(null, "修改成功！！！");
//				// 清空文本框
//				ID.setText("");
//				Name.setText("");
//				Age.setText("");
//				Phone.setText("");
//				Password.setText("");
//				Identity.setText("");
//				group.clearSelection();
//			}
//		});
		Back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); // 目的是使控件不可以显示出来
				new Login();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}