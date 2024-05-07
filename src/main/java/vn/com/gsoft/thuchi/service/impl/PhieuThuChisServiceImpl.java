package vn.com.gsoft.thuchi.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.thuchi.constant.RecordStatusContains;
import vn.com.gsoft.thuchi.entity.*;
import vn.com.gsoft.thuchi.model.dto.PhieuThuChisReq;
import vn.com.gsoft.thuchi.model.system.Profile;
import vn.com.gsoft.thuchi.repository.*;
import vn.com.gsoft.thuchi.service.PhieuThuChisService;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Log4j2
public class PhieuThuChisServiceImpl extends BaseServiceImpl<PhieuThuChis, PhieuThuChisReq, Long> implements PhieuThuChisService {

    private PhieuThuChisRepository hdrRepo;
    private KhachHangsRepository khachHangsRepository;
    private UserProfileRepository userProfileRepository;
    private NhaCungCapsRepository nhaCungCapsRepository;
    private NhaThuocsRepository nhaThuocsRepository;
    private InOutPaymentReceiverNoteRepository inOutPaymentReceiverNoteRepository;

    @Autowired
    public PhieuThuChisServiceImpl(PhieuThuChisRepository hdrRepo,
                                   UserProfileRepository userProfileRepository,
                                   NhaCungCapsRepository nhaCungCapsRepository,
                                   NhaThuocsRepository nhaThuocsRepository,
                                   InOutPaymentReceiverNoteRepository inOutPaymentReceiverNoteRepository,
                                   KhachHangsRepository khachHangsRepository) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
        this.khachHangsRepository = khachHangsRepository;
        this.userProfileRepository = userProfileRepository;
        this.nhaCungCapsRepository = nhaCungCapsRepository;
        this.nhaThuocsRepository = nhaThuocsRepository;
        this.inOutPaymentReceiverNoteRepository = inOutPaymentReceiverNoteRepository;
    }

    @Override
    public Page<PhieuThuChis> searchPage(PhieuThuChisReq req) throws Exception {
        Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        Page<PhieuThuChis> phieuThuChis = hdrRepo.searchPage(req, pageable);
        for (PhieuThuChis ptc : phieuThuChis.getContent()) {
            if (ptc.getCreatedByUserId() != null && ptc.getCreatedByUserId() > 0) {
                Optional<UserProfile> userProfile = userProfileRepository.findById(ptc.getCreatedByUserId());
                if (userProfile.isPresent()) {
                    ptc.setCreatedByUserText(userProfile.get().getTenDayDu());
                }
            }
            if (ptc.getCustomerId() != null && ptc.getCustomerId() > 0) {
                Optional<KhachHangs> khachHang = khachHangsRepository.findById(ptc.getCustomerId());
                if (khachHang.isPresent()) {
                    ptc.setCustomerText(khachHang.get().getTenKhachHang());
                }
            }
            if (ptc.getNhaCungCapMaNhaCungCap() != null && ptc.getNhaCungCapMaNhaCungCap() > 0) {
                Optional<NhaCungCaps> nhaCungCaps = nhaCungCapsRepository.findById(ptc.getNhaCungCapMaNhaCungCap());
                if (nhaCungCaps.isPresent()) {
                    ptc.setNhaCungCapMaNhaCungCapText(nhaCungCaps.get().getTenNhaCungCap());
                }
            }
        }
        return phieuThuChis;
    }

    @Override
    public PhieuThuChis create(PhieuThuChisReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");
        PhieuThuChis e = new PhieuThuChis();
        BeanUtils.copyProperties(req, e, "id");
        if (e.getRecordStatusId() == null) {
            e.setRecordStatusId(RecordStatusContains.ACTIVE);
        }
        e.setCreated(new Date());
        e.setCreatedByUserId(getLoggedUser().getId());
        hdrRepo.save(e);
        return e;
    }

    @Override
    public PhieuThuChis update(PhieuThuChisReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");

        Optional<PhieuThuChis> optional = hdrRepo.findById(req.getId());
        if (optional.isEmpty()) {
            throw new Exception("Không tìm thấy dữ liệu.");
        }

        PhieuThuChis e = optional.get();
        BeanUtils.copyProperties(req, e, "id", "created", "createdByUserId");
        if (e.getRecordStatusId() == null) {
            e.setRecordStatusId(RecordStatusContains.ACTIVE);
        }
        e.setModified(new Date());
        e.setModifiedByUserId(getLoggedUser().getId());
        hdrRepo.save(e);
        return e;
    }

    @Override
    public PhieuThuChis detail(Long id) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");

        Optional<PhieuThuChis> optional = hdrRepo.findById(id);
        if (optional.isEmpty()) {
            throw new Exception("Không tìm thấy dữ liệu.");
        } else {
            if (optional.get().getRecordStatusId() != RecordStatusContains.ACTIVE) {
                throw new Exception("Không tìm thấy dữ liệu.");
            }
        }
        if (optional.get().getCreatedByUserId() != null && optional.get().getCreatedByUserId() > 0) {
            Optional<UserProfile> userProfile = userProfileRepository.findById(optional.get().getCreatedByUserId());
            if (userProfile.isPresent()) {
                optional.get().setCreatedByUserText(userProfile.get().getTenDayDu());
            }
        }
        if (optional.get().getCustomerId() != null && optional.get().getCustomerId() > 0) {
            Optional<KhachHangs> khachHang = khachHangsRepository.findById(optional.get().getCustomerId());
            if (khachHang.isPresent()) {
                optional.get().setCustomerText(khachHang.get().getTenKhachHang());
            }
        }
        if (optional.get().getNhaCungCapMaNhaCungCap() != null && optional.get().getNhaCungCapMaNhaCungCap() > 0) {
            Optional<NhaCungCaps> nhaCungCaps = nhaCungCapsRepository.findById(optional.get().getNhaCungCapMaNhaCungCap());
            if (nhaCungCaps.isPresent()) {
                optional.get().setNhaCungCapMaNhaCungCapText(nhaCungCaps.get().getTenNhaCungCap());
            }
        }
        if (optional.get().getNhaThuocMaNhaThuoc() != null) {
            Optional<NhaThuocs> nhaThuocs = nhaThuocsRepository.findByMaNhaThuoc(optional.get().getNhaThuocMaNhaThuoc());
            if (nhaThuocs.isPresent()) {
                optional.get().setNhaThuocs(nhaThuocs.get());
            }
        }
        List<InOutPaymentReceiverNote> inOutPaymentReceiverNotes = inOutPaymentReceiverNoteRepository.findByInOutCommingNoteId(optional.get().getId());
        optional.get().setChiTiets(inOutPaymentReceiverNotes);
        return optional.get();
    }
}
