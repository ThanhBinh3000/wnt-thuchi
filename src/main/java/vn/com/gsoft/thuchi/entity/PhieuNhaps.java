package vn.com.gsoft.thuchi.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
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
@Table(name = "PhieuNhaps")
public class PhieuNhaps extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaPhieuNhap")
    private Integer maPhieuNhap;
    @Column(name = "SoPhieuNhap")
    private Long soPhieuNhap;
    @Column(name = "NgayNhap")
    private Date ngayNhap;
    @Column(name = "VAT")
    private Integer vat;
    @Column(name = "DienGiai")
    private String dienGiai;
    @Column(name = "TongTien")
    private BigDecimal tongTien;
    @Column(name = "DaTra")
    private BigDecimal daTra;
    @Column(name = "NhaThuoc_MaNhaThuoc")
    private String nhaThuocMaNhaThuoc;
    @Column(name = "LoaiXuatNhap_MaLoaiXuatNhap")
    private Integer loaiXuatNhapMaLoaiXuatNhap;
    @Column(name = "NhaCungCap_MaNhaCungCap")
    private Long nhaCungCapMaNhaCungCap;
    @Column(name = "KhachHang_MaKhachHang")
    private Long khachHangMaKhachHang;
    @Column(name = "UserProfile_UserId")
    private Integer userProfileUserId;

    @Column(name = "Active")
    private Boolean active;
    @Column(name = "IsModified")
    private Boolean isModified;
    @Column(name = "Locked")
    private Boolean locked;
    @Column(name = "IsDebt")
    private Boolean isDebt;
    @Column(name = "PreNoteDate")
    private Date preNoteDate;
    @Column(name = "RecordStatusID")
    private Integer recordStatusID;
    @Column(name = "ConnectivityNoteID")
    private String connectivityNoteID;
    @Column(name = "ConnectivityStatusID")
    private Integer connectivityStatusID;
    @Column(name = "ConnectivityResult")
    private String connectivityResult;
    @Column(name = "ConnectivityDateTime")
    private Date connectivityDateTime;
    @Column(name = "OrderId")
    private Integer orderId;
    @Column(name = "ArchivedId")
    private Integer archivedId;
    @Column(name = "StoreId")
    private Integer storeId;
    @Column(name = "TargetId")
    private Integer targetId;
    @Column(name = "SourceId")
    private Integer sourceId;
    @Column(name = "SourceStoreId")
    private Integer sourceStoreId;
    @Column(name = "TargetStoreId")
    private Integer targetStoreId;
    @Column(name = "PartnerId")
    private Integer partnerId;
    @Column(name = "UId")
    private Long uId;
    @Column(name = "InvoiceCode")
    private String invoiceCode;
    @Column(name = "InvoiceNo")
    private String invoiceNo;
    @Column(name = "Score")
    private BigDecimal score;
    @Column(name = "PreScore")
    private BigDecimal preScore;
    @Column(name = "ReferenceKey")
    private String referenceKey;
    @Column(name = "InvoiceDate")
    private Date invoiceDate;
    @Column(name = "InvoiceTemplateCode")
    private String invoiceTemplateCode;
    @Column(name = "InvoiceSeries")
    private String invoiceSeries;
    @Column(name = "InvoiceType")
    private String invoiceType;
    @Column(name = "ArchivedDate")
    private Date archivedDate;
    @Column(name = "TimeTypeId")
    private Integer timeTypeId;
    @Column(name = "NoteName")
    private String noteName;
    @Column(name = "Notes")
    private String notes;
    @Column(name = "Reasons")
    private String reasons;
    @Column(name = "SynStatusId")
    private Integer synStatusId;
    @Column(name = "PaymentTypeId")
    private Integer paymentTypeId;
    @Column(name = "DebtPaymentAmount")
    private BigDecimal debtPaymentAmount;
    @Column(name = "PickUpOrderId")
    private Integer pickUpOrderId;
    @Column(name = "LinkFile")
    private String linkFile;
    @Column(name = "Discount")
    private BigDecimal discount;
    @Column(name = "TargetManagementId")
    private Integer targetManagementId;
}

