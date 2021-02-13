import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddFrame extends JFrame
{

Container c;
JLabel lblrno,lblname,lblsub1,lblsub2,lblsub3;
JTextField txtrno,txtname,txtsub1,txtsub2,txtsub3;
JButton btnSubmit,btnBack;
AddFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblrno = new JLabel("Enter rno");
lblname = new JLabel ("Enter name");
lblsub1 = new JLabel ("Enter marks of sub1");
lblsub2 = new JLabel ("Enter marks of sub2");
lblsub3 = new JLabel ("Enter marks of sub3");

txtrno = new JTextField(25);
txtname = new JTextField(25);
txtsub1 = new JTextField(25);
txtsub2 = new JTextField(25);
txtsub3 = new JTextField(25);

btnSubmit = new JButton("Submit");
btnBack = new JButton("Back");

c.add(lblrno);	c.add(txtrno);
c.add(lblname);	c.add(txtname);
c.add(lblsub1);	c.add(txtsub1);
c.add(lblsub2);	c.add(txtsub2);
c.add(lblsub3);	c.add(txtsub3);
c.add(btnSubmit);
c.add(btnBack);

ActionListener a1 = (ae) ->{
try{
int rno = Integer.parseInt(txtrno.getText());
String name = txtname.getText();
int sub1 = Integer.parseInt(txtsub1.getText());
int sub2 =Integer.parseInt(txtsub2.getText());
int sub3 = Integer.parseInt(txtsub3.getText());

if(rno <=0 )
{
JOptionPane.showMessageDialog(c,"Enter correct rno");

}else if(name.length()<2 || name.matches("[0-9]+")){
JOptionPane.showMessageDialog(c,"Enter correct name");
}else if(sub1 < 0 || sub1>100){
JOptionPane.showMessageDialog(c,"Enter correct marks of sub1");
}else if(sub2 < 0 || sub2>100){
JOptionPane.showMessageDialog(c,"Enter correct marks of sub2");
}else if(sub3 < 0 || sub3>100){
JOptionPane.showMessageDialog(c,"Enter correct marks of sub3");
}else{

HbOpAdd h = new HbOpAdd(rno,name,sub1,sub2,sub3);
}
}catch(NumberFormatException e)
{
JOptionPane.showMessageDialog(c,"Please Enter Correct Rno");
}catch(Exception e)
{

JOptionPane.showMessageDialog(c,"Don't Enter Blank Data");
}
};
btnSubmit.addActionListener(a1);

ActionListener a2 = (ae) ->{
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a2);
setTitle("Add Student ");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);


}
}