package main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

public class SystemManage2 {

	JFrame frame;
	JTextField textField;
	static JPanel panel_navbar;
	static JPanel panel_card;
	static CardLayout c1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemManage2 window = new SystemManage2();
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
	public SystemManage2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		// 創建視窗
		frame = new JFrame("系統管理者介面");
		frame.setBounds(100, 100, 955, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// 面板_頭部
		JPanel panel_head = new JPanel();
		panel_head.setBackground(SystemColor.activeCaption);
		panel_head.setBounds(0, 0, 937, 44);
		frame.getContentPane().add(panel_head);
		panel_head.setLayout(null);

		// 標籤_KYTUES
		JLabel Label_Kytues = new JLabel("KYTUES");
		Label_Kytues.setFont(new Font("Arial Black", Font.PLAIN, 18));
		Label_Kytues.setBounds(14, 0, 179, 44);
		panel_head.add(Label_Kytues);

		// 標籤_歡迎
		JLabel Label_welcome = new JLabel("歡迎 XXX");
		Label_welcome.setBackground(new Color(240, 240, 240));
		Label_welcome.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_welcome.setBounds(859, 15, 64, 19);
		panel_head.add(Label_welcome);

		// 面板_按鈕
		panel_navbar = new JPanel();
		panel_navbar.setBackground(SystemColor.activeCaption);
		panel_navbar.setBounds(0, 43, 193, 484);
		frame.getContentPane().add(panel_navbar);
		panel_navbar.setLayout(null);

		// 標籤_帳號管理
		JLabel Label_account = new JLabel("使用者帳號管理");
		Label_account.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_account.setHorizontalAlignment(SwingConstants.CENTER);
		Label_account.setLabelFor(Label_account);
		Label_account.setBounds(0, 0, 193, 43);
		panel_navbar.add(Label_account);

		// 按鈕_建立帳號
		JButton btn_createAccount = new JButton("建立帳號");
		btn_createAccount.setBackground(SystemColor.activeCaption);
		btn_createAccount.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_createAccount.setBounds(0, 42, 193, 43);
		panel_navbar.add(btn_createAccount);

		// 按鈕_刪除帳號
		JButton btn_deleteAccount = new JButton("刪除帳號");
		btn_deleteAccount.setBackground(SystemColor.activeCaption);
		btn_deleteAccount.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_deleteAccount.setBounds(0, 84, 193, 43);
		panel_navbar.add(btn_deleteAccount);

		// 標籤_科目管理
		JLabel Label_subject = new JLabel("測驗科目管理");
		Label_subject.setHorizontalAlignment(SwingConstants.CENTER);
		Label_subject.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_subject.setBounds(0, 126, 193, 43);
		panel_navbar.add(Label_subject);

		// 按鈕_新增科目
		JButton btn_addSubject = new JButton("新增科目");
		btn_addSubject.setBackground(SystemColor.activeCaption);
		btn_addSubject.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_addSubject.setBounds(0, 168, 193, 43);
		panel_navbar.add(btn_addSubject);

		// 按鈕_刪除科目
		JButton btn_deleteSubject = new JButton("刪除科目");
		btn_deleteSubject.setBackground(SystemColor.activeCaption);
		btn_deleteSubject.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_deleteSubject.setBounds(0, 210, 193, 43);
		panel_navbar.add(btn_deleteSubject);

		// 標籤_群組管理
		JLabel Label_group = new JLabel("測驗群組管理");
		Label_group.setHorizontalAlignment(SwingConstants.CENTER);
		Label_group.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_group.setBounds(0, 252, 193, 43);
		panel_navbar.add(Label_group);

		// 按鈕_新增群組
		JButton btn_addGroup = new JButton("新增群組");
		btn_addGroup.setBackground(SystemColor.activeCaption);
		btn_addGroup.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_addGroup.setBounds(0, 294, 193, 43);
		panel_navbar.add(btn_addGroup);

		// 按鈕_編輯群組
		JButton btn_editGroup = new JButton("編輯群組");
		btn_editGroup.setBackground(SystemColor.activeCaption);
		btn_editGroup.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_editGroup.setBounds(0, 336, 193, 43);
		panel_navbar.add(btn_editGroup);

		// 面板_卡片
		panel_card = new JPanel();
		panel_card.setBackground(SystemColor.activeCaption);
		panel_card.setBounds(193, 44, 744, 484);
		frame.getContentPane().add(panel_card);
		panel_card.setLayout(new CardLayout(0, 0));
		c1 = (CardLayout) panel_card.getLayout();

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

		// 面板_建立帳號
		JPanel panel_createAccount = new JPanel();
		panel_createAccount.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_createAccount, "name_createAccount");
		panel_createAccount.setLayout(null);

