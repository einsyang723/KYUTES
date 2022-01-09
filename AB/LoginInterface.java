package AB;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginInterface extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton login = new JButton("登入");
	JButton exit = new JButton("退出");
	JLabel name = new JLabel("使用者名稱：");
	JLabel password = new JLabel("密碼：");
	JTextField JName = new JTextField(10); // 明文賬號輸入
	JPasswordField JPassword = new JPasswordField(10); // 非明文密碼輸入；
	JButton register = new JButton("註冊");
	JButton forgot = new JButton("忘記密碼");

	public LoginInterface() {
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(4, 2)); // 3行2列的面板jp（網格佈局）

		name.setHorizontalAlignment(SwingConstants.RIGHT); // 設定該元件的對齊方式為向右對齊
		password.setHorizontalAlignment(SwingConstants.RIGHT);

		jp.add(name); // 將內容加到面板jp上
		jp.add(JName);
		jp.add(password);
		jp.add(JPassword);
		jp.add(login);
		jp.add(exit);
		jp.add(register);
		jp.add(forgot);

		login.addActionListener(this);// 登入增加事件監聽
		exit.addActionListener(this);// 退出增加事件監聽
		forgot.addActionListener(this);
		register.addActionListener(this);

		this.add(jp, BorderLayout.CENTER); // 將整塊面板定義在中間

		this.setTitle("登入");
		this.setLocation(500, 300); // 設定初始位置
		this.pack(); // 表示隨著面板自動調整大小
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) // 對時間進行處理
	{

		if ((e.getSource() == exit)) {
			int i = JOptionPane.showConfirmDialog(null, "確認要退出嗎？", "確認", JOptionPane.YES_NO_OPTION);
			// 顯示選擇對話方塊
			if (i == JOptionPane.YES_OPTION)
				;
			System.exit(0);
		} else {
			if (JName.getText().equals("123") && String.valueOf(JPassword.getPassword()).equals("123")) {
				JOptionPane.showMessageDialog(null, "登入成功！");
				// 顯示資訊提示框
				this.dispose();
				new Login();
			} else {
				JOptionPane.showMessageDialog(null, "使用者或密碼錯誤！請重新登入！");
				// 顯示資訊提示框
				JName.setText("");
				JPassword.setText("");
			}
		}
	}

	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new Login();
	}
}