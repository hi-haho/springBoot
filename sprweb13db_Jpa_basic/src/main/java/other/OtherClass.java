package other;

import org.springframework.stereotype.Component;

@Component
public class OtherClass {
	public OtherClass() {
		System.out.println("메롱");
	}
	
	public void abc() {
		System.out.println("abc method");
	}
}
