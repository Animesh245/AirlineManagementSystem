package airlineManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;


public class Journey_Details extends JFrame{

	
	JTable t1;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	JButton b1;
	JComboBox c1, c2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Journey_Details();
	}
	
	public Journey_Details(){
		
		setTitle("JOURNEY_DETAILS");
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(null);
		
		
		l1 = new JLabel("SOURCE");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		l1.setBounds(60, 100, 150, 27);
		add(l1);
		
		l2 = new JLabel("DESTINATION");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		l2.setBounds(350, 100, 150, 27);
		add(l2);
		
		b1 = new JButton("SHOW");
		b1.setBounds(680, 100, 100, 30);
		add(b1);
	
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		l10 = new JLabel("JOURNEY DETAILS");
		l10.setForeground(Color.BLUE);
		l10.setFont(new Font("Tahoma", Font.PLAIN, 31));
		l10.setBounds(280, 27, 359, 31);
		add(l10);
		
		l3 = new JLabel("PNR_NO");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l3.setBounds(79, 270, 83, 20);
		add(l3);
		
		l4 = new JLabel("TICKET_ID");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l4.setBounds(172, 270, 71, 20);
		add(l4);
		
		l5 = new JLabel("F_CODE");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l5.setBounds(297, 270, 103, 20);
		add(l5);
		
		l6 = new JLabel("JNY_DATE");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l6.setBounds(390, 270, 94, 20);
		add(l6);
		
		l7 = new JLabel("JNY_TIME");
		l7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l7.setBounds(494, 270, 83, 20);
		add(l7);
		
		l8 = new JLabel("SOURCE");
		l8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l8.setBounds(613, 270, 94, 20);
		add(l8);
		
		l9 = new JLabel("DESTINATION");
		l9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		l9.setBounds(717, 270, 94, 20);
		add(l9);
		

		String[] item1 = {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA","DELHI", "HYDERABAD"};
		JComboBox c1 = new JComboBox(item1);
		c1.setBounds(150, 100, 150, 27);
		add(c1);
		
		String[] item2 = {"BANGALORE", "MUMBAI", "CHENNAI", "PATNA", "DELHI", "HYDERABAD"};
		JComboBox c2 = new JComboBox(item2);
		c2.setBounds(500, 100, 150, 27);
		add(c2);
		
//		String[] columnName = {
//				"f_code","f_name","src","dst","capacity","class_code","class_name"
//		};
//		
//		Object[][] data = {
//				
//		};
		
		t1 = new JTable();
		t1.setBounds(38, 310, 770, 130);
		add(t1);
		

		
		
		
		
		b1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				try {
					String src = (String) c1.getSelectedItem();
					String dst = (String) c2.getSelectedItem();
					
					Conn c = new Conn();
					
					String str = "SELECT pnr_no, ticket_id, f_code, jny_date, jny_time, src, dst FROM reservation WHERE src = '"+src+"' and dst = '"+dst+"'";
					ResultSet rs = c.s.executeQuery(str);
					
					if(rs.next()) {
						t1.setModel(DbUtils.resultSetToTableModel(rs));
					}
					else {
						JOptionPane.showMessageDialog(null, "No Flights between Source and Destination");
					}
				}
				catch(Exception e) {

				}
			}
		});
	
	
	
	
	setSize(860,600);
	setLocation(400,200);
	setVisible(true);
	
	
	
	
	
	}
	
	


}
