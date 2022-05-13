package webclothes.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loaisanpham")
public class LoaiSanPham {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long maLoaiSP;

	/* Tránh viết cả 2 trùng nhau sẽ bị lỗi */
	  @Column(name = "TenLoaiSP")
	  private String tenLoaiSP;

	public long getMaLoaiSP() {
		return maLoaiSP;
	}

	public void setMaLoaiSP(long maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}

	public String getTenLoaiSP() {
		return tenLoaiSP;
	}

	public void setTenLoaiSP(String tenLoaiSP) {
		this.tenLoaiSP = tenLoaiSP;
	}

}
