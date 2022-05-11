package qlshopquanao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import qlshopquanao.model.Quyen;

@Repository
public interface QuyenRepository extends JpaRepository<Quyen, Long> {
	//Custom query
	@Query(value = "SELECT * FROM quyen q WHERE q.MaQuyen like %:keyword% or q.TenQuyen like %:keyword%", nativeQuery = true)
	List<Quyen> findByKeyword(@Param("keyword") String keyword);

}
