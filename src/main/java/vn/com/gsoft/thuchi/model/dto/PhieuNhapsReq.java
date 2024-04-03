package vn.com.gsoft.thuchi.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.gsoft.thuchi.model.system.BaseRequest;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PhieuNhapsReq extends BaseRequest {
    private Integer maPhieuNhap;
    private Long soPhieuNhap;
    private Date ngayNhap;
    private Integer vAT;
    private String dienGiai;
    private BigDecimal tongTien;
    private BigDecimal daTra;
    private String nhaThuocMaNhaThuoc;
    private Integer loaiXuatNhapMaLoaiXuatNhap;
    private Integer nhaCungCapMaNhaCungCap;
    private Integer khachHangMaKhachHang;
    private Integer userProfileUserId;
    private Date created;
    private Date modified;
    private Integer createdByUserId;
    private Integer modifiedByUserId;
    private Boolean active;
    private Boolean isModified;
    private Boolean locked;
    private Boolean isDebt;
    private Date preNoteDate;
    private Integer recordStatusID;
    private String connectivityNoteID;
    private Integer connectivityStatusID;
    private String connectivityResult;
    private Date connectivityDateTime;
    private Integer orderId;
    private Integer archivedId;
    private Integer storeId;
    private Integer targetId;
    private Integer sourceId;
    private Integer sourceStoreId;
    private Integer targetStoreId;
    private Integer partnerId;
    private Long uId;
    private String invoiceCode;
    private String invoiceNo;
    private BigDecimal score;
    private BigDecimal preScore;
    private String referenceKey;
    private Date invoiceDate;
    private String invoiceTemplateCode;
    private String invoiceSeries;
    private String invoiceType;
    private Date archivedDate;
    private Integer timeTypeId;
    private String noteName;
    private String notes;
    private String reasons;
    private Integer synStatusId;
    private Integer paymentTypeId;
    private BigDecimal debtPaymentAmount;
    private Integer pickUpOrderId;
    private String linkFile;
    private BigDecimal discount;
    private Integer targetManagementId;
}

