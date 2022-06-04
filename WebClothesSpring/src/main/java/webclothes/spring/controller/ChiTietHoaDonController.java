package webclothes.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webclothes.spring.model.ChiTietHoaDon;
import webclothes.spring.service.ChiTietHoaDonService;
import webclothes.spring.service.HoaDonService;
import webclothes.spring.service.SanPhamService;

@Controller
public class ChiTietHoaDonController {

	@Autowired
	private ChiTietHoaDonService ChiTietHoaDonService;
	
	@Autowired
	private HoaDonService HoaDonService;
	
	@Autowired
	private SanPhamService SanPhamService;
	
	@GetMapping("/page_chitiethoadon/{maHD}")
	public String viewListCTHD(@PathVariable ( value = "maHD") long maHD, Model model) {
		model.addAttribute("listChiTietHoaDons", ChiTietHoaDonService.getAllChiTietHoaDon());
		model.addAttribute("listHoaDons", HoaDonService.getHoaDonById(maHD));
		model.addAttribute("listSanPhams", SanPhamService.getAllSanPham());
		return "admin/page_chitiethoadon";
	}
	
	@GetMapping("/showNewChiTietHoaDonForm")
	public String showNewChiTietHoaDonForm(Model model) {
		ChiTietHoaDon chitiethoadon = new ChiTietHoaDon();
	    model.addAttribute("chitiethoadon", chitiethoadon);
	    model.addAttribute("listHoaDons", HoaDonService.getAllHoaDon());
		model.addAttribute("listSanPhams", SanPhamService.getAllSanPham());
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
		model.addAttribute("listHoaDons", HoaDonService.getAllHoaDon());
		model.addAttribute("listSanPhams", SanPhamService.getAllSanPham());
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

