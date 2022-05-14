package webclothes.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webclothes.spring.model.ChiTietPhieuNhap;
import webclothes.spring.service.ChiTietPhieuNhapService;
import webclothes.spring.service.PhieuNhapService;
import webclothes.spring.service.SanPhamService;

@Controller
public class ChiTietPhieuNhapController {

	@Autowired
	private ChiTietPhieuNhapService ChiTietPhieuNhapService;
	
	@Autowired
	private PhieuNhapService PhieuNhapService;;
	
	@Autowired
	private SanPhamService SanPhamService;
	
	@GetMapping("/page_chitietphieunhap")
	public String viewListCTPN(Model model) {
		model.addAttribute("listChiTietPhieuNhaps", ChiTietPhieuNhapService.getAllChiTietPhieuNhap());
		model.addAttribute("listPhieuNhaps", PhieuNhapService.getAllPhieuNhap());
		model.addAttribute("listSanPhams", SanPhamService.getAllSanPham());
		return "admin/page_chitietphieunhap";
	}
	
	@GetMapping("/showNewChiTietPhieuNhapForm")
	public String showNewChiTietPhieuNhapForm(Model model) {
		ChiTietPhieuNhap chitietphieunhap = new ChiTietPhieuNhap();
	    model.addAttribute("chitietphieunhap", chitietphieunhap);
	    model.addAttribute("listPhieuNhaps", PhieuNhapService.getAllPhieuNhap());
		model.addAttribute("listSanPhams", SanPhamService.getAllSanPham());
	    return "admin/new_chitietphieunhap";
	 }
	 
	@PostMapping("/saveChiTietPhieuNhap")
	public String saveCTPN(@ModelAttribute("chitietphieunhap") ChiTietPhieuNhap chitietphieunhap) {
		ChiTietPhieuNhapService.saveChiTietPhieuNhap(chitietphieunhap);
		return "redirect:/page_chitietphieunhap";
	 }
	
	@GetMapping("/showFormForUpdateCTPN/{maPN}")
	public String showFormForUpdateCTPN(@PathVariable ( value = "maPN") long maPN, Model model) {
		ChiTietPhieuNhap chitietphieunhap = ChiTietPhieuNhapService.getChiTietPhieuNhapById(maPN);
		model.addAttribute("chitietphieunhap", chitietphieunhap);
		model.addAttribute("listPhieuNhaps", PhieuNhapService.getAllPhieuNhap());
		model.addAttribute("listSanPhams", SanPhamService.getAllSanPham());
		return "admin/update_chitietphieunhap";
	}
	
	@GetMapping("/deleteChiTietPhieuNhap/{maPN}")
	public String deleteChiTietPhieuNhap(@PathVariable (value = "maPN") long maPN) {
		this.ChiTietPhieuNhapService.deleteChiTietPhieuNhapById(maPN);
		return "redirect:/page_chitietphieunhap";
	}
	
	/* CTPNông được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchCTPN"})
	public String home(ChiTietPhieuNhap ChiTietPhieuNhap, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listChiTietPhieuNhaps", ChiTietPhieuNhapService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listChiTietPhieuNhaps", ChiTietPhieuNhapService.getAllChiTietPhieuNhap());}
		return "admin/page_chitietphieunhap";
	 }
}

