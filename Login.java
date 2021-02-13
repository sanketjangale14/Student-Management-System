import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginFrame extends JFrame
{
Container c;
JLabel lblname,lblpass;
JTextField txtname;
JPasswordField txtpass;
JButton btnLogin,btnForgot;

LoginFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
lblname = new JLabel("Enter Admin ID");
lblpass = new JLabel ("Enter Password");
txtname = new JTextField(25);
txtpass = new JPasswordField(25);

btnLogin = new JButton("Login");
btnForgot = new JButton("Forgot Password");

c.add(lblname); c.add(txtname);
c.add(lblpass);	c.add(txtpass);
c.add(btnLogin); c.add(btnForgot);

ActionListener a1 = (ae) ->{
try
{
int id = Integer.parseInt(txtname.getText());
String pass = txtpass.getText();

if (id<0 )
{
JOptionPane.showMessageDialog(c,"Please Enter Correct Id");
}else if(pass.length()==0 ){
JOptionPane.showMessageDialog(c,"Please Enter Password");
}
else{
HbOpLogin h = new HbOpLogin(id);
String password = h.get();

if(pass.equals(password) )
{
	MainFrame m = new MainFrame();
	dispose();
}else if(!password.equals("")){
JOptionPane.showMessageDialog(c,"Wrong Password entered");
}
}
}catch(Exception e)
{
JOptionPane.showMessageDialog(c,"Please Enter correct Data");
}
};
btnLogin.addActionListener(a1);

ActionListener a2 = (ae)->{
ForgotFrame f = new ForgotFrame();
dispose();
};
btnForgot.addActionListener(a2);

setTitle("Admin Login");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}

}


class Login 
{
public static void main(String args[])
{
LoginFrame f = new LoginFrame();
}
}