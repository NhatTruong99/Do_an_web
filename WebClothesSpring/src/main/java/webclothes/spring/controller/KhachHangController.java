package webclothes.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webclothes.spring.model.KhachHang;
import webclothes.spring.model.NhanVien;
import webclothes.spring.service.KhachHangService;

@Controller
public class KhachHangController {

	@Autowired
	private KhachHangService KhachHangService;
	
	@GetMapping("/403/KH")
	public String error403_KH() {
		return "admin/403";
	}
	
	@GetMapping("/page_khachhang")
	public String viewListKH(Model model) {
		model.addAttribute("listKhachHangs", KhachHangService.getAllKhachHang());
		return findPaginatedKhachHang(1, "maKH", "asc", model);
		//	"admin/page_khachhang";
	}
	
	@GetMapping("/showNewKhachHangForm")
	public String showNewKhachHangForm(Model model) {
		KhachHang khachhang = new KhachHang();
	    model.addAttribute("khachhang", khachhang);
	    return "admin/new_khachhang";
	 }
	 
//	@PostMapping("/saveKhachHang")
//	public String saveKH(@ModelAttribute("khachhang") KhachHang khachhang) {
//		KhachHangService.saveKhachHang(khachhang);
//		return "redirect:/page_khachhang";
//	 }
	
	@PostMapping("/saveKhachHang")
	public String saveKH(@ModelAttribute("khachhang") @Valid KhachHang khachhang, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
		{
			return "admin/new_khachhang";
		}
		else 
		{
			KhachHangService.saveKhachHang(khachhang);
			return "redirect:/page_khachhang";
		}
		
	 }
	
	@PostMapping("/updateKhachHang")
	public String updateNV(@ModelAttribute("khachhang") @Valid KhachHang khachhang, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
		{
			return "admin/update_khachhang";
		}
		else 
		{
			KhachHangService.saveKhachHang(khachhang);
			return "redirect:/page_khachhang";
		}
		
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
	
	/* Kh??ng ???????c tr??ng n??n ph???i ghi search... ????? ph??n bi???t (Nh??? ghi ????ng b??n html m???i search ???????c) */
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
	
	@GetMapping("/pageKH/{pageNo}")
	public String findPaginatedKhachHang(@PathVariable(value = "pageNo") int pageNo,
	    @RequestParam("sortField") String sortField,
	    @RequestParam("sortDir") String sortDir,
	    Model model) {
	    int pageSize = 3;

	    Page<KhachHang> page = KhachHangService.findPaginatedNhaCungCap(pageNo, pageSize, sortField, sortDir);
	    List<KhachHang> listKhachHangs = page.getContent();

	    model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());

	    model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

	    model.addAttribute("listKhachHangs", listKhachHangs);
	    return "admin/page_khachhang";
	}
}
