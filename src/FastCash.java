package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    
    JButton deposit,withdrawal,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    
    FastCash(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text=new JLabel("SELECT WITHDRAWL AMOUNT:");
        text.setBounds(145,220,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Rs 100");
        deposit.setBounds(120,275,135,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal=new JButton("Rs 500");
        withdrawal.setBounds(270,275,135,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(120,315,135,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Rs 2000");
        ministatement.setBounds(270,315,135,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(120,355,135,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry=new JButton("Rs 10000");
        balanceenquiry.setBounds(270,355,135,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit=new JButton("BACK");
        exit.setBounds(270,395,135,30);
        exit.addActionListener(this);
        image.add(exit);
        
        
        setSize(700,700);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else{
            String amount=((JButton)ae.getSource()).getText().substring(3);//500
            Conn conn=new Conn();
            try{
                ResultSet rs = conn.s.executeQuery("select * from bank where PinNumber = '"+pinnumber+"'");
                int balance=0;
                while (rs.next()){
                    if(rs.getString("Type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("Amount"));
                    }else if(rs.getString("Type").equals("Withdrawn")){
                        balance-=Integer.parseInt(rs.getString("Amount"));
                    }
                    
                }
                if(ae.getSource()!= exit && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Oops...Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="insert into bank values ('"+pinnumber+"','"+date+"','Withdrawn','"+amount+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawn Successfully");
                
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
                
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
        
    }
    public static void main(String args[]){
        new FastCash("");
    }
    
}
