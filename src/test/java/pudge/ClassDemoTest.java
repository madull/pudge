package pudge;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pudge.entity.ClassDemo;
import com.pudge.service.UserServiceI;

public class ClassDemoTest {
	
	
	private UserServiceI userService;
	
	@Before
    public void before(){                                                                   
        @SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath*:spring/applicationContext-db.xml"
        });
        userService = (UserServiceI) context.getBean("userServiceI");
    }
     
    @Test
    public void addUser(){
    	List<ClassDemo> all = userService.getAll();
    	System.out.println(all.toString());
    }
    
    public static void main(String[] args) {
		String text="可租10辆可还0辆";
		Pattern p=Pattern.compile("(\\d)+");   
		  Matcher m=p.matcher(text);       
		  while (m.find()){  
		      String val = m.group();  
		      System.out.println("MATCH: " + val);  
		    }
	}
}
