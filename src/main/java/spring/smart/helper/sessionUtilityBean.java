package spring.smart.helper;

import org.hibernate.annotations.Comment;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jakarta.servlet.http.HttpSession;

@Component
public class sessionUtilityBean {
	 @Bean
     public void removeMessageFromSession() {
	            try {
	                System.out.println("removing message form session ");
	               
	                ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
	                
	                if (requestAttributes != null) {
	                    HttpSession session = requestAttributes.getRequest().getSession();
	                    if (session.getAttribute("message") != null) {
	                        session.removeAttribute("message");
	                    }
	                } else {
	                    System.out.println("No active request context, cannot remove message from session.");
	                } 
	                
	                
		            } catch (Exception e) {
	                e.printStackTrace();
	
	            }
	 }
}