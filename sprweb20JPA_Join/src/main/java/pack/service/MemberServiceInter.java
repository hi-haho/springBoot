package pack.service;

import org.springframework.ui.Model;
import pack.dto.Memberdto;

public interface MemberServiceInter {
	public void getList(Model model);
	public void insert(Memberdto dto);
	public void getdata(Long num, Model model);
	public void update(Memberdto dto);
	public void update2(Memberdto dto);
	public void delete(Long num);
}
