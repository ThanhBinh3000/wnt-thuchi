package vn.com.gsoft.thuchi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhieuXuats")
public class PhieuXuats extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SoPhieuXuat")
    private Long soPhieuXuat;
    @Column(name = "NgayXuat")
    private Date ngayXuat;
    @Column(name = "VAT")
    private BigDecimal vat;
    @Column(name = "DienGiai")
    private String dienGiai;
    @Column(name = "TongTien")
    private BigDecimal tongTien;
    @Column(name = "DaTra")
    private BigDecimal daTra;
    @Column(name = "NhaThuoc_MaNhaThuoc")
    private String nhaThuocMaNhaThuoc;
    @Column(name = "MaLoaiXuatNhap")
    private Long maLoaiXuatNhap;
    @Column(name = "KhachHang_MaKhachHang")
    private Long khachHangMaKhachHang;
    @Column(name = "NhaCungCap_MaNhaCungCap")
    private Long nhaCungCapMaNhaCungCap;
    @Transient
    private String nhaCungCapMaNhaCungCapText;
    @Column(name = "BacSy_MaBacSy")
    private Long bacSyMaBacSy;
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
    @Column(name = "ConnectivityNoteID")
    private String connectivityNoteID;
    @Column(name = "ConnectivityStatusID")
    private Long connectivityStatusID;
    @Column(name = "ConnectivityResult")
    private String connectivityResult;
    @Column(name = "ConnectivityDateTime")
    private Date connectivityDateTime;
    @Column(name = "OrderId")
    private Long orderId;
    @Column(name = "Discount")
    private BigDecimal discount;
    @Column(name = "Score")
    private BigDecimal score;
    @Column(name = "PreScore")
    private BigDecimal preScore;
    @Column(name = "ArchivedId")
    private Long archivedId;
    @Column(name = "StoreId")
    private Long storeId;
    @Column(name = "TargetId")
    private Long targetId;
    @Column(name = "SourceId")
    private Long sourceId;
    @Column(name = "SourceStoreId")
    private Long sourceStoreId;
    @Column(name = "TargetStoreId")
    private Long targetStoreId;
    @Column(name = "PartnerId")
    private Long partnerId;
    @Column(name = "PrescriptionId")
    private Long prescriptionId;
    @Column(name = "UId")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID uId;
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
    private Long bonusPaymentId;
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
    private Long synStatusId;
    @Column(name = "TransPaymentAmount")
    private BigDecimal transPaymentAmount;
    @Column(name = "PaymentTypeId")
    private Long paymentTypeId;
    @Transient
    private String paymentTypeText;
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
    private Long eInvoiceStatusID;
    @Column(name = "SignEInvoiceStatusID")
    private Long signEInvoiceStatusID;
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
    private Long pickUpOrderId;
    @Column(name = "ESampleNoteCode")
    private String eSampleNoteCode;
    @Lob
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
    private Long idPaymentQR;
    @Column(name = "TargetManagementId")
    private Long targetManagementId;

    @Transient
    private Boolean IsConnectivity;
    @Transient
    private Boolean IsManagement;
    @Transient
    private String createdByUserText;
    @Transient
    private String targetStoreText;
    @Transient
    private String khachHangMaKhachHangText;
    @Transient
    private String bacSyMaBacSyText;
    @Transient
    private List<PhieuXuatChiTiets> chiTiets;
    @Transient
    private BigDecimal debtAmount;
    @Transient
    private String noteInfo;
}

