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
public class PhieuXuatChiTietsReq extends BaseRequest {
    private Integer maPhieuXuatCt;
    private Integer phieuXuatMaPhieuXuat;
    private String nhaThuocMaNhaThuoc;
    private Integer thuocThuocId;
    private Integer donViTinhMaDonViTinh;
    private BigDecimal chietKhau;
    private BigDecimal giaXuat;
    private BigDecimal soLuong;
    private String option1;
    private String option2;
    private String option3;
    private String refConnectivityCode;
    private String preQuantity;
    private Boolean isReceiptDrugPriceRefGenerated;
    private Float retailQuantity;
    private Integer handledStatusId;
    private Float retailPrice;
    private Boolean requestUpdateFromBkgService;
    private String reduceNoteItemIds;
    private Float reduceQuantity;
    private Boolean isModified;
    private Integer itemOrder;
    private Integer archiveDrugId;
    private Integer archiveUnitId;
    private Integer recordStatusID;
    private Float preRetailQuantity;
    private String batchNumber;
    private Date expiredDate;
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
    private BigDecimal vat;
    private String reason;
    private String solution;
    private String notes;
    private Boolean lockReGenReportData;
    private Boolean isProdRef;
    private Boolean negativeRevenue;
    private BigDecimal revenue;
    private BigDecimal refPrice;
    private String usage;
    private BigDecimal outOwnerPriceChild;
}

