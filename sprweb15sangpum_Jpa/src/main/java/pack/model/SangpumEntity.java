package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="sangdata")
public class SangpumEntity {
	@Id
	private int code; //null 값 X  / Integer는 null값 허용
	
	@Column(nullable = false)
	private String sang;
	
	private int su;
	private int dan;
}
