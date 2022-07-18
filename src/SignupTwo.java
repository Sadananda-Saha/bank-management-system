package bank.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    JTextField pan,aadhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno; 
    JComboBox religion,category,occupation,education,income;
    String formno;
    
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
      
        JLabel additionalDetails=new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,60,400,30);
        add(additionalDetails);
        
        JLabel religionLabel=new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway",Font.BOLD,20));
        religionLabel.setBounds(100,110,100,30);
        add(religionLabel);
        
        String valReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
        
        religion=new JComboBox(valReligion);
        religion.setBounds(300,110,400,30);
        religion.setBackground(Color.white);
        add(religion);
        
        JLabel categoryLabel=new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway",Font.BOLD,20));
        categoryLabel.setBounds(100,160,200,30);
        add(categoryLabel);
        
        String valCategory[]={"General","OBC","ST","SC","Other"};
        
        category=new JComboBox(valCategory);
        category.setBounds(300,160,400,30);
        category.setBackground(Color.white);
        add(category);
        
        JLabel incomeLabel=new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway",Font.BOLD,20));
        incomeLabel.setBounds(100,210,200,30);
        add(incomeLabel); 
        
        String incomeCategory[]={"Null","< 1,50,000","<2,50,000","< 5,00,000","<10,00,000",">10,00,000"};
        
        income=new JComboBox(incomeCategory);
        income.setBounds(300,210,400,30);
        income.setBackground(Color.white);
        add(income);    
        
        JLabel educationLabel=new JLabel("Educational:");
        educationLabel.setFont(new Font("Raleway",Font.BOLD,20));
        educationLabel.setBounds(100,260,200,30);
        add(educationLabel);
        
        
        
        JLabel qualificationLabel=new JLabel("Qualification:");
        qualificationLabel.setFont(new Font("Raleway",Font.BOLD,20));
        qualificationLabel.setBounds(100,285,200,30);
        add(qualificationLabel);
        
        String educationValues[]={"Non-Graduation","Graduate","Post-Graduation","Doctorate","Others"};
        
        education=new JComboBox(educationValues);
        education.setBounds(300,285,400,30);
        education.setBackground(Color.white);
        add(education); 
        
        
        
        JLabel occupationLabel=new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway",Font.BOLD,20));
        occupationLabel.setBounds(100,360,200,30);
        add(occupationLabel);
        
        String occupationValues[]={"Salaried","Self-Employed","Business","Student","Retired","Others"};
        
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,360,400,30);
        occupation.setBackground(Color.white);
        add(occupation); 
        
        
        JLabel panLabel=new JLabel("PAN Number:");
        panLabel.setFont(new Font("Raleway",Font.BOLD,20));
        panLabel.setBounds(100,410,200,30);
        add(panLabel);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300,410,400,30);
        add(pan);
        
        JLabel aadharLabel=new JLabel("Aadhar Number:");
        aadharLabel.setFont(new Font("Raleway",Font.BOLD,20));
        aadharLabel.setBounds(100,460,200,30);
        add(aadharLabel);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300,460,400,30);
        add(aadhar);
        
        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,20));
        senior.setBounds(100,510,200,30);
        add(senior);
        
        syes=new JRadioButton("Yes");
        syes.setBounds(300,510,100,30);
        syes.setBackground(Color.white);
        add(syes);
        
        sno=new JRadioButton("No");
        sno.setBounds(450,510,120,30);
        sno.setBackground(Color.white);
        add(sno);
       
        
        ButtonGroup seniorGroup=new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);
        
        JLabel existing=new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway",Font.BOLD,20));
        existing.setBounds(100,560,200,30);
        add(existing);
        
        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,560,100,30);
        eyes.setBackground(Color.white);
        add(eyes);
        
        eno=new JRadioButton("No");
        eno.setBounds(450,560,120,30);
        eno.setBackground(Color.white);
        add(eno);
       
        
        ButtonGroup existingGroup=new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);
        

        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,600,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.white);
        
        setSize(850,700);
        setLocation(300,0);
        setVisible(true);
        
        
    }
   @Override 
    public void actionPerformed(ActionEvent ae){
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        }else if(sno.isSelected()){
            seniorcitizen="No";
        }
        
        String existingaccount=null;
        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount="No";
        }
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        try{
            if(sreligion.equals("")){
                JOptionPane.showMessageDialog(null,"Religion is Required");
            }else if(sincome == null){
                JOptionPane.showMessageDialog(null,"Income cannot be null");
            }else if(existingaccount == null){
                JOptionPane.showMessageDialog(null,"Please select existing account field");
                    
            }else if(seniorcitizen == null){
                JOptionPane.showMessageDialog(null,"Please select seniority field");
            }else if(span.equals("")){
                JOptionPane.showMessageDialog(null,"Please fill PAN number");
            }else if(saadhar .equals("")){
                JOptionPane.showMessageDialog(null,"Please fill Aadhar Card number");
            }
            else{
                Conn c1=new Conn();
                String query="insert into signuptwo values('"+formno+"', '"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c1.s.executeUpdate(query);
                
                //Signup3 Object
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
      
    }
    
    
    
    
    public static void main(String args[]){
        new SignupTwo("");
    }
    
}
