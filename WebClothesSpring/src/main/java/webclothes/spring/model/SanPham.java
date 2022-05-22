package webclothes.spring.model;

import java.beans.Transient;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "SanPham")
public class SanPham {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long maSP;

	/* Tránh viết cả 2 trùng nhau sẽ bị lỗi */
	  @Column(name = "TenSP")
	  private String tenSP;

	  @Column(name = "DacDiem")
	  private String dacDiem;

	  @Column(name = "Anh")
	  private String anh;
	  
	  @Column(name = "DonGia")
	  private int donGia;
	  
	  @Column(name = "GhiChu")
	  private String ghiChu;
	  
	  @Column(name = "MaSize")
	  private long maSize;
	  
	  @Column(name = "MaLoaiSP")
	  private long maLoaiSP;
	  
	 @Transient
	 public String getPhotosImagePath() {
		 if (anh == null) return null;
	     	return "src/main/resources/static/images" + anh;
	    }  

	public long getMaSP() {
		return maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public String getDacDiem() {
		return dacDiem;
	}

	public String getAnh() {
		return anh;
	}

	public int getDonGia() {
		return donGia;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public long getMaSize() {
		return maSize;
	}

	public long getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaSP(long maSP) {
		this.maSP = maSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public void setDacDiem(String dacDiem) {
		this.dacDiem = dacDiem;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public void setMaSize(long maSize) {
		this.maSize = maSize;
	}

	public void setMaLoaiSP(long maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	

}
