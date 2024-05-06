package vn.com.gsoft.thuchi.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.thuchi.entity.PhieuNhaps;
import vn.com.gsoft.thuchi.model.dto.PhieuNhapsReq;
import vn.com.gsoft.thuchi.repository.PhieuNhapsRepository;
import vn.com.gsoft.thuchi.service.PhieuNhapsService;


@Service
@Log4j2
public class PhieuNhapsServiceImpl extends BaseServiceImpl<PhieuNhaps, PhieuNhapsReq,Long> implements PhieuNhapsService {

	private PhieuNhapsRepository hdrRepo;
	@Autowired
	public PhieuNhapsServiceImpl(PhieuNhapsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
