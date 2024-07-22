package pack;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import other.OtherClass;

@SpringBootApplication
@ComponentScan(basePackages = {"other"})
public class Sprweb13dbJpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb13dbJpaBasicApplication.class, args).getBean(Sprweb13dbJpaBasicApplication.class)
				.myExecute();
	}

	@Autowired
	ProductCRUD crud;
	@Autowired
	OtherClass class1;

	private void myExecute() {
		System.out.println("독립적인 프로그램으로 실행");
		insData();
		selectData();
		delData();
		class1.abc();
	}

	private void insData() {
		// ProductVo vo = new ProductVo();
		// vo.setCode(2); .. VO에 생성자로 만들어놓음

		// 삽입
		 ProductVo vo = new ProductVo(null, "아이고", 2, 10000);
		 System.out.println(vo.toString());
		 crud.save(vo);

		//수정
		ProductVo vo1 = new ProductVo(2, "사랑비", 5, 2000);
		crud.save(vo1);
	}

	private void delData() {
		crud.deleteById(7);
	}

	private void selectData() {
		// 전체 레코드 읽기
		List<ProductVo> list = (List) crud.findAll();
		// System.out.println(list.get(0).getSang());
		for (ProductVo p : list) {
			System.out.println("##" + p.getCode() + " " + p.getSang() + " " + p.getSu() + " " + p.getDan());
		}
		// 1개 레코드 읽기
		ProductVo vo = crud.findById(2).get();
		System.out.println(vo.getCode() + " " + vo.getSang() + " " + vo.getSu() + " " + vo.getDan());
	}
}
