package pack.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.dto.Memberdto;
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MEMBER_TBL") //물리적 테이블명은 _가능
@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //자동증가
	private Long num;
	private String name;
	private String addr;
	
	//dto를 entity로 변환
	public static Member toEntity(Memberdto dto) {
		return Member.builder()
				.num(dto.getNum())
				.name(dto.getName())
				.addr(dto.getAddr())
				.build();
	}
}
