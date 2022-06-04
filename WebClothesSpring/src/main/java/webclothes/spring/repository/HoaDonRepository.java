package webclothes.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import webclothes.spring.model.ChiTietHoaDon;
import webclothes.spring.model.HoaDon;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {

	 //Custom query
	 @Query(value = "SELECT * FROM hoadon hd JOIN khachhang kh on hd.maKH = kh.maKH WHERE hd.MaHD like %:keyword% or hd.SHD like %:keyword% or hd.NgayDat like %:keyword% or hd.NgayGiao like %:keyword% or hd.DiaChiNhan like %:keyword% or hd.TinhTrang like %:keyword% or kh.hoTen like %:keyword%", nativeQuery = true)
	 List<HoaDon> findByKeyword(@Param("keyword") String keyword);

}
