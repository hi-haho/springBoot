package pack.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dept { //dept는 1대다 
	@Id
	private int deptno;
	private String dname;
	private String loc;
	
	//
	//FetchType.EAGER : Dept 사용중 Emp 바로 로딩. 별도 관리하지 않아도 된다. 메모리 차지 많음
	//FetchType.LAZY : Dept 사용중 Emp 사용(필요)시 로딩. 메모리 차지 적음, 개별 관리가 필요함
	//LazyInitializationException 조치 필요
	@OneToMany(mappedBy = "dept",fetch=FetchType.EAGER) // "dept" 는 fk
	//@Builder 생성자 인자를 메서드 체인을 통해 명시적으로 대입하여 생성자를 호출할 수 있게 빌더 클래스를 생성 해준다.
	@Builder.Default //Emp 엔티티가 생성될 때 list를 초기화한다
	private List<Emp> list = new ArrayList<Emp>();
	
}
