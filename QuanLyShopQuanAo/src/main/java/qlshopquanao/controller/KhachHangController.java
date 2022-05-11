package qlshopquanao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import qlshopquanao.model.KhachHang;
import qlshopquanao.service.KhachHangService;

@Controller
public class KhachHangController {

	@Autowired
	private KhachHangService KhachHangService;
	
	@GetMapping("/page_khachhang")
	public String viewListKH(Model model) {
		model.addAttribute("listKhachHangs", KhachHangService.getAllKhachHang());
		return "admin/page_khachhang";
	}
	
	@GetMapping("/showNewKhachHangForm")
	public String showNewKhachHangForm(Model model) {
		KhachHang khachhang = new KhachHang();
	    model.addAttribute("khachhang", khachhang);
	    return "admin/new_khachhang";
	 }
	 
	@PostMapping("/saveKhachHang")
	public String saveKH(@ModelAttribute("khachhang") KhachHang khachhang) {
		KhachHangService.saveKhachHang(khachhang);
		return "redirect:/page_khachhang";
	 }
	
	@GetMapping("/showFormForUpdateKH/{maKH}")
	public String showFormForUpdateKH(@PathVariable ( value = "maKH") long maKH, Model model) {
		KhachHang khachhang = KhachHangService.getKhachHangById(maKH);
		model.addAttribute("khachhang", khachhang);
		return "admin/update_khachhang";
	}
	
	@GetMapping("/deleteKhachHang/{maKH}")
	public String deleteKhachHang(@PathVariable (value = "maKH") long maKH) {
		this.KhachHangService.deleteKhachHangById(maKH);
		return "redirect:/page_khachhang";
	}
	
	/* Không được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchKH"})
	public String home(KhachHang KhachHang, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listKhachHangs", KhachHangService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listKhachHangs", KhachHangService.getAllKhachHang());}
		return "admin/page_khachhang";
	 }
}
