package webclothes.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chitietphieunhap")
public class ChiTietPhieuNhap {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long maPN;

	/* Tránh viết cả 2 trùng nhau sẽ bị lỗi */
	  @Column(name = "MaSP")
	  private long maSP;

	  @Column(name = "SoLuongNhap")
	  private long soLuongNhap;

	  @Column(name = "donGiaNhap")
	  private long donGiaNhap;

	public long getMaPN() {
		return maPN;
	}

	public void setMaPN(long maPN) {
		this.maPN = maPN;
	}

	public long getMaSP() {
		return maSP;
	}

	public void setMaSP(long maSP) {
		this.maSP = maSP;
	}

	public long getSoLuongNhap() {
		return soLuongNhap;
	}

	public void setSoLuongNhap(long soLuongNhap) {
		this.soLuongNhap = soLuongNhap;
	}

	public long getDonGiaNhap() {
		return donGiaNhap;
	}

	public void setDonGiaNhap(long donGiaNhap) {
		this.donGiaNhap = donGiaNhap;
	}


}
