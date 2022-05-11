package qlshopquanao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import qlshopquanao.model.HoaDon;
import qlshopquanao.service.HoaDonService;

@Controller
public class HoaDonController {

	@Autowired
	private HoaDonService HoaDonService;
	
	@GetMapping("/page_hoadon")
	public String viewListHD(Model model) {
		model.addAttribute("listHoaDons", HoaDonService.getAllHoaDon());
		return "admin/page_hoadon";
	}
	
	@GetMapping("/showNewHoaDonForm")
	public String showNewHoaDonForm(Model model) {
		HoaDon hoadon = new HoaDon();
	    model.addAttribute("hoadon", hoadon);
	    return "admin/new_hoadon";
	 }
	 
	@PostMapping("/saveHoaDon")
	public String saveHD(@ModelAttribute("hoadon") HoaDon hoadon) {
		HoaDonService.saveHoaDon(hoadon);
		return "redirect:/page_hoadon";
	 }
	
	@GetMapping("/showFormForUpdateHD/{maHD}")
	public String showFormForUpdateHD(@PathVariable ( value = "maHD") long maHD, Model model) {
		HoaDon hoadon = HoaDonService.getHoaDonById(maHD);
		model.addAttribute("HoaDon", hoadon);
		return "admin/update_hoadon";
	}
	
	@GetMapping("/deleteHoaDon/{maHD}")
	public String deleteHoaDon(@PathVariable (value = "maHD") long maHD) {
		this.HoaDonService.deleteHoaDonById(maHD);
		return "redirect:/page_hoadon";
	}
	
	/* HDông được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchHD"})
	public String home(HoaDon HoaDon, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listHoaDons", HoaDonService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listHoaDons", HoaDonService.getAllHoaDon());}
		return "admin/page_hoadon";
	 }
}
