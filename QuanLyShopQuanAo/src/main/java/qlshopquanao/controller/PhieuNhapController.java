package qlshopquanao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import qlshopquanao.model.PhieuNhap;
import qlshopquanao.service.PhieuNhapService;

@Controller
public class PhieuNhapController {

	@Autowired
	private PhieuNhapService PhieuNhapService;
	
	@GetMapping("/page_phieunhap")
	public String viewListPN(Model model) {
		model.addAttribute("listPhieuNhaps", PhieuNhapService.getAllPhieuNhap());
		return "admin/page_phieunhap";
	}
	
	@GetMapping("/showNewPhieuNhapForm")
	public String showNewPhieuNhapForm(Model model) {
		PhieuNhap phieunhap = new PhieuNhap();
	    model.addAttribute("phieunhap", phieunhap);
	    return "admin/new_phieunhap";
	 }
	 
	@PostMapping("/savePhieuNhap")
	public String savePN(@ModelAttribute("phieunhap") PhieuNhap phieunhap) {
		PhieuNhapService.savePhieuNhap(phieunhap);
		return "redirect:/page_phieunhap";
	 }
	
	@GetMapping("/showFormForUpdatePN/{maPN}")
	public String showFormForUpdatePN(@PathVariable ( value = "maPN") long maPN, Model model) {
		PhieuNhap phieunhap = PhieuNhapService.getPhieuNhapById(maPN);
		model.addAttribute("phieunhap", phieunhap);
		return "admin/update_phieunhap";
	}
	
	@GetMapping("/deletePhieuNhap/{maPN}")
	public String deletePhieuNhap(@PathVariable (value = "maPN") long maPN) {
		this.PhieuNhapService.deletePhieuNhapById(maPN);
		return "redirect:/page_phieunhap";
	}
	
	/* PNông được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchPN"})
	public String home(PhieuNhap PhieuNhap, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listPhieuNhaps", PhieuNhapService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listPhieuNhaps", PhieuNhapService.getAllPhieuNhap());}
		return "admin/page_phieunhap";
	 }
}