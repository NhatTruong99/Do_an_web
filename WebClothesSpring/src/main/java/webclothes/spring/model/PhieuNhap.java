package webclothes.spring.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "phieunhap")
public class PhieuNhap {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long maPN;

	/* Tránh viết cả 2 trùng nhau sẽ bị lỗi */
	/* Bỏ @DateTimeFormat vào sẽ lỗi không New với Update Hoá Đơn mới được */
	  @Column(name = "NgayNhap")
	  private Date ngayNhap;

	  @Column(name = "MaNV")
	  private long maNV;

	  @Column(name = "MaNCC")
	  private long maNCC;

	public long getMaPN() {
		return maPN;
	}

	public void setMaPN(long maPN) {
		this.maPN = maPN;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public long getMaNV() {
		return maNV;
	}

	public void setMaNV(long maNV) {
		this.maNV = maNV;
	}

	public long getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(long maNCC) {
		this.maNCC = maNCC;
	}
}
