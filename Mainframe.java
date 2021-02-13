import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends JFrame
{
Container c;
JButton btnAdd,btnView,btnUpdate,btnDelete,btnChart;

MainFrame(){
c = getContentPane();
c.setLayout(new FlowLayout());
btnAdd = new JButton("  Add  ");
btnView = new JButton("  View  ");
btnUpdate = new JButton("  Update  ");
btnDelete = new JButton("  Delete  ");
btnChart = new JButton("  Chart  ");
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);
c.add(btnChart);

ActionListener a1 = (ae) ->{
 AddFrame a = new AddFrame();
 dispose();
};
btnAdd.addActionListener(a1);

ActionListener a2 = (ae) ->{
 ViewFrame a = new ViewFrame();
 dispose();
};
btnView.addActionListener(a2);
ActionListener a3 = (ae) ->{
 UpdateFrame a = new UpdateFrame();
 dispose();
};
btnUpdate.addActionListener(a3);
ActionListener a4 = (ae) ->{
 DeleteFrame a = new DeleteFrame();
 dispose();
};
btnDelete.addActionListener(a4);

ActionListener a5 = (ae) ->{
 ChartFrame a = new ChartFrame();
 dispose();
};
btnChart.addActionListener(a5);

setTitle("Student Management System");
setSize(300,300);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}
}
