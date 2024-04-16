package vn.com.gsoft.thuchi.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhieuNhapChiTiets")
public class PhieuNhapChiTiets extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaPhieuNhapCt")
    private Integer maPhieuNhapCt;
    @Column(name = "PhieuNhap_MaPhieuNhap")
    private Integer phieuNhapMaPhieuNhap;
    @Column(name = "NhaThuoc_MaNhaThuoc")
    private String nhaThuocMaNhaThuoc;
    @Column(name = "Thuoc_ThuocId")
    private Integer thuocThuocId;
    @Column(name = "DonViTinh_MaDonViTinh")
    private Integer donViTinhMaDonViTinh;
    @Column(name = "ChietKhau")
    private BigDecimal chietKhau;
    @Column(name = "GiaNhap")
    private BigDecimal giaNhap;
    @Column(name = "SoLuong")
    private BigDecimal soLuong;
    @Column(name = "Option1")
    private String option1;
    @Column(name = "Option2")
    private String option2;
    @Column(name = "Option3")
    private String option3;
    @Column(name = "Option4")
    private String option4;
    @Column(name = "Option5")
    private String option5;
    @Column(name = "SoLo")
    private String soLo;
    @Column(name = "HanDung")
    private Date hanDung;
    @Column(name = "RemainRefQuantity")
    private Float remainRefQuantity;
    @Column(name = "RetailQuantity")
    private Float retailQuantity;
    @Column(name = "PreRetailQuantity")
    private Float preRetailQuantity;
    @Column(name = "HandledStatusId")
    private Integer handledStatusId;
    @Column(name = "RetailPrice")
    private Float retailPrice;
    @Column(name = "RequestUpdateFromBkgService")
    private Boolean requestUpdateFromBkgService;
    @Column(name = "ReduceNoteItemIds")
    private String reduceNoteItemIds;
    @Column(name = "ReduceQuantity")
    private Float reduceQuantity;
    @Column(name = "IsModified")
    private Boolean isModified;
    @Column(name = "GiaBanLe")
    private BigDecimal giaBanLe;
    @Column(name = "RetailOutPrice")
    private Float retailOutPrice;
    @Column(name = "RecordStatusID")
    private Integer recordStatusID;
    @Column(name = "ItemOrder")
    private Integer itemOrder;
    @Column(name = "RpMetadataHash")
    private Integer rpMetadataHash;
    @Column(name = "ArchiveDrugId")
    private Integer archiveDrugId;
    @Column(name = "ArchiveUnitId")
    private Integer archiveUnitId;
    @Column(name = "ExpirySetAuto")
    private Boolean expirySetAuto;
    @Column(name = "ReferenceId")
    private Integer referenceId;
    @Column(name = "ArchivedId")
    private Integer archivedId;
    @Column(name = "StoreId")
    private Integer storeId;
    @Column(name = "ConnectivityStatusId")
    private Integer connectivityStatusId;
    @Column(name = "ConnectivityResult")
    private String connectivityResult;
    @Column(name = "UpdatedById")
    private Integer updatedById;
    @Column(name = "UpdatedDate")
    private Date updatedDate;
    @Column(name = "CreatedById")
    private Integer createdById;
    @Column(name = "CreatedDate")
    private Date createdDate;
    @Column(name = "VAT")
    private BigDecimal vat;
    @Column(name = "LockReGenReportData")
    private Boolean lockReGenReportData;
    @Column(name = "Reason")
    private String reason;
    @Column(name = "Solution")
    private String solution;
    @Column(name = "Notes")
    private String notes;
    @Column(name = "IsProdRef")
    private Boolean isProdRef;
    @Column(name = "RefPrice")
    private BigDecimal refPrice;
    @Column(name = "Decscription")
    private String decscription;
    @Column(name = "StorageConditions")
    private String storageConditions;
}

