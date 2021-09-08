package airlineManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Add_Customer extends JFrame{

	JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
	JRadioButton Male,Female;
	
	public Add_Customer() {
		
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setBackground(Color.WHITE);
		setTitle("ADD CUSTOMER DETAILS");
		
		
		
		//Image
		ImageIcon i1 = new ImageIcon("images/emp.png");
		JLabel image = new JLabel(i1);
		image.setBounds(450, 80, 280, 410);
		add(image);
		
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setSize(778,486);
		getContentPane().setLayout(null);
		
		
		
		JButton Next = new JButton("SAVE");
		Next.setBounds(200, 420, 150, 27);
		Next.setBackground(Color.BLACK);
		Next.setForeground(Color.WHITE);
		add(Next);
		
		
		
		
		JLabel PassportNo = new JLabel("PASSPORT NO");
		PassportNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		PassportNo.setBounds(60, 80, 150, 27);
		add(PassportNo);
		
		JLabel PnrNo = new JLabel("PNR NO");
		PnrNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		PnrNo.setBounds(60, 120, 150, 27);
		add(PnrNo);
		
		JLabel Address = new JLabel("ADDRESS");
		Address.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Address.setBounds(60, 170, 150, 27);
		add(Address);
		
		JLabel Nationality = new JLabel("Nationality");
		Nationality.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Nationality.setBounds(60, 220, 150, 27);
		add(Nationality);
		
		JLabel Name = new JLabel("NAME");
		Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Name.setBounds(60, 270, 150, 27);
		add(Name);
		
		JLabel Gender = new JLabel("GENDER");
		Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
		Gender.setBounds(60,320, 150, 27);
		add(Gender);
		
		JLabel PhoneNo = new JLabel("PH NO");
		PhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		PhoneNo.setBounds(60, 370, 150, 27);
		add(PhoneNo);
		
		
		Male = new JRadioButton("MALE");
		Male.setBackground(Color.WHITE);
		Male.setBounds(200, 320, 70, 27);
		add(Male);
		
		Female = new JRadioButton("FEMALE");
		Female.setBackground(Color.WHITE);
		Female.setBounds(280, 320, 70, 27);
		add(Female);
		
		ButtonGroup groupStatus = new ButtonGroup();
		groupStatus.add(Male);
		groupStatus.add(Female);
		
		
		setVisible(true);
		
		JLabel AddPassengers = new JLabel("ADD CUSTOMER DETAILS");
		AddPassengers.setForeground(Color.BLUE);
		AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
		AddPassengers.setBounds(420, 24, 442, 35);
		add(AddPassengers);
		
		JLabel FlightCode = new JLabel("FLIGHT CODE");
		FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
		FlightCode.setBounds(60, 30, 150, 27);
		add(FlightCode);
		
		tf1 = new JTextField();
		tf1.setBounds(200, 30, 150, 27);
		add(tf1);
		
		tf2 = new JTextField();
		tf2.setBounds(200, 80, 150, 27); //120
		add(tf2);
		
		tf3 = new JTextField();
		tf3.setBounds(200, 120, 150, 27);
		add(tf3);
		
		tf4 = new JTextField();
		tf4.setBounds(200, 170, 150, 27);
		add(tf4);
		
		tf5 = new JTextField();
		tf5.setBounds(200, 220, 150, 27);
		add(tf5);
		
		tf6 = new JTextField();
		tf6.setBounds(200, 270, 150, 27);
		add(tf6);
		
		tf7 = new JTextField();
		tf7.setBounds(200, 370, 150, 27);
		add(tf7);
		
		
		
		
		Next.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
			
			String fl_code = tf1.getText();
			String passport_no	= tf2.getText()	;
			String pnr_no	= tf3.getText();
			String address = tf4.getText();
			String nationality = tf5.getText();
			String name = tf6.getText();

			
			String gender = null;
			String ph_no = tf7.getText();
			
			if(Male.isSelected()){
				gender = "male";
			}
			else if(Female.isSelected()) {
				gender = "female";
			}
			
			try {
				Conn c = new Conn();
				String str = "INSERT INTO passenger VALUES('"+pnr_no+"', '"+address+"', '"+nationality+"', '"+name+"','"+gender+"', '"+ph_no+"', '"+passport_no+"','"+fl_code+"')";
				
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null,"Customer Added");
				setVisible(false);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			}
		});
		
		setSize(900,600);
		setVisible(true);
		setLocation(400,200);
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Add_Customer();
	}

}
