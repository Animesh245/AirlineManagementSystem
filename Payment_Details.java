package airlineManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Payment_Details extends JFrame{

	
	JTextField tf1;
	JTable t1;
	JLabel l1, l2, l3, l4, l5,l6, l7,l8,l9;
	JButton b1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Payment_Details();
	}

	
	public Payment_Details() {
		initialize();
	}
	
	private void initialize() {
		setTitle("PAYMENT_DETAILS");
		getContentPane().setBackground(Color.WHITE);
		setSize(860, 486);
		setLayout(null);
		
		l1 = new JLabel("PNR NO");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l1.setBounds(60, 160, 150, 26);
		add(l1);
		
		l2 = new JLabel("PAYMENT DETAILS");
		l2.setForeground(Color.BLUE);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 31));
		l2.setBounds(51, 17, 300, 39);
		add(l2);
		
		l3 = new JLabel("PNR_NO");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l3.setBounds(84, 292, 108, 26);
		add(l3);		
		
		l4 = new JLabel("PAID_AMOUNT");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l4.setBounds(183, 298, 92, 14);
		add(l4);
		
		l5 = new JLabel("PAY_DATE");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l5.setBounds(322, 294, 101, 24);
		add(l5);
		
		l6 = new JLabel("CHEQUE_NO");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l6.setBounds(455, 298, 114, 14);
		add(l6);
		
		
		l7 = new JLabel("");
		l7.setIcon(new ImageIcon("images/payment.png"));
//		l7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l7.setBounds(425, 15, 239, 272);
		add(l7);
		
		l8 = new JLabel("CARD_NO");
		l8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l8.setBounds(602, 299, 101, 19);
		add(l8);
		
		l9 = new JLabel("PHONE_NO");
		l9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l9.setBounds(712, 294, 86, 24);
		add(l9);
		
		
		tf1 = new JTextField();
		tf1.setBounds(200, 160, 150, 26);
		add(tf1);
		
		t1 = new JTable();
		t1.setBounds(45, 329, 766, 87);
		add(t1);
		
		b1 = new JButton("SHOW");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(200, 210, 150, 26);
		add(b1);
		
		setVisible(true);
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				try {
					String code = tf1.getText();
					
					Conn c = new Conn();
					String str = "select pnr_no, paid_amt, pay_date,cheque_no,card_no,ph_no from payment where pnr_no ='"+code+"'";
					
					ResultSet rs = c.s.executeQuery(str);
					
					t1.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
