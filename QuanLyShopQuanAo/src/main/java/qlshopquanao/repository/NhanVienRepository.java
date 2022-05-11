package qlshopquanao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import qlshopquanao.model.NhanVien;


@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, Long> {

	//Custom query
	@Query(value = "SELECT * FROM nhanvien nv WHERE nv.MaNV like %:keyword% or nv.HoTen like %:keyword% or nv.Email like %:keyword% or nv.SDT like %:keyword% or nv.DiaChi like %:keyword% or nv.CMND like %:keyword% or nv.TaiKhoan like %:keyword% or nv.MatKhau like %:keyword% or nv.MaQuyen like %:keyword%", nativeQuery = true)
	List<NhanVien> findByKeyword(@Param("keyword") String keyword);
}
