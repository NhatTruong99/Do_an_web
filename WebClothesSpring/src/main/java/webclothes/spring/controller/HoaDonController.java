package webclothes.spring.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webclothes.spring.model.HoaDon;
import webclothes.spring.model.NhaCungCap;
import webclothes.spring.service.HoaDonService;
import webclothes.spring.service.KhachHangService;

@Controller
public class HoaDonController {

	@Autowired
	private HoaDonService HoaDonService;
	
	@Autowired
	private KhachHangService KhachHangService;
	
	@GetMapping("/page_hoadon")
	public String viewListHD(Model model) {
		model.addAttribute("listHoaDons", HoaDonService.getAllHoaDon());
		model.addAttribute("listKhachHangs", KhachHangService.getAllKhachHang());
		return findPaginatedHoaDon(1, "maHD", "asc", model);
		// 	"admin/page_hoadon";
	}
	
	@GetMapping("/showNewHoaDonForm")
	public String showNewHoaDonForm(Model model) {
		HoaDon hoadon = new HoaDon();
	    model.addAttribute("hoadon", hoadon);
	    model.addAttribute("listKhachHangs", KhachHangService.getAllKhachHang());
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
		model.addAttribute("listKhachHangs", KhachHangService.getAllKhachHang());
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
	
	@GetMapping("/pageHD/{pageNo}")
	public String findPaginatedHoaDon(@PathVariable(value = "pageNo") int pageNo,
	    @RequestParam("sortField") String sortField,
	    @RequestParam("sortDir") String sortDir,
	    Model model) {
	    int pageSize = 3;

	    Page<HoaDon> page = HoaDonService.findPaginatedHoaDon(pageNo, pageSize, sortField, sortDir);
	    List<HoaDon> listHoaDons = page.getContent();

	    model.addAttribute("currentPage", pageNo);
	    model.addAttribute("totalPages", page.getTotalPages());
	    model.addAttribute("totalItems", page.getTotalElements());

	    model.addAttribute("sortField", sortField);
	    model.addAttribute("sortDir", sortDir);
	    model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

	    model.addAttribute("listHoaDons", listHoaDons);
	    return "admin/page_hoadon";
	}
}
