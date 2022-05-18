package webclothes.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import webclothes.spring.model.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Long> {
	//Custom query
	@Query(value = "SELECT * FROM sanpham sp WHERE sp.MaSP like %:keyword% or sp.TenSP like %:keyword% or sp.DacDiem like %:keyword% or sp.Anh like %:keyword% or sp.DonGia like %:keyword% or sp.GhiChu like %:keyword% or sp.MaSize like %:keyword% or sp.MaLoaiSP like %:keyword% ", nativeQuery = true)
	List<SanPham> findByKeyword(@Param("keyword") String keyword);
	
	@Query(value = "SELECT * FROM sanpham sp WHERE sp.MaLoaiSP like %:idCategory%", nativeQuery = true)
	List<SanPham> findByCategoryID(@Param("idCategory") long idCategory);
}
