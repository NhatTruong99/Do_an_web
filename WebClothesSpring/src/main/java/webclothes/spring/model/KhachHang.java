package webclothes.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "khachhang")
public class KhachHang {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long maKH;

	/* Tránh viết cả 2 trùng nhau sẽ bị lỗi */
	  @Column(name = "HoTen")
	  private String hoTen;

	  @Column(name = "Email")
	  private String email;

	  @Column(name = "SDT")
	  private long sdt;
	  
	  @Column(name = "DiaChi")
	  private String diaChi;

	public long getMaKH() {
		return maKH;
	}

	public void setMaKH(long maKH) {
		this.maKH = maKH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getSdt() {
		return sdt;
	}

	public void setSdt(long sdt) {
		this.sdt = sdt;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	

	  
}
