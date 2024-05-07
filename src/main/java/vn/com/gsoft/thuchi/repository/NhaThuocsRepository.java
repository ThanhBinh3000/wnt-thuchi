package vn.com.gsoft.thuchi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.thuchi.entity.NhaThuocs;

import java.util.Optional;

@Repository
public interface NhaThuocsRepository extends CrudRepository<NhaThuocs, Long> {
    Optional<NhaThuocs> findByMaNhaThuoc(String nhaThuocMaNhaThuoc);
}
