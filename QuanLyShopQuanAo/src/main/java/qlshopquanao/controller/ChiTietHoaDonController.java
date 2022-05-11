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

import qlshopquanao.model.ChiTietHoaDon;
import qlshopquanao.service.ChiTietHoaDonService;

@Controller
public class ChiTietHoaDonController {

	@Autowired
	private ChiTietHoaDonService ChiTietHoaDonService;
	
	@GetMapping("/page_chitiethoadon")
	public String viewListCTHD(Model model) {
		model.addAttribute("listChiTietHoaDons", ChiTietHoaDonService.getAllChiTietHoaDon());
		return "admin/page_chitiethoadon";
	}
	
	@GetMapping("/showNewChiTietHoaDonForm")
	public String showNewChiTietHoaDonForm(Model model) {
		ChiTietHoaDon chitiethoadon = new ChiTietHoaDon();
	    model.addAttribute("chitiethoadon", chitiethoadon);
	    return "admin/new_chitiethoadon";
	 }
	 
	@PostMapping("/saveChiTietHoaDon")
	public String saveCTHD(@ModelAttribute("chitiethoadon") ChiTietHoaDon chitiethoadon) {
		ChiTietHoaDonService.saveChiTietHoaDon(chitiethoadon);
		return "redirect:/page_chitiethoadon";
	 }
	
	@GetMapping("/showFormForUpdateCTHD/{maHD}")
	public String showFormForUpdateCTHD(@PathVariable ( value = "maHD") long maHD, Model model) {
		ChiTietHoaDon chitiethoadon = ChiTietHoaDonService.getChiTietHoaDonById(maHD);
		model.addAttribute("chitiethoadon", chitiethoadon);
		return "admin/update_chitiethoadon";
	}
	
	@GetMapping("/deleteChiTietHoaDon/{maHD}")
	public String deleteChiTietHoaDon(@PathVariable (value = "maHD") long maHD) {
		this.ChiTietHoaDonService.deleteChiTietHoaDonById(maHD);
		return "redirect:/page_chitiethoadon";
	}
	
	/* CTHDông được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchCTHD"})
	public String home(ChiTietHoaDon ChiTietHoaDon, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listChiTietHoaDons", ChiTietHoaDonService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listChiTietHoaDons", ChiTietHoaDonService.getAllChiTietHoaDon());}
		return "admin/page_chitiethoadon";
	 }
}

