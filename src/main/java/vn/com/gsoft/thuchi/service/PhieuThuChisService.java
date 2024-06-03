package vn.com.gsoft.thuchi.service;


import vn.com.gsoft.thuchi.entity.PhieuNhaps;
import vn.com.gsoft.thuchi.entity.PhieuThuChis;
import vn.com.gsoft.thuchi.entity.PhieuXuats;
import vn.com.gsoft.thuchi.model.dto.DebtInfoRes;
import vn.com.gsoft.thuchi.model.dto.PhieuThuChisReq;

import java.util.List;

public interface PhieuThuChisService extends BaseService<PhieuThuChis, PhieuThuChisReq, Long> {
    Long getSoPhieuThuChi(Integer loaiPhieu) throws Exception;
    DebtInfoRes<PhieuXuats> getInComingCustomerDebt(Long phieuThuChiId, Long customerId) throws Exception;
    DebtInfoRes<PhieuNhaps> getOutReturnCustomerDebt(Long phieuThuChiId, Long customerId) throws Exception;
    DebtInfoRes<PhieuNhaps> getOutComingSupplierDebt(Long phieuThuChiId, Long supplierId) throws Exception;
    DebtInfoRes<PhieuXuats> getInReturnSupplierDebt(Long phieuThuChiId, Long supplierId) throws Exception;
}