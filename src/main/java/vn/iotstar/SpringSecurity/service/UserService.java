package vn.iotstar.SpringSecurity.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import vn.iotstar.SpringSecurity.entity.UserInfo;
import vn.iotstar.SpringSecurity.repository.UserInfoRepository;

@Service
public record UserService(UserInfoRepository repository,
		PasswordEncoder passwordEncoder) {

	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "Add user successfully";
	}
}
