package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener{
    
    JButton deposit,withdrawal,ministatement,pinchange,fastcash,balanceenquiry,exit;
    String pinnumber;
    
    Transactions(String pinnumber){
        
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(700,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,700,700);
        add(image);
        
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(145,220,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(120,275,135,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawal=new JButton("Cash Withdrawal");
        withdrawal.setBounds(270,275,135,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(120,315,135,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(270,315,135,30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange=new JButton("PIN Change");
        pinchange.setBounds(120,355,135,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceenquiry=new JButton("Balance Enquiry");
        balanceenquiry.setBounds(270,355,135,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        exit=new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
        else if(ae.getSource()==withdrawal){
            setVisible(false);
            new Withdrawal(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    public static void main(String args[]){
        new Transactions("");
    }
    
}
