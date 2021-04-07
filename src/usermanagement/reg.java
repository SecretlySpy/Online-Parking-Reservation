package usermanagement;

import java.awt.Container;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import DatabaseConnection.ConnectionDB;

import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class reg extends JFrame implements ActionListener {
	String tpass1, trpass2;
	public char pass1[],pass2[];
	public JLabel custdet, fnam, mnam, lnam, bdate, mno, type, email, platno, brand, color, gender, unam, pass, rpass,
			carprof, or;
	public JTextField tfnam, tmnam, tlnam, tmno, temail, tplatno, tbrand, tcolor, tunam;
	public JRadioButton male, female;
	public ButtonGroup gengp;
	public JComboBox<?> date, month, year;
	public JPasswordField tpass, trpass;
	public JButton sub, reset1;
	public JTextArea tout;
	public Connection conn = null;
	public Statement st = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	public DefaultTableModel dm = null;
	public ResultSetMetaData rsmd = null;
	Font f1 = new Font("Times New Roman", Font.PLAIN, 15);
	Font f2 = new Font("Times New Roman", Font.BOLD, 20);
	Font f3 = new Font("Times New Roman", Font.PLAIN, 13);
	Font f4 = new Font("Times New Roman", Font.CENTER_BASELINE, 15);
	// Color c1 = new Color.

	private JLabel lblClock;
	private ImageIcon icon;
	private JLabel label;
	private JLabel photo;
	private JLabel title;
	private JButton col;
	private JComboBox<?> combo;
	private JCheckBox term;
	private JLabel cnum;
	
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

	public reg() {
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
		photo.setBounds(10, 10, 100, 100);

		con.add(lblClock = new JLabel(""));
		lblClock.setBounds(730, 10, 230, 30);
		lblClock.setFont(f3);

		title = new JLabel("Manalad Group of Company");
		title.setBounds(100, -10, 200, 100);
		con.add(title);

		custdet = new JLabel(
				"----------------------------------------------------CUSTOMER PROFILE--------------------------------------------------");
		custdet.setBounds(10, 60, 1200, 50);
		custdet.setFont(f2);
		con.add(custdet);

		fnam = new JLabel("First Name:");
		fnam.setBounds(40, 110, 80, 30);
		fnam.setFont(f1);
		con.add(fnam);

		mnam = new JLabel("Middle Name:");
		mnam.setBounds(40, 150, 90, 30);
		mnam.setFont(f1);
		con.add(mnam);

		lnam = new JLabel("Last Name:");
		lnam.setBounds(40, 190, 80, 30);
		lnam.setFont(f1);
		con.add(lnam);

		gender = new JLabel("Gender:");
		gender.setBounds(500, 110, 90, 30);
		gender.setFont(f1);
		con.add(gender);

		mno = new JLabel("Mobile #:");
		mno.setBounds(500, 190, 80, 30);
		mno.setFont(f1);
		con.add(mno);

		cnum = new JLabel("+63");
		cnum.setBounds(630, 190, 30, 30);
		cnum.setFont(f1);
		con.add(cnum);

		unam = new JLabel("Username:");
		unam.setBounds(500, 230, 80, 30);
		unam.setFont(f1);
		con.add(unam);

		rpass = new JLabel("Repeat Password:");
		rpass.setBounds(500, 270, 120, 30);
		rpass.setFont(f1);
		con.add(rpass);

		email = new JLabel("E-mail:");
		email.setBounds(40, 230, 80, 30);
		email.setFont(f1);
		con.add(email);

		pass = new JLabel("Password:");
		pass.setBounds(40, 270, 80, 30);
		pass.setFont(f1);
		con.add(pass);

		carprof = new JLabel(
				"------------------------CAR PROFILE------------------------                                         SUMMARY PROFILE");
		carprof.setBounds(10, 330, 1200, 50);
		carprof.setFont(f2);
		con.add(carprof);

		platno = new JLabel("PLATE #:");
		platno.setBounds(40, 370, 80, 30);
		platno.setFont(f1);
		con.add(platno);

		brand = new JLabel("Brand:");
		brand.setBounds(40, 410, 80, 30);
		brand.setFont(f1);
		con.add(brand);

		color = new JLabel("Color:");
		color.setBounds(40, 450, 80, 30);
		color.setFont(f1);
		con.add(color);

		or = new JLabel("or");
		or.setBounds(310, 450, 20, 30);
		or.setFont(f1);
		con.add(or);

		col = new JButton("Choose Color");
		col.setBounds(330, 450, 120, 30);
		col.setFont(f1);
		col.addActionListener(this);
		con.add(col);

		type = new JLabel("Type of Car:");
		type.setBounds(40, 490, 100, 30);
		type.setFont(f1);
		con.add(type);

		String Select[] = { "Select -/-", "Hatchback", " Sedan", "MPV", "SUV", "Crossover", " Coupe", "Convertible",
				"Sports Car", "Utility", "Compact", "Mini Van", "Van", "Pick-Up Truck" };
		combo = new JComboBox(Select);
		combo.setFont(new Font("Arial", Font.PLAIN, 15));
		combo.setBounds(150, 490, 100, 30);
		con.add(combo);

		term = new JCheckBox("Accept Terms And Conditions.");
		term.setFont(new Font("Arial", Font.PLAIN, 15));
		term.setBounds(150, 530, 300, 30);
		con.add(term);

		sub = new JButton("Submit");
		sub.setFont(new Font("Arial", Font.PLAIN, 15));
		sub.setBounds(150, 570, 100, 20);
		sub.addActionListener(this);
		con.add(sub);

		reset1 = new JButton("Reset");
		reset1.setFont(new Font("Arial", Font.PLAIN, 15));
		reset1.setBounds(300, 570, 100, 20);
		reset1.addActionListener(this);
		con.add(reset1);

		tfnam = new JTextField();
		tfnam.setBounds(150, 110, 300, 30);
		tfnam.setFont(f1);
		con.add(tfnam);

		tmnam = new JTextField();
		tmnam.setBounds(150, 150, 300, 30);
		tmnam.setFont(f1);
		con.add(tmnam);

		tlnam = new JTextField();
		tlnam.setBounds(150, 190, 300, 30);
		tlnam.setFont(f1);
		con.add(tlnam);

		tmno = new JTextField();
		tmno.setBounds(670, 190, 260, 30);
		tmno.setFont(f1);
		con.add(tmno);

		temail = new JTextField();
		temail.setBounds(150, 230, 300, 30);
		temail.setFont(f1);
		con.add(temail);

		tunam = new JTextField();
		tunam.setBounds(630, 230, 300, 30);
		tunam.setFont(f1);
		con.add(tunam);

		tpass = new JPasswordField();
		tpass.setBounds(150, 270, 300, 30);
		tpass.setFont(f1);
		con.add(tpass);

		trpass = new JPasswordField();
		trpass.setBounds(630, 270, 300, 30);
		trpass.setFont(f1);
		con.add(trpass);

		tout = new JTextArea();
		tout.setFont(new Font("Arial", Font.PLAIN, 15));
		tout.setBounds(630, 370, 300, 300);
		tout.setLineWrap(true);
		tout.setEditable(false);
		con.add(tout);

		tplatno = new JTextField();
		tplatno.setBounds(150, 370, 300, 30);
		tplatno.setFont(f1);
		con.add(tplatno);

		tbrand = new JTextField();
		tbrand.setBounds(150, 410, 300, 30);
		tbrand.setFont(f1);
		con.add(tbrand);

		tcolor = new JTextField();
		tcolor.setBounds(150, 450, 150, 30);
		tcolor.setFont(f1);
		con.add(tcolor);

		male = new JRadioButton("Male");
		male.setFont(new Font("Arial", Font.PLAIN, 15));
		male.setSelected(true);
		male.setBounds(630, 110, 80, 30);
		male.setActionCommand("male");
		con.add(male);

		female = new JRadioButton("Female");
		female.setFont(new Font("Arial", Font.PLAIN, 15));
		female.setSelected(false);
		female.setBounds(750, 110, 80, 30);
		female.setActionCommand("female");
		con.add(female);

		gengp = new ButtonGroup();
		gengp.add(male);
		gengp.add(female);

		bdate = new JLabel("Birthdate:");
		bdate.setFont(new Font("Arial", Font.PLAIN, 15));
		bdate.setBounds(500, 150, 80, 30);
		con.add(bdate);

		String dates[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17",
				"18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
		date = new JComboBox(dates);
		date.setFont(new Font("Arial", Font.PLAIN, 15));
		date.setBounds(730, 150, 80, 30);
		con.add(date);

		String months[] = { "Jan", "feb", "Mar", "Apr", "May", "Jun", "July", "Aug", "Sep", "Oct", "Nov", "Dec" };
		month = new JComboBox(months);
		month.setFont(new Font("Arial", Font.PLAIN, 15));
		month.setBounds(630, 150, 80, 30);
		con.add(month);

		String years[] = { "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940",
				"1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953",
				"1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966",
				"1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979",
				"1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992",
				"1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005",
				"2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018",
				"2019", "2020" };
		year = new JComboBox(years);
		year.setFont(new Font("Arial", Font.PLAIN, 15));
		year.setBounds(830, 150, 80, 30);
		con.add(year);

		Clock();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		pass1 = tpass.getPassword();
		tpass1 = String.valueOf(pass1);
		pass2 = trpass.getPassword();
		trpass2 = String.valueOf(pass2);
		if (e.getSource() == sub) {

			if (term.isSelected()) {
				String data1;
				String data = "               ADMIN INFORMATION     " + "\n" + "\n" + "Name : " + tfnam.getText() + " "
						+ tmnam.getText() + " " + tlnam.getText() + "\n" + "Mobile :+63" + tmno.getText() + "\n"
						+ "E-mail :" + temail.getText() + "\n" + "Username :" + tunam.getText() + "\n";
				if (male.isSelected())
					data1 = "Gender : Male" + "\n";
				else
					data1 = "Gender : Female" + "\n";
				String data2 = "Date of Birth : " + (String) date.getSelectedItem() + "/"
						+ (String) month.getSelectedItem() + "/" + (String) year.getSelectedItem() + "\n" + "\n"
						+ "               CAR INFORMATION     " + "\n" + "\n" + "PLATE # :" + tplatno.getText() + "\n"
						+ "Brand :" + tbrand.getText() + "\n" + "Color of the Car :" + tcolor.getText() + "\n";
				;

				String data3 = "Type of Car : " + (String) combo.getSelectedItem() + "\n";
				tout.setText(data + data1 + data2 + data3);
				tout.setEditable(false);
				JOptionPane.showMessageDialog(this, "Registration Successfully");

				try {
					String query = "insert into useraccount (FirstName,MiddleName,LastName,Email,Gender,Birthdate,MobileNumber,Username,Password,RepeatPassword,PlateNumber,Brand,Color,Type) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
					
					ps = conn.prepareStatement(query);
					ps.setString(1, tfnam.getText());
					ps.setString(2, tmnam.getText());
					ps.setString(3, tlnam.getText());
					ps.setString(4, temail.getText());
					ps.setString(5, gengp.getSelection().getActionCommand());
					ps.setString(6, (String)date.getSelectedItem());
					ps.setString(6, (String)month.getSelectedItem());
					ps.setString(6, (String)year.getSelectedItem());
					ps.setString(7, tmno.getText());
					ps.setString(8, tunam.getText());
					ps.setString(9, tpass.getText());
					ps.setString(10, trpass.getText());
					ps.setString(11, tplatno.getText());
					ps.setString(12, tbrand.getText());
					ps.setString(13, tcolor.getText());
					ps.setString(14, (String)combo.getSelectedItem());
				
					
					
					
					ps.execute();
					JOptionPane.showMessageDialog(null, "Data Saved");

					ps.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				// pabalik ng login.java
				login app = new login();
				app.setVisible(true);
				app.setSize(450, 600);
				app.setVisible(true);
				app.setLocationRelativeTo(null);
				reg.this.dispose();

			} else {
				tout.setText("");
				JOptionPane.showMessageDialog(this, "Please accept the" + " terms & conditions!", "Alert",
						JOptionPane.WARNING_MESSAGE);
			}
		}

		else if (e.getSource() == reset1) {
			String def = "";
			tfnam.setText(def);
			tmnam.setText(def);
			tlnam.setText(def);
			temail.setText(def);
			tunam.setText(def);
			tpass.setText(def);
			trpass.setText(def);
			tplatno.setText(def);
			tbrand.setText(def);
			tcolor.setText(def);
			tmno.setText(def);
			tout.setText(def);
			term.setSelected(false);
			date.setSelectedIndex(0);
			month.setSelectedIndex(0);
			year.setSelectedIndex(0);
			combo.setSelectedIndex(0);
		}

	}

//main

	static reg app = new reg();

	public static void main(String[] args) {
		app.setTitle("Registration Form");
		app.setSize(950, 750);
		app.setVisible(true);
		app.setLocationRelativeTo(null);
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
