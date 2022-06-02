package webclothes.spring.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import webclothes.spring.model.HoaDon;
import webclothes.spring.model.SanPham;
import webclothes.spring.repository.KhachHangRepository;
import webclothes.spring.repository.NhanVienRepository;
import webclothes.spring.repository.SanPhamRepository;
import webclothes.spring.service.SanPhamService;

@Controller
public class ThongKeController {

	@Autowired
	private SanPhamService SanPhamService;

	@Autowired
	private SanPhamRepository SanPhamRepository;
	
	@Autowired
	private KhachHangRepository KhachHangRepository;
	
	@Autowired
	private NhanVienRepository NhanVienRepository;
	
	@GetMapping("/page_thongke")
	public String viewPageThongKe(Model model) {
		model.addAttribute("countSP", SanPhamRepository.count());
		model.addAttribute("countKH", KhachHangRepository.count());
		model.addAttribute("countNV", NhanVienRepository.count());
		model.addAttribute("tongDoanhThu", SanPhamRepository.tongDoanhThu());
		String Date = java.time.LocalDate.now().toString();
		model.addAttribute("date",Date);
		model.addAttribute("tongDoanhThu_Ngay", SanPhamService.tongDoanhThu_Ngay(Date));
		return "admin/page_thongke";
	}
	
	
	@RequestMapping({ "/searchDoanhThu_Ngay" })
	public String searchDoanhThu_Ngay(HoaDon HoaDon, Model model, String date) {
		if (date != null) {
			model.addAttribute("countSP", SanPhamRepository.count());
			model.addAttribute("countKH", KhachHangRepository.count());
			model.addAttribute("countNV", NhanVienRepository.count());
			model.addAttribute("tongDoanhThu", SanPhamRepository.tongDoanhThu());
			
			model.addAttribute("tongDoanhThu_Ngay", SanPhamService.tongDoanhThu_Ngay(date));
		}
		else {
			return "admin/page_thongke";
		}
		return "admin/page_thongke";
	}
	
	@RequestMapping({ "/searchDoanhThu_Thang" })
	public String searchDoanhThu_Thang(HoaDon HoaDon, Model model, String month) {
		if (month != null) {
			model.addAttribute("countSP", SanPhamRepository.count());
			model.addAttribute("countKH", KhachHangRepository.count());
			model.addAttribute("countNV", NhanVienRepository.count());
			model.addAttribute("tongDoanhThu", SanPhamRepository.tongDoanhThu());
			
			model.addAttribute("tongDoanhThu_Thang", SanPhamService.tongDoanhThu_Ngay(month));
		}
		else {
			return "admin/page_thongke";
		}
		return "admin/page_thongke";
	}
	
}
