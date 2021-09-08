package airlineManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Cancel extends JFrame{

	
	private JTextField tf1, tf2, tf3, tf4,tf5;
	JLabel l1, l2, l3, l4, l5, l6;
	JButton b1;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Cancel();
	}
	
	public Cancel() {
		initialize();
	}
	
	private void initialize() {
		setTitle("CANCELLATION");
		getContentPane().setBackground(Color.WHITE);
		setBounds(100,100,801,472);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon("images/cancel.png");
		Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel NewLabel = new JLabel(i3);
		NewLabel.setBounds(470, 100, 250, 250);
		add(NewLabel);
		
		l1 = new JLabel("CANCELLATION");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l1.setBounds(185, 24, 259, 38);
		add(l1);
		
		l2 = new JLabel("PNR NO");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l2.setBounds(60, 100, 132, 26);
		add(l2);
		
		l3 = new JLabel("CANCELLATION NO");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l3.setBounds(60,150,150,27);
		add(l3);
		
		l4 = new JLabel("CANCELLATION DATE");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l4.setBounds(60, 200, 180, 27);
		add(l4);
		
		l5 = new JLabel("TICKET_ID");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l5.setBounds(60, 250, 150, 27);
		add(l5);
		
		l6 = new JLabel("FLIGHT_CODE");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		l6.setBounds(60, 300, 150, 27);
		add(l6);
		
		
		b1 = new JButton("CANCEL");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(250, 350, 150, 30);
		add(b1);
		
		tf1 = new JTextField();
		tf1.setBounds(250, 100, 150, 27);
		add(tf1);
		
		tf2 = new JTextField();
		tf2.setBounds(250, 150, 150, 27);
		add(tf2);
		
		tf3 = new JTextField();
		tf3.setBounds(250, 200, 150, 27);
		add(tf3);
		
		tf4 = new JTextField();
		tf4.setBounds(250, 250, 150, 27);
		add(tf4);
		
		tf5 = new JTextField();
		tf5.setBounds(250, 300, 150, 27);
		add(tf5);
		
		b1.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent ae) {
				
				String pnr_no = tf1.getText();
				String cancellation_no = tf2.getText();
				String cancellation_date = tf3.getText();
				String ticket_id = tf4.getText();
				String flight_code = tf5.getText();
				
				try {
					Conn c = new Conn();
					String str = "INSERT INTO cancellation VALUES('"+pnr_no+"', '"+cancellation_no+"','"+cancellation_date+"','"+ticket_id+"','"+flight_code+"')";
					
					c.s.executeUpdate(str);
					JOptionPane.showMessageDialog(null, "Ticket Cancelled");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		
		
		
		
		
		
		
		
		setSize(860,500);
		setVisible(true);
		setLocation(400,200);
		
		
		
		
		
		
		
		
	}

}
