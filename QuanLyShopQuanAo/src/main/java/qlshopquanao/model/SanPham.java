package qlshopquanao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	  private long donGia;
	  
	  @Column(name = "GhiChu")
	  private String ghiChu;
	  
	  @Column(name = "MaSize")
	  private long maSize;
	  
	  @Column(name = "MaLoaiSP")
	  private long maLoaiSP;

	public long getMaSP() {
		return maSP;
	}

	public void setMaSP(long maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getDacDiem() {
		return dacDiem;
	}

	public void setDacDiem(String dacDiem) {
		this.dacDiem = dacDiem;
	}

	public String getAnh() {
		return anh;
	}

	public void setAnh(String anh) {
		this.anh = anh;
	}

	public long getDonGia() {
		return donGia;
	}

	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public long getMaSize() {
		return maSize;
	}

	public void setMaSize(long maSize) {
		this.maSize = maSize;
	}

	public long getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(long maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

}
