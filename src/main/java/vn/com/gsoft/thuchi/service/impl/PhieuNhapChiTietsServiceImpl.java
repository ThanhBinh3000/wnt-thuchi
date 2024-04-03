package vn.com.gsoft.thuchi.service.impl;


import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.thuchi.entity.PhieuNhapChiTiets;
import vn.com.gsoft.thuchi.model.dto.PhieuNhapChiTietsReq;
import vn.com.gsoft.thuchi.repository.PhieuNhapChiTietsRepository;
import vn.com.gsoft.thuchi.service.PhieuNhapChiTietsService;


@Service
@Log4j2
public class PhieuNhapChiTietsServiceImpl extends BaseServiceImpl<PhieuNhapChiTiets, PhieuNhapChiTietsReq,Long> implements PhieuNhapChiTietsService {

	private PhieuNhapChiTietsRepository hdrRepo;
	@Autowired
	public PhieuNhapChiTietsServiceImpl(PhieuNhapChiTietsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
