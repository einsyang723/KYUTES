package AB;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Test2 extends JFrame implements ActionListener {

	private JButton start, commit, back, next;
	private JRadioButton aButton, bButton, cButton, dButton;
	private ButtonGroup buttonGroup;
	private JLabel label, clock;
	private JTextArea jTextArea;
	private JPanel panel, panel2, panel3;
	Testquestion t1;
	Testquestion[] questions;
	int examtime;
	int p = 0;// 設定題目數指標
	int topicnum = 0;
	int right, error; // 答對和答錯
	ClockDispaly mt; // 倒計時模組

	public Test2() {
		this.setTitle("學生線上考試系統v1"); // 設定標題
		this.setSize(440, 320); // 設定視窗大小
		this.setLocationRelativeTo(null); // 設定顯示位置居中
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 設定關閉時關閉
		panel = new JPanel(); // 初始化面板
		panel2 = new JPanel();
		panel3 = new JPanel();
		label = new JLabel("總考試時間:30分鐘 "); // 初始化並命名標籤
		clock = new JLabel();
		jTextArea = new JTextArea(10, 35); // 初始化文字區域
		jTextArea.setEditable(false); // 設定文字不可修改

		aButton = new JRadioButton("A"); // 初始化單選按鈕
		bButton = new JRadioButton("B");
		cButton = new JRadioButton("C");
		dButton = new JRadioButton("D");
		buttonGroup = new ButtonGroup(); // 初始化選項組

		start = new JButton("開始考試"); // 初始化按鍵
		back = new JButton("上一題");
		next = new JButton("下一題");
		commit = new JButton("提交考試");

		aButton.addActionListener(this); // 單選按鈕新增監聽事件
		bButton.addActionListener(this);
		cButton.addActionListener(this);
		dButton.addActionListener(this);

		start.addActionListener(this); // 按鈕新增監聽事件
		back.addActionListener(this);
		next.addActionListener(this);
		commit.addActionListener(this);

		buttonGroup.add(aButton); // 把單選按鈕放到選項組
		buttonGroup.add(bButton);
		buttonGroup.add(cButton);
		buttonGroup.add(dButton);

		panel.add(label); // 把標籤放入面板panel
		panel.add(clock);
		panel.add(start); // 把按鍵放入面板panel
		panel2.add(jTextArea); // 把文字區域放入面板panel2
		panel3.add(aButton); // 把單選按鈕放入面板panel3
		panel3.add(bButton);
		panel3.add(cButton);
		panel3.add(dButton);
		panel3.add(back); // 把按鍵放入面板panel3
		panel3.add(next);
		panel3.add(commit);

		this.add(panel, BorderLayout.NORTH); // 設定面板panel放在上面
		this.add(panel2, BorderLayout.CENTER); // 設定面板panel2放在中間
		this.add(panel3, BorderLayout.SOUTH); // 設定面板panel放在下面

		this.setVisible(true); // 設定視窗可見

		mt = new ClockDispaly(clock, 30); // 呼叫並設定倒計時的時間

	}

	public void createExam() {// 建立考試模組
		Vector<Testquestion> qList = null;// 建立一個向量列表，用於動態增加試題
		Testquestion t;
		String questionText = "";
		String standardKey;
		String s;
		try {
			FileReader fr = new FileReader("D:\\test.txt");
			BufferedReader br = new BufferedReader(fr); // 可以每次讀一行
			qList = new Vector<Testquestion>();
			while ((s = br.readLine()) != null) {// 讀取試題
				if (s.equals("*****")) {
					questionText = "";// 準備接收一個題目的內容
					s = br.readLine();// 獲取試題內容的首行

				}
				if (s.equals("$$$$$")) {// 準備讀取試題的答案
					s = br.readLine(); // 獲取試題的答案
					standardKey = s; // 把試題答案賦值給正確答案
					t = new Testquestion(questionText, standardKey); // 把試題和答案賦值給t
					qList.add(t); // 把試題和答案賦值給列表
				}
				questionText = questionText + s + '\n';

			}
			br.close();// 關閉緩衝流
			fr.close();// 關閉檔案流

		} catch (IOException e) {
			e.printStackTrace(); // 列印異常資訊
		}
		topicnum = qList.size(); // 統計試題數量
		questions = new Testquestion[topicnum];
		for (int i = 0; i < qList.size(); i++) // 讀取試題
			questions[i] = qList.get(i);
	}

	public void setSelected(String s) {// 設定單選按鈕不重複模組
		if (s.equals("A"))
			buttonGroup.setSelected(aButton.getModel(), true);
		if (s.equals("B"))
			buttonGroup.setSelected(bButton.getModel(), true);
		if (s.equals("C"))
			buttonGroup.setSelected(cButton.getModel(), true);
		if (s.equals("D"))
			buttonGroup.setSelected(dButton.getModel(), true);
		if (s.equals(""))
			buttonGroup.clearSelection();
	}

	public void showQuestion() {// 設定試題模組
		jTextArea.setText("");
		jTextArea.append(questions[p].getQuestionText());// 在文字區域顯示試題
		setSelected(questions[p].getSelectKey());
	}

	public void showScore() {// 設定成績模組
		right = 0;
		error = 0;
		for (int i = 0; i < topicnum; i++) {
			if (questions[i].check()) {// 判斷答案的正確與錯誤
				right++;
			} else {
				error++;
			}
		}
		int score = (int) (right * 100 / topicnum); // 設定分數
		JOptionPane.showMessageDialog(null, "答對" + right + "題，答錯" + error + "題，分數為" + score);
	}

	@Override
	public void actionPerformed(ActionEvent e) {// 動作監聽事件

		if (e.getSource() == start) {// 開始開始按鍵實現
			createExam(); // 呼叫createExam模組
			p = 0; // 題目序號
			showQuestion(); // 呼叫showQuestion模組
			start.setEnabled(false);// 設定按鈕不可點選
			mt.start(); // 考試時間倒計時啟動
		}
		if (e.getSource() == back) {// 上一題的按鍵實現
			p--;
			if (p == -1) {
				JOptionPane.showMessageDialog(null, "已經是第一題");
				p++;
			}
			showQuestion();
		}
		if (e.getSource() == next) {// 下一題的按鍵實現
			p++;
			if (p == topicnum) {
				JOptionPane.showMessageDialog(null, "已經是最後一題");
				p--;
			}
			showQuestion();
		}
		if (e.getSource() == commit) {// 提交試卷的按鍵實現
			showScore();
			commit.setEnabled(false);
			System.exit(0); // 退出
		}

		if (e.getSource() == aButton)
			questions[p].setSelectKey("A");
		if (e.getSource() == bButton)
			questions[p].setSelectKey("B");
		if (e.getSource() == cButton)
			questions[p].setSelectKey("C");
		if (e.getSource() == dButton)
			questions[p].setSelectKey("D");
//		panel3.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				panel3.setVisible(false);
//			}
//
//		});
	}

	class ClockDispaly extends Thread {// 設定Thread考試倒計時模組

		private JLabel lefttimer;
		private int testtime;

		public ClockDispaly(JLabel lt, int time) {
			lefttimer = lt;
			testtime = time * 60;
		}

		public void run() {
			NumberFormat numberFormat = NumberFormat.getInstance();// 控制時間的顯示格式
			numberFormat.setMinimumIntegerDigits(2);// 設定數值的整數部分允許的最小位數
			int h, m, s;// 定義時分秒
			while (testtime >= 0) {
				h = testtime / 3600;
				m = testtime % 3600 / 60;
				s = testtime % 60;
				StringBuffer stringBuffer = new StringBuffer("");
				// 增加到lefttimer標籤
				stringBuffer.append("考試剩餘時間為：" + numberFormat.format(h) + ":" + numberFormat.format(m) + ":"
						+ numberFormat.format(s));
				lefttimer.setText(stringBuffer.toString());
				try {
					Thread.sleep(1000);// 延時一秒
				} catch (Exception e) {
					// ignore error
				}
				testtime = testtime - 1;
			}
			if (testtime <= 0) {
				JOptionPane.showMessageDialog(null, "考試結束");
				System.exit(0);
			}
		}
	}
}