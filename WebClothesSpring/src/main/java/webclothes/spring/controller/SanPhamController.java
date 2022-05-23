package webclothes.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import webclothes.spring.model.FileUploadUtil;
import webclothes.spring.model.SanPham;
import webclothes.spring.repository.SanPhamRepository;
import webclothes.spring.service.LoaiSanPhamService;
import webclothes.spring.service.SanPhamService;
import webclothes.spring.service.SizeService;

@Controller
public class SanPhamController {

	@Autowired
	private SanPhamService SanPhamService;
	
	@Autowired
	private SizeService SizeService;
	
	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;
	
	@Autowired
	private SanPhamRepository SanPhamRepository;
	
	@GetMapping("/page_sanpham")
	public String viewListSP(Model model) {
		model.addAttribute("listSanPhams", SanPhamService.getAllSanPham());
		model.addAttribute("listSizes", SizeService.getAllSize());
		model.addAttribute("listLoaiSanPhams", LoaiSanPhamService.getAllLoaiSanPham());
		return "admin/page_sanpham";
	}
	
	@GetMapping("/showNewSanPhamForm")
	public String showNewSanPhamForm(Model model) {
		SanPham sanpham = new SanPham();
	    model.addAttribute("sanpham",sanpham);
	    model.addAttribute("listSizes", SizeService.getAllSize());
		model.addAttribute("listLoaiSanPhams", LoaiSanPhamService.getAllLoaiSanPham());
	    return "admin/new_sanpham";
	 }
	 
	
//	@PostMapping("/saveSanPham")
//	public String saveSP(@ModelAttribute("sanpham") SanPham sanpham) {
//		SanPhamService.saveSanPham(sanpham);
//		return "redirect:/page_sanpham";
//	 }
	@PostMapping("/saveSanPham")
    public RedirectView saveSP(SanPham sanpham,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
         
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        sanpham.setAnh(fileName);
         
        SanPham savedSanPham = SanPhamRepository.save(sanpham);
 
//        String uploadDir = "user-photos/" + savedSanPham.getMaSP();
        String uploadDir = "src/main/resources/static/images";
        String uploadDir1 = "target/classes/static/images";

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        FileUploadUtil.saveFile(uploadDir1, fileName, multipartFile);

        return new RedirectView("/page_sanpham", true);
    }
	
	
	@GetMapping("/showFormForUpdateSP/{maSP}")
	public String showFormForUpdateSP(@PathVariable ( value = "maSP") long maSP, Model model) {
		SanPham sanpham = SanPhamService.getSanPhamById(maSP);
		model.addAttribute("sanpham", sanpham);
		model.addAttribute("listSizes", SizeService.getAllSize());
		model.addAttribute("listLoaiSanPhams", LoaiSanPhamService.getAllLoaiSanPham());
		return "admin/update_sanpham";
	}
	
	@GetMapping("/deleteSanPham/{maSP}")
	public String deleteSanPham(@PathVariable (value = "maSP") long maSP) {
		this.SanPhamService.deleteSanPhamById(maSP);
		return "redirect:/page_sanpham";
	}
	
	/* SPông được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchSP"})
	public String home(SanPham SanPham, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listSanPhams", SanPhamService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listSanPhams", SanPhamService.getAllSanPham());}
		return "admin/page_sanpham";
	 }
	

}
