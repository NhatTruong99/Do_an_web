package qlshopquanao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import qlshopquanao.model.KhachHang;
import qlshopquanao.model.LoaiSanPham;
import qlshopquanao.service.LoaiSanPhamService;

@Controller
public class LoaiSanPhamController {

	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;
	
	@GetMapping("/page_loaisanpham")
	public String viewListLSP(Model model) {
		model.addAttribute("listLoaiSanPhams", LoaiSanPhamService.getAllLoaiSanPham());
		return "admin/page_loaisanpham";
	}
	
	@GetMapping("/showNewLoaiSanPhamForm")
	public String showNewLoaiSanPhamForm(Model model) {
		LoaiSanPham loaisanpham = new LoaiSanPham();
	    model.addAttribute("loaisanpham", loaisanpham);
	    return "admin/new_loaisanpham";
	 }
	
	@PostMapping("/saveLoaiSanPham")
	public String saveLSP(@ModelAttribute("loaisanpham") LoaiSanPham loaisanpham) {
		LoaiSanPhamService.saveLoaiSanPham(loaisanpham);
		return "redirect:/page_loaisanpham";
	 }
	
	@GetMapping("/showFormForUpdateLSP/{maLoaiSP}")
	public String showFormForUpdateLSP(@PathVariable ( value = "maLoaiSP") long maLoaiSP, Model model) {
		LoaiSanPham loaisanpham = LoaiSanPhamService.getLoaiSanPhamById(maLoaiSP);
		model.addAttribute("loaisanpham", loaisanpham);
		return "admin/update_loaisanpham";
	}
	
	@GetMapping("/deleteLoaiSanPham/{maLoaiSP}")
	public String deleteLoaiSanPham(@PathVariable (value = "maLoaiSP") long maLoaiSP) {
		this.LoaiSanPhamService.deleteLoaiSanPhamById(maLoaiSP);
		return "redirect:/page_loaisanpham";
	}
	
	/* Không được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchLSP"})
	public String home(LoaiSanPham LoaiSanPham, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listLoaiSanPhams", LoaiSanPhamService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listLoaiSanPhams", LoaiSanPhamService.getAllLoaiSanPham());}
		return "admin/page_loaisanpham";
	 }
	 
}
