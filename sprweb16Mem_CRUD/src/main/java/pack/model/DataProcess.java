package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess {
	@Autowired
	private MemRepository memRepository;

	// 전체 자료 읽기
	public List<MemEntity> getDataAll() {
		List<MemEntity> list = memRepository.findAll();
		return list;
	}

	// 추가
	public String insertData(MemBean bean) {
		// 자동 증가
		// int max = MemRepository.findByMaxNum();

		// num 중복 확인
		try {
			MemEntity mem = memRepository.findById(bean.getNum()).get();
			System.out.println("mem" + mem);
			return "이미 등록된 번호입니다.";

		} catch (Exception e) {
			try {
				MemEntity mem = new MemEntity();
				mem.setNum(bean.getNum());
				mem.setName(bean.getName());
				mem.setAddr(bean.getAddr());
				mem = memRepository.save(mem);
				return "success";
			} catch (Exception e2) {
				return "입력 오류 : " + e2.getMessage();
			}
		}

	}

	// 추가 - 1개의 레코드 읽기
	public MemEntity getData(String num) {
		MemEntity mem = (MemEntity)memRepository.findByNum(num);
		return mem;
	}

	// 수정
	public String upData(MemBean bean) {
		try {
			MemEntity mem = new MemEntity();
			mem.setNum(bean.getNum());
			mem.setName(bean.getName());
			mem.setAddr(bean.getAddr());
			memRepository.save(mem);
			return "success";
		} catch (Exception e2) {
			return "입력 오류 : " + e2.getMessage();
		}

	}
	// 삭제
	public String delete(int num) {
		try {
			memRepository.deleteById(num);
			//System.out.println("delete mem :" + num);
			return "success";
		} catch (Exception e2) {
			return "입력 오류 : " + e2.getMessage();
		}

	}

	
}
