package webclothes.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webclothes.spring.model.NhanVien;
import webclothes.spring.service.NhanVienService;
import webclothes.spring.service.QuyenService;

@Controller
public class NhanVienController {
	
	@Autowired
	private NhanVienService NhanVienService;
	
	@Autowired QuyenService QuyenService;
	
	@GetMapping("/page_nhanvien")
	public String viewListNV(Model model) {
		model.addAttribute("listNhanViens", NhanVienService.getAllNhanVien());
		model.addAttribute("listQuyens", QuyenService.getAllQuyen());
		return "admin/page_nhanvien";
	}
	
	@GetMapping("/showNewNhanVienForm")
	public String showNewNhanVienForm(Model model) {
		NhanVien nhanvien = new NhanVien();
	    model.addAttribute("nhanvien",nhanvien);
	    model.addAttribute("listQuyens", QuyenService.getAllQuyen());
	    return "admin/new_nhanvien";
	 }
	 
	@PostMapping("/saveNhanVien")
	public String saveNV(@ModelAttribute("nhanvien") NhanVien nhanvien) {
		NhanVienService.saveNhanVien(nhanvien);
		return "redirect:/page_nhanvien";
	 }
	
	@GetMapping("/showFormForUpdateNV/{maNV}")
	public String showFormForUpdateNV(@PathVariable ( value = "maNV") long maNV, Model model) {
		NhanVien nhanvien = NhanVienService.getNhanVienById(maNV);
		model.addAttribute("nhanvien", nhanvien);
		model.addAttribute("listQuyens", QuyenService.getAllQuyen());
		return "admin/update_nhanvien";
	}
	
	@GetMapping("/deleteNhanVien/{maNV}")
	public String deleteNhanVien(@PathVariable (value = "maNV") long maNV) {
		this.NhanVienService.deleteNhanVienById(maNV);
		return "redirect:/page_nhanvien";
	}
	
	/* NVông được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchNV"})
	public String home(NhanVien NhanVien, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listNhanViens", NhanVienService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listNhanViens", NhanVienService.getAllNhanVien());}
		return "admin/page_nhanvien";
	 }
}
