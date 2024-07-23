package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

@SpringBootApplication
public class Sprweb20JpaJoinApplication {
	//1)어플리케이션에서 SQL 처리용 메소드 연습
	//2)@MVC로 회원 자료 처리
	//3)@MVC로 직원자료 처리 (조인)
	//4)JPQL 연습용 화면 작성 : AJAX
	
	@Autowired
	private EntityManagerFactory emf;
	
	//생성자 이후 자동 실행
	@PostConstruct
	public void initMembers() {
		//hibernate 객체 사용 : dept,emp 샘플 데이터 jpql을 이용해 저장
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			List<String>queries = new ArrayList<String>();
			queries.add("INSERT INTO DEPT VALUES (10, 'ACCOUNTING', 'NEW YORK');");
			queries.add("INSERT INTO DEPT VALUES (20, 'RESEARCH',   'DALLAS');");
			queries.add("INSERT INTO DEPT VALUES (30, 'SALES',      'CHICAGO');");
			queries.add("INSERT INTO DEPT VALUES (40, 'OPERATIONS', 'BOSTON');");
			
			queries.add("INSERT INTO EMP VALUES (7369, 'SMITH',  'CLERK', 7902,"
					+ "        TO_DATE('17-12-1980', 'DD-MM-YYYY'),  800, NULL, 20);");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7499, 'ALLEN',  'SALESMAN',  7698,"
					+ "        TO_DATE('20-02-1981', 'DD-MM-YYYY'), 1600,  300, 30);");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7521, 'WARD',   'SALESMAN',  7698,"
					+ "        TO_DATE('22-02-1981', 'DD-MM-YYYY'), 1250,  500, 30);"
					+ "");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7566, 'JONES',  'MANAGER',   7839,"
					+ "        TO_DATE('02-04-1981', 'DD-MM-YYYY'),  2975, NULL, 20); "
					+ "");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7654, 'MARTIN', 'SALESMAN',  7698, "
					+ "        TO_DATE('28-09-1981', 'DD-MM-YYYY'), 1250, 1400, 30);");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7698, 'BLAKE',  'MANAGER',   7839, "
					+ "        TO_DATE('01-05-1981', 'DD-MM-YYYY'),  2850, NULL, 30);");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7782, 'CLARK',  'MANAGER',   7839, "
					+ "        TO_DATE('09-06-1981', 'DD-MM-YYYY'),  2450, NULL, 10);");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7788, 'SCOTT',  'ANALYST',   7566, "
					+ "        TO_DATE('09-12-1982', 'DD-MM-YYYY'), 3000, NULL, 20);"
					+ "");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7839, 'KING',   'PRESIDENT', NULL, "
					+ "        TO_DATE('17-11-1981', 'DD-MM-YYYY'), 5000, NULL, 10);");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7844, 'TURNER', 'SALESMAN',  7698, "
					+ "        TO_DATE('08-09-1981', 'DD-MM-YYYY'),  1500, NULL, 30);");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7876, 'ADAMS',  'CLERK',     7788, "
					+ "        TO_DATE('12-01-1983', 'DD-MM-YYYY'), 1100, NULL, 20);");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7900, 'JAMES',  'CLERK',     7698, "
					+ "        TO_DATE('03-12-1981', 'DD-MM-YYYY'),   950, NULL, 30);");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7902, 'FORD',   'ANALYST',   7566, "
					+ "        TO_DATE('03-12-1981', 'DD-MM-YYYY'),  3000, NULL, 20);");
			queries.add("INSERT INTO EMP VALUES "
					+ "        (7934, 'MILLER', 'CLERK',     7782, "
					+ "        TO_DATE('23-01-1982', 'DD-MM-YYYY'), 1300, NULL, 10);");
			
			tx.commit();
		} catch (Exception e) {
			System.out.println("init() : "+e);
			tx.rollback();
		}finally {
			em.close();
			//emf.close();
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Sprweb20JpaJoinApplication.class, args);
	}

}
