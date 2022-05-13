package webclothes.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import webclothes.spring.model.ChiTietHoaDon;

@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, Long> {
	//Custom query
	@Query(value = "SELECT * FROM chitiethoadon cthd WHERE cthd.MaHD like %:keyword% or cthd.MaSP like %:keyword% or cthd.SoLuong like %:keyword% or cthd.DonGia like %:keyword%", nativeQuery = true)
	List<ChiTietHoaDon> findByKeyword(@Param("keyword") String keyword);
}
