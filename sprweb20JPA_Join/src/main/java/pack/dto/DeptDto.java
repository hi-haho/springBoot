package pack.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Dept;
import pack.entity.Emp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeptDto {
	@Id
	private int deptno;
	private String dname;
	private String loc;
	
	private int count; // 근무 인원수 저장
	private List<String> names;  //근무 직원의 이름들
	
	//entity를 dto로 변환하기
	public static DeptDto toDto(Dept dept) {
		//직원명 저장 리스트
		List<String> names = new ArrayList<String>();
		for(Emp temp:dept.getList()) {
			names.add(temp.getEname());
		}
		//lombok builder로 생성자 주입값을 선택적으로 할 수 있다.체이닝
		return DeptDto.builder().deptno(dept.getDeptno())
				.dname(dept.getDname())
				.loc(dept.getLoc())
				.count(dept.getList().size())
				.names(names).build();
	}
}
