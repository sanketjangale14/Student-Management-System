import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
import org.jfree.data.category.*;

class HbOpChart
{
int sub1,sub2,sub3;
String name;


DefaultCategoryDataset ds = new DefaultCategoryDataset();
HbOpChart()
{


Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session s = null;

try{
s = sf.openSession();
System.out.println("Connected");

List<Student> st = new ArrayList<>();
st = s.createQuery("from Student order by rno ").list();
for(Student r: st)
{
	name = r.getName();
	sub1 = r.getSub1();
	sub2 = r.getSub2();
	sub3 = r.getSub3();
	ds.addValue(sub1,name,"Physics");
	ds.addValue(sub2,name,"Maths");
	ds.addValue(sub3,name,"Chemistry");
	
}


}catch(Exception e){
System.out.println("issue"+e);
}
finally{
s.close();
System.out.println("Closed");
}


}
}