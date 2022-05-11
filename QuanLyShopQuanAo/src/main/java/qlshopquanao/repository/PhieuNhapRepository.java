package qlshopquanao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import qlshopquanao.model.KhachHang;
import qlshopquanao.model.PhieuNhap;

@Repository
public interface PhieuNhapRepository extends JpaRepository<PhieuNhap, Long> {
	 //Custom query
	 @Query(value = "SELECT * FROM phieunhap pn WHERE pn.MaPN like %:keyword% or pn.NgayNhap like %:keyword% or pn.MaNV like %:keyword% or pn.MaNCC like %:keyword% ", nativeQuery = true)
	 List<PhieuNhap> findByKeyword(@Param("keyword") String keyword);
}
