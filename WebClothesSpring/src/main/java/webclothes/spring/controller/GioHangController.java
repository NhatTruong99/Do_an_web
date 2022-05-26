package webclothes.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import webclothes.spring.service.LoaiSanPhamService;
import webclothes.spring.service.SanPhamService;
import webclothes.spring.service.SizeService;

@Controller
public class GioHangController {

	
	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private LoaiSanPhamService loaiSanPhamService;

	@Autowired
	private SizeService sizeService;
	
	@GetMapping("/shopcart")
	public String ShopCart() {
		return "user/shopcart";
	}
}