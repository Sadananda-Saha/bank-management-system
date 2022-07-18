package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;


public class MiniStatement extends JFrame {  
    String pinnumber;
      
    MiniStatement(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        JLabel mini=new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);
        
        JLabel bank=new JLabel("AXIS BANK");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select * from login where PinNumber = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("CardNumber").substring(0,4)+"XXXXXXXX"+rs.getString("CardNumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn conn=new Conn();
            int bal=0;
            ResultSet rs=conn.s.executeQuery("select * from bank where PinNumber = '"+pinnumber+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>" + rs.getString("Date")+ "&nbsp&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("Type")+"&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;Rs "+rs.getString("Amount")+"<br><br><html>");
                
                if(rs.getString("Type").equals("Deposit")){
                    bal+=Integer.parseInt(rs.getString("Amount"));
                }else if(rs.getString("Type").equals("Withdrawn")){
                    bal-=Integer.parseInt(rs.getString("Amount"));
                }
            }
            balance.setText("Your current account balance is Rs "+bal);
        }catch(Exception e){
            System.out.println(e);
        }
        
        
        
        setTitle("Mini Statement");
        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        
        setVisible(true);
        
        
        
        
    }
    
    public static void main(String args[]){
        new MiniStatement("");
    }
    
}