		JLabel Label_createSglAc = new JLabel("建立單個帳號");
		Label_createSglAc.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_createSglAc.setBounds(14, 13, 179, 44);
		panel_createAccount.add(Label_createSglAc);

		JLabel Label_studentName = new JLabel("輸入學生姓名");
		Label_studentName.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_studentName.setBounds(14, 58, 179, 44);
		panel_createAccount.add(Label_studentName);

		JTextField textField_stdName = new JTextField();
		textField_stdName.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_stdName.setToolTipText("");
		textField_stdName.setBounds(14, 103, 179, 25);
		panel_createAccount.add(textField_stdName);
		textField_stdName.setColumns(10);

		JLabel Label_stdDpm = new JLabel("輸入學生科系");
		Label_stdDpm.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_stdDpm.setBounds(14, 127, 179, 44);
		panel_createAccount.add(Label_stdDpm);

		JTextField textField_stdDpm = new JTextField();
		textField_stdDpm.setToolTipText("");
		textField_stdDpm.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_stdDpm.setColumns(10);
		textField_stdDpm.setBounds(14, 172, 179, 25);
		panel_createAccount.add(textField_stdDpm);

		JLabel Label_studentAccount = new JLabel("輸入學生帳號");
		Label_studentAccount.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_studentAccount.setBounds(14, 198, 179, 44);
		panel_createAccount.add(Label_studentAccount);

		JTextField textField_stdAccount = new JTextField();
		textField_stdAccount.setToolTipText("");
		textField_stdAccount.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_stdAccount.setColumns(10);
		textField_stdAccount.setBounds(14, 242, 179, 25);
		panel_createAccount.add(textField_stdAccount);

		JLabel Label_stdPassword = new JLabel("輸入學生密碼");
		Label_stdPassword.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_stdPassword.setBounds(14, 280, 179, 44);
		panel_createAccount.add(Label_stdPassword);

		JTextField textField_stdPassword = new JTextField();
		textField_stdPassword.setToolTipText("");
		textField_stdPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_stdPassword.setColumns(10);
		textField_stdPassword.setBounds(14, 324, 179, 25);
		panel_createAccount.add(textField_stdPassword);

		JButton btn_sure_account = new JButton("確定");
		btn_sure_account.setBackground(SystemColor.activeCaption);
		btn_sure_account.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_sure_account.setBounds(207, 324, 99, 25);
		panel_createAccount.add(btn_sure_account);

		JLabel Label_create = new JLabel("!!! 建立成功 !!!");
		Label_create.setForeground(new Color(255, 102, 102));
		Label_create.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_create.setBounds(320, 324, 197, 25);
		panel_createAccount.add(Label_create);
		Label_create.setVisible(false);

		JLabel Label_lotsAccount = new JLabel("建立多個帳號");
		Label_lotsAccount.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_lotsAccount.setBounds(14, 362, 179, 44);
		panel_createAccount.add(Label_lotsAccount);

		JButton btn_chooseFile = new JButton("選擇檔案");
		btn_chooseFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_chooseFile.setBackground(SystemColor.activeCaption);
		btn_chooseFile.setBounds(14, 411, 99, 25);
		panel_createAccount.add(btn_chooseFile);

		// btn_sure_account增加互動 新增帳號檔案
		btn_sure_account.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				File dir_file_create = new File("D:/KYUTES/帳號/"); /* 路徑跟檔名 */
				String tmp2 = "";
				try {
					tmp2 = new String(textField_stdDpm.getText().getBytes("UTF-8"), "UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				File file_create = new File(dir_file_create, tmp2 + ".csv");
				dir_file_create.mkdirs();
				try {
					file_create.createNewFile();
					StringBuilder sb = new StringBuilder();
					sb.append(textField_stdDpm.getText());
					sb.append(',');
					sb.append(textField_stdAccount.getText());
					sb.append(',');
					sb.append(textField_stdName.getText());
					sb.append(',');
					sb.append(',');
					sb.append(',');
					sb.append(',');
					sb.append(textField_stdPassword.getText());
					sb.append(',');
					sb.append('\n');
					String sb2 = new String(sb.toString().getBytes("UTF-8"), "UTF-8");
					FileWriter writer = new FileWriter(file_create, true); // 建立一個寫入檔案的物件，這裡的false表示不在檔案的末尾新增
					writer.write(sb2);
					writer.flush();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Label_create.setVisible(true);
			}
		});

