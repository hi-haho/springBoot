package pack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //스프링 설정을 위한 클래스임을 뜻함
@EnableWebSecurity //Spring Security 기능 활성화
//보안설정 자동화, 인증 및 권한 부여, 비밀번호 암호화,CSRF 보호, 기본 로그인 등 제공, user라는 기본 사용자 계정 생성
public class SecurityConfig {

	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((requests) ->
				requests.requestMatchers("/").permitAll()
				.anyRequest().authenticated()) //루트 경로("/")는 모든 사용자가 허용. 그 외는 인증 필요
			.formLogin((form) -> form.loginPage("/login").permitAll()) //커스텀 로그인 페이지
			.logout((logout) ->  //로그아웃 설정을 정의
				logout.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.deleteCookies("jSESSIONID")
				.permitAll())
			.csrf((csrf)->csrf.disable()); //csrf 보호는 테스트이므로 비활성화
		return http.build();
	}
	
	@Bean
	//사용자 세부 정보르 관리하는 서비스 정의
	public UserDetailsService userDetailsService() {
		 //사용자 정보를 빌더
		UserDetails user = User.builder()
								.username("user")
								.password(passwordEncoder().encode("password"))
								.roles("USER")
								.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		//BCrypt는 암호화 해시 함수로 현재 사용중인 강력한 해시 메거니즘 중 하나
		//해시 함수에는 MD5나 SHA 등의 종류가 있지만 BCrypt는 단순히 입력을 1회 해시시키는 것이 아니라 솔트(salt)를 부여하여 여러번 해싱하므로 더 안전하게 암호를 관리
		//해시 : 입력 데이터를 고정된 길이의 고윳값(해시값)으로 변환하는 과정 또는 결과
		return new BCryptPasswordEncoder();
	}
}
