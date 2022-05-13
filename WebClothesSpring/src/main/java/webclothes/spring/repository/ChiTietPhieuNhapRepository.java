package webclothes.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import webclothes.spring.model.ChiTietPhieuNhap;

@Repository
public interface ChiTietPhieuNhapRepository extends JpaRepository<ChiTietPhieuNhap, Long>{
	//Custom query
		@Query(value = "SELECT * FROM chitietphieunhap ctpn WHERE ctpn.MaPN like %:keyword% or ctpn.MaSP like %:keyword% or ctpn.SoLuongNhap like %:keyword% or ctpn.DonGiaNhap like %:keyword%", nativeQuery = true)
		List<ChiTietPhieuNhap> findByKeyword(@Param("keyword") String keyword);
}
