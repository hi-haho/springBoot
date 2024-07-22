package pack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pack.model.Product;
import pack.model.ProductDRUDrepo;

@SpringBootApplication
public class Sprweb14dbJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb14dbJpaApplication.class, args).getBean(Sprweb14dbJpaApplication.class).execute();

	}

	@Autowired
	ProductDRUDrepo drepo;

	private void execute() {
		System.out.println("main에 해당 메서드를 bean으로 설정해줘야해");
		// insertData();
		selectData();
	}

	private void insertData() {
		/*
		 * 추가 Product vo = new Product(); vo.setSang("볼펜"); vo.setSu(4);
		 * vo.setDan(3000); vo = drepo.save(vo); System.out.println("등록데이터 : " + vo);
		 */
		Product vo = new Product();
		vo.setCode(2); // 해당 번호가 있다면 수정
		vo.setSang("지우개");
		vo.setSu(10);
		vo.setDan(800);
		vo = drepo.save(vo);
	}

	private void selectData() {
		/*
		 * System.out.println("전체 자료 읽기 : DBMS에 독립적");
		 *  List<Product> list = drepo.findAll(); for(Product li : list) { System.out.println(li.getCode()
		 * +" " + li.getSang() + " " + li.getSu() + " " + li.getDan()); }
		 */
		/*
		System.out.println("부분자료 읽기");
		Product vo = drepo.findById(1).get();
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		
		System.out.println("부분자료 읽기 --- jpql(직접 생성)");
		Product vo = drepo.findByCode(2);
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
		*/
		System.out.println("전체 자료 읽기----jpql ");
		List<Product> list = drepo.findAllData();
		for (Product li2 : list) {
			System.out.println(li2.getCode() + " " + li2.getSang() + " " + li2.getSu() + " " + li2.getDan());
		}
		
		System.out.println("부분자료 읽기 --- jpql(직접 생성)");
		Product vo1 = drepo.findByCodeMy(1); //메서드 이름 임의 생성
		System.out.println(vo1.getCode() + " " + vo1.getSang() + " " + vo1.getSu() + " " + vo1.getDan()); 
		
		Product vo2 = drepo.findByCodeMy2(1); //메서드 이름 임의 생성
		System.out.println(vo2.getCode() + " " + vo2.getSang() + " " + vo2.getSu() + " " + vo2.getDan());
		
		List<Product> vo4 = drepo.findByData(1,"차카니"); //메서드 이름 임의 생성
		for (Product li3 : vo4) {
			System.out.println(li3.getCode() + " " + li3.getSang() + " " + li3.getSu() + " " + li3.getDan());
		}
		
		List<Product> list1 = drepo.findAllData2();
		for (Product li : list1) {
			System.out.println("(●'◡'●) "+li.getCode() + " " + li.getSang() + " " + li.getSu() + " " + li.getDan());
		}
	}
}
