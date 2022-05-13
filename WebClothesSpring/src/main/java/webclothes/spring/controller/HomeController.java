package webclothes.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	@GetMapping("/admin")
	public String viewAdmin(Model model) {
		model.addAttribute("listLoaiSanPhams",loaiSanPhamService.getAllLoaiSanPham());
		model.addAttribute("listSanPhams",sanPhamService.getAllSanPham());
		return "admin/layout";
	}
	@GetMapping("/contact")
	public String Contact() {
		return "user/contact";
	}
	
	@GetMapping("/single")
	public String Single() {
		return "user/single";
	}
	
	@GetMapping("/categories")
	public String Categories(Model model) {
		model.addAttribute("listSanPhams",sanPhamService.getAllSanPham());
		model.addAttribute("listLoaiSanPhams",loaiSanPhamService.getAllLoaiSanPham());
		model.addAttribute("listSizes",sizeService.getAllSize());
		return "user/categories";
	}
	
}
