package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import pack.dto.DeptDto;
import pack.dto.EmpListDto;
import pack.entity.Dept;
import pack.entity.Emp;
import pack.repository.DeptRepository;
import pack.repository.EmpRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EmployController {
	@Autowired
	private EntityManagerFactory factory;
	
	@Autowired
	private EmpRepository empRepo;
	
	@Autowired
	private DeptRepository deptRepo;
	
	@GetMapping("/employee/list")
	public String empList(Model model) { //모든 직원의 정보 출력
//		List<Emp> list = empRepo.findAll();
//		List<Emp> list =empRepo.findAllByOrderByEmpnoDesc();
		List<Emp> list =empRepo.getlistAll();
//		List<Emp> list =empRepo.getList(1500);
		model.addAttribute("list",list);
		return"employ/elist";
	}
	@GetMapping("/employ/dept")
	public String getList(@RequestParam("deptno") int deptno,Model model) {
		Dept d = deptRepo.findById(deptno).get();
		DeptDto dto = DeptDto.toDto(d); //프록시 밖으로 빠져나와 controller에 나온 것
		model.addAttribute("dto",dto);
		return "employ/dept";
	}
	//jpql
	@GetMapping("/jpql")
	public String getJpql() {
		return "jpql";
	}
	
	@ResponseBody
	@PostMapping("/jpql/test")
	public List<EmpListDto> postTest(@RequestParam("query") String query) {
		//System.out.println(query);//select e from Emp as e
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		List<EmpListDto> list = null;
		try {
			//전달 받은 query문을 실행
			//Emp 값을 고정시켜놨기때문
			TypedQuery<Emp> tQuery = em.createQuery(query,Emp.class);
			//.map : 함수 실행
			list = tQuery.getResultStream().map(EmpListDto::toDto).toList();
			tx.commit();
		} catch (Exception e) {
			System.out.println("postTest err : " );e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return list;
	}
	
	
}
