package qlshopquanao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import qlshopquanao.model.NhaCungCap;
import qlshopquanao.model.Size;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {
	//Custom query
	@Query(value = "SELECT * FROM size sz WHERE sz.MaSize like %:keyword% or sz.TenSize like %:keyword% or sz.ChieuCao like %:keyword% or sz.CanNang like %:keyword%" , nativeQuery = true)
	List<Size> findByKeyword(@Param("keyword") String keyword);

}
