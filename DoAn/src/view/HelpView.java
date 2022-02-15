package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class HelpView extends JFrame {

	private JPanel contentPane;

	public HelpView() {
		setTitle("Tr\u1EE3 Gi\u00FAp");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\TH\u1EBE ANH_21IT394\\H\u01AF\u1EDANG \u0110\u1ED0I T\u01AF\u1EE2NG\\\u1EA3nh \u0111\u1ED3 \u00E1n\\logo3.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 679, 359);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhà Phát Triển");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setBounds(259, 47, 153, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Võ Thế Anh");
		lblNewLabel_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(299, 78, 105, 17);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Trần Văn Đức Anh");
		lblNewLabel_1_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(282, 106, 142, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblThngTinLin = new JLabel("Thông Tin Liên Hệ");
		lblThngTinLin.setForeground(new Color(0, 0, 153));
		lblThngTinLin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblThngTinLin.setBounds(255, 148, 193, 25);
		contentPane.add(lblThngTinLin);
		
		JLabel lblNewLabel_1_2 = new JLabel("Mail 1 : anhvt.21it@vku.udn.vn\r\n");
		lblNewLabel_1_2.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(259, 179, 230, 17);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Mail 2 : anhtvd.21it@vku.udn.vn");
		lblNewLabel_1_2_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1.setBounds(259, 207, 230, 17);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("SDT 1: 0961735552");
		lblNewLabel_1_2_1_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1.setBounds(259, 235, 230, 17);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("SDT 2: 093468798");
		lblNewLabel_1_2_1_1_1.setForeground(new Color(255, 102, 0));
		lblNewLabel_1_2_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2_1_1_1.setBounds(259, 263, 230, 17);
		contentPane.add(lblNewLabel_1_2_1_1_1);
		
	}
}
