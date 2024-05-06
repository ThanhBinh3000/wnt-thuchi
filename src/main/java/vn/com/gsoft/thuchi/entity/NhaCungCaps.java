package vn.com.gsoft.thuchi.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "NhaCungCaps")
public class NhaCungCaps {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "TenNhaCungCap")
    private String tenNhaCungCap;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "SoDienThoai")
    private String soDienThoai;
    @Column(name = "SoFax")
    private String soFax;
    @Column(name = "MaSoThue")
    private String maSoThue;
    @Column(name = "NguoiDaiDien")
    private String nguoiDaiDien;
    @Column(name = "NguoiLienHe")
    private String nguoiLienHe;
    @Column(name = "Email")
    private String email;
    @Column(name = "NoDauKy")
    private BigDecimal noDauKy;
    @Column(name = "MaNhaThuoc")
    private String maNhaThuoc;
    @Column(name = "MaNhomNhaCungCap")
    private Integer maNhomNhaCungCap;
    @Column(name = "Created")
    private Date created;
    @Column(name = "Modified")
    private Date modified;
    @Column(name = "CreatedBy_UserId")
    private Integer createdByUserId;
    @Column(name = "ModifiedBy_UserId")
    private Integer modifiedByUserId;
    @Column(name = "Active")
    private Boolean active;
    @Column(name = "SupplierTypeId")
    private Integer supplierTypeId;
    @Column(name = "RecordStatusID")
    private Integer recordStatusID;
    @Column(name = "BarCode")
    private String barCode;
    @Column(name = "DiaBanHoatDong")
    private String diaBanHoatDong;
    @Column(name = "Website")
    private String website;
    @Column(name = "ArchivedId")
    private Integer archivedId;
    @Column(name = "ReferenceId")
    private Integer referenceId;
    @Column(name = "StoreId")
    private Integer storeId;
    @Column(name = "MasterId")
    private Integer masterId;
    @Column(name = "MetadataHash")
    private Integer metadataHash;
    @Column(name = "PreMetadataHash")
    private Integer preMetadataHash;
    @Column(name = "Code")
    private String code;
    @Column(name = "MappingStoreId")
    private Integer mappingStoreId;
    @Column(name = "IsOrganization")
    private Integer isOrganization;
}


