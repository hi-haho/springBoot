package pack.dto;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("memberDto") //객체 별명을 주고 mapper.xml에서 사용
//application.properties > mybatis.type-aliases-package=pack.dto.**를 설정해서 사용이 가능
public class MemberDto {
 private int num;
 private String name;
 private String addr;
}
