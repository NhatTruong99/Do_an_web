package qlshopquanao.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qlshopquanao.model.Quyen;
import qlshopquanao.repository.QuyenRepository;

@Service
public class QuyenServicelmpl implements QuyenService{

	@Autowired
	private QuyenRepository QuyenRepository;
	
	@Override
	public List<Quyen> getAllQuyen() {
		return QuyenRepository.findAll();
	}

	@Override
	public void saveQuyen(Quyen quyen) {
		this.QuyenRepository.save(quyen);
	}

	@Override
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

	@Override
	public void deleteQuyenById(long maQuyen) {
		this.QuyenRepository.deleteById(maQuyen);
	}

	@Override
	public List<Quyen> getByKeyword(String keyword) {
		return QuyenRepository.findByKeyword(keyword);
	}

}
