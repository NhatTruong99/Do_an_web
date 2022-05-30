package webclothes.spring.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import webclothes.spring.model.GioHangItem;
import webclothes.spring.model.SanPham;
import webclothes.spring.repository.GioHangRepository;

@Service
public class GioHangService{

	@Autowired
	private GioHangRepository gioHangRepository;
	
	public HashMap<Long,GioHangItem> AddGioHang(long id,int soLuong, HashMap<Long,GioHangItem> gioHang) {
		return gioHangRepository.AddGioHang(id,soLuong, gioHang);
	}
	
	public HashMap<Long,GioHangItem> EditGioHang(long id,int soLuong, HashMap<Long,GioHangItem> gioHang) {
		return gioHangRepository.EditGioHang(id, soLuong, gioHang);
	}
	
	public HashMap<Long,GioHangItem> DeleteGioHang(long id, HashMap<Long,GioHangItem> gioHang) {
		return gioHangRepository.DeleteGioHang(id, gioHang);
	}
	
	public int TotalQuantity(HashMap<Long,GioHangItem> gioHang) {
		return gioHangRepository.TotalQuantity(gioHang);
	}
	
	public int TotalPrice(HashMap<Long,GioHangItem> gioHang) {
		return gioHangRepository.TotalPrice(gioHang);

	}
}
