package webclothes.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "size")
public class Size {


	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long maSize;

	/* Tránh viết cả 2 trùng nhau sẽ bị lỗi */
	  @Column(name = "TenSize")
	  private String tenSize;
	  
	  @Column(name = "ChieuCao")
	  private String chieuCao;
	  
	  @Column(name = "CanNang")
	  private String canNang;

	public long getMaSize() {
		return maSize;
	}

	public void setMaSize(long maSize) {
		this.maSize = maSize;
	}

	public String getTenSize() {
		return tenSize;
	}

	public void setTenSize(String tenSize) {
		this.tenSize = tenSize;
	}

	public String getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(String chieuCao) {
		this.chieuCao = chieuCao;
	}

	public String getCanNang() {
		return canNang;
	}

	public void setCanNang(String canNang) {
		this.canNang = canNang;
	}
	  
	  

}
