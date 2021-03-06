package webclothes.spring.controller;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import webclothes.spring.model.ChiTietHoaDon;
import webclothes.spring.model.GioHangItem;
import webclothes.spring.model.HoaDon;
import webclothes.spring.model.KhachHang;
import webclothes.spring.service.ChiTietHoaDonService;
import webclothes.spring.service.GioHangService;
import webclothes.spring.service.HoaDonService;
import webclothes.spring.service.KhachHangService;
import webclothes.spring.service.LoaiSanPhamService;
import webclothes.spring.service.SanPhamService;

@Controller
public class GioHangController {

	
	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private KhachHangService khachHangService;
	
	@Autowired
	private LoaiSanPhamService loaiSanPhamService;
	
	@Autowired
	private GioHangService gioHangService;
	
	@Autowired
	private HoaDonService hoaDonService;
	
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
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
		return "redirect:" + request.getHeader("Referer");//Refresh l???i trang hi???n t???i
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
		return "redirect:" + request.getHeader("Referer");//Refresh l???i trang hi???n t???i
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
		return "redirect:" + request.getHeader("Referer");//Refresh l???i trang hi???n t???i
	}
	
	
	@GetMapping("/paybill")
	public String PayTheBill(Model model) {
		KhachHang khachhang = new KhachHang();
	    model.addAttribute("khachhang", khachhang);
	   
		return "user/paybill";
	}
	
	@GetMapping("/checkInsert")
	public String Check(HttpServletRequest request) {
		return "redirect:" + request.getHeader("Referer");
	}
	
//	@GetMapping("/paydone")
//	public String Done() {
//		return "user/paydone";
//	}
	
	@PostMapping("/checkoutbill")
	public String CheckOutBill(HttpServletRequest request, HttpSession session,
			@ModelAttribute("khachhang") @Valid  KhachHang khachhang, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) 
		{
			return "user/paybill";
		} else {
			List<KhachHang> listKHs = khachHangService.getAllKhachHang();
			boolean chooseMaKH = false;
			long maKH = 1;
			
			//N???u c?? kh??ch h??ng tr??ng t??n,email,sdt,diachi v???i kh??ch h??ng c?? trong database th?? l???y kh??ch h??ng trong database
			for(int i=0;i<listKHs.size(); i++) {
				if (khachhang.getHoTen().equals(listKHs.get(i).getHoTen())
					&& khachhang.getEmail().equals(listKHs.get(i).getEmail())	
					&& khachhang.getSdt().equals(listKHs.get(i).getSdt())
					&& khachhang.getDiaChi().equals(listKHs.get(i).getDiaChi())
					) 
				{
					maKH = listKHs.get(i).getMaKH();
					chooseMaKH = true;
					break;
				}
			}
			
			if (chooseMaKH == false) {
				khachHangService.saveKhachHang(khachhang);
				maKH = khachHangService.getLastIdKhachHang();
			}
			HoaDon hoaDon = new HoaDon();
			//S??? h??a ????n
			long millis=System.currentTimeMillis();  
			java.sql.Date today=new java.sql.Date(millis); 
			String toDayString = today.toString().replaceAll("-","");
			long lastIDHoaDon = hoaDonService.getLastIdHoaDon() + 1;
			String soHD = "HD" + toDayString + "0" + lastIDHoaDon;
			hoaDon.setShd(soHD);
			//Ng??y ?????t 
			hoaDon.setNgayDat(today);
			//?????a ch??? nh???n
			String diaChi = khachHangService.getKhachHangById(maKH).getDiaChi();
			hoaDon.setDiaChiNhan(diaChi);
			//T??nh tr???ng
			hoaDon.setTinhTrang("Ch??a x??c nh???n");
			//M?? kh??ch h??ng
			hoaDon.setMaKH(maKH);
			//L??u h??a ????n
			hoaDonService.saveHoaDon(hoaDon);
			//L??u chi ti???t h??a ????n
			long maHD = hoaDonService.getLastIdHoaDon();
			HashMap<Long,GioHangItem> gioHang = (HashMap<Long,GioHangItem>)session.getAttribute("GioHang");
			for(Map.Entry<Long, GioHangItem> gioHangItem : gioHang.entrySet()) {
				ChiTietHoaDon cthd = new ChiTietHoaDon();
				cthd.setMaHD(maHD);
				cthd.setMaSP(gioHangItem.getValue().getSanPham().getMaSP());
				cthd.setSoLuong(gioHangItem.getValue().getSoLuong());
				cthd.setDonGia(gioHangItem.getValue().getSanPham().getDonGia());
				
				chiTietHoaDonService.addChiTietHoaDonUseQuery(cthd);
			}
			//X??a session
			session.removeAttribute("GioHang");
			session.removeAttribute("TongTienGioHang");
			session.removeAttribute("TongSLGioHang");
			
			return "user/paydone";
		}

	 }
}
