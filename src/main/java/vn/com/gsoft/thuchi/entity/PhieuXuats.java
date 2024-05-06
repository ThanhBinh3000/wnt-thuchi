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
@Table(name = "PhieuXuats")
public class PhieuXuats extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MaPhieuXuat")
    private Integer maPhieuXuat;
    @Column(name = "SoPhieuXuat")
    private Long soPhieuXuat;
    @Column(name = "NgayXuat")
    private Date ngayXuat;
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
    @Column(name = "MaLoaiXuatNhap")
    private Integer maLoaiXuatNhap;
    @Column(name = "KhachHang_MaKhachHang")
    private Long khachHangMaKhachHang;
    @Column(name = "NhaCungCap_MaNhaCungCap")
    private Long nhaCungCapMaNhaCungCap;
    @Column(name = "BacSy_MaBacSy")
    private Integer bacSyMaBacSy;
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
    @Column(name = "Discount")
    private BigDecimal discount;
    @Column(name = "Score")
    private BigDecimal score;
    @Column(name = "PreScore")
    private BigDecimal preScore;
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
    @Column(name = "PrescriptionId")
    private Integer prescriptionId;
    @Column(name = "UId")
    private Long uId;
    @Column(name = "InvoiceCode")
    private String invoiceCode;
    @Column(name = "InvoiceNo")
    private String invoiceNo;
    @Column(name = "ReferenceKey")
    private String referenceKey;
    @Column(name = "InvoiceDate")
    private Date invoiceDate;
    @Column(name = "PaymentScore")
    private BigDecimal paymentScore;
    @Column(name = "PaymentScoreAmount")
    private BigDecimal paymentScoreAmount;
    @Column(name = "BonusPaymentId")
    private Integer bonusPaymentId;
    @Column(name = "InvoiceTemplateCode")
    private String invoiceTemplateCode;
    @Column(name = "InvoiceSeries")
    private String invoiceSeries;
    @Column(name = "InvoiceType")
    private String invoiceType;
    @Column(name = "ArchivedDate")
    private Date archivedDate;
    @Column(name = "PrePaymentScore")
    private BigDecimal prePaymentScore;
    @Column(name = "SynStatusId")
    private Integer synStatusId;
    @Column(name = "TransPaymentAmount")
    private BigDecimal transPaymentAmount;
    @Column(name = "PaymentTypeId")
    private Integer paymentTypeId;
    @Column(name = "DebtPaymentAmount")
    private BigDecimal debtPaymentAmount;
    @Column(name = "BackPaymentAmount")
    private BigDecimal backPaymentAmount;
    @Column(name = "LinkFile")
    private String linkFile;
    @Column(name = "DoctorComments")
    private String doctorComments;
    @Column(name = "KeyNewEInvoice")
    private String keyNewEInvoice;
    @Column(name = "KeyOldEInvoice")
    private String keyOldEInvoice;
    @Column(name = "EInvoiceStatusID")
    private Integer eInvoiceStatusID;
    @Column(name = "SignEInvoiceStatusID")
    private Integer signEInvoiceStatusID;
    @Column(name = "ConnEInvoiceDateTime")
    private Date connEInvoiceDateTime;
    @Column(name = "SignEInvoiceDateTime")
    private Date signEInvoiceDateTime;
    @Column(name = "DestroyEInvoiceDateTime")
    private Date destroyEInvoiceDateTime;
    @Column(name = "ReplacedEInvoiceDateTime")
    private Date replacedEInvoiceDateTime;
    @Column(name = "EditedEInvoiceDateTime")
    private Date editedEInvoiceDateTime;
    @Column(name = "KHHDon")
    private String kHHDon;
    @Column(name = "KHMSHDon")
    private String kHMSHDon;
    @Column(name = "SHDon")
    private String sHDon;
    @Column(name = "PickUpOrderId")
    private Integer pickUpOrderId;
    @Column(name = "ESampleNoteCode")
    private String eSampleNoteCode;
    @Column(name = "LinkConfirm")
    private String linkConfirm;
    @Column(name = "TaxAuthorityCode")
    private String taxAuthorityCode;
    @Column(name = "EInvoiveResult")
    private String eInvoiveResult;
    @Column(name = "IsRefSampleNote")
    private Boolean isRefSampleNote;
    @Column(name = "NextPurchaseDate")
    private Date nextPurchaseDate;
    @Column(name = "TrackingIdZNS")
    private String trackingIdZNS;
    @Column(name = "ResultZNS")
    private String resultZNS;
    @Column(name = "IdPaymentQR")
    private Integer idPaymentQR;
    @Column(name = "TargetManagementId")
    private Integer targetManagementId;
}

