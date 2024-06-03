package vn.com.gsoft.thuchi.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.gsoft.thuchi.model.dto.DebtInfoRes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PhieuThuChis")
@Entity
public class PhieuThuChis extends BaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SoPhieu")
    private Long soPhieu;
    @Column(name = "DienGiai")
    private String dienGiai;
    @Column(name = "NgayTao")
    private Date ngayTao;
    @Column(name = "LoaiPhieu")
    private Integer loaiPhieu;
    @Column(name = "NhaThuoc_MaNhaThuoc")
    private String nhaThuocMaNhaThuoc;
    @Column(name = "KhachHang_MaKhachHang")
    private Long khachHangMaKhachHang;
    @Column(name = "NhaCungCap_MaNhaCungCap")
    private Long nhaCungCapMaNhaCungCap;
    @Column(name = "UserProfile_UserId")
    private Long userProfileUserId;
    @Column(name = "Amount")
    private BigDecimal amount;
    @Column(name = "NguoiNhan")
    private String nguoiNhan;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "LoaiThuChi_MaLoaiPhieu")
    private Integer loaiThuChiMaLoaiPhieu;
    @Column(name = "Active")
    private Boolean active;
    @Column(name = "CustomerId")
    private Long customerId;
    @Column(name = "SupplierId")
    private Long supplierId;
    @Column(name = "ArchivedId")
    private Integer archivedId;
    @Column(name = "StoreId")
    private Long storeId;
    @Column(name = "PaymentTypeId")
    private Integer paymentTypeId;
    @Column(name = "MaCoSo")
    private String maCoSo;
    @Column(name = "NhanVienId")
    private Long nhanVienId;
    @Column(name = "RewardProgramId")
    private Integer rewardProgramId;
    @Column(name = "FromDate")
    private Date fromDate;
    @Column(name = "ToDate")
    private Date toDate;
    @Transient
    private String createdByUserText;
    @Transient
    private String customerText;
    @Transient
    private String nhaCungCapMaNhaCungCapText;
    @Transient
    private String nhanVienText;
    @Transient
    private NhaThuocs nhaThuocs;
}

