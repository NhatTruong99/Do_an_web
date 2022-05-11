package qlshopquanao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import qlshopquanao.model.LoaiSanPham;
import qlshopquanao.model.NhaCungCap;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Long>{
	//Custom query
	 @Query(value = "SELECT * FROM nhacungcap ncc WHERE ncc.MaNCC like %:keyword% or ncc.TenNCC like %:keyword%", nativeQuery = true)
	 List<NhaCungCap> findByKeyword(@Param("keyword") String keyword);

}
