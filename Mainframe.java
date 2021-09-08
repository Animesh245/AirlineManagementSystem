package airlineManagementSystem;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Mainframe extends JFrame{
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Mainframe().setVisible(true);
		
		
	}
	
	public Mainframe() {
		super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
		initialize();
	}
	
	private void initialize() {
		
		setForeground(Color.CYAN);
		setLayout(null);
		
		JLabel NewLabel = new JLabel("");
		NewLabel.setIcon(new ImageIcon("images/front.jpg"));
		NewLabel.setBounds(0, 0, 1920, 990);
		add(NewLabel);
		
		JLabel AirlineManagementSystem = new JLabel("AIR INDIA WELCOMES YOU");
		AirlineManagementSystem.setForeground(Color.BLUE);
		AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
		AirlineManagementSystem.setBounds(700, 60, 1000, 55);
		NewLabel.add(AirlineManagementSystem);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		
		
//		AirlineSystem menu
		JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");	
		AirlineSystem.setForeground(Color.BLUE);
		menuBar.add(AirlineSystem);
		
		JMenuItem FlightDetails = new JMenuItem("FLIGHT_INFO");
		AirlineSystem.add(FlightDetails);
		
		JMenuItem ReservationDetails = new JMenuItem("ADD_CUSTOMER_DETAILS");
		AirlineSystem.add(ReservationDetails);
		
		JMenuItem PassengerDetails = new JMenuItem("JOURNEY_DETAILS");
		AirlineSystem.add(PassengerDetails);
		
		JMenuItem PaymentDetails = new JMenuItem("PAYMENT_DETAILS");
		AirlineSystem.add(PaymentDetails);
		
		JMenuItem Cancellation = new JMenuItem("CANCELLATION");
		AirlineSystem.add(Cancellation);
		
		
		
//		Ticket menu
		JMenu Ticket = new JMenu("TICKET");
		Ticket.setForeground(Color.RED);
		menuBar.add(Ticket);
		
		JMenu List = new JMenu("LIST");
		List.setForeground(Color.BLUE);
		menuBar.add(List);
		
		JMenu Misc = new JMenu("MISC");
		List.setForeground(Color.RED);
		menuBar.add(Misc);
		
		
		FlightDetails.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				new Flight_Info();
			}
		});
		
		ReservationDetails.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				try {
					new Add_Customer();
				} 
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		PassengerDetails.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent ae) {
				try {
					new Journey_Details();
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		PaymentDetails.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent ae) {
						try {
							new Payment_Details();
						}
						catch(Exception e) {
							e.printStackTrace();
						}
					}
				});
		
		
		Cancellation.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent ae) {
					new Cancel();
					}
				});
		
		
		setSize(1950,1090);
		setVisible(true);
		

		
	}

}
