package vn.com.gsoft.thuchi.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.com.gsoft.thuchi.entity.PhieuXuats;
import vn.com.gsoft.thuchi.model.dto.PhieuXuatsReq;
import vn.com.gsoft.thuchi.repository.PhieuXuatsRepository;
import vn.com.gsoft.thuchi.service.PhieuXuatsService;


@Service
@Log4j2
public class PhieuXuatsServiceImpl extends BaseServiceImpl<PhieuXuats, PhieuXuatsReq,Long> implements PhieuXuatsService {

	private PhieuXuatsRepository hdrRepo;
	@Autowired
	public PhieuXuatsServiceImpl(PhieuXuatsRepository hdrRepo) {
		super(hdrRepo);
		this.hdrRepo = hdrRepo;
	}

}
