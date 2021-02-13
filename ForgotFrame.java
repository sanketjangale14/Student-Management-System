import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ForgotFrame extends JFrame
{
Container c;
JLabel lblid,lblpass,lblconfirm;
JTextField txtid;
JPasswordField txtpass,txtconfirm;
JButton btnSave,btnBack;

ForgotFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblid = new JLabel("Enter Admin ID");
lblpass = new JLabel ("Enter New Password");
lblconfirm = new JLabel ("Confirm Password");
txtid = new JTextField(25);
txtpass = new JPasswordField(25);
txtconfirm = new JPasswordField(25);

btnSave = new JButton("Save");
btnBack = new JButton("Back");

c.add(lblid); c.add(txtid);
c.add(lblpass);	c.add(txtpass);
c.add(lblconfirm); c.add(txtconfirm);
c.add(btnSave); c.add(btnBack);

ActionListener a1 = (ae) ->{
try{
int id = Integer.parseInt(txtid.getText());
String pass = txtpass.getText();
String cpass = txtconfirm.getText();
if (id<0 )
{
JOptionPane.showMessageDialog(c,"Please Enter Correct Id");
}else if(pass.length()==0 || cpass.length()==0 || pass.length()<5){
JOptionPane.showMessageDialog(c,"Please Enter Password with length greater than 5");
}else if(!pass.equals(cpass)){
JOptionPane.showMessageDialog(c,"Confirm password does not match original password");
}
else{
HbOpForgot h = new HbOpForgot(id,pass);

}
}catch(Exception e)
{
JOptionPane.showMessageDialog(c,"Please Enter Correct Data");
}
};
btnSave.addActionListener(a1);

ActionListener a2 = (ae) ->{
LoginFrame l = new LoginFrame();
dispose();
};
btnBack.addActionListener(a2);

setTitle("Reset Password");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}

}


