package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class InformationView extends JDialog {
     private ManagerView managerView;
	
	
	public InformationView(JFrame addFrame) {
		super(addFrame);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\THẾ ANH_21IT394\\HƯỚNG ĐỐI TƯỢNG\\ảnh đồ án\\logo3.png"));
		setTitle("Lời Bài Hát");
		managerView = (ManagerView) addFrame;
		setBounds(100, 100, 816, 486);
		getContentPane().setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(57, 132, 682, 281);
			getContentPane().add(scrollPane);
			{
				JTextArea textArea = new JTextArea();
				textArea.setFont(new Font("Tahoma", Font.BOLD, 18));
				textArea.setText(managerView.loiBaiHat());
				
				scrollPane.setViewportView(textArea);
			}
		}
		
		JLabel lblNewLabel = new JLabel("Lời Bài Hát");
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(344, 11, 147, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel tenBh = new JLabel();
		tenBh.setForeground(new Color(255, 51, 0));
		tenBh.setText(managerView.tenBaihat()+"");
		tenBh.setFont(new Font("Tahoma", Font.BOLD, 23));
		tenBh.setBounds(284, 53, 506, 30);
		getContentPane().add(tenBh);
	}

}
