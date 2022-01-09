package AB;

import javax.management.modelmbean.ModelMBean;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

@SuppressWarnings("unused")
public class showonescore {

	ArrayList<student_information> arry = new ArrayList<student_information>();
	student_information stu = new student_information();
	JTable table = null;
	DefaultTableModel model = null;

	@SuppressWarnings("unchecked")
	public showonescore() {
		JFrame jf = new JFrame("我的成績資訊");
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		@SuppressWarnings("rawtypes")
		Vector columnNames = createColumnNames();
		
		String[] f = new String[7];
		try {
			FileReader f1 = new FileReader("D:\\StudentScore1.txt");
			BufferedReader br = new BufferedReader(f1);
			arry.clear();
			String t = null;
			while ((t = br.readLine()) != null) {
				f = t.split("\\s+"); // 要查詢的學生資訊
			}

			f1.close();
			br.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		File file = new File("D:\\StudentScore1.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write("");
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		@SuppressWarnings("rawtypes")
		ArrayList List = new ArrayList();
		for (int i = 0; i < 5; i++) {
			if (!f[i].equals("--"))// 需要满足的條件
				List.add(i);
		}
		// 將满足查詢條件的學生資訊登入系统
		for (int i = 0; i < List.size(); i++)
			System.out.println(List.get(i));
		try {
			FileReader f1 = new FileReader("D:\\StudentScore.txt");
			BufferedReader br = new BufferedReader(f1);
			String t = null;
			int flag = 0;
			int t1 = 0;

			arry.clear();
			while ((t = br.readLine()) != null) {
				String[] s = t.split("\\s+");
				for (int i = 0; i < List.size(); i++) {
					t1 = (int) List.get(i);
					if (f[t1].equals(s[t1])) {
						flag = flag + 1;
					}
				}
				if (flag == List.size()) {
					student_information st = new student_information(s[0], s[1], s[2], s[3], s[4], s[5], s[6]);
					arry.add(st);
				}
				flag = 0;
			}
			f1.close();
			br.close();
		} catch (IOException e) {
			// TODO 自動生成的 catch 塊
			e.printStackTrace();
		}

		@SuppressWarnings("rawtypes")
		Vector data = createTableModelData();

		model = new DefaultTableModel(data, columnNames);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(400, 80));
		JScrollPane tablePanel = new JScrollPane(table);

		// 內容
		table.setForeground(Color.BLACK);
		table.setFont(new Font(null, Font.PLAIN, 14));
		table.setSelectionForeground(Color.DARK_GRAY);
		table.setSelectionBackground(Color.LIGHT_GRAY);
		table.setGridColor(Color.GRAY);

		// 標頭
		table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));
		table.getTableHeader().setForeground(Color.RED);
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);

		// 行高
		table.setRowHeight(40);
		table.getColumnModel().getColumn(0).setPreferredWidth(40);

		table.setPreferredScrollableViewportSize(new Dimension(900, 320));

		@SuppressWarnings("rawtypes")
		RowSorter sorter = new TableRowSorter(model);
		table.setRowSorter(sorter);
		JScrollPane pane = new JScrollPane(table);

		// 把表格放到面板
		JScrollPane scrollPane = new JScrollPane(table);



		// JScrollPane pane = new JScrollPane(table);
		
		jf.setContentPane(panel);
		jf.pack();
		jf.setSize(900, 600);
		jf.add(scrollPane, BorderLayout.CENTER);
		// 數據居中顯示
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);

		jf.setLocationRelativeTo(null);
		int t = arry.size();

		if (t <= 0) {
			JOptionPane.showMessageDialog(null, "系统中没有符合條件的學生！！！");
			jf.setVisible(false);
		} else {
			jf.setVisible(true);
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Vector createColumnNames() {
		Vector columnNames = new Vector();
		// columnNames.add("序號");
		columnNames.add("學號");
		columnNames.add("姓名");
		columnNames.add(" ");
		columnNames.add("科目");
		columnNames.add("成績");
		columnNames.add(" ");
		columnNames.add(" ");

		return columnNames;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Vector createTableModelData() {
		Vector data = new Vector();
		for (int i = 0; i < arry.size(); i++) {
			Vector<String> rowData = new Vector<>();
			rowData.add(arry.get(i).getStuID());
			rowData.add(arry.get(i).getName());
			rowData.add(" ");
			rowData.add(arry.get(i).getCallnumber());
			rowData.add(arry.get(i).getPassword());
			rowData.add(" ");
			rowData.add(" ");
			data.add(rowData);

		}
		return data;
	}

}