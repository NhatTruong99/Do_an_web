package webclothes.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import webclothes.spring.model.LoaiSanPham;
import webclothes.spring.model.NhanVien;
import webclothes.spring.model.SanPham;
import webclothes.spring.repository.NhanVienRepository;
import webclothes.spring.service.LoaiSanPhamService;
import webclothes.spring.service.QuyenService;
import webclothes.spring.service.SanPhamService;

@Controller
public class HomeController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private LoaiSanPhamService loaiSanPhamService;

	@Autowired 
	private QuyenService QuyenService;
	
	@Autowired
	private NhanVienRepository NhanVienRepository;
	
	 @GetMapping("/layout") 
	 public String LayoutPage(){
	        return "admin/layout";
	 }
	  
    @GetMapping("/login") 
    public String getLogin() {
        return "login";
    }
    
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new NhanVien());
        model.addAttribute("listQuyens", QuyenService.getAllQuyen());
        return "signup_form";
    }
    
    @PostMapping("/process_register")
    public String processRegister(NhanVien user) {
    	// Mã hoá mật khẩu lưu vào Database
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getMatKhau());
        user.setMatKhau(encodedPassword);
         
        NhanVienRepository.save(user);
         
        return "register_success";
    }
    
	@GetMapping("/")
	public String viewIndex(Model model) {
		List<SanPham> list = sanPhamService.getAllSanPham();
		List<SanPham> listSP = new ArrayList<SanPham>();
		for(int i=0;i< 10;i++) {
			listSP.add(list.get(i));
		}
		model.addAttribute("listLoaiSanPhams", loaiSanPhamService.getAllLoaiSanPham());
		model.addAttribute("listSanPhams",listSP );
		model.addAttribute("listSanPhams2",sanPhamService.getAllSanPham() );
		return "user/index";
	}

	// Trang Admin
	@GetMapping("/admin")
	public String viewAdmin(Model model) {
		
		model.addAttribute("listLoaiSanPhams", loaiSanPhamService.getAllLoaiSanPham());
		model.addAttribute("listSanPhams", sanPhamService.getAllSanPham());
		return "admin/layout";
	}
	@GetMapping("/logout")
	public String logout() {
		return "admin/logout";
	}
	// Trang liên hệ
	@GetMapping("/contact")
	public String Contact(Model model) {
		model.addAttribute("listLoaiSanPhams", loaiSanPhamService.getAllLoaiSanPham());
		return "user/contact";
	}

	// Trang tất cả sản phẩm
	/*
	 * @GetMapping("/categories") public String Categories(Model model) {
	 * model.addAttribute("listSanPhams",sanPhamService.getAllSanPham());
	 * model.addAttribute("listLoaiSanPhams",loaiSanPhamService.getAllLoaiSanPham())
	 * ; model.addAttribute("listSizes",sizeService.getAllSize()); return
	 * "user/categories"; }
	 */

	//Tìm kiếm sản phẩm
	@RequestMapping({ "/searchSpUser" })
	public String searchSpUser(SanPham SanPham, Model model, String keyword) {
		if (keyword != null) {
			model.addAttribute("listSanPhams", sanPhamService.getByKeywordWithUserPage(keyword));
			model.addAttribute("keyword",keyword);
		} else {
			model.addAttribute("listSanPhams", null);
		}
		model.addAttribute("listLoaiSanPhams", loaiSanPhamService.getAllLoaiSanPham());
		return "user/categories";
	}
	
	@GetMapping("/categories")
	public String Categories(Model model) {
		return findPaginated(1, model);
	}

	/*
	 * //Hiển thị sản phẩm theo loại
	 * 
	 * @GetMapping("/categories/{maLoaiSP}/page/{pageNo}") public String
	 * showProductByCategoryPagination(@PathVariable ( value = "maLoaiSP") long
	 * maLoaiSP, @PathVariable (value = "pageNo") int pageNo, Model model) { int
	 * pageSize = 5; Page<SanPham> page = sanPhamService.findPaginated(pageNo,
	 * pageSize); model.addAttribute("currentPage", pageNo);
	 * model.addAttribute("totalPages", page.getTotalPages());
	 * model.addAttribute("totalItems", page.getTotalElements());
	 * 
	 * //List<SanPham> listSP = sanPhamService.getByCategoryID(maLoaiSP);
	 * List<SanPham> listSP = page.getContent();
	 * model.addAttribute("listSanPhams",listSP);
	 * model.addAttribute("listLoaiSanPhams",loaiSanPhamService.getAllLoaiSanPham())
	 * ; model.addAttribute("listSizes",sizeService.getAllSize()); return
	 * "user/categories"; }
	 */
	
	//Hiển thị sản phẩm theo giá
	@GetMapping("/categories/price/{idPrice}")
	public String showProductWithMinMaxPrice(@PathVariable ( value = "idPrice") int idPrice, @RequestParam (value = "minPrice") int minPrice,
			@RequestParam (value = "maxPrice") int maxPrice, Model model) {
		List<SanPham> listSP = sanPhamService.getByMinMaxPrice(minPrice, maxPrice);
		model.addAttribute("listSanPhams",listSP);
		model.addAttribute("idPriceCheck",idPrice);
		model.addAttribute("listLoaiSanPhams",loaiSanPhamService.getAllLoaiSanPham());
		return "user/categories";
	}
	 //Hiển thị sản phẩm theo loại
	  
	 @GetMapping("/categories/{maLoaiSP}") 
	  public String showProductByCategory(@PathVariable ( value = "maLoaiSP") long maLoaiSP, Model model) {
		  List<SanPham> listSP = sanPhamService.getByCategoryID(maLoaiSP);
		  //List<SanPham> listSP = page.getContent();
		  model.addAttribute("listSanPhams",listSP);
		  model.addAttribute("listLoaiSanPhams",loaiSanPhamService.getAllLoaiSanPham());
		  model.addAttribute("loaiSanPham",loaiSanPhamService.getLoaiSanPhamById(maLoaiSP));
		  return "user/categories"; 
	 }

	// Trang chi tiết sản phẩm
	@GetMapping("/single/{maSP}")
	public String showProductById(@PathVariable(value = "maSP") long maSP, Model model) {
		SanPham sanPham = sanPhamService.getSanPhamById(maSP);
		int donGia = sanPham.getDonGia();
		String anh = sanPham.getAnh();

		List<LoaiSanPham> listLoaiSP = loaiSanPhamService.getAllLoaiSanPham();
		LoaiSanPham loaiSanPham = null;

		for (int i = 0; i < listLoaiSP.size(); i++) {
			if (sanPham.getMaLoaiSP() == listLoaiSP.get(i).getMaLoaiSP()) {
				loaiSanPham = listLoaiSP.get(i);
				break;
			}
		}
		model.addAttribute("sanPham", sanPham);
		model.addAttribute("donGia", donGia);
		model.addAttribute("loaiSanPham", loaiSanPham);
		model.addAttribute("listLoaiSanPhams",listLoaiSP);
		model.addAttribute("listSanPhams", sanPhamService.getAllSanPham());
		return "user/single";
	}

	// Phân trang
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value = "pageNo") int pageNo, Model model) {
		int pageSize = 8;
		Page<SanPham> page = sanPhamService.findPaginated(pageNo, pageSize);
		List<SanPham> listSanPhams = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listSanPhams", listSanPhams);

		// model.addAttribute("listSanPhams",sanPhamService.getAllSanPham());
		model.addAttribute("listLoaiSanPhams", loaiSanPhamService.getAllLoaiSanPham());

		return "user/categories";
	}

	// Phân trang
	@GetMapping("/categories/{maLoaiSP}/page/{pageNo}")
	public String findPaginatedCategories(@PathVariable(value = "pageNo") int pageNo, Model model) {
		int pageSize = 2;
		Page<SanPham> page = sanPhamService.findPaginated(pageNo, pageSize);
		List<SanPham> listSanPhams = page.getContent();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("listSanPhams", listSanPhams);

		// model.addAttribute("listSanPhams",sanPhamService.getAllSanPham());
		model.addAttribute("listLoaiSanPhams", loaiSanPhamService.getAllLoaiSanPham());

		return "user/categories";
	}

}
