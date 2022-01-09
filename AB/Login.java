package AB;

import java.awt.*;
import javax.swing.*;

//import StudentA;

import java.awt.event.*;

public class Login extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();
	JPanel jp1, jp2, jp3;// 面板
	JLabel jlb1, jlb2;
	JButton jb1, jb2;// 按钮


	public Login() {
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jlb1 = new JLabel("學生介面");

		jb2 = new JButton("我是學生");

		frame.setLayout(new GridLayout(3, 1));

		jp1.add(jlb1);
		jp3.add(jb2);

		// 加入到JFrame
		frame.add(jp2);
		frame.add(jp1);
		// this.add(jp2);
		frame.add(jp3);

		frame.setTitle("用戶登入頁面");
		frame.setSize(400, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		jb2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
				new StudentA();
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}