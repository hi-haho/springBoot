package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="prod") //(name="prod") prod로 db가 만들어진다.
public class Product {
	@Id
	@Column(name="code")
	@GeneratedValue(strategy=GenerationType.IDENTITY) //자동증가
	private int code;
	@Column(name="sang", nullable = false, length = 20)
	private String sang;
	
	private int su;
	private int dan;
}
