package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateView extends JDialog {
	private JTextField maBhField;
	private JTextField theLoaiFiled;
	private ManagerView managerView;
	private JTextArea tenBhArea;
	private JTextArea loiMd;
	private JTextArea nhacSi;
	private JTextArea caSi;
	private JTextArea loiBHArea;	

	public UpdateView(JFrame addFrame) {
		super(addFrame);
		managerView = (ManagerView) addFrame;
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\TH\u1EBE ANH_21IT394\\H\u01AF\u1EDANG \u0110\u1ED0I T\u01AF\u1EE2NG\\\u1EA3nh \u0111\u1ED3 \u00E1n\\logo3.png"));
		setTitle("Sửa Thông Tin Bài Hát");
		setBounds(100, 100, 645, 496);
		getContentPane().setLayout(null);

		maBhField = new JTextField();
		maBhField.setText(managerView.maBaiHat());
		maBhField.setFont(new Font("Tahoma", Font.BOLD, 12));
		maBhField.setColumns(10);
		maBhField.setBounds(234, 73, 291, 20);
		getContentPane().add(maBhField);

		theLoaiFiled = new JTextField();
		theLoaiFiled.setText(managerView.tLoai());
		theLoaiFiled.setFont(new Font("Tahoma", Font.BOLD, 12));
		theLoaiFiled.setColumns(5);
		theLoaiFiled.setBounds(234, 166, 147, 20);
		getContentPane().add(theLoaiFiled);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(234, 274, 290, 124);
		getContentPane().add(scrollPane);

		 loiBHArea = new JTextArea(100,100);
		 loiBHArea.setTabSize(1000);
		loiBHArea.setText(managerView.loiBaiHat());
		loiBHArea.setFont(new Font("Tahoma", Font.BOLD, 14));
		scrollPane.setViewportView(loiBHArea);

		JComboBox theLoaiComboBox = new JComboBox();
		theLoaiComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object index = e.getItem();
				theLoaiFiled.setText(index + "");
			}
		});
		theLoaiComboBox.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		theLoaiComboBox.addItem("Nhạc Nước Ngoài");
		theLoaiComboBox.addItem("Nhạc Vàng");
		theLoaiComboBox.addItem("Nhạc Bolero");
		theLoaiComboBox.addItem("Nhạc Trẻ");
		theLoaiComboBox.addItem("EDM");
		theLoaiComboBox.setBounds(391, 166, 134, 22);
		getContentPane().add(theLoaiComboBox);

		JLabel lblNewLabel = new JLabel("Mã Bài Hát");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setBounds(103, 73, 86, 17);
		getContentPane().add(lblNewLabel);

		JLabel lblTnBiHt = new JLabel("Tên Bài Hát");
		lblTnBiHt.setForeground(new Color(0, 0, 51));
		lblTnBiHt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnBiHt.setBounds(103, 107, 86, 17);
		getContentPane().add(lblTnBiHt);

		JLabel lblLiMu = new JLabel("Lời Mở Đầu");
		lblLiMu.setForeground(new Color(0, 0, 51));
		lblLiMu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLiMu.setBounds(103, 138, 86, 17);
		getContentPane().add(lblLiMu);

		JLabel lblNewLabel_2_1 = new JLabel("Thể Loại");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 51));
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(103, 169, 86, 17);
		getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("Ca Sĩ");
		lblNewLabel_2_2.setForeground(new Color(0, 0, 51));
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_2.setBounds(103, 200, 86, 17);
		getContentPane().add(lblNewLabel_2_2);

		JLabel lblNewLabel_2_3 = new JLabel("Nhạc Sĩ");
		lblNewLabel_2_3.setForeground(new Color(0, 0, 51));
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_3.setBounds(103, 231, 86, 17);
		getContentPane().add(lblNewLabel_2_3);

		JLabel lblNewLabel_2_4 = new JLabel("Lời Bài Hát");
		lblNewLabel_2_4.setForeground(new Color(0, 0, 51));
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2_4.setBounds(103, 265, 86, 17);
		getContentPane().add(lblNewLabel_2_4);

		 tenBhArea = new JTextArea();
		tenBhArea.setFont(new Font("Tahoma", Font.BOLD, 12));
		tenBhArea.setText(managerView.tenBaihat());
		tenBhArea.setBounds(234, 104, 291, 22);
		getContentPane().add(tenBhArea);

		 loiMd = new JTextArea();

		loiMd.setText(managerView.loiMD());
		loiMd.setFont(new Font("Tahoma", Font.BOLD, 12));
		loiMd.setBounds(234, 133, 291, 22);
		getContentPane().add(loiMd);

		 caSi = new JTextArea();
		caSi.setText(managerView.cSi());
		
		caSi.setFont(new Font("Tahoma", Font.BOLD, 12));
		caSi.setBounds(234, 197, 291, 22);
		getContentPane().add(caSi);

		 nhacSi = new JTextArea();
		nhacSi.setText(managerView.nSi());

		nhacSi.setFont(new Font("Tahoma", Font.BOLD, 12));
		nhacSi.setBounds(234, 229, 291, 22);
		getContentPane().add(nhacSi);
		
		JButton saveButton = new JButton("Lưu");
		saveButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {				
					sua();								
				UpdateView.this.setVisible(false);			
			}
		});
		
		saveButton.setForeground(new Color(0, 0, 153));
		saveButton.setBackground(new Color(0, 204, 255));
		saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		saveButton.setBounds(439, 421, 104, 25);
		getContentPane().add(saveButton);
	}
	public void sua() {
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String sua = "update ThongTinBaiHat set tenBh = N'"+
					tenBhArea.getText()+"'"+
					", loiMoDau = N'"+loiMd.getText()+"'"+
					", theLoai = N'"+theLoaiFiled.getText()+"'"+
					", caSi = N'"+caSi.getText()+"'"+
					", nhacSi = N'"+nhacSi.getText()+"'"+
					", loiBaiHat = N'"+loiBHArea.getText()+"' where maBh ='" +managerView.maBaiHat()+"'";
			PreparedStatement ps = conn.prepareStatement(sua);		
			ps.executeUpdate();
			managerView.tableModel.setNumRows(0);
			JOptionPane.showMessageDialog(null,"Sửa Thành Công!");
			managerView.showData();
			

		} catch (Exception e1) {
			
			e1.printStackTrace();
		}
	}
}
