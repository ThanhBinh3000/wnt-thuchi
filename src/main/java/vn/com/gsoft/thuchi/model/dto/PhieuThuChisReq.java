package vn.com.gsoft.thuchi.model.dto;

import lombok.Data;
import vn.com.gsoft.thuchi.model.system.BaseRequest;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PhieuThuChisReq extends BaseRequest {

    private Long id;
    private Integer maPhieu;
    private Integer soPhieu;
    private String dienGiai;
    private Date ngayTao;
    private Integer loaiPhieu;
    private String nhaThuocMaNhaThuoc;
    private Integer khachHangMaKhachHang;
    private Integer nhaCungCapMaNhaCungCap;
    private Integer userProfileUserId;
    private BigDecimal amount;
    private String nguoiNhan;
    private String diaChi;
    private Integer loaiThuChiMaLoaiPhieu;
    private Boolean active;
    private Integer customerId;
    private Integer supplierId;
    private Integer archivedId;
    private Integer storeId;
    private Integer paymentTypeId;
    private String maCoSo;
    private Integer nhanVienId;
    private Integer rewardProgramId;
    private Date fromDate;
    private Date toDate;
}

