package pack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import jakarta.transaction.Transactional;
import pack.dto.Memberdto;
import pack.entity.Member;
import pack.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberServiceInter{//규모가 큰 경우 service를 만든다
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public void getList(Model model) { //멤버 전체 자료 반환
		
		//방법1 :  전체자료 반환 :  기본 메서드 사용
		//member 엔티티를 memberdto 객체로 전달
		List<Member> entityList = memberRepository.findAll();
		
		List<Memberdto> list = new ArrayList<Memberdto>();
		for(Member temp:entityList) {
			Memberdto dto = new Memberdto();
			dto.setNum(temp.getNum());
			dto.setName(temp.getName());
			dto.setAddr(temp.getAddr());
			list.add(dto);
		}
		/*
		//방법 2-1 : List<Member>를 Stream으로 변경해서 map()을 사용 List<MemberDto>
		List<Memberdto> list = memberRepository
							.findAllByOrderByNumDesc()
							.stream()// stream 변환
							.map(item -> Memberdto.toDto(item))// function 실행할 수 있는 map 사용
							.toList(); // List로 변환
		
		//방법 2-2 : 람다표현식을 메소드참조 표현식으로 기술	클래스명::메소드명
				List<Memberdto> list = memberRepository
									.findAllByOrderByNumDesc()
									.stream()
									.map(Memberdto::toDto).toList();*/
		
		model.addAttribute("list",list);//컨트롤러에 멤버 dto가 담긴 리스트 전달
	}
	@Override
	public void insert(Memberdto dto) {
		//jpa 작업 영역 내로 들어갈때 일반 자료 전달용객체(Dto,FormBean) 객체를 대응 entity로 변환
		memberRepository.save(Member.toEntity(dto));
	}
	//수정자료 읽기
	@Override
	public void getdata(Long num, Model model) {
		Member m = memberRepository.findById(num).get(); //entity를 가져온것
		//model.addAttribute("dto",m); -> 변환한것을 가져와야겠지
		model.addAttribute("dto",Memberdto.toDto(m));
	}
	
	@Override
	public void update(Memberdto dto) {
		memberRepository.save(Member.toEntity(dto));
	}
	
	@Transactional
	@Override
	public void update2(Memberdto dto) {
		 Member m1 = memberRepository.findById(dto.getNum()).get();
		 Member m2 = memberRepository.findById(dto.getNum()).get();
		    
		 // 동일성 검사
		 boolean isEqual = m1 == m2;
		 System.out.println("m1과 m2가 같냐?" + isEqual);
		    
		 // setter 메소드를 이용해서 이름과 주소 수정하기
		 m1.setName(dto.getName());
		 m1.setAddr(dto.getAddr());
	}
	
	@Override
	public void delete(Long num) {
		memberRepository.deleteById(num);
	}
}
