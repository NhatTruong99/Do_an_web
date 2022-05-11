package qlshopquanao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import qlshopquanao.model.NhaCungCap;
import qlshopquanao.service.NhaCungCapService;


@Controller
public class NhaCungCapController {
	@Autowired
	private NhaCungCapService NhaCungCapService;
	
	@GetMapping("/page_nhacungcap")
	public String viewListNCC(Model model) {
		model.addAttribute("listNhaCungCaps", NhaCungCapService.getAllNhaCungCap());
		return "admin/page_nhacungcap";
	}
	
	@GetMapping("/showNewNhaCungCapForm")
	public String showNewNhaCungCapForm(Model model) {
		NhaCungCap nhacungcap = new NhaCungCap();
	    model.addAttribute("nhacungcap", nhacungcap);
	    return "admin/new_nhacungcap";
	 }
	
	@PostMapping("/saveNhaCungCap")
	public String saveNCC(@ModelAttribute("nhacungcap") NhaCungCap nhacungcap) {
		NhaCungCapService.saveNhaCungCap(nhacungcap);
		return "redirect:/page_nhacungcap";
	 }
	
	@GetMapping("/showFormForUpdateNCC/{maNCC}")
	public String showFormForUpdateNCC(@PathVariable ( value = "maNCC") long maNCC, Model model) {
		NhaCungCap nhacungcap = NhaCungCapService.getNhaCungCapById(maNCC);
		model.addAttribute("nhacungcap", nhacungcap);
		return "admin/update_nhacungcap";
	}
	
	@GetMapping("/deleteNCC/{maNCC}")
	public String deleteNCC(@PathVariable (value = "maNCC") long maNCC) {
		this.NhaCungCapService.deleteNhaCungCapById(maNCC);
		return "redirect:/page_nhacungcap";
	}
	
	/* Không được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchNCC"})
	public String home(NhaCungCap NhaCungCap, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listNhaCungCaps", NhaCungCapService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listNhaCungCaps", NhaCungCapService.getAllNhaCungCap());}
		return "admin/page_nhacungcap";
	 }
}
