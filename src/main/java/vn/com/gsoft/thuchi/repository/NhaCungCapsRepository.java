package vn.com.gsoft.thuchi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.thuchi.entity.NhaCungCaps;

@Repository
public interface NhaCungCapsRepository extends CrudRepository<NhaCungCaps,Long> {
}
