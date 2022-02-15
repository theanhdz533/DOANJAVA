package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.BaiHatModel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddNewView extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField maBHFiled;
	private JTextField TenField;
	private JTextField moDauFiled;
	private JTextField caSiFiled;
	private JTextField nhacSiFiled;
	private JTextField theLoaiFiled;
	public ManagerView managerView;
	private JTextArea loiBaiHatArea;
	private JButton resetlButton;

	public AddNewView(JFrame addFrame) {
		super(addFrame);
		managerView = (ManagerView) addFrame;
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\TH\u1EBE ANH_21IT394\\H\u01AF\u1EDANG \u0110\u1ED0I T\u01AF\u1EE2NG\\\u1EA3nh \u0111\u1ED3 \u00E1n\\logo3.png"));
		setTitle("Th\u00EAm B\u00E0i H\u00E1t");
		setBounds(100, 100, 640, 488);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel MaBhLabel = new JLabel("M\u00E3 B\u00E0i H\u00E1t");
		MaBhLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		MaBhLabel.setBounds(62, 62, 74, 20);
		contentPanel.add(MaBhLabel);

		JLabel TenBhLabel = new JLabel("T\u00EAn B\u00E0i H\u00E1t");
		TenBhLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		TenBhLabel.setBounds(62, 93, 92, 20);
		contentPanel.add(TenBhLabel);

		JLabel LMDLabel = new JLabel("L\u1EDDi M\u1EDF \u0110\u1EA7u");
		LMDLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		LMDLabel.setBounds(62, 124, 92, 20);
		contentPanel.add(LMDLabel);

		JLabel TheLoaiLabel = new JLabel("Th\u1EC3 Lo\u1EA1i");
		TheLoaiLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		TheLoaiLabel.setBounds(62, 160, 74, 20);
		contentPanel.add(TheLoaiLabel);

		JLabel caSiLabel = new JLabel("Ca S\u0129");
		caSiLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		caSiLabel.setBounds(62, 191, 74, 20);
		contentPanel.add(caSiLabel);

		JLabel nhacsiLabel = new JLabel("Nh\u1EA1c S\u0129");
		nhacsiLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhacsiLabel.setBounds(62, 222, 74, 20);
		contentPanel.add(nhacsiLabel);

		maBHFiled = new JTextField();
		maBHFiled.setFont(new Font("Tahoma", Font.BOLD, 12));
		maBHFiled.setBounds(210, 64, 356, 20);
		contentPanel.add(maBHFiled);
		maBHFiled.setColumns(10);

		TenField = new JTextField();
		TenField.setFont(new Font("Tahoma", Font.BOLD, 12));
		TenField.setColumns(10);
		TenField.setBounds(210, 95, 356, 20);
		contentPanel.add(TenField);

		moDauFiled = new JTextField();
		moDauFiled.setFont(new Font("Tahoma", Font.BOLD, 12));
		moDauFiled.setColumns(10);
		moDauFiled.setBounds(210, 126, 356, 20);
		contentPanel.add(moDauFiled);

		caSiFiled = new JTextField();
		caSiFiled.setFont(new Font("Tahoma", Font.BOLD, 12));
		caSiFiled.setColumns(10);
		caSiFiled.setBounds(210, 193, 356, 20);
		contentPanel.add(caSiFiled);

		nhacSiFiled = new JTextField();
		nhacSiFiled.setFont(new Font("Tahoma", Font.BOLD, 12));
		nhacSiFiled.setColumns(10);
		nhacSiFiled.setBounds(210, 224, 356, 20);
		contentPanel.add(nhacSiFiled);

		JLabel loiBaiHatFiled = new JLabel("L\u1EDDi B\u00E0i H\u00E1t");
		loiBaiHatFiled.setFont(new Font("Tahoma", Font.BOLD, 14));
		loiBaiHatFiled.setBounds(62, 253, 74, 20);
		contentPanel.add(loiBaiHatFiled);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(210, 252, 356, 120);
		contentPanel.add(scrollPane);

		loiBaiHatArea = new JTextArea(1000, 10);
		loiBaiHatArea.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(loiBaiHatArea);

		theLoaiFiled = new JTextField();
		theLoaiFiled.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		theLoaiFiled.setBounds(210, 162, 197, 20);
		contentPanel.add(theLoaiFiled);
		theLoaiFiled.setColumns(10);

		JComboBox theLoai = new JComboBox();
		theLoai.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Object index = e.getItem();
				theLoaiFiled.setText(index + "");
			}
		});

		theLoai.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		theLoai.setBounds(417, 161, 149, 22);
		theLoai.addItem("Nhạc Nước Ngoài");
		theLoai.addItem("Nhạc Vàng");
		theLoai.addItem("Nhạc Bolero");
		theLoai.addItem("Nhạc Trẻ");
		theLoai.addItem("EDM");

		contentPanel.add(theLoai);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			JButton saveButton = new JButton("Lưu");
			saveButton.addActionListener(this);
			saveButton.setBackground(new Color(0, 204, 255));
			saveButton.setForeground(new Color(0, 0, 153));
			saveButton.setFont(new Font("Tahoma", Font.BOLD, 14));
			buttonPane.add(saveButton);
			{
				resetlButton = new JButton("X\u00F3a Th\u00F4ng Tin");
				resetlButton.setForeground(new Color(0, 0, 153));
				resetlButton.setBackground(new Color(0, 204, 255));
				resetlButton.setFont(new Font("Tahoma", Font.BOLD, 14));
				resetlButton.setActionCommand("X\\u00F3a Th\\u00F4ng Tin");
				buttonPane.add(resetlButton);
			}
		}
	}

	boolean checkPK = true;
	int check1 = 0;

	public boolean themDuLieu(BaiHatModel baiHatModel) {

		// TODO Auto-generated method stub
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String them = "insert into ThongTinBaiHat(maBh,tenBh,loiMoDau,theLoai,caSi,nhacSi,loiBaiHat)"
					+ "values (?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(them);
			ps.setString(1, baiHatModel.getMaBh());
			ps.setString(2, baiHatModel.getTenBh());
			ps.setString(3, baiHatModel.getLoiMoDau());
			ps.setString(4, baiHatModel.getTheLoai());
			ps.setString(5, baiHatModel.getCaSi());
			ps.setString(6, baiHatModel.getNhacSi());
			ps.setString(7, baiHatModel.getLoiBatHat());

			return ps.executeUpdate() > 0;

		} catch (Exception e1) {

			// TODO Auto-generated catch block
			if (e1.getMessage().startsWith("Violation of PRIMARY KEY constraint 'PK_ThongTinBaiHat'.")) {
				checkPK = false;
			}

		}
		return false;

	}

	@Override

	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();

		if (src.equals("Lưu")) {
			boolean check = true;

			String maBh = maBHFiled.getText();
			String tenBh = TenField.getText();
			String loiMoDau = moDauFiled.getText();
			String theLoai = theLoaiFiled.getText();
			String caSi = caSiFiled.getText();
			String nhacSi = nhacSiFiled.getText();
			String loiBatHat = loiBaiHatArea.getText();

			if (maBh.equals("")) {
				JOptionPane.showMessageDialog(null, "Vui Lòng Thêm Mã Bài Hát!");
				check = false;
			}
			if (tenBh.equals("")) {
				JOptionPane.showMessageDialog(null, "Vui Lòng Thêm Tên Bài Hát!");
				check = false;
			}

			if (check == true) {
				BaiHatModel bh = new BaiHatModel(maBh, tenBh, loiMoDau, theLoai, caSi, nhacSi, loiBatHat);
				this.dispose();
				themDuLieu(bh);

				if (checkPK == true) {
					managerView.addBaiHat(bh);
					JOptionPane.showMessageDialog(null, "Lưu Thành Công!");
				} else {
					JOptionPane.showMessageDialog(null, "Mã Bài Hát Đã Tồn Tại!");
				}
			}

		}

	}

}
