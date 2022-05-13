package webclothes.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webclothes.spring.model.Quyen;
import webclothes.spring.repository.QuyenRepository;

@Service
public class QuyenService{

	@Autowired
	private QuyenRepository QuyenRepository;
	

	public List<Quyen> getAllQuyen() {
		return QuyenRepository.findAll();
	}

	public void saveQuyen(Quyen quyen) {
		this.QuyenRepository.save(quyen);
	}


	public Quyen getQuyenById(long maQuyen) {
		Optional<Quyen> optional = QuyenRepository.findById(maQuyen);
		Quyen quyen = null;
		if (optional.isPresent()) {
			quyen = optional.get();
		}
		else 
		{
			throw new RuntimeException(" Không tìm thấy quyền với mã quyền: " + maQuyen);    
		}
		return quyen;
	}

	public void deleteQuyenById(long maQuyen) {
		this.QuyenRepository.deleteById(maQuyen);
	}

	public List<Quyen> getByKeyword(String keyword) {
		return QuyenRepository.findByKeyword(keyword);
	}

}
