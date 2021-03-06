package webclothes.spring.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name = "quyen")
public class Quyen{
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long maQuyen;

	/* Tránh viết cả 2 trùng nhau sẽ bị lỗi */
	  @NotBlank(message = "Tên Quyền không được để trống")
	  @Column(name = "TenQuyen")
	  private String tenQuyen;

	public long getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(long maQuyen) {
		this.maQuyen = maQuyen;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	  
	  
}
	  
