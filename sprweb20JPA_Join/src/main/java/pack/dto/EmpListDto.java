package pack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Emp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmpListDto {
	private Integer empno;
	private String ename;
	private Integer deptno;
	private String dname;
	private String job;
	
	//entity를 dto로 변환하기
	public static EmpListDto toDto(Emp emp) {// Emp(entity)가 EmpListDto로 변환된다.
		return EmpListDto.builder()
				.deptno(emp.getEmpno())
				.ename(emp.getEname())
				.deptno(emp.getDept().getDeptno())
				.dname(emp.getDept().getDname())
				.job(emp.getJob())
				.build();
	}
}
