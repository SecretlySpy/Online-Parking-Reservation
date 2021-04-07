package usermanagement;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menu extends JFrame implements ActionListener{
	
	public JButton user, uprof, cprof, pslot, logout;
	
	Font f1 = new Font("Times New Roman", Font.BOLD,17);
	Font f2 = new Font("Arial", Font.ITALIC,13);
	Color c1 = Color.GRAY;
	Color c2 = Color.BLACK;
	Color c3 = Color.WHITE;
	
public menu() {
	Container con = getContentPane();
	con.setLayout(null);
	
	user = new JButton ("CUSTOMER PROFILE");
	uprof = new JButton ("uprofING");
	cprof = new JButton ("PARK cprofORY");
	pslot = new JButton ("PARKING SLOT");
	logout = new JButton ("LOGOUT");
	
	user.addActionListener(this);
	uprof.addActionListener(this);
	cprof.addActionListener(this);
	pslot.addActionListener(this);
	logout.addActionListener(this);

	user.setBounds(10,90,250,30);
	uprof.setBounds(10,130,250,30);
	cprof.setBounds(10,170,250,30);
	pslot.setBounds(10,210,250,30);
	logout.setBounds(800,10,170,30);

	user.setFont(f1);
	uprof.setFont(f1);
	cprof.setFont(f1);
	pslot.setFont(f1);
	logout.setFont(f1);
	
	user.setForeground(c2);
	uprof.setForeground(c2);
	cprof.setForeground(c2);
	pslot.setForeground(c2);
	logout.setForeground(c2);
	
	con.setBackground(c1);

	con.add(user);
	con.add(uprof);
	con.add(cprof);
	con.add(pslot);
	con.add(logout);
	
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	//paglogout
	if (e.getSource() == logout) {
		int dialog = JOptionPane.showConfirmDialog(null, "Are you sure you want to LOGOUT?", "WARNING",
				JOptionPane.YES_NO_OPTION);
		if (dialog == JOptionPane.YES_OPTION) {
			//pabalik ng login.java
	        login app = new login();
	        app.setVisible(true);
	        app.setSize(450,600); 
	        app.setVisible(true);
	    	app.setLocationRelativeTo(null);
	    	menu.this.dispose();
		}
		if (dialog == JOptionPane.NO_OPTION) {
			menu.this.show();
		}
	}
	
	//papuntang user profile
	uprof.addActionListener(new ActionListener() { 
	    public void actionPerformed(ActionEvent evt) {
	        user_profile app = new user_profile();
	      //  app.setVisible(true);
	      //  app.setSize(1000,700);
	    //	app.setLocationRelativeTo(null);
	    	menu.this.dispose();
	    } 
	});
	
	//papuntang car profile
		cprof.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent evt) {
		    	car_profile app = new car_profile();
		    //    app.setVisible(true);
		    //    app.setSize(1000,700);
		    //	app.setLocationRelativeTo(null);
		    	menu.this.dispose();
		    } 
		});
	//papuntang slot/reserve/cancel

		
		
	//papuntang receipt
	}	


static menu app = new menu();
public static void main(String[] args) {
app.setTitle("Admin Menu");
app.setSize(1000,400);
app.setVisible(true);
app.setLocationRelativeTo(null);
}
}
