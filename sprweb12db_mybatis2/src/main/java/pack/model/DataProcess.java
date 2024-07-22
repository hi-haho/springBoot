package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.DataBean;

@Repository
public class DataProcess {
	private Logger logger = LoggerFactory.getLogger(this.getClass()); // 내용 출력

	@Autowired
	private DataMapperInter inter; // hikari pool 자동 지원된다.

	// 전체자료 읽기
	public List<DataDto> getDataAll() {
		List<DataDto> list = inter.selectAll();
		logger.info("전체 자료 길이 : " + list.size());
		return list;
	}

	// 특정 자료 읽기
	public DataDto selectOne(String num) {
		DataDto dto = inter.selectOne(num);
		return dto;
	}

	// 자료 추가
	public boolean insertData(DataBean bean) {
		// 번호 중복 방지 생략
		int a = inter.insertData(bean);
		if (a > 0)
			return true;
		else
			return false;
	}

	// 자료 수정
	public boolean update(DataBean bean) {
		int a = inter.update(bean);
		logger.info("###"+a);
		if (a > 0)
			return true;
		else
			return false;
	}

	// 자료 삭제
	public boolean delete(String num) {
		int a = inter.delete(num);
		if (a > 0)
			return true;
		else
			return false;
	}
}
