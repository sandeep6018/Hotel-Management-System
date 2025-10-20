package hotel.management.system;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class AddDrivers extends JFrame implements ActionListener{
    
    JButton add, cancel;
    JTextField tfname, tfcompany , tfage , tfmodel, tflocation;
    JComboBox typecombo, availablecombo, agecombo ,cleancombo , gendercombo;

    AddDrivers() {
        getContentPane().setBackground(Color.WHITE);
	setLayout(null);
        
        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
	heading.setBounds(150, 10, 200, 20);
	add(heading);
        
	
        
	JLabel lblname = new JLabel("Name");
	lblname.setForeground(new Color(25, 25, 112));
	lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblname.setBounds(60, 70, 120, 30);
	add(lblname);
        
        
        tfname = new JTextField();
	tfname.setBounds(200, 80, 150, 30);
	add(tfname);
        

	JLabel age = new JLabel("Age");
	age.setForeground(new Color(25, 25, 112));
	age.setFont(new Font("Tahoma", Font.PLAIN, 16));
	age.setBounds(60, 110, 120, 30);
	add(age);
        
        tfage = new JTextField();
	tfage.setBounds(200, 110, 150, 30);
	add(tfage);


	JLabel lblgender = new JLabel("Gender");
	lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblgender.setBounds(60, 150, 120, 30);
	add(lblgender);
        
        String cleanOptions[] = { "Male", "Female" };
        gendercombo = new JComboBox(cleanOptions);
	gendercombo.setBounds(200, 150, 150, 30);
        gendercombo.setBackground(Color.WHITE);
	add(gendercombo);

	JLabel lblcarcompany = new JLabel("Car Company");
	lblcarcompany.setForeground(new Color(25, 25, 112));
	lblcarcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblcarcompany.setBounds(60, 190, 150, 30);
	add(lblcarcompany);
        
        tfcompany = new JTextField();
	tfcompany.setBounds(200, 190, 150, 30);
	add(tfcompany);

        JLabel lblmodel = new JLabel("Car Model");
	lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblmodel.setBounds(60, 230, 120, 30);
	add(lblmodel);


        tfmodel = new JTextField();
	tfmodel.setBounds(200, 230, 150, 30);
	add(tfmodel);
	
        JLabel lblavailable = new JLabel("Available");
	lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lblavailable.setBounds(60, 270, 120, 30);
	add(lblavailable);
        
        String driverOptions[] = { "Available", "Busy" };
        availablecombo = new JComboBox(driverOptions);
	availablecombo.setBounds(200, 270, 150, 30);
        availablecombo.setBackground(Color.WHITE);
	add(availablecombo);
        
        JLabel lbllocation = new JLabel("Location");
	lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
	lbllocation.setBounds(60, 310, 120, 30);
	add(lbllocation);


        tflocation = new JTextField();
	tflocation.setBounds(200, 310, 150, 30);
	add(tflocation);

	add= new JButton("Add Driver");
	add.addActionListener(this);
	add.setBounds(60, 370, 130, 30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
	add(add);

	cancel= new JButton("Cancel");
	cancel.addActionListener(this);
	cancel.setBounds(220, 370, 130, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
	add(cancel);
    
        
         ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
         Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
         ImageIcon i3 = new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(400,30,500,300);
         add(image);
         
         setBounds(300, 200, 980, 470);
         setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == add){
                String name = tfname.getText();
                String age =  tfage.getText();
                String gender = (String) gendercombo.getSelectedItem();
                String company  = tfcompany.getText();
                String model = tfmodel.getText();
                String availability = (String)availablecombo.getSelectedItem();
                String location = tflocation.getText();
                
                
                try {
                    Conn conn = new Conn();
                    String str = "insert into drivers  values('"+name+"', '"+age+"', '"+gender+"','"+company+"', '"+model+"', '"+availability+"','"+location+"')";
                    
                    conn.s.executeUpdate(str);
                    
                    JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
                    setVisible(false);
                } catch (Exception e) {
                    e.printStackTrace();
                } 
            } else {
                setVisible(false);
            }
            }
                    

     public static void main(String[] args) {
        new AddDrivers();
    }
}
               
 
