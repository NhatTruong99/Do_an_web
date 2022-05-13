package webclothes.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import webclothes.spring.model.Size;
import webclothes.spring.service.SizeService;

@Controller
public class SizeController {
	
	@Autowired
	private SizeService SizeService;
	
	@GetMapping("/page_size")
	public String viewListSize(Model model) {
		model.addAttribute("listSizes", SizeService.getAllSize());
		return "admin/page_size";
	}
	
	@GetMapping("/showNewSizeForm")
	public String showNewSizeForm(Model model) {
		Size size = new Size();
	    model.addAttribute("size", size);
	    return "admin/new_size";
	 }
	
	@PostMapping("/saveSize")
	public String saveSize(@ModelAttribute("size") Size size) {
		SizeService.saveSize(size);
		return "redirect:/page_size";
	 }
	
	@GetMapping("/showFormForUpdateSize/{maSize}")
	public String showFormForUpdateSize(@PathVariable ( value = "maSize") long maSize, Model model) {
		Size size = SizeService.getSizeById(maSize);
		model.addAttribute("size", size);
		return "admin/update_size";
	}
	
	@GetMapping("/deleteSize/{maSize}")
	public String deleteSize(@PathVariable (value = "maSize") long maSize) {
		this.SizeService.deleteSizeById(maSize);
		return "redirect:/page_size";
	}
	
	/* Không được trùng nên phải ghi search... để phân biệt (Nhớ ghi đúng bên html mới search được) */
	@RequestMapping({"/searchSize"})
	public String home(Size Size, Model model, String keyword) {
		if(keyword!=null) {
			model.addAttribute("listSizes", SizeService.getByKeyword(keyword));
		}
		else
		{
			model.addAttribute("listSizes", SizeService.getAllSize());}
		return "admin/page_size";
	 }
}
