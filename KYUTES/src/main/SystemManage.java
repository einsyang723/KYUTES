package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.BorderLayout;
import java.awt.Choice;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Scrollbar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingConstants;

public class SystemManage {

	private JFrame frameSystemManage;
	private JFrame frameAccountManage;
	private JFrame frameTestGroupManage;
	private JFrame frameSubjectManage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemManage window = new SystemManage();
					window.frameSystemManage.setVisible(true);
					window.frameAccountManage.setVisible(false);
					window.frameTestGroupManage.setVisible(false);
					window.frameSubjectManage.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SystemManage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameSystemManage = new JFrame("系統管理者介面");
		frameSystemManage.setBounds(100, 100, 850, 450);
		frameSystemManage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSystemManage.getContentPane().setLayout(null);

		frameTestGroupManage = new JFrame("測驗群組管理介面");
		frameTestGroupManage.setBounds(100, 100, 850, 450);
		frameTestGroupManage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameTestGroupManage.getContentPane().setLayout(null);

		frameSubjectManage = new JFrame("測驗科目管理介面");
		frameSubjectManage.setBounds(100, 100, 850, 450);
		frameSubjectManage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameSubjectManage.getContentPane().setLayout(null);

		JButton accountManageButton = new JButton("使用者帳號管理");
		accountManageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				initializeAccountManage();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				accountManageButton.setBackground(Color.LIGHT_GRAY);
			}
		});
		accountManageButton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				accountManageButton.setBackground(Color.WHITE);
			}
		});
		accountManageButton.setForeground(Color.BLACK);
		accountManageButton.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		accountManageButton.setBackground(Color.LIGHT_GRAY);
		accountManageButton.setBounds(300, 71, 230, 50);
		frameSystemManage.getContentPane().add(accountManageButton);

		JButton btnNewButton_1 = new JButton("測驗群組管理");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameSystemManage.dispose();
				frameTestGroupManage.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_1.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnNewButton_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnNewButton_1.setBackground(Color.WHITE);
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btnNewButton_1.setBounds(300, 161, 230, 50);
		frameSystemManage.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("測驗科目管理");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frameSystemManage.dispose();
				frameSubjectManage.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setBackground(Color.LIGHT_GRAY);
			}
		});
		btnNewButton_2.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnNewButton_2.setBackground(Color.WHITE);
			}
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		btnNewButton_2.setBounds(300, 250, 230, 50);
		frameSystemManage.getContentPane().add(btnNewButton_2);
	}

	private void initializeAccountManage() {
		frameAccountManage = new JFrame("使用者帳號管理介面");
		frameAccountManage.setBounds(100, 100, 850, 450);
		frameAccountManage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameAccountManage.getContentPane().setLayout(null);

		JButton addAccountButton = new JButton("新增使用者帳號");
		addAccountButton.setForeground(Color.BLACK);
		addAccountButton.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		addAccountButton.setBackground(Color.LIGHT_GRAY);
		addAccountButton.setBounds(300, 100, 230, 50);
		frameAccountManage.getContentPane().add(addAccountButton);

		JButton deleteAccountButton = new JButton("刪除使用者帳號");
		deleteAccountButton.setForeground(Color.BLACK);
		deleteAccountButton.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		deleteAccountButton.setBackground(Color.LIGHT_GRAY);
		deleteAccountButton.setBounds(300, 200, 230, 50);
		frameAccountManage.getContentPane().add(deleteAccountButton);

		frameSystemManage.dispose();
		frameAccountManage.setVisible(true);
	}
}