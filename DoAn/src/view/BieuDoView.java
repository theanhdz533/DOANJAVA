package view;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.text.DefaultCaret;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import com.orsoncharts.legend.ColorScaleElement;

import model.BaiHatModel;

public class BieuDoView extends JDialog {
	private static int  dem = 0;

	public static PieDataset createDataset() {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue("Bolero", bolero());
		dataset.setValue("Nhạc Trẻ", nhacTre());
		dataset.setValue("Nhạc Vàng", nhacVang());
		dataset.setValue("Nhạc Nước Ngoài", nuocNgoai());
		dataset.setValue("EDM", edm());
		dataset.setValue("Các Loại Khác", loaiKhac());

		return dataset;
	}

	public static JFreeChart createPieChart(PieDataset dataset) {
		JFreeChart chart = ChartFactory.createPieChart("Biểu đồ tỉ lệ các thể loại bài hát".toUpperCase(), dataset,
				true, true, true);
		return chart;
	}

	public BieuDoView() {
		JFreeChart pieChart = createPieChart(createDataset());
		ChartPanel chartPanel = new ChartPanel(pieChart);
		JDialog abc = new JDialog();
		abc.add(chartPanel);
		abc.setSize(600, 400);
		abc.setLocationRelativeTo(null);
		abc.setResizable(false);
		abc.setVisible(true);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"D:\\TH\u1EBE ANH_21IT394\\H\u01AF\u1EDANG \u0110\u1ED0I T\u01AF\u1EE2NG\\\u1EA3nh \u0111\u1ED3 \u00E1n\\logo3.png"));
	}

	public static int bolero() {
		java.sql.Connection connection;
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			connection = DriverManager.getConnection(dbURL);

			if (connection != null) {
				String query = "select  count(maBh) as bolero from ThongTinBaiHat where theLoai = N'Nhạc Bolero'";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {
					dem = (Integer) (rs.getInt("bolero"));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem;
	}

	public static int nhacTre() {
		java.sql.Connection connection;
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			connection = DriverManager.getConnection(dbURL);

			if (connection != null) {
				String query = "select  count(maBh) as NhacTre from ThongTinBaiHat where theLoai = N'Nhạc Trẻ'";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {

					dem = (Integer) (rs.getInt("NhacTre"));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem;
	}

	public static int nhacVang() {
		java.sql.Connection connection;
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			connection = DriverManager.getConnection(dbURL);

			if (connection != null) {
				String query = "select  count(maBh) as NhacVang from ThongTinBaiHat where theLoai = N'Nhạc Vàng'";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {

					dem = (Integer) (rs.getInt("NhacVang"));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem;
	}

	public static int nuocNgoai() {
		java.sql.Connection connection;
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			connection = DriverManager.getConnection(dbURL);

			if (connection != null) {
				String query = "select  count(maBh) as NuocNgoai from ThongTinBaiHat where theLoai = N'Nhạc Nước Ngoài'";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {

					dem = (Integer) (rs.getInt("NuocNgoai"));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem;
	}
	public static int edm (){
		java.sql.Connection connection;
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			connection = DriverManager.getConnection(dbURL);

			if (connection != null) {
				String query = "select  count(maBh) as EDM from ThongTinBaiHat where theLoai = 'EDM'";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {

					dem = (Integer) (rs.getInt("EDM"));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem;
	}
	public static int loaiKhac (){
		java.sql.Connection connection;
		String dbURL = "jdbc:sqlserver://localhost;databaseName=DoAnJava;user=sa;password=sa";
		try {
			connection = DriverManager.getConnection(dbURL);

			if (connection != null) {
				String query = "select  count(maBh) as LoaiKhac from ThongTinBaiHat where theLoai !='EDM' \r\n" + 
						"and theLoai != N'Nhạc Bolero' and theLoai != N'Nhạc Vàng' and theLoai != N'Nhạc Trẻ'\r\n" + 
						"and theLoai != N'Nhạc Nước Ngoài'";
				Statement st = connection.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {

					dem = (Integer) (rs.getInt("LoaiKhac"));
				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dem;
	}
}
