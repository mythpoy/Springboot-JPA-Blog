package com.cos.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.blog.model.User;

import lombok.Data;
import lombok.Getter;

//������ ��ť��Ƽ�� �α��� ��û�� ����ä�� �α����� �����ϰ� �Ϸᰡ �Ǹ� UserDetails Ÿ���� ������Ʈ��
//������ ��ť��Ƽ�� �����h ��������ҿ� ������ ���ش�.
@Getter
public class PrincipalDetail implements UserDetails {
	private User user; //��������

	public PrincipalDetail(User user) {
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	//������ ������� �ʾҴ��� �����Ѵ�.(true:����ȵ�)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	//������ ������� �ʾҴ��� �����Ѵ�.(true:����� ����)
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//��й�ȣ�� ������� �ʾҴ��� �����Ѵ�.(true:����ȵ�)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//������ Ȱ��ȭ(��밡��)���� �����Ѵ�.(true:Ȱ��ȭ)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		//GrantedAuthority���� �޼ҵ尡 1���̹Ƿ� ���ٽ����� add���ֱ�
		collectors.add(()-> {return "ROLE_"+user.getRole();});
		
		
		return null;
	}
	
}











 