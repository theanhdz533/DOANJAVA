package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import java.awt.Button;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainView() {
		setTitle("Karaoke List");
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\TH\u1EBE ANH_21IT394\\H\u01AF\u1EDANG \u0110\u1ED0I T\u01AF\u1EE2NG\\\u1EA3nh \u0111\u1ED3 \u00E1n\\logo3.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 471);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton ButtongLogin = new JButton("Truy C\u1EADp \u1EE8ng D\u1EE5ng");
		ButtongLogin.setIcon(new ImageIcon("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\truycapungdung.png"));
		ButtongLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ManagerView().setVisible(true);
			}
		});
		ButtongLogin.setForeground(new Color(0, 0, 153));
		ButtongLogin.setBackground(new Color(0, 204, 255));
		ButtongLogin.setFont(new Font("Tahoma", Font.BOLD, 14));
		ButtongLogin.setBounds(284, 253, 226, 49);
	
		contentPane.add(ButtongLogin);
		
		JButton helpButton = new JButton("Tr\u1EE3 Gi\u00FAp");
		helpButton.setIcon(new ImageIcon("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\help.png"));
		helpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new HelpView().setVisible(true);
			}
		});
		helpButton.setBackground(new Color(0, 204, 255));
		helpButton.setForeground(new Color(0, 0, 153));
		helpButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		helpButton.setBounds(284, 313, 226, 49);
	
		contentPane.add(helpButton);
		
		JLabel imageBack = new JLabel("");
		imageBack.setIcon(new ImageIcon("D:\\TH\u1EBE ANH_21IT394\\H\u01AF\u1EDANG \u0110\u1ED0I T\u01AF\u1EE2NG\\\u1EA3nh \u0111\u1ED3 \u00E1n\\backGround1.png"));
		imageBack.setBounds(0, 0, 781, 445);
		contentPane.add(imageBack);
	}
}
