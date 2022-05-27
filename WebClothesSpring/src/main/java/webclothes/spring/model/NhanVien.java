package webclothes.spring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nhanvien")
public class NhanVien{
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long maNV;

	/* Tránh viết cả 2 trùng nhau sẽ bị lỗi */
	  @Column(name = "HoTen")
	  private String hoTen;

	  @Column(name = "Email")
	  private String email;

	  @Column(name = "SDT")
	  private long sdt;
	  
	  @Column(name = "DiaChi")
	  private String diaChi;
	  
	  @Column(name = "CMND")
	  private String cmnd;
	  
	  @Column(name = "TaiKhoan")
	  private String taiKhoan;
	  
	  @Column(name = "MatKhau")
	  private String matKhau;
	  
	  @Column(name = "MaQuyen")
	  private long maQuyen;
	  
	  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	  @JoinTable(
			  name = "nhanvien_quyen",
	          joinColumns = @JoinColumn(name = "nhanvien_id"),
	          inverseJoinColumns = @JoinColumn(name = "quyen_id")
			  )
	  private Set<Quyen> quyens;
	  
	public Set<Quyen> getQuyens() {
		return quyens;
	}

	public void setQuyens(Set<Quyen> quyens) {
		this.quyens = quyens;
	}

	public long getMaNV() {
		return maNV;
	}

	public void setMaNV(long maNV) {
		this.maNV = maNV;
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

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public long getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(long maQuyen) {
		this.maQuyen = maQuyen;
	}
	  
}