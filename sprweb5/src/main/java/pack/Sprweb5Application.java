package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sprweb5Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb5Application.class, args).getBean(Sprweb5Application.class).execute();
	}
	
	@Autowired
	My my;
	
	@Autowired
	ProcessServiceImpl processServiceImpl;
	
	private void execute() { //애플리케이션과 동시에 메서드를 사용할 수 있다.
		System.out.println("execute method 수행");
		my.aaa();
		processServiceImpl.selectProcess();
	}
}
 