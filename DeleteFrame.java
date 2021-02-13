import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame
{
Container c;
JLabel lblrno;
JTextField txtrno;
JButton btnDelete,btnBack;

DeleteFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());
lblrno = new JLabel("Enter rno");
txtrno = new JTextField(25);
btnDelete = new JButton("Delete");
btnBack = new JButton("Back");
c.add(lblrno); c.add(txtrno);
c.add(btnDelete); c.add(btnBack);

ActionListener a1 = (ae) ->{
try{
int rno  = Integer.parseInt(txtrno.getText());
if(rno<0)
{
JOptionPane.showMessageDialog(c,"Enter correct rno");
}else{
HbOpDelete h = new HbOpDelete(rno);
}
}catch(Exception e)
{
JOptionPane.showMessageDialog(c,"Please Enter Correct Data");
}
};
btnDelete.addActionListener(a1);

ActionListener a2 = (ae) ->{
MainFrame a = new MainFrame();
dispose();
};
btnBack.addActionListener(a2);
setTitle("E.M.S.");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}
