package vn.com.gsoft.thuchi.model.dto;

import lombok.Data;
import vn.com.gsoft.thuchi.model.system.BaseRequest;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PhieuNhapChiTietsReq extends BaseRequest {

    private Integer maPhieuNhapCt;
    private Integer phieuNhapMaPhieuNhap;
    private String nhaThuocMaNhaThuoc;
    private Integer thuocThuocId;
    private Integer donViTinhMaDonViTinh;
    private BigDecimal chietKhau;
    private BigDecimal giaNhap;
    private BigDecimal soLuong;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String option5;
    private String soLo;
    private Date hanDung;
    private Float remainRefQuantity;
    private Float retailQuantity;
    private Float preRetailQuantity;
    private Integer handledStatusId;
    private Float retailPrice;
    private Boolean requestUpdateFromBkgService;
    private String reduceNoteItemIds;
    private Float reduceQuantity;
    private Boolean isModified;
    private BigDecimal giaBanLe;
    private Float retailOutPrice;
    private Integer recordStatusID;
    private Integer itemOrder;
    private Integer rpMetadataHash;
    private Integer archiveDrugId;
    private Integer archiveUnitId;
    private Boolean expirySetAuto;
    private Integer referenceId;
    private Integer archivedId;
    private Integer storeId;
    private Integer connectivityStatusId;
    private String connectivityResult;
    private Integer updatedById;
    private Date updatedDate;
    private Integer createdById;
    private Date createdDate;
    private BigDecimal vAT;
    private Boolean lockReGenReportData;
    private String reason;
    private String solution;
    private String notes;
    private Boolean isProdRef;
    private BigDecimal refPrice;
    private String decscription;
    private String storageConditions;
}

