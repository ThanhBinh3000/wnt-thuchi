package vn.com.gsoft.thuchi.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.com.gsoft.thuchi.entity.PhieuThuChis;
import vn.com.gsoft.thuchi.model.dto.PhieuThuChisReq;

import java.util.List;

@Repository
public interface PhieuThuChisRepository extends BaseRepository<PhieuThuChis, PhieuThuChisReq, Long> {
  @Query("SELECT c FROM PhieuThuChis c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.soPhieu} IS NULL OR c.soPhieu = :#{#param.soPhieu}) "
          + " AND (:#{#param.dienGiai} IS NULL OR lower(c.dienGiai) LIKE lower(concat('%',CONCAT(:#{#param.dienGiai},'%'))))"
//          + " AND (:#{#param.ngayTao} IS NULL OR c.ngayTao >= :#{#param.ngayTaoFrom}) "
//          + " AND (:#{#param.ngayTao} IS NULL OR c.ngayTao <= :#{#param.ngayTaoTo}) "
          + " AND (:#{#param.loaiPhieu} IS NULL OR c.loaiPhieu = :#{#param.loaiPhieu}) "
          + " AND (:#{#param.nhaThuocMaNhaThuoc} IS NULL OR lower(c.nhaThuocMaNhaThuoc) LIKE lower(concat('%',CONCAT(:#{#param.nhaThuocMaNhaThuoc},'%'))))"
          + " AND (:#{#param.khachHangMaKhachHang} IS NULL OR c.khachHangMaKhachHang = :#{#param.khachHangMaKhachHang}) "
          + " AND (:#{#param.nhaCungCapMaNhaCungCap} IS NULL OR c.nhaCungCapMaNhaCungCap = :#{#param.nhaCungCapMaNhaCungCap}) "
          + " AND (:#{#param.userProfileUserId} IS NULL OR c.userProfileUserId = :#{#param.userProfileUserId}) "
          + " AND (:#{#param.amount} IS NULL OR c.amount = :#{#param.amount}) "
//          + " AND (:#{#param.created} IS NULL OR c.created >= :#{#param.createdFrom}) "
//          + " AND (:#{#param.created} IS NULL OR c.created <= :#{#param.createdTo}) "
//          + " AND (:#{#param.modified} IS NULL OR c.modified >= :#{#param.modifiedFrom}) "
//          + " AND (:#{#param.modified} IS NULL OR c.modified <= :#{#param.modifiedTo}) "
          + " AND (:#{#param.createdByUserId} IS NULL OR c.createdByUserId = :#{#param.createdByUserId}) "
//          + " AND (:#{#param.modifiedByUserId} IS NULL OR c.modifiedByUserId = :#{#param.modifiedByUserId}) "
          + " AND (:#{#param.nguoiNhan} IS NULL OR lower(c.nguoiNhan) LIKE lower(concat('%',CONCAT(:#{#param.nguoiNhan},'%'))))"
          + " AND (:#{#param.diaChi} IS NULL OR lower(c.diaChi) LIKE lower(concat('%',CONCAT(:#{#param.diaChi},'%'))))"
          + " AND (:#{#param.loaiThuChiMaLoaiPhieu} IS NULL OR c.loaiThuChiMaLoaiPhieu = :#{#param.loaiThuChiMaLoaiPhieu}) "
          + " AND (:#{#param.customerId} IS NULL OR c.customerId = :#{#param.customerId}) "
          + " AND (:#{#param.supplierId} IS NULL OR c.supplierId = :#{#param.supplierId}) "
          + " AND (:#{#param.archivedId} IS NULL OR c.archivedId = :#{#param.archivedId}) "
          + " AND (:#{#param.storeId} IS NULL OR c.storeId = :#{#param.storeId}) "
          + " AND (:#{#param.paymentTypeId} IS NULL OR c.paymentTypeId = :#{#param.paymentTypeId}) "
          + " AND (:#{#param.maCoSo} IS NULL OR lower(c.maCoSo) LIKE lower(concat('%',CONCAT(:#{#param.maCoSo},'%'))))"
          + " AND (:#{#param.nhanVienId} IS NULL OR c.nhanVienId = :#{#param.nhanVienId}) "
          + " AND (:#{#param.rewardProgramId} IS NULL OR c.rewardProgramId = :#{#param.rewardProgramId}) "
//          + " AND (:#{#param.fromDate} IS NULL OR c.fromDate >= :#{#param.fromDateFrom}) "
//          + " AND (:#{#param.fromDate} IS NULL OR c.fromDate <= :#{#param.fromDateTo}) "
//          + " AND (:#{#param.toDate} IS NULL OR c.toDate >= :#{#param.toDateFrom}) "
//          + " AND (:#{#param.toDate} IS NULL OR c.toDate <= :#{#param.toDateTo}) "
          + " ORDER BY c.id desc"
  )
  Page<PhieuThuChis> searchPage(@Param("param") PhieuThuChisReq param, Pageable pageable);
  
  
  @Query("SELECT c FROM PhieuThuChis c " +
         "WHERE 1=1 "
          + " AND (:#{#param.id} IS NULL OR c.id = :#{#param.id}) "
          + " AND (:#{#param.soPhieu} IS NULL OR c.soPhieu = :#{#param.soPhieu}) "
          + " AND (:#{#param.dienGiai} IS NULL OR lower(c.dienGiai) LIKE lower(concat('%',CONCAT(:#{#param.dienGiai},'%'))))"
//          + " AND (:#{#param.ngayTao} IS NULL OR c.ngayTao >= :#{#param.ngayTaoFrom}) "
//          + " AND (:#{#param.ngayTao} IS NULL OR c.ngayTao <= :#{#param.ngayTaoTo}) "
          + " AND (:#{#param.loaiPhieu} IS NULL OR c.loaiPhieu = :#{#param.loaiPhieu}) "
          + " AND (:#{#param.nhaThuocMaNhaThuoc} IS NULL OR lower(c.nhaThuocMaNhaThuoc) LIKE lower(concat('%',CONCAT(:#{#param.nhaThuocMaNhaThuoc},'%'))))"
          + " AND (:#{#param.khachHangMaKhachHang} IS NULL OR c.khachHangMaKhachHang = :#{#param.khachHangMaKhachHang}) "
          + " AND (:#{#param.nhaCungCapMaNhaCungCap} IS NULL OR c.nhaCungCapMaNhaCungCap = :#{#param.nhaCungCapMaNhaCungCap}) "
          + " AND (:#{#param.userProfileUserId} IS NULL OR c.userProfileUserId = :#{#param.userProfileUserId}) "
          + " AND (:#{#param.amount} IS NULL OR c.amount = :#{#param.amount}) "
//          + " AND (:#{#param.created} IS NULL OR c.created >= :#{#param.createdFrom}) "
//          + " AND (:#{#param.created} IS NULL OR c.created <= :#{#param.createdTo}) "
//          + " AND (:#{#param.modified} IS NULL OR c.modified >= :#{#param.modifiedFrom}) "
//          + " AND (:#{#param.modified} IS NULL OR c.modified <= :#{#param.modifiedTo}) "
          + " AND (:#{#param.createdByUserId} IS NULL OR c.createdByUserId = :#{#param.createdByUserId}) "
//          + " AND (:#{#param.modifiedByUserId} IS NULL OR c.modifiedByUserId = :#{#param.modifiedByUserId}) "
          + " AND (:#{#param.nguoiNhan} IS NULL OR lower(c.nguoiNhan) LIKE lower(concat('%',CONCAT(:#{#param.nguoiNhan},'%'))))"
          + " AND (:#{#param.diaChi} IS NULL OR lower(c.diaChi) LIKE lower(concat('%',CONCAT(:#{#param.diaChi},'%'))))"
          + " AND (:#{#param.loaiThuChiMaLoaiPhieu} IS NULL OR c.loaiThuChiMaLoaiPhieu = :#{#param.loaiThuChiMaLoaiPhieu}) "
          + " AND (:#{#param.customerId} IS NULL OR c.customerId = :#{#param.customerId}) "
          + " AND (:#{#param.supplierId} IS NULL OR c.supplierId = :#{#param.supplierId}) "
          + " AND (:#{#param.archivedId} IS NULL OR c.archivedId = :#{#param.archivedId}) "
          + " AND (:#{#param.storeId} IS NULL OR c.storeId = :#{#param.storeId}) "
          + " AND (:#{#param.paymentTypeId} IS NULL OR c.paymentTypeId = :#{#param.paymentTypeId}) "
          + " AND (:#{#param.maCoSo} IS NULL OR lower(c.maCoSo) LIKE lower(concat('%',CONCAT(:#{#param.maCoSo},'%'))))"
          + " AND (:#{#param.nhanVienId} IS NULL OR c.nhanVienId = :#{#param.nhanVienId}) "
          + " AND (:#{#param.rewardProgramId} IS NULL OR c.rewardProgramId = :#{#param.rewardProgramId}) "
//          + " AND (:#{#param.fromDate} IS NULL OR c.fromDate >= :#{#param.fromDateFrom}) "
//          + " AND (:#{#param.fromDate} IS NULL OR c.fromDate <= :#{#param.fromDateTo}) "
//          + " AND (:#{#param.toDate} IS NULL OR c.toDate >= :#{#param.toDateFrom}) "
//          + " AND (:#{#param.toDate} IS NULL OR c.toDate <= :#{#param.toDateTo}) "
          + " ORDER BY c.id desc"
  )
  List<PhieuThuChis> searchList(@Param("param") PhieuThuChisReq param);

}
