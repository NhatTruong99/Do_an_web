package qlshopquanao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "nhacungcap")
public class NhaCungCap {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long maNCC;

	/* Tránh viết cả 2 trùng nhau sẽ bị lỗi */
	  @Column(name = "TenNCC")
	  private String tenNCC;

	public long getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(long maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	  
}
