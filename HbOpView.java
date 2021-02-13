import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;

class HbOpView{
String data ="";


HbOpView()
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
	data = data + "r= "+ r.getRno()+" n= "+ r.getName() + " s1= "+r.getSub1()+" s2= "+r.getSub2() +" s3= "+ r.getSub3() +"\n";


}catch(Exception e){
System.out.println("issue"+e);
}
finally{
s.close();
System.out.println("Closed");
}

}

public String getData()
{
	return data;
}

}