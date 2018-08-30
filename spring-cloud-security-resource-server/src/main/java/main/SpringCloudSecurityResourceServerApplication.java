package main;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableResourceServer
@RestController
public class SpringCloudSecurityResourceServerApplication {

	Map<Integer, Account> accMap = new HashMap<>();
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSecurityResourceServerApplication.class, args);
	}
	//context path = /resource
	@RequestMapping(value="/account")
	private Collection<Account> getAccountDetails(){
		if(ObjectUtils.isEmpty(accMap)) {
			accMap.put(111, new Account(111, "Savings", "Kevin Kanyi", "WestlandsBranch, Nairobi"));
			accMap.put(112, new Account(112, "Savings", "Nancy Moraa", "WestlandsBranch, Nairobi"));
			accMap.put(113, new Account(113, "Savings", "Millicent Nyatichi", "NgongBranch, Nairobi"));
		}
		return accMap.values();
	}
}
