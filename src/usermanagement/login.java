package usermanagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import DatabaseConnection.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class login extends JFrame implements ActionListener {

	public JLabel unam, pas, lblClock, photo;
	public JTextField t1;
	public char getpass[];
	public String pass;
	public JButton login, res, reg1;
	public JCheckBox show;
	public JPasswordField  pfpwd;
	public Connection conn = null;
	public Statement st = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public DefaultTableModel dm = null;
	public ResultSetMetaData rsmd = null;
	Font f1 = new Font("Times New Roman", Font.BOLD, 17);
	Font f2 = new Font("Arial", Font.ITALIC, 13);
	Font f3 = new Font("Times New Roman", Font.PLAIN, 15);

	Color c1 = Color.GRAY;
	Color c2 = Color.WHITE;
	Color c3 = Color.BLACK;

	private ImageIcon icon;
	private JLabel label;

	public void Clock() {
		Thread clock = new Thread() {
			@Override
			public void run() {
				try {
					while (true) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);

						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);

						lblClock.setText("Time " + hour + " : " + minute + " : " + second + " Date " + year + " / "
								+ (month + 1) + " / " + day);
						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	public login() {
		conn = ConnectionDB.getConnection();
		icon = new ImageIcon("src/m.jpg");

		Container con = getContentPane();
		con.setLayout(null);

		photo = new JLabel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				super.paintComponent(g);
			}
		};

		photo.setOpaque(false);
		con.add(photo);
		photo.setBounds(200, 60, 150, 100);

		con.add(lblClock = new JLabel(""));
		lblClock.setBounds(200, 10, 230, 30);
		lblClock.setFont(f3);

		unam = new JLabel("User Name");
		pas = new JLabel("Password");

		t1 = new JTextField();
		pfpwd = new JPasswordField();

		login = new JButton("Login");
		show = new JCheckBox("Show Password");
		res = new JButton("Reset");
		reg1 = new JButton("Register!");

		login.addActionListener(this);
		show.addActionListener(this);
		res.addActionListener(this);
		reg1.addActionListener(this);

		unam.setBounds(50, 150, 100, 20);
		pas.setBounds(50, 220, 100, 20);
		t1.setBounds(150, 150, 200, 20);
		pfpwd.setBounds(150, 220, 200, 20);
		show.setBounds(150, 250, 150, 20);
		login.setBounds(50, 300, 150, 20);
		res.setBounds(200, 300, 150, 20);
		reg1.setBounds(125, 350, 150, 20);

		unam.setFont(f1);
		pas.setFont(f1);
		t1.setFont(f1);
		pfpwd.setFont(f1);

		login.setFont(f2);
		res.setFont(f2);
		show.setFont(f2);
		reg1.setFont(f2);

		unam.setForeground(c3);
		pas.setForeground(c3);
		t1.setForeground(c3);
		pfpwd.setForeground(c3);

		login.setForeground(c3);
		res.setForeground(c3);
		show.setForeground(c3);
		reg1.setForeground(c3);

		con.add(unam);
		con.add(pas);
		con.add(t1);
		con.add(pfpwd);

		con.add(login);
		con.add(res);
		con.add(show);
		con.add(reg1);

		Clock();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// reg button papuntang regform

		if (e.getSource() == reg1) {
			reg app = new reg();
			app.setTitle("Admin Registration Form");
			app.setVisible(true);
			app.setSize(1000, 750);
			app.setLocationRelativeTo(null);
			login.this.dispose();
		}

		// Login Button
		if (e.getSource() == login) {
			getpass = pfpwd.getPassword();
			pass = String.valueOf(getpass);

				
				
						
						
						
						try {
							String sql = "select * from useraccount where Username=? and Password=?";
								ps = conn.prepareStatement(sql);
								ps.setString(1, t1.getText());
								ps.setString(2, pass);
								rs = ps.executeQuery();
								int count = 0;
								while (rs.next()) {
									count = count + 1;
								}
								if (count == 1) {
									JOptionPane.showMessageDialog(null, "UserName and Password is correct");
									JOptionPane.showMessageDialog(this, "Login Successful");
									// login button punta ng home/menu
									login.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent evt) {
											menu app = new menu();
											app.setTitle("Admin Menu");
											app.setVisible(true);
											app.setSize(1000, 400);
											app.setLocationRelativeTo(null);
											login.this.dispose();
									
									
									
									
									
									
									
									
									
								}
							});
								} else if (count > 1) {
									JOptionPane.showMessageDialog(null, "Duplicate UserName and Password");
								} else {
									JOptionPane.showMessageDialog(null, "UserName and Password is not correct Try Again...");
									JOptionPane.showMessageDialog(this, "Invalid Username or Password");
									t1.setText("");
									pfpwd.setText("");
								}
								
								rs.close();
								ps.close();
							} catch (Exception ex) {
								JOptionPane.showMessageDialog(null, ex);
							}
					
						
						
						
			}

			

		
		// Reset Button
		if (e.getSource() == res) {
			t1.setText("");
			pfpwd.setText("");
		}
		// Show Password
		if (e.getSource() == show) {
			if (show.isSelected()) {
				pfpwd.setEchoChar((char) 0);
			} else {
				pfpwd.setEchoChar('*');
			}

		}

	}

	static login app = new login();

	public static void main(String[] args) {
		app.setTitle("User Login");
		app.setSize(450, 600);
		app.setVisible(true);
		app.setLocationRelativeTo(null);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
