package view;

import java.awt.BorderLayout;
import java.lang.reflect.InvocationTargetException;
import java.security.spec.DSAGenParameterSpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import model.BaiHatModel;

import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

public class ManagerView extends JFrame {
	private ArrayList<BaiHatModel> baiHatModels = new ArrayList<>();
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;
	private JTextField findFiled;
	private String value;
	

	public ManagerView() {
		setTitle("Ứng Dụng Quản Lí Bài Hát Karaoke");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\logo3.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 1280, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton addButton = new JButton("Thêm Bài Hát");
		addButton.setIcon(new ImageIcon("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\them.png"));
		addButton.setBackground(new Color(0, 204, 255));
		addButton.setForeground(new Color(0, 0, 153));
		addButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddNewView addNewView = new AddNewView(ManagerView.this);
				addNewView.setVisible(true);
			}
		});
		addButton.setBounds(247, 498, 166, 35);
		contentPane.add(addButton);

		JButton updateButton = new JButton("Sửa");
		updateButton.setIcon(new ImageIcon("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\sua.png"));
		updateButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		updateButton.setForeground(new Color(0, 0, 153));
		updateButton.setBackground(new Color(0, 204, 255));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UpdateView updateView = new UpdateView(ManagerView.this);
					updateView.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Chọn Hàng Cần Sửa!");
				}

			}
		});
		updateButton.setBounds(460, 498, 140, 35);
		contentPane.add(updateButton);

		JButton deleteButton = new JButton("Xóa");
		deleteButton.setIcon(new ImageIcon("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\xoa.png"));
		deleteButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int chon = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa bài hát: " + tenBaihat(),
							"Message", JOptionPane.YES_NO_OPTION);
					if (chon == JOptionPane.YES_OPTION) {
						xoaBaiHat();
						xoaHang();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Chọn Hàng Cần Xóa!");
				}
			}
		});
		deleteButton.setForeground(new Color(0, 0, 153));
		deleteButton.setBackground(new Color(0, 204, 255));
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteButton.setBounds(639, 498, 140, 35);
		contentPane.add(deleteButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 155, 1140, 300);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 B\u00E0i H\u00E1t", "T\u00EAn B\u00E0i H\u00E1t",
						"L\u1EDDi M\u1EDF \u0110\u1EA7u", "Th\u1EC3 Lo\u1EA1i", "Ca S\u0129", "Nh\u1EA1c S\u0129",
						"L\u1EDDi B\u00E0i H\u00E1t" }));

		findFiled = new JTextField();

		findFiled.setHorizontalAlignment(SwingConstants.LEFT);
		findFiled.setFont(new Font("Tahoma", Font.BOLD, 12));
		findFiled.setBounds(306, 108, 488, 36);
		contentPane.add(findFiled);
		findFiled.setColumns(10);

		JButton findButton = new JButton("Tìm Kiếm");
		findButton.setIcon(new ImageIcon("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\timkem.png"));
		findButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				timKiemBaiHat();

			}
		});
		findButton.setBackground(new Color(0, 204, 255));
		findButton.setForeground(new Color(0, 0, 153));
		findButton.setFont(new Font("Tahoma", Font.BOLD, 14));

		findButton.setBounds(836, 108, 166, 35);
		contentPane.add(findButton);

		JLabel karaLabel = new JLabel("Danh Sách Bài Hát Karaoke");
		karaLabel.setBackground(new Color(0, 0, 153));
		karaLabel.setForeground(new Color(0, 0, 153));
		karaLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
		karaLabel.setBounds(372, 35, 475, 35);
		contentPane.add(karaLabel);

		JButton sortButton = new JButton("Sắp Xếp");
		sortButton.setIcon(new ImageIcon("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\sapxep.png"));
		sortButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableModel.setNumRows(0);
				showData();

			}
		});
		sortButton.setForeground(new Color(0, 0, 153));
		sortButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		sortButton.setBackground(new Color(0, 204, 255));
		sortButton.setBounds(824, 498, 128, 35);
		contentPane.add(sortButton);

		JButton xemCtButton = new JButton("Xem Chi Tiết Lời Bài Hát");
		xemCtButton.setIcon(new ImageIcon("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\xemchitiet.png"));
		xemCtButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					InformationView informationView = new InformationView(ManagerView.this);
					informationView.setVisible(true);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Chọn Bài Hát Muốn Xem!");
				}

			}
		});
         
		xemCtButton.setForeground(new Color(0, 0, 153));
		xemCtButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		xemCtButton.setBackground(new Color(0, 204, 255));
		xemCtButton.setBounds(988, 498, 241, 35);
		contentPane.add(xemCtButton);

		JButton thongKeButton = new JButton("Thống Kê");
		thongKeButton.setIcon(new ImageIcon("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\thongke.png"));
		thongKeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				BieuDoView testBieuDoView = new  BieuDoView();


			}
		});
		thongKeButton.setForeground(new Color(0, 0, 153));
		thongKeButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		thongKeButton.setBackground(new Color(0, 204, 255));
		thongKeButton.setBounds(56, 498, 148, 35);
		contentPane.add(thongKeButton);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(84);
		table.getColumnModel().getColumn(4).setPreferredWidth(81);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		tableModel = (DefaultTableModel) table.getModel();
		showData();

	}

	public void addBaiHat(BaiHatModel baiHat) {
		baiHatModels.add(baiHat);
		tableModel.addRow(new Object[] { baiHat.getMaBh(), baiHat.getTenBh(), baiHat.getLoiMoDau(), baiHat.getTheLoai(),
				baiHat.getCaSi(), baiHat.getNhacSi(), baiHat.getLoiBatHat() });
	}

	public String maBaiHat() {
		int column = 0;
		int row = table.getSelectedRow();
		value = table.getModel().getValueAt(row, column).toString();
		return value;
	}

	public String loiBaiHat() {
		int column = 6;
		int row = table.getSelectedRow();
		String loiBh = table.getModel().getValueAt(row, column).toString();
		return loiBh;
	}

	public String tenBaihat() {
		int column = 1;
		int row = table.getSelectedRow();
		String tenBh = table.getModel().getValueAt(row, column).toString();
		return tenBh;
	}

	public String loiMD() {
		int column = 2;
		int row = table.getSelectedRow();
		String loiMd = table.getModel().getValueAt(row, column).toString();
		return loiMd;
	}

	public String tLoai() {
		int column = 3;
		int row = table.getSelectedRow();
		String tLoai = table.getModel().getValueAt(row, column).toString();
		return tLoai;
	}

	public String cSi() {
		int column = 4;
		int row = table.getSelectedRow();
		String cSi = table.getModel().getValueAt(row, column).toString();
		return cSi;
	}

	public String nSi() {
		int column = 5;
		int row = table.getSelectedRow();
		String nSi = table.getModel().getValueAt(row, column).toString();
		return nSi;
	}

	public void xoaHang() {
		tableModel.removeRow(table.getSelectedRow());
	}

	

	public ArrayList<BaiHatModel> danhSach() {
		ArrayList<BaiHatModel> danhSach = new ArrayList<BaiHatModel>();
		java.sql.Connection connection;
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			connection = DriverManager.getConnection(dbURL);
			if (connection != null) {
				String query = "select * from ThongTinBaiHat";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);
				BaiHatModel bh;
				while (rs.next()) {
					bh = new BaiHatModel(rs.getString("maBh"), rs.getString("tenBh"), rs.getString("loiMoDau"),
							rs.getString("theLoai"), rs.getString("caSi"), rs.getString("nhacSi"),
							rs.getString("loiBaiHat"));
					danhSach.add(bh);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return danhSach;
	}

	public void showData() {
		ArrayList<BaiHatModel> ds = danhSach();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] row = new Object[8];
		for (int i = 0; i < ds.size(); i++) {
			row[0] = ds.get(i).getMaBh();
			row[1] = ds.get(i).getTenBh();
			row[2] = ds.get(i).getLoiMoDau();
			row[3] = ds.get(i).getTheLoai();
			row[4] = ds.get(i).getCaSi();
			row[5] = ds.get(i).getNhacSi();
			row[6] = ds.get(i).getLoiBatHat();
			tableModel.addRow(row);
		}
	}

	public void xoaBaiHat() {
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			Connection conn = DriverManager.getConnection(dbURL);
			String xoa = "delete from ThongTinBaiHat where maBh = ?";
			PreparedStatement ps = conn.prepareStatement(xoa);
			ps.setString(1, maBaiHat());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<BaiHatModel> danhSachTimKiem() {
		baiHatModels.clear();

		ArrayList<BaiHatModel> timkiem = new ArrayList<BaiHatModel>();
		java.sql.Connection connection;
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			connection = DriverManager.getConnection(dbURL);

			if (connection != null) {
				String query = "select * from ThongTinBaiHat where maBh like '%" + findFiled.getText()
						+ "%' or tenBh like N'%" + findFiled.getText() + "%'" + " or loiBaiHat like N'%"
						+ findFiled.getText() + "%'" + " or theLoai like N'%" + findFiled.getText() + "%'"
						+ " or caSi like N'%" + findFiled.getText() + "%'" + " or nhacSi like N'%" + findFiled.getText()
						+ "%'";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);
				BaiHatModel bh;
				while (rs.next()) {
					bh = new BaiHatModel(rs.getString("maBh"), rs.getString("tenBh"), rs.getString("loiMoDau"),
							rs.getString("theLoai"), rs.getString("caSi"), rs.getString("nhacSi"),
							rs.getString("loiBaiHat"));
					timkiem.add(bh);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return timkiem;
	}

	public void showDataTimKiem() {
		baiHatModels.clear();
		ArrayList<BaiHatModel> ds = danhSachTimKiem();
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		Object[] row = new Object[7];
		for (int i = 0; i < ds.size(); i++) {
			row[0] = ds.get(i).getMaBh();
			row[1] = ds.get(i).getTenBh();
			row[2] = ds.get(i).getLoiMoDau();
			row[3] = ds.get(i).getTheLoai();
			row[4] = ds.get(i).getCaSi();
			row[5] = ds.get(i).getNhacSi();
			row[6] = ds.get(i).getLoiBatHat();
			tableModel.addRow(row);
		}
	}

	public void timKiemBaiHat() {
		if (danhSachTimKiem().size() == 0) {
			JOptionPane.showMessageDialog(null, "Không Tìm Thấy!");
		} else {
			tableModel.setNumRows(0);
			showDataTimKiem();
		}

	}
}
