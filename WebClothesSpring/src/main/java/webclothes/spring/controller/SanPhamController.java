package webclothes.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webclothes.spring.model.SanPham;
import webclothes.spring.service.SanPhamService;

@Controller
public class SanPhamController {

	@Autowired
	private SanPhamService SanPhamService;
	
	@GetMapping("/page_sanpham")
	public String viewListSP(Model model) {
		model.addAttribute("listSanPhams", SanPhamService.getAllSanPham());
		return "admin/page_sanpham";
	}
	
	@GetMapping("/showNewSanPhamForm")
	public String showNewSanPhamForm(Model model) {
		SanPham sanpham = new SanPham();
	    model.addAttribute("sanpham",sanpham);
	    return "admin/new_sanpham";
	 }
	 
	@PostMapping("/saveSanPham")
	public String saveSP(@ModelAttribute("sanpham") SanPham sanpham) {
		SanPhamService.saveSanPham(sanpham);
		return "redirect:/page_sanpham";
	 }
	
	@GetMapping("/showFormForUpdateSP/{maSP}")
	public String showFormForUpdateSP(@PathVariable ( value = "maSP") long maSP, Model model) {
		SanPham sanpham = SanPhamService.getSanPhamById(maSP);
		model.addAttribute("sanpham", sanpham);
		return "admin/update_sanpham";
	}
	
	@GetMapping("/deleteSanPham/{maSP}")
	public String deleteSanPham(@PathVariable (value = "maSP") long maSP) {
		this.SanPhamService.deleteSanPhamById(maSP);
		return "redirect:/page_sanpham";
	}
	
	/* SPông được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchSP"})
	public String home(SanPham SanPham, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listSanPhams", SanPhamService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listSanPhams", SanPhamService.getAllSanPham());}
		return "admin/page_sanpham";
	 }
}