		// btn_chooseFile增加互動 新增帳號檔案
		btn_chooseFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					tryReader.readFile("D:\\");
					CSVReader reader = new CSVReader(tryReader.filePath);
					String line = "";
					String nameDpm = "";
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
						String[] lineSplit = line.split(",");
						nameDpm = new String(lineSplit[0].getBytes("UTF-8"), "UTF-8");
						File dir_file_create = new File("D:/KYUTES/帳號/"); /* 路徑跟檔名 */
						File file_create = new File(dir_file_create, nameDpm + ".csv");
						dir_file_create.mkdirs();
						try {
							file_create.createNewFile();
							FileWriter writer = new FileWriter(file_create, true); // 建立一個寫入檔案的物件，這裡的false表示不在檔案的末尾新增
							line = new String(line.getBytes("UTF-8"), "UTF-8");
							writer.write(line + "\n");
							writer.flush();
							writer.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					Label_create.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// 面板_刪除帳號
		JPanel panel_deleteAccount = new JPanel();
		panel_deleteAccount.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_deleteAccount, "name_deleteAccount");
		panel_deleteAccount.setLayout(null);

		JLabel Label_deleteSglAc = new JLabel("刪除單個帳號");
		Label_deleteSglAc.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_deleteSglAc.setBounds(14, 13, 179, 44);
		panel_deleteAccount.add(Label_deleteSglAc);

		JLabel Label_stdDpm_del = new JLabel("輸入學生科系");
		Label_stdDpm_del.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_stdDpm_del.setBounds(14, 58, 179, 44);
		panel_deleteAccount.add(Label_stdDpm_del);

		JTextField textField_stdDpm_del = new JTextField();
		textField_stdDpm_del.setToolTipText("");
		textField_stdDpm_del.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_stdDpm_del.setColumns(10);
		textField_stdDpm_del.setBounds(14, 103, 179, 25);
		panel_deleteAccount.add(textField_stdDpm_del);

		JLabel Label_stdAccount_del = new JLabel("輸入學生帳號");
		Label_stdAccount_del.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_stdAccount_del.setBounds(14, 127, 179, 44);
		panel_deleteAccount.add(Label_stdAccount_del);

		JTextField textField_stdAccount_del = new JTextField();
		textField_stdAccount_del.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_stdAccount_del.setToolTipText("");
		textField_stdAccount_del.setBounds(14, 172, 179, 25);
		panel_deleteAccount.add(textField_stdAccount_del);
		textField_stdAccount_del.setColumns(10);

		JButton btn_sure_accDel = new JButton("確定");
		btn_sure_accDel.setBackground(SystemColor.activeCaption);
		btn_sure_accDel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_sure_accDel.setBounds(207, 172, 99, 25);
		panel_deleteAccount.add(btn_sure_accDel);

		JLabel Label_accDel = new JLabel("!!! 刪除成功 !!!");
		Label_accDel.setForeground(new Color(255, 102, 102));
		Label_accDel.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_accDel.setBounds(320, 172, 197, 25);
		panel_deleteAccount.add(Label_accDel);
		Label_accDel.setVisible(false);

		// File file_rename = new File("D:/KYUTES/帳號/" + textField_stdDpm_del.getText()
		// + "1.csv");
		// btn_sure_accDel增加互動 刪除帳號檔案
		btn_sure_accDel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					File file_delete = new File("D:/KYUTES/帳號/" + textField_stdDpm_del.getText() + ".csv");
					CSVReader reader = new CSVReader(file_delete.getAbsolutePath());
					String line = "";
					String nameDpm = "";
					File file_create = null;
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
						String[] lineSplit = line.split(",");
						if (!(lineSplit[1].equals(textField_stdAccount_del.getText()))) {
							nameDpm = new String(lineSplit[0].getBytes("UTF-8"), "UTF-8");
							File dir_file_create = new File("D:/KYUTES/帳號/"); /* 路徑跟檔名 */
							file_create = new File(dir_file_create, nameDpm + "1.csv");
							dir_file_create.mkdirs();
							try {
								file_create.createNewFile();
								FileWriter writer = new FileWriter(file_create, true); // 建立一個寫入檔案的物件，這裡的false表示不在檔案的末尾新增
								line = new String(line.getBytes("UTF-8"), "UTF-8");
								writer.write(line + "\n");
								writer.flush();
								writer.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
					}
					CSVReader.reader.close();
					Path path = Paths.get("D:/KYUTES/帳號/" + textField_stdDpm_del.getText() + ".csv");
					try {
						Files.delete(path);
					} catch (IOException e) {
						e.printStackTrace();
					}
					file_create.renameTo(file_delete);
					Label_accDel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// 面板_新增科目
		JPanel panel_addSubject = new JPanel();
		panel_addSubject.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_addSubject, "name_addSubject");
		panel_addSubject.setLayout(null);

