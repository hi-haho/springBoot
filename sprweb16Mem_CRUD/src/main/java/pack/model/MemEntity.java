package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mem") //논리테이블
public class MemEntity { //entity와 dto를 나눠야한다.
	@Id
	private int num;
	
	private String name;
	private String addr;
	
}
