package AB;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AB.Function;
import AB.Test2;
import AB.accountfix;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JComboBox;

public class StudentA extends JFrame implements ActionListener {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentA window = new StudentA();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public StudentA() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();// 最一開始
		frame.setTitle("KYUTES學生");
		frame.setBounds(100, 100, 955, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_card1 = new JPanel();
		panel_card1.setBackground(SystemColor.activeCaption);
		panel_card1.setBounds(193, 44, 744, 484);
		frame.getContentPane().add(panel_card1);
		panel_card1.setLayout(new CardLayout(0, 0));
		CardLayout c1 = (CardLayout) panel_card1.getLayout();

//跳轉
		JPanel panel_content = new JPanel();
		panel_content.setBackground(SystemColor.inactiveCaptionBorder);
		JButton content_button1 = new JButton("題目本");
		content_button1.setBounds(61, 73, 123, 64);
		panel_content.add(content_button1);
		JButton content_button2 = new JButton("解答本");
		content_button2.setBounds(548, 73, 123, 64);
		panel_content.add(content_button2);
		c1.show(panel_card1, "name_content");
		panel_card1.add(panel_content, "name_content");

		JPanel panel_question = new JPanel();
		panel_question.setBackground(SystemColor.inactiveCaptionBorder);
		JButton question_button1 = new JButton("選擇年級!");
		question_button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		question_button1.setBounds(304, 10, 123, 47);
		panel_question.add(question_button1);
		panel_card1.add(panel_question, "name_question");
		panel_question.setLayout(null);

		JPanel panel_account = new JPanel();
		panel_account.setBackground(SystemColor.inactiveCaptionBorder);
		JButton account_button1 = new JButton("修改內容");
		account_button1.setBounds(0, 42, 193, 43);
		panel_account.add(account_button1);
		panel_card1.add(panel_account, "name_account");

		JPanel panel_score = new JPanel();
		panel_score.setBackground(SystemColor.inactiveCaptionBorder);
		JButton score_button1 = new JButton("查詢成績");
		score_button1.setBounds(0, 42, 193, 43);
		panel_score.add(score_button1);
		panel_card1.add(panel_score, "name_score");

		JPanel panel_paper = new JPanel();
		panel_paper.setBackground(SystemColor.inactiveCaptionBorder);
		JButton paper_button1 = new JButton("閱卷");
		paper_button1.setBounds(0, 42, 193, 43);
		panel_paper.add(paper_button1);
		panel_card1.add(panel_paper, "name_paper");

		JPanel panel_quiz = new JPanel();
		panel_quiz.setBackground(SystemColor.inactiveCaptionBorder);
		JButton quiz_button1 = new JButton("開始測驗");
		quiz_button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		quiz_button1.setBounds(90, 91, 123, 64);
		panel_quiz.add(quiz_button1);
		panel_card1.add(panel_quiz, "name_quiz");

		JComboBox BoxSubject = new JComboBox();
		BoxSubject.addItem("請選擇科目");
		BoxSubject.addItem("微積分");
		BoxSubject.addItem("軟體工程");
		panel_quiz.add(BoxSubject);

		JComboBox BoxDifficult = new JComboBox();
		BoxDifficult.addItem("請選擇難度");
		BoxDifficult.addItem("易");
		BoxDifficult.addItem("適中");
		BoxDifficult.addItem("難");
		panel_quiz.add(BoxDifficult);
//主要
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JMenuBar jb = new JMenuBar();
		jb.setBounds(0, 0, 941, 51);
		jb.setBackground(SystemColor.activeCaption);
		panel.add(jb);

		JMenu jmenu1 = new JMenu("更多");
		jb.add(jmenu1);

		JMenuItem MenuItem1 = new JMenuItem("關於高師大");
		jmenu1.add(MenuItem1);

		JMenuItem MenuItem2 = new JMenuItem("疑難排解");
		jmenu1.add(MenuItem2);
//按鈕
		JButton btn_content = new JButton("查看試題內容");
		btn_content.setBounds(0, 44, 192, 73);
		panel.add(btn_content);

		JButton btn_question = new JButton("線上出題");
		btn_question.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_question.setBounds(0, 127, 192, 73);
		panel.add(btn_question);

		JButton btn_account = new JButton("帳號修改");
		btn_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_account.setBounds(0, 210, 192, 73);
		panel.add(btn_account);

		JButton btn_score = new JButton("成績查詢");
		btn_score.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_score.setBounds(0, 289, 192, 73);
		panel.add(btn_score);

		JButton btn_paper = new JButton("閱卷");
		btn_paper.setBounds(0, 372, 192, 73);
		panel.add(btn_paper);

		JButton btn_quiz = new JButton("進行線上測驗");
		btn_quiz.setBounds(0, 455, 192, 73);
		panel.add(btn_quiz);

//事件
		btn_content.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card1, "name_content");
			}
		});
		btn_question.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card1, "name_question");
			}
		});
		btn_account.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card1, "name_account");
			}
		});
		btn_score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card1, "name_score");
			}
		});
		btn_paper.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card1, "name_paper");
			}
		});
		btn_quiz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card1, "name_quiz");
			}
		});
		account_button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card1, "name_quiz");
				new accountfix();
			}
		});
		quiz_button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card1, "name_quiz");
				new Test2();
			}
		});
		score_button1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card1, "name_quiz");
				new ScoreSearch();
			}
		});
	}
}