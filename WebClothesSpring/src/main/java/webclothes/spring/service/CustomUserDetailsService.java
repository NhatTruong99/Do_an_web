package webclothes.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import webclothes.spring.model.CustomUserDetails;
import webclothes.spring.model.NhanVien;
import webclothes.spring.repository.NhanVienRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	 @Autowired
	 private NhanVienRepository userRepo;
	     
	 @Override
	 public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		 NhanVien user = userRepo.findByEmail(username);
		 NhanVien user = userRepo.findByTaiKhoan(username);
		 if (user == null) {
			 throw new UsernameNotFoundException("User not found");
	 }
		 return new CustomUserDetails(user);
	    }
}
