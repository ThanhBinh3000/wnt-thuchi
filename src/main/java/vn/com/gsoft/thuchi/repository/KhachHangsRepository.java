package vn.com.gsoft.thuchi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.thuchi.entity.KhachHangs;

@Repository
public interface KhachHangsRepository extends CrudRepository<KhachHangs, Long> {
}
