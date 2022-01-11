package main;

import java.awt.CardLayout;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class test3 {

	private JFrame frame;
	private File openFile; // 檔案類
	private FileInputStream fileInputStream; // 位元組檔案輸入流
	private FileOutputStream fileOutputStream; // 位元組檔案輸出流
	private OutputStreamWriter outputStreamWriter; // 字元檔案輸出流j

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test3 window = new test3();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test3() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("評量管理者介面");
		frame.setBounds(100, 100, 955, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_head = new JPanel();
		panel_head.setBackground(SystemColor.activeCaption);
		panel_head.setBounds(0, 0, 937, 44);
		frame.getContentPane().add(panel_head);
		panel_head.setLayout(null);

		JLabel Label_Kytues = new JLabel("KYTUES");
		Label_Kytues.setFont(new Font("Arial Black", Font.PLAIN, 18));
		Label_Kytues.setBounds(14, 0, 181, 44);
		panel_head.add(Label_Kytues);

		JLabel Label_welcome = new JLabel("歡迎 XXX");
		Label_welcome.setBackground(new Color(240, 240, 240));
		Label_welcome.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_welcome.setBounds(859, 15, 64, 19);
		panel_head.add(Label_welcome);

		JPanel panel_navbar = new JPanel();
		panel_navbar.setBackground(SystemColor.activeCaption);
		panel_navbar.setBounds(0, 44, 193, 484);
		frame.getContentPane().add(panel_navbar);
		panel_navbar.setLayout(null);

		JLabel Label_question = new JLabel("建立各科試題");
		Label_question.setHorizontalAlignment(SwingConstants.CENTER);
		Label_question.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_question.setBounds(0, 0, 193, 42);
		panel_navbar.add(Label_question);

		JButton btn_addQuestion = new JButton("新增試題");
		btn_addQuestion.setBackground(SystemColor.activeCaption);
		btn_addQuestion.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_addQuestion.setBounds(0, 41, 193, 42);
		panel_navbar.add(btn_addQuestion);

		JButton btn_editQuestion = new JButton("編輯題庫");
		btn_editQuestion.setBackground(SystemColor.activeCaption);
		btn_editQuestion.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_editQuestion.setBounds(0, 80, 193, 42);
		panel_navbar.add(btn_editQuestion);

		JLabel Label_testInfo = new JLabel("定義測驗資料");
		Label_testInfo.setHorizontalAlignment(SwingConstants.CENTER);
		Label_testInfo.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_testInfo.setBounds(0, 120, 193, 42);
		panel_navbar.add(Label_testInfo);

		JButton btn_createTest = new JButton("建立試卷");
		btn_createTest.setBackground(SystemColor.activeCaption);
		btn_createTest.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_createTest.setBounds(0, 159, 193, 42);
		panel_navbar.add(btn_createTest);

		JLabel Label_groupManage = new JLabel("測驗群組管理");
		Label_groupManage.setHorizontalAlignment(SwingConstants.CENTER);
		Label_groupManage.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_groupManage.setBounds(0, 198, 193, 42);
		panel_navbar.add(Label_groupManage);

		JButton btn_addStd = new JButton("新增學生");
		btn_addStd.setBackground(SystemColor.activeCaption);
		btn_addStd.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_addStd.setBounds(0, 237, 193, 42);
		panel_navbar.add(btn_addStd);

		JButton btn_deleteStd = new JButton("刪除學生");
		btn_deleteStd.setBackground(SystemColor.activeCaption);
		btn_deleteStd.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_deleteStd.setBounds(0, 276, 193, 42);
		panel_navbar.add(btn_deleteStd);

		JLabel Label_searchScore = new JLabel("檢視成績");
		Label_searchScore.setHorizontalAlignment(SwingConstants.CENTER);
		Label_searchScore.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_searchScore.setBounds(0, 315, 193, 42);
		panel_navbar.add(Label_searchScore);

		JButton btn_searchScore = new JButton("查詢成績");
		btn_searchScore.setBackground(SystemColor.activeCaption);
		btn_searchScore.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_searchScore.setBounds(0, 354, 193, 43);
		panel_navbar.add(btn_searchScore);

		// 面板_卡片
		JPanel panel_card = new JPanel();
		panel_card.setBackground(SystemColor.activeCaption);
		panel_card.setBounds(193, 44, 744, 484);
		frame.getContentPane().add(panel_card);
		panel_card.setLayout(new CardLayout(0, 0));
		CardLayout c1 = (CardLayout) panel_card.getLayout();

		// 面板_初始畫面
		JPanel panel_initial = new JPanel();
		panel_initial.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_initial, "name_initial");
		panel_initial.setLayout(null);
		c1.show(panel_card, "name_initial");

		JLabel Label_userName = new JLabel("使用者名稱:");
		Label_userName.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		Label_userName.setBounds(98, 95, 126, 30);
		panel_initial.add(Label_userName);

		JTextField textField_userName = new JTextField();
		textField_userName.setBounds(234, 95, 257, 28);
		panel_initial.add(textField_userName);
		textField_userName.setColumns(10);

		JLabel Label_userAccount = new JLabel("使用者帳號:");
		Label_userAccount.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		Label_userAccount.setBounds(98, 181, 126, 30);
		panel_initial.add(Label_userAccount);

		JTextField textField_userAccount = new JTextField();
		textField_userAccount.setColumns(10);
		textField_userAccount.setBounds(234, 181, 257, 28);
		panel_initial.add(textField_userAccount);

		JLabel Label_gmail = new JLabel("Gmail:");
		Label_gmail.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		Label_gmail.setBounds(163, 261, 126, 30);
		panel_initial.add(Label_gmail);

		JTextField textField_gmail = new JTextField();
		textField_gmail.setColumns(10);
		textField_gmail.setBounds(234, 261, 257, 28);
		panel_initial.add(textField_gmail);

		// 面板_新增試題
		JPanel panel_addQuestion = new JPanel();
		panel_addQuestion.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_addQuestion, "name_addQuestion");
		panel_addQuestion.setLayout(null);

		JLabel Label_addQuestion = new JLabel("新增試題");
		Label_addQuestion.setBounds(14, 13, 179, 44);
		Label_addQuestion.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		panel_addQuestion.add(Label_addQuestion);

		JTextField textField_testFile = new JTextField();
		textField_testFile.setBounds(86, 70, 386, 29);
		textField_testFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_testFile.setToolTipText("");
		panel_addQuestion.add(textField_testFile);
		textField_testFile.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 112, 560, 286);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(14, 112, 560, 286);
		scrollPane.setViewportView(textArea);
		panel_addQuestion.add(scrollPane);

		JLabel Label_File = new JLabel("File:");
		Label_File.setBounds(14, 74, 58, 22);
		Label_File.setFont(new Font("微軟正黑體", Font.PLAIN, 24));
		panel_addQuestion.add(Label_File);

		JButton btn_testFile = new JButton("選擇檔案");
		btn_testFile.setBounds(489, 73, 85, 23);
		btn_testFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_testFile.setBackground(SystemColor.activeCaption);
		panel_addQuestion.add(btn_testFile);

		JButton btn_Read = new JButton("Read");
		btn_Read.setBounds(14, 411, 85, 23);
		btn_Read.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_Read.setBackground(SystemColor.activeCaption);
		panel_addQuestion.add(btn_Read);

		JButton btn_Save = new JButton("Save");
		btn_Save.setBounds(113, 411, 85, 23);
		btn_Save.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_Save.setBackground(SystemColor.activeCaption);
		panel_addQuestion.add(btn_Save);

		JButton btn_Exit = new JButton("Exit");
		btn_Exit.setBounds(489, 411, 85, 23);
		btn_Exit.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_Exit.setBackground(SystemColor.activeCaption);
		panel_addQuestion.add(btn_Exit);

		JLabel Label_success = new JLabel("!!! 成功儲存 !!!");
		Label_success.setBounds(212, 411, 133, 23);
		Label_success.setForeground(new Color(255, 102, 102));
		Label_success.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		panel_addQuestion.add(Label_success);
		Label_success.setVisible(false);

		// btn_testFile 增加互動 選擇檔案
		btn_testFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					tryReader.readFile("D:\\");
					textField_testFile.setText(tryReader.filePath);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		btn_Read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile = new File(textField_testFile.getText());
				try {
					if (!openFile.exists()) { // 如果檔案不存在
						openFile.createNewFile();// 建立檔案
					}
					fileInputStream = new FileInputStream(openFile); // 建立檔案輸入流
					byte b[] = new byte[(int) openFile.length()]; // 定義檔案大小的位元組資料
					fileInputStream.read(b); // 將檔案資料儲存在b陣列
					String content = new String(b, "UTF-8"); // 將位元組資料轉換為UTF-8編碼的字串
					textArea.setText(content); // 文字區顯示檔案內容
					fileInputStream.close(); // 關閉檔案輸入流
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btn_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFile = new File(textField_testFile.getText());
				try {
					fileOutputStream = new FileOutputStream(openFile);
					outputStreamWriter = new OutputStreamWriter(fileOutputStream, "utf-8");
					String content = textArea.getText();
					outputStreamWriter.write(content);
					outputStreamWriter.flush(); // 清空快取
					outputStreamWriter.close(); // 關閉檔案字元輸出流
					fileOutputStream.close(); // 關閉檔案位元組輸出流
					Label_success.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		btn_Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c1.show(panel_card, "name_initial");
			}
		});

		// 面板_編輯試題
		JPanel panel_editQuestion = new JPanel();
		panel_editQuestion.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_editQuestion, "name_editQuestion");
		panel_editQuestion.setLayout(null);

		JLabel Label_editQuestion = new JLabel("編輯題庫(新增試題)");
		Label_editQuestion.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_editQuestion.setBounds(14, 13, 179, 44);
		panel_editQuestion.add(Label_editQuestion);

		JLabel Label_testSubject = new JLabel("輸入題庫之科目");
		Label_testSubject.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_testSubject.setBounds(14, 58, 179, 44);
		panel_editQuestion.add(Label_testSubject);

		JTextField textField_testSubject = new JTextField();
		textField_testSubject.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_testSubject.setToolTipText("");
		textField_testSubject.setBounds(14, 103, 212, 25);
		panel_editQuestion.add(textField_testSubject);
		textField_testSubject.setColumns(10);

		JLabel Label_testLevel = new JLabel("輸入試題難度");
		Label_testLevel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_testLevel.setBounds(14, 127, 179, 44);
		panel_editQuestion.add(Label_testLevel);

		JTextField textField_testLevel = new JTextField();
		textField_testLevel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_testLevel.setToolTipText("");
		textField_testLevel.setBounds(14, 172, 212, 25);
		panel_editQuestion.add(textField_testLevel);
		textField_testLevel.setColumns(10);

		JLabel Label_testNum = new JLabel("輸入試題編號");
		Label_testNum.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_testNum.setBounds(14, 196, 179, 44);
		panel_editQuestion.add(Label_testNum);

		JTextField textField_testNum = new JTextField();
		textField_testNum.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_testNum.setToolTipText("");
		textField_testNum.setBounds(14, 241, 212, 25);
		panel_editQuestion.add(textField_testNum);
		textField_testNum.setColumns(10);

		JLabel Label_addTest = new JLabel("選擇試題檔案");
		Label_addTest.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_addTest.setBounds(14, 265, 179, 44);
		panel_editQuestion.add(Label_addTest);

		JTextField textField_addTest = new JTextField();
		textField_addTest.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_addTest.setToolTipText("");
		textField_addTest.setBounds(14, 310, 212, 25);
		panel_editQuestion.add(textField_addTest);
		textField_addTest.setColumns(10);

		JButton btn_addTestFile = new JButton("選擇檔案");
		btn_addTestFile.setBackground(SystemColor.activeCaption);
		btn_addTestFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_addTestFile.setBounds(14, 348, 99, 25);
		panel_editQuestion.add(btn_addTestFile);

		JButton btn_sure_addTestFile = new JButton("確定");
		btn_sure_addTestFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_sure_addTestFile.setBackground(SystemColor.activeCaption);
		btn_sure_addTestFile.setBounds(127, 348, 99, 25);
		panel_editQuestion.add(btn_sure_addTestFile);

		JLabel Label_addTestFile = new JLabel("!!! 新增成功 !!!");
		Label_addTestFile.setForeground(new Color(255, 102, 102));
		Label_addTestFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_addTestFile.setBounds(14, 386, 197, 25);
		panel_editQuestion.add(Label_addTestFile);

		JLabel Label_deleteQuestion = new JLabel("編輯題庫(刪除試題)");
		Label_deleteQuestion.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_deleteQuestion.setBounds(336, 13, 179, 44);
		panel_editQuestion.add(Label_deleteQuestion);

		JLabel Label_testSubject_del = new JLabel("輸入題庫之科目");
		Label_testSubject_del.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_testSubject_del.setBounds(336, 58, 179, 44);
		panel_editQuestion.add(Label_testSubject_del);

		JTextField textField_testSubject_del = new JTextField();
		textField_testSubject_del.setToolTipText("");
		textField_testSubject_del.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_testSubject_del.setColumns(10);
		textField_testSubject_del.setBounds(336, 103, 212, 25);
		panel_editQuestion.add(textField_testSubject_del);

		JLabel Label_testLevel_del = new JLabel("輸入試題難度");
		Label_testLevel_del.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_testLevel_del.setBounds(336, 127, 179, 44);
		panel_editQuestion.add(Label_testLevel_del);

		JTextField textField_testLevel_del = new JTextField();
		textField_testLevel_del.setToolTipText("");
		textField_testLevel_del.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_testLevel_del.setColumns(10);
		textField_testLevel_del.setBounds(336, 172, 212, 25);
		panel_editQuestion.add(textField_testLevel_del);

		JLabel Label_testDel = new JLabel("選擇欲刪除的檔案");
		Label_testDel.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_testDel.setBounds(336, 196, 179, 44);
		panel_editQuestion.add(Label_testDel);

		JTextField textField_testDel = new JTextField();
		textField_testDel.setToolTipText("");
		textField_testDel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_testDel.setColumns(10);
		textField_testDel.setBounds(336, 243, 212, 25);
		panel_editQuestion.add(textField_testDel);

		JButton btn_delTestFile = new JButton("選擇檔案");
		btn_delTestFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_delTestFile.setBackground(SystemColor.activeCaption);
		btn_delTestFile.setBounds(336, 284, 99, 25);
		panel_editQuestion.add(btn_delTestFile);

		JButton btn_sure_delTestFile = new JButton("確定");
		btn_sure_delTestFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_sure_delTestFile.setBackground(SystemColor.activeCaption);
		btn_sure_delTestFile.setBounds(449, 284, 99, 25);
		panel_editQuestion.add(btn_sure_delTestFile);
		Label_addTestFile.setVisible(false);

		JLabel Label_delTestFile = new JLabel("!!! 刪除成功 !!!");
		Label_delTestFile.setForeground(new Color(255, 102, 102));
		Label_delTestFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_delTestFile.setBounds(336, 322, 197, 25);
		panel_editQuestion.add(Label_delTestFile);
		Label_delTestFile.setVisible(false);

		// btn_addTestFile 增加互動 選擇檔案
		btn_addTestFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					tryReader.readFile("D:\\");
					textField_addTest.setText(tryReader.filePath);
				} catch (Exception e) {
					e.printStackTrace();
				}
				File originalFile = new File(tryReader.filePath);
				// btn_sure_addTestFile 增加互動 新增檔案;
				btn_sure_addTestFile.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						originalFile.renameTo(new File("D:/KYUTES/題庫/" + textField_testSubject.getText() + "/"
								+ textField_testLevel.getText() + "/" + textField_testNum.getText() + ".txt"));
						Label_addTestFile.setVisible(true);
					}
				});
			}
		});

		// btn_delTestFile 增加互動 選擇檔案
		btn_delTestFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					tryReader.readFile("D:/KYUTES/題庫/" + textField_testSubject_del.getText() + "/"
							+ textField_testLevel_del.getText());
					textField_testDel.setText(tryReader.filePath);
				} catch (Exception e) {
					e.printStackTrace();
				}
				File originalFile = new File(textField_testDel.getText());
				// btn_sure_delTestFile 增加互動 新增檔案;
				btn_sure_delTestFile.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						originalFile.delete();
						Label_delTestFile.setVisible(true);
					}
				});
			}
		});

		// 面板_建立試卷
		JPanel panel_createTest = new JPanel();
		panel_createTest.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_createTest, "name_createTest");
		panel_createTest.setLayout(null);

		JComboBox comboBox_quantity = new JComboBox();
		comboBox_quantity.setModel(new DefaultComboBoxModel(new String[] { "40題", "80題", "120題" }));
		comboBox_quantity.setBounds(154, 259, 78, 23);
		panel_createTest.add(comboBox_quantity);

		JComboBox comboBox_Time = new JComboBox();
		comboBox_Time.setModel(new DefaultComboBoxModel(new String[] { "30分鐘", "60分鐘", "90分鐘" }));
		comboBox_Time.setBounds(310, 259, 78, 23);
		panel_createTest.add(comboBox_Time);

		JComboBox comboBox_topic = new JComboBox();
		comboBox_topic.setModel(new DefaultComboBoxModel(new String[] { "簡單", "中等", "困難" }));
		comboBox_topic.setBounds(458, 259, 78, 23);
		panel_createTest.add(comboBox_topic);

		JLabel lblNewLabel_4 = new JLabel("題數");
		lblNewLabel_4.setFont(new Font("新細明體", Font.PLAIN, 40));
		lblNewLabel_4.setBounds(154, 192, 85, 58);
		panel_createTest.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("時間");
		lblNewLabel_4_1.setFont(new Font("新細明體", Font.PLAIN, 40));
		lblNewLabel_4_1.setBounds(310, 191, 85, 58);
		panel_createTest.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("難易度");
		lblNewLabel_4_2.setFont(new Font("新細明體", Font.PLAIN, 40));
		lblNewLabel_4_2.setBounds(437, 192, 128, 58);
		panel_createTest.add(lblNewLabel_4_2);

		JButton btnNewButton_4 = new JButton("新增試卷");
		btnNewButton_4.setBounds(296, 361, 112, 23);
		panel_createTest.add(btnNewButton_4);

		// 面板_新增學生
		JPanel panel_addStd = new JPanel();
		panel_addStd.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_addStd, "name_addStd");
		panel_addStd.setLayout(null);

		JLabel Label_addStd = new JLabel("新增學生");
		Label_addStd.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_addStd.setBounds(14, 13, 179, 44);
		panel_addStd.add(Label_addStd);

		JLabel Label_groupName_add = new JLabel("輸入群組名稱");
		Label_groupName_add.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_groupName_add.setBounds(14, 58, 179, 44);
		panel_addStd.add(Label_groupName_add);

		JTextField textField_groupName = new JTextField();
		textField_groupName.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_groupName.setToolTipText("");
		textField_groupName.setBounds(14, 103, 179, 25);
		panel_addStd.add(textField_groupName);
		textField_groupName.setColumns(10);

		JLabel Label_groupFile = new JLabel("選擇群組名單");
		Label_groupFile.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_groupFile.setBounds(14, 127, 179, 44);
		panel_addStd.add(Label_groupFile);

		JTextField textField_fileName = new JTextField();
		textField_fileName.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_fileName.setToolTipText("");
		textField_fileName.setBounds(14, 172, 179, 25);
		panel_addStd.add(textField_fileName);
		textField_fileName.setColumns(10);

		JButton btn_groupFile = new JButton("選擇檔案");
		btn_groupFile.setBackground(SystemColor.activeCaption);
		btn_groupFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_groupFile.setBounds(207, 172, 99, 25);
		panel_addStd.add(btn_groupFile);

		JButton btn_sure_groupAdd = new JButton("確定");
		btn_sure_groupAdd.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_sure_groupAdd.setBackground(SystemColor.activeCaption);
		btn_sure_groupAdd.setBounds(326, 172, 99, 25);
		panel_addStd.add(btn_sure_groupAdd);

		JLabel Label_groupAdd = new JLabel("!!! 新增成功 !!!");
		Label_groupAdd.setForeground(new Color(255, 102, 102));
		Label_groupAdd.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_groupAdd.setBounds(439, 172, 197, 25);
		panel_addStd.add(Label_groupAdd);
		Label_groupAdd.setVisible(false);

		// btn_groupFile 增加互動 選擇檔案
		btn_groupFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					tryReader.readFile("D:\\");
					textField_fileName.setText(tryReader.filePath);
				} catch (Exception e) {
					e.printStackTrace();
				}
				File originalFile = new File(tryReader.filePath);
				// btn_sure_groupAdd 增加互動 新增檔案;
				btn_sure_groupAdd.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						originalFile.renameTo(new File("D:/KYUTES/群組/" + textField_groupName.getText() + ".csv"));
						Label_groupAdd.setVisible(true);
					}
				});
			}
		});

		// 面板_刪除學生
		JPanel panel_deleteStd = new JPanel();
		panel_deleteStd.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_deleteStd, "name_deleteStd");
		panel_deleteStd.setLayout(null);

		JLabel Label_editGroup = new JLabel("編輯群組");
		Label_editGroup.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_editGroup.setBounds(14, 13, 179, 44);
		panel_deleteStd.add(Label_editGroup);

		JLabel Label_groupName_edit = new JLabel("選擇群組檔案");
		Label_groupName_edit.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_groupName_edit.setBounds(14, 58, 179, 44);
		panel_deleteStd.add(Label_groupName_edit);

		JTextField textField_groupName_edit = new JTextField();
		textField_groupName_edit.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_groupName_edit.setToolTipText("");
		textField_groupName_edit.setBounds(14, 103, 179, 25);
		panel_deleteStd.add(textField_groupName_edit);
		textField_groupName.setColumns(10);

		JButton btn_groupFile_edit = new JButton("選擇檔案");
		btn_groupFile_edit.setBackground(SystemColor.activeCaption);
		btn_groupFile_edit.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_groupFile_edit.setBounds(207, 103, 99, 25);
		panel_deleteStd.add(btn_groupFile_edit);

		JButton btn_sure_groupEdit = new JButton("確定");
		btn_sure_groupEdit.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_sure_groupEdit.setBackground(SystemColor.activeCaption);
		btn_sure_groupEdit.setBounds(326, 103, 99, 25);
		panel_deleteStd.add(btn_sure_groupEdit);

		JLabel Label_groupEdit = new JLabel("!!! 刪除成功 !!!");
		Label_groupEdit.setForeground(new Color(255, 102, 102));
		Label_groupEdit.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_groupEdit.setBounds(439, 103, 197, 25);
		panel_deleteStd.add(Label_groupEdit);
		Label_groupEdit.setVisible(false);

		// btn_groupFile_edit 增加互動 選擇檔案
		btn_groupFile_edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					tryReader.readFile("D:/KYUTES/群組/");
					textField_groupName_edit.setText(tryReader.filePath);
				} catch (Exception e) {
					e.printStackTrace();
				}
				File originalFile = new File(textField_groupName_edit.getText());
				// btn_sure_groupEdit 增加互動 刪除檔案;
				btn_sure_groupEdit.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						originalFile.delete();
						Label_groupEdit.setVisible(true);
					}
				});
			}
		});

		// 面板_查詢成績
		JPanel panel_searchScore = new JPanel();
		panel_searchScore.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_searchScore, "name_searchScore");
		panel_searchScore.setLayout(null);

		JLabel Label_stdScore = new JLabel("查詢學生成績");
		Label_stdScore.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_stdScore.setBounds(14, 13, 179, 44);
		panel_searchScore.add(Label_stdScore);

		JLabel Label_subjectFile = new JLabel("選擇科目");
		Label_subjectFile.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_subjectFile.setBounds(14, 58, 179, 44);
		panel_searchScore.add(Label_subjectFile);

		JTextField textField_subjectFile = new JTextField();
		textField_subjectFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_subjectFile.setToolTipText("");
		textField_subjectFile.setBounds(14, 103, 179, 25);
		panel_searchScore.add(textField_subjectFile);
		textField_subjectFile.setColumns(10);

		JButton btn_chooseFile = new JButton("選擇檔案");
		btn_chooseFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_chooseFile.setBackground(SystemColor.activeCaption);
		btn_chooseFile.setBounds(207, 103, 99, 25);
		panel_searchScore.add(btn_chooseFile);

		String[][] rec = new String[100][5];

		String[] header = { "科系", "學號", "名字", "測驗日期", "成績" };
		JTable table = new JTable(rec, header);
		JScrollPane jscrollpane = new JScrollPane(table);
		jscrollpane.setBounds(14, 55, 500, 400);
		panel_searchScore.add(jscrollpane);
		jscrollpane.setVisible(false);

		btn_chooseFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					tryReader.readFile("D:/KYUTES/群組");
					CSVReader reader = new CSVReader(tryReader.filePath);
					String line = "";
					textField_subjectFile.setText(tryReader.filePath);
					int i = 0;
					while ((line = reader.readLine()) != null) {
						rec[i] = line.split(",");
						i += 1;
					}
					jscrollpane.setVisible(true);
					btn_chooseFile.setVisible(false);
					textField_subjectFile.setVisible(false);
					Label_subjectFile.setVisible(false);
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// 按鈕加互動_個人資料設定
		Label_Kytues.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_initial");
			}
		});

		// 按鈕加互動_新增試題
		btn_addQuestion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_addQuestion.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_addQuestion");
			}
		});
		btn_addQuestion.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_addQuestion.setBackground(Color.WHITE);
			}
		});

		// 按鈕加互動_刪除試題
		btn_editQuestion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_editQuestion.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_editQuestion");
			}
		});
		btn_editQuestion.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_editQuestion.setBackground(Color.WHITE);
			}
		});

		// 按鈕加互動_建立試卷
		btn_createTest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_createTest.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_createTest");
			}
		});
		btn_createTest.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_createTest.setBackground(Color.WHITE);
			}
		});

		// 按鈕加互動_新增學生
		btn_addStd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_addStd.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_addStd");
			}
		});
		btn_addStd.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_addStd.setBackground(Color.WHITE);
			}
		});

		// 按鈕加互動_刪除學生
		btn_deleteStd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_deleteStd.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_deleteStd");
			}
		});
		btn_deleteStd.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_deleteStd.setBackground(Color.WHITE);
			}
		});

		// 按鈕加互動_查詢成績
		btn_searchScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_searchScore.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_searchScore");
			}
		});
		btn_searchScore.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_searchScore.setBackground(Color.WHITE);
			}
		});
	}
}