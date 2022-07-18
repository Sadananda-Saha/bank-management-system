
package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField nameTextField,fnameTextField,pinTextField,emailTextField,addressTextField,cityTextField,stateTextField;
    JButton next;
    JRadioButton male,female,others,married,unmarried,other;
    JDateChooser dateChooser; 
    SignupOne(){
        setLayout(null);
        Random ran=new Random();
        random=Math.abs((ran.nextLong() % 9000L)+1000L);
        
        JLabel formno=new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,10,600,40);
        add(formno);
        
        JLabel personDetails=new JLabel("Page 1: Personal Details");
        personDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personDetails.setBounds(290,50,400,30);
        add(personDetails);
        
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,100,100,30);
        add(name);
        
        nameTextField=new JTextField();
        nameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        nameTextField.setBounds(300,100,400,30);
        add(nameTextField);
        
        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,150,200,30);
        add(fname);
        
        fnameTextField=new JTextField();
        fnameTextField.setFont(new Font("Raleway",Font.BOLD,14));
        fnameTextField.setBounds(300,150,400,30);
        add(fnameTextField);
        
        JLabel dob=new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,200,200,30);
        add(dob); 
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,200,400,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
        
        
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,250,200,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,250,60,30);
        male.setBackground(Color.white);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(450,250,120,30);
        female.setBackground(Color.white);
        add(female);
        
        others=new JRadioButton("Others");
        others.setBounds(600,250,180,30);
        others.setBackground(Color.white);
        add(others);
        
        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);
        genderGroup.add(others);
        
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,300,200,30);
        add(email);
        
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Raleway",Font.BOLD,14));
        emailTextField.setBounds(300,300,400,30);
        add(emailTextField);
       
        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,350,200,30);
        add(marital);
        
        married=new JRadioButton("Married");
        married.setBounds(300,350,100,30);
        married.setBackground(Color.white);
        add(married);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(450,350,120,30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        other=new JRadioButton("Others");
        other.setBounds(600,350,100,30);
        other.setBackground(Color.white);
        add(other);
       
        
        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);
        
        
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,400,200,30);
        add(address);
        
        addressTextField=new JTextField();
        addressTextField.setFont(new Font("Raleway",Font.BOLD,14));
        addressTextField.setBounds(300,400,400,30);
        add(addressTextField);
        
        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,450,200,30);
        add(city);
        
        cityTextField=new JTextField();
        cityTextField.setFont(new Font("Raleway",Font.BOLD,14));
        cityTextField.setBounds(300,450,400,30);
        add(cityTextField);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,500,200,30);
        add(state);
        
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Raleway",Font.BOLD,14));
        stateTextField.setBounds(300,500,400,30);
        add(stateTextField);
        
        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,550,200,30);
        add(pincode);
        
        pinTextField=new JTextField();
        pinTextField.setFont(new Font("Raleway",Font.BOLD,14));
        pinTextField.setBounds(300,550,400,30);
        add(pinTextField);
        
        
        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,600,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,700);
        setLocation(280,0);
        setVisible(true);
        
        
    }
   @Override 
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;//long number
        String name=nameTextField.getText();
        String fname=fnameTextField.getText();
        
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }else if(others.isSelected()){
            gender="Others";
        }
        String email=emailTextField.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }else if(other.isSelected()){
            marital="Other";
        }
        String address=addressTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pin=pinTextField.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your name.");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your Father's Name.");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your date of birth.");
            }else if(gender == null){
                JOptionPane.showMessageDialog(null,"Please select your gender");
            }else if(marital == null){
                JOptionPane.showMessageDialog(null,"Please select your marital status");
            }else if(address.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your address");
            }else if(city.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your city");
            }else if(state.equals("")){
                
                JOptionPane.showMessageDialog(null,"Please enter your state");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter your pincode");
            }
            else{
                Conn c1=new Conn();
                String query="insert into signup values('"+formno+"', '"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c1.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
      
    }
    
    
    
    
    public static void main(String args[]){
        new SignupOne();
    }
    
}
