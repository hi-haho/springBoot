package pack.entity;

import java.util.Date;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emp { //emp(직원) 입장. 다대1
	@Id
	private Integer empno;
	private String ename;
	private String job;
	private String mgr; //관리자 직원번호
	@Temporal(TemporalType.DATE) //날짜 타입 매핑 시 사용(로컬데이터 타입에 맞추기 위해)
	private Date hiredate; //입사일
	private Double sal; //월급
	private Double comm;
	//private int deptno;
	
	//fetch join
	@ManyToOne(fetch =FetchType.EAGER) //한명의 직원이 여러 고객을 만들 수 있다.
	@JoinColumn(name="deptno",foreignKey = @ForeignKey(value=ConstraintMode.NO_CONSTRAINT))
	private Dept dept;
}
