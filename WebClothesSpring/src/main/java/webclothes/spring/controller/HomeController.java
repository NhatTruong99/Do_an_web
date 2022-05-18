package webclothes.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import webclothes.spring.model.LoaiSanPham;
import webclothes.spring.model.SanPham;
import webclothes.spring.service.LoaiSanPhamService;
import webclothes.spring.service.SanPhamService;
import webclothes.spring.service.SizeService;

@Controller
public class HomeController {

	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private LoaiSanPhamService loaiSanPhamService;
	
	@Autowired
	private SizeService sizeService;
	
	@GetMapping("/")
	public String viewIndex(Model model) {
		model.addAttribute("listLoaiSanPhams",loaiSanPhamService.getAllLoaiSanPham());
		model.addAttribute("listSanPhams",sanPhamService.getAllSanPham());
		return "user/index";
	}
	
	//Trang Admin
	@GetMapping("/admin")
	public String viewAdmin(Model model) {
		model.addAttribute("listLoaiSanPhams",loaiSanPhamService.getAllLoaiSanPham());
		model.addAttribute("listSanPhams",sanPhamService.getAllSanPham());
		return "admin/layout";
	}
	
	//Trang liên hệ
	@GetMapping("/contact")
	public String Contact() {
		return "user/contact";
	}
	
	//Trang chi tiết sản phẩm
	@GetMapping("/single")
	public String Single() {
		return "user/single";
	}
	
	//Trang tất cả sản phẩm
	@GetMapping("/categories")
	public String Categories(Model model) {
		model.addAttribute("listSanPhams",sanPhamService.getAllSanPham());
		model.addAttribute("listLoaiSanPhams",loaiSanPhamService.getAllLoaiSanPham());
		model.addAttribute("listSizes",sizeService.getAllSize());
		return "user/categories";
	}
	
	
	//Hiển thị sản phẩm theo loại
	@GetMapping("/categories/{maLoaiSP}")
	public String showProductByCategory(@PathVariable ( value = "maLoaiSP") long maLoaiSP, Model model) {
		List<SanPham> listSP = sanPhamService.getByCategoryID(maLoaiSP);
		model.addAttribute("listSanPhams",listSP);
		model.addAttribute("listLoaiSanPhams",loaiSanPhamService.getAllLoaiSanPham());
		model.addAttribute("listSizes",sizeService.getAllSize());
		return "user/categories";
	}
	
	//Trang chi tiết sản phẩm
	@GetMapping("/single/{maSP}")
	public String showProductById(@PathVariable (value = "maSP") long maSP, Model model) {
		SanPham sanPham = sanPhamService.getSanPhamById(maSP);
		int donGia = sanPham.getDonGia();
		String anh = sanPham.getAnh();

		List<LoaiSanPham> listLoaiSP = loaiSanPhamService.getAllLoaiSanPham();
		LoaiSanPham loaiSanPham = null;
		
		for(int i =0; i< listLoaiSP.size(); i++) {
			if (sanPham.getMaLoaiSP() == listLoaiSP.get(i).getMaLoaiSP()) {
				loaiSanPham = listLoaiSP.get(i);
				break;
			}
		}
		
		model.addAttribute("sanPham",sanPham);
		model.addAttribute("donGia",donGia);
		model.addAttribute("loaiSanPham",loaiSanPham);
		model.addAttribute("listSizes",sizeService.getAllSize());
		return "user/single";
	}
	
	
	
	
	
	
	
	
}
