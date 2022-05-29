package webclothes.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import webclothes.spring.model.PhanQuyen;
import webclothes.spring.model.Quyen;

@Repository
public interface PhanQuyenRepository extends JpaRepository<PhanQuyen, Long>{
	//Custom query
	@Query(value = "SELECT * FROM nhanvien_quyen nvq WHERE nvq.nhanvien_id like %:keyword% or nvq.quyen_id like %:keyword%", nativeQuery = true)
	List<PhanQuyen> findByKeyword(@Param("keyword") String keyword);

}