package AB;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.io.*;

import java.util.ArrayList;
import java.util.Vector;

//读取学生信息，展示在窗口

@SuppressWarnings("unused")
public class show_stuall {

	JTable table = null;
	DefaultTableModel model = null;

	// 显示全部学生信息
	@SuppressWarnings("unchecked")
	public show_stuall() {
		JFrame jf = new JFrame("顯示學生信息");
		
		JPanel panel = new JPanel();
		
		@SuppressWarnings("rawtypes")
		Vector columnNames = createColumnNames();
		@SuppressWarnings("rawtypes")
		Vector data = createTableModelData();

		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(400, 80));
		JScrollPane tablePanel = new JScrollPane(table);
		
		table.setForeground(Color.BLACK); 
		table.setFont(new Font(null, Font.PLAIN, 14)); 
		table.setSelectionForeground(Color.DARK_GRAY); 
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setGridColor(Color.GRAY); 

		
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
		table.getTableHeader().setForeground(Color.RED); 
		table.getTableHeader().setResizingAllowed(false); 
		table.getTableHeader().setReorderingAllowed(false); 

		
		table.setRowHeight(40);

	
		table.getColumnModel().getColumn(0).setPreferredWidth(40);

		
		table.setPreferredScrollableViewportSize(new Dimension(900, 320));

		// 排序器
		@SuppressWarnings({ "rawtypes" })
		RowSorter sorter = new TableRowSorter(model);
		table.setRowSorter(sorter);
		JScrollPane pane = new JScrollPane(table);

		
		JScrollPane scrollPane = new JScrollPane(table);

		
		panel.add(scrollPane);
		// JScrollPane pane = new JScrollPane(table);
		// 设置 内容面板 到 窗口
		jf.setContentPane(panel);
		jf.pack();
		jf.setSize(900, 600);
		jf.add(scrollPane, BorderLayout.CENTER);

		// 数据居中显示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);

		jf.setLocationRelativeTo(null);
		int t = table.getRowCount();
		if (t <= 0) {
			JOptionPane.showMessageDialog(null, "系统中還没有登入學生資訊！！！");
			jf.setVisible(false);
		} else {
			jf.setVisible(true);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Vector createColumnNames() {
		Vector columnNames = new Vector();
		// columnNames.add("序号");
		columnNames.add("學號");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("年齡");
		//columnNames.add("電話");
		columnNames.add(" ");
		columnNames.add(" ");

		return columnNames;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Vector createTableModelData() {
		Vector data = new Vector();
		String t = null;
		try {
			FileReader f1 = new FileReader("D:\\student.txt");
			BufferedReader br = new BufferedReader(f1);
			// arry.clear();// 清除原数组列表中的数据
			int i = 0;
			while ((t = br.readLine()) != null) {
				String[] s = t.split(",|\\s|;"); // 通过空格分割字符串数组
				Vector rowData = new Vector();
				// rowData.add("i");
				rowData.add(s[0]);
				rowData.add(s[1]);
				rowData.add(s[2]);
				rowData.add(s[3]);
				rowData.add(" ");
				rowData.add(" ");
				rowData.add(" ");
				data.add(rowData);
				// System.out.print(s[6]);
				i++;
			}
			f1.close();
			br.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return data;
	}
}
