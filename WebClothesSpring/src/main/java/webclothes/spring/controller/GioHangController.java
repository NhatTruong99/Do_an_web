package webclothes.spring.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import webclothes.spring.model.GioHangItem;
import webclothes.spring.service.GioHangService;
import webclothes.spring.service.LoaiSanPhamService;
import webclothes.spring.service.SanPhamService;

@Controller
public class GioHangController {

	
	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private LoaiSanPhamService loaiSanPhamService;
	
	@Autowired
	private GioHangService gioHangService;
	
	@GetMapping("/cart")
	public String ShopCart() {
		return "user/shopcart";
	}
	
	@GetMapping("/addcart/{id}/{quantity}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable(value = "id") long id, 
			@PathVariable(value = "quantity") int quantity, Model model) {
		HashMap<Long,GioHangItem> gioHang = (HashMap<Long,GioHangItem>)session.getAttribute("GioHang");
		if (gioHang == null) {
			gioHang = new HashMap<Long,GioHangItem>();
		}
		gioHang = gioHangService.AddGioHang(id,quantity, gioHang);
		session.setAttribute("GioHang", gioHang);
		session.setAttribute("TongTienGioHang", gioHangService.TotalPrice(gioHang));
		session.setAttribute("TongSLGioHang", gioHangService.TotalQuantity(gioHang));
		return "redirect:" + request.getHeader("Referer");//Refresh lại trang hiện tại
	}
	
	@GetMapping("/editcart/{id}/{quantity}")
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable(value = "id") long id,@PathVariable(value = "quantity") int quantity,Model model) {
		HashMap<Long,GioHangItem> gioHang = (HashMap<Long,GioHangItem>)session.getAttribute("GioHang");
		if (gioHang == null) {
			gioHang = new HashMap<Long,GioHangItem>();
		}
		
		gioHang = gioHangService.EditGioHang(id,quantity, gioHang);
		session.setAttribute("GioHang", gioHang);
		session.setAttribute("TongTienGioHang", gioHangService.TotalPrice(gioHang));
		session.setAttribute("TongSLGioHang", gioHangService.TotalQuantity(gioHang));
		return "redirect:" + request.getHeader("Referer");//Refresh lại trang hiện tại
	}
	
	@GetMapping("/Deletecart/{id}")
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable(value = "id") long id,Model model) {
		HashMap<Long,GioHangItem> gioHang = (HashMap<Long,GioHangItem>)session.getAttribute("GioHang");
		if (gioHang == null) {
			gioHang = new HashMap<Long,GioHangItem>();
		}
		gioHang = gioHangService.DeleteGioHang(id, gioHang);
		session.setAttribute("GioHang", gioHang);
		session.setAttribute("TongTienGioHang", gioHangService.TotalPrice(gioHang));
		session.setAttribute("TongSLGioHang", gioHangService.TotalQuantity(gioHang));
		return "redirect:" + request.getHeader("Referer");//Refresh lại trang hiện tại
	}
	
	@GetMapping("/paybill")
	public String PayTheBill() {
		
		return "user/paybill";
	}
}