		JLabel Label_addSubject = new JLabel("新增科目");
		Label_addSubject.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_addSubject.setBounds(14, 13, 179, 44);
		panel_addSubject.add(Label_addSubject);

		JLabel Label_subjectName = new JLabel("輸入科目名稱");
		Label_subjectName.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_subjectName.setBounds(14, 58, 179, 44);
		panel_addSubject.add(Label_subjectName);

		// 文字框_輸入科目
		JTextField textField_add = new JTextField();
		textField_add.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_add.setToolTipText("");
		textField_add.setBounds(14, 103, 179, 25);
		panel_addSubject.add(textField_add);
		textField_add.setColumns(10);
		String subjectName = textField_add.getText();

		JButton btn_sure = new JButton("確定");
		btn_sure.setBackground(SystemColor.activeCaption);
		btn_sure.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_sure.setBounds(207, 103, 99, 25);
		panel_addSubject.add(btn_sure);

		JLabel Label_success = new JLabel("");
		Label_success.setForeground(new Color(255, 102, 102));
		Label_success.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_success.setBounds(320, 103, 197, 25);
		panel_addSubject.add(Label_success);
		Label_success.setVisible(false);

		// btn_sure增加互動 新增資料夾
		btn_sure.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				File dir_file_add = new File("D:/KYUTES/題庫/" + textField_add.getText()); /* 路徑跟檔名 */
				dir_file_add.mkdirs();
				Label_success.setText("!!! 新增科目  " + dir_file_add.getName() + "  成功 !!!");
				Label_success.setVisible(true);
			}
		});

		// 面板_刪除科目
		JPanel panel_deleteSubject = new JPanel();
		panel_deleteSubject.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_deleteSubject, "name_deleteSubject");
		panel_deleteSubject.setLayout(null);

		JLabel Label_deleteSubject = new JLabel("刪除科目");
		Label_deleteSubject.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_deleteSubject.setBounds(14, 13, 179, 44);
		panel_deleteSubject.add(Label_deleteSubject);

		JLabel Label_subjectName_delete = new JLabel("輸入科目名稱");
		Label_subjectName_delete.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_subjectName_delete.setBounds(14, 58, 179, 44);
		panel_deleteSubject.add(Label_subjectName_delete);

		textField = new JTextField();
		textField.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField.setToolTipText("");
		textField.setBounds(14, 103, 179, 25);
		panel_deleteSubject.add(textField);
		textField.setColumns(10);
		subjectName = textField.getText();

		JButton btn_sure_delete = new JButton("確定");
		btn_sure_delete.setBackground(SystemColor.activeCaption);
		btn_sure_delete.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_sure_delete.setBounds(207, 103, 99, 25);
		panel_deleteSubject.add(btn_sure_delete);

		JLabel Label_delete = new JLabel("!!! 刪除成功 !!!" + subjectName);
		Label_delete.setForeground(new Color(255, 102, 102));
		Label_delete.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_delete.setBounds(320, 103, 197, 25);
		panel_deleteSubject.add(Label_delete);
		Label_delete.setVisible(false);

		// btn_sure_delete增加互動 刪除資料夾
		btn_sure_delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				File dir_file_delete = new File("D:/KYUTES/題庫/" + textField.getText()); /* 路徑跟檔名 */
				dir_file_delete.delete();
				Label_delete.setVisible(true);
			}
		});

		// 面板_新增群組
		JPanel panel_addGroup = new JPanel();
		panel_addGroup.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_addGroup, "name_addGroup");
		panel_addGroup.setLayout(null);

		JLabel Label_addGroup = new JLabel("新增群組");
		Label_addGroup.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_addGroup.setBounds(14, 13, 179, 44);
		panel_addGroup.add(Label_addGroup);

		JLabel Label_groupName_add = new JLabel("輸入群組名稱");
		Label_groupName_add.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_groupName_add.setBounds(14, 58, 179, 44);
		panel_addGroup.add(Label_groupName_add);

		JTextField textField_groupName = new JTextField();
		textField_groupName.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_groupName.setToolTipText("");
		textField_groupName.setBounds(14, 103, 179, 25);
		panel_addGroup.add(textField_groupName);
		textField_groupName.setColumns(10);

		JLabel Label_groupFile = new JLabel("選擇群組名單");
		Label_groupFile.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_groupFile.setBounds(14, 127, 179, 44);
		panel_addGroup.add(Label_groupFile);

		JTextField textField_fileName = new JTextField();
		textField_fileName.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_fileName.setToolTipText("");
		textField_fileName.setBounds(14, 172, 179, 25);
		panel_addGroup.add(textField_fileName);
		textField_fileName.setColumns(10);

		JButton btn_groupFile = new JButton("選擇檔案");
		btn_groupFile.setBackground(SystemColor.activeCaption);
		btn_groupFile.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_groupFile.setBounds(207, 172, 99, 25);
		panel_addGroup.add(btn_groupFile);

		JButton btn_sure_groupAdd = new JButton("確定");
		btn_sure_groupAdd.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_sure_groupAdd.setBackground(SystemColor.activeCaption);
		btn_sure_groupAdd.setBounds(326, 172, 99, 25);
		panel_addGroup.add(btn_sure_groupAdd);

		JLabel Label_groupAdd = new JLabel("!!! 新增成功 !!!");
		Label_groupAdd.setForeground(new Color(255, 102, 102));
		Label_groupAdd.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_groupAdd.setBounds(439, 172, 197, 25);
		panel_addGroup.add(Label_groupAdd);
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

		// 面板_編輯群組
		JPanel panel_editGroup = new JPanel();
		panel_editGroup.setBackground(SystemColor.inactiveCaptionBorder);
		panel_card.add(panel_editGroup, "name_editGroup");
		panel_editGroup.setLayout(null);

		JLabel Label_editGroup = new JLabel("編輯群組");
		Label_editGroup.setFont(new Font("微軟正黑體", Font.BOLD, 18));
		Label_editGroup.setBounds(14, 13, 179, 44);
		panel_editGroup.add(Label_editGroup);

		JLabel Label_groupName_edit = new JLabel("選擇群組檔案");
		Label_groupName_edit.setFont(new Font("微軟正黑體", Font.BOLD, 16));
		Label_groupName_edit.setBounds(14, 58, 179, 44);
		panel_editGroup.add(Label_groupName_edit);

		JTextField textField_groupName_edit = new JTextField();
		textField_groupName_edit.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		textField_groupName_edit.setToolTipText("");
		textField_groupName_edit.setBounds(14, 103, 179, 25);
		panel_editGroup.add(textField_groupName_edit);
		textField_groupName.setColumns(10);

		JButton btn_groupFile_edit = new JButton("選擇檔案");
		btn_groupFile_edit.setBackground(SystemColor.activeCaption);
		btn_groupFile_edit.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_groupFile_edit.setBounds(207, 103, 99, 25);
		panel_editGroup.add(btn_groupFile_edit);

		JButton btn_sure_groupEdit = new JButton("確定");
		btn_sure_groupEdit.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btn_sure_groupEdit.setBackground(SystemColor.activeCaption);
		btn_sure_groupEdit.setBounds(326, 103, 99, 25);
		panel_editGroup.add(btn_sure_groupEdit);

		JLabel Label_groupEdit = new JLabel("!!! 刪除成功 !!!");
		Label_groupEdit.setForeground(new Color(255, 102, 102));
		Label_groupEdit.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		Label_groupEdit.setBounds(439, 103, 197, 25);
		panel_editGroup.add(Label_groupEdit);
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
				File originalFile = new File(tryReader.filePath);
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

		// 按鈕加互動_個人資料設定
		Label_Kytues.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_initial");
			}
		});

		// 按鈕加互動_建立帳號
		btn_createAccount.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseExited(MouseEvent e) {
				btn_createAccount.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_createAccount");
			}
		});
		btn_createAccount.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_createAccount.setBackground(Color.WHITE);
			}
		});

		// 刪除帳號
		btn_deleteAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_deleteAccount.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_deleteAccount");
			}
		});
		btn_deleteAccount.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_deleteAccount.setBackground(Color.WHITE);
			}
		});

		// 新增科目
		btn_addSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_addSubject.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_addSubject");
			}
		});
		btn_addSubject.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_addSubject.setBackground(Color.WHITE);
			}
		});

		// 刪除科目
		btn_deleteSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_deleteSubject.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_deleteSubject");
			}
		});
		btn_deleteSubject.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_deleteSubject.setBackground(Color.WHITE);
			}
		});

		// 新增群組
		btn_addGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_addGroup.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_addGroup");
			}
		});
		btn_addGroup.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_addGroup.setBackground(Color.WHITE);
			}
		});

		// 編輯群組
		btn_editGroup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btn_editGroup.setBackground(SystemColor.activeCaption);
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				c1.show(panel_card, "name_editGroup");
			}
		});
		btn_editGroup.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btn_editGroup.setBackground(Color.WHITE);
			}
		});
	}
}