package vn.com.gsoft.thuchi.service.impl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.com.gsoft.thuchi.constant.ENoteType;
import vn.com.gsoft.thuchi.constant.InOutCommingType;
import vn.com.gsoft.thuchi.constant.RecordStatusContains;
import vn.com.gsoft.thuchi.constant.StoreSettingKeys;
import vn.com.gsoft.thuchi.entity.*;
import vn.com.gsoft.thuchi.model.dto.DebtInfoRes;
import vn.com.gsoft.thuchi.model.dto.PhieuThuChisReq;
import vn.com.gsoft.thuchi.model.system.ApplicationSetting;
import vn.com.gsoft.thuchi.model.system.Profile;
import vn.com.gsoft.thuchi.repository.*;
import vn.com.gsoft.thuchi.service.PhieuThuChisService;
import vn.com.gsoft.thuchi.util.system.FileUtils;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


@Service
@Log4j2
public class PhieuThuChisServiceImpl extends BaseServiceImpl<PhieuThuChis, PhieuThuChisReq, Long> implements PhieuThuChisService {

    private PhieuThuChisRepository hdrRepo;
    private KhachHangsRepository khachHangsRepository;
    private UserProfileRepository userProfileRepository;
    private NhaCungCapsRepository nhaCungCapsRepository;
    private NhaThuocsRepository nhaThuocsRepository;
    private InOutPaymentReceiverNoteRepository inOutPaymentReceiverNoteRepository;
    private PhieuNhapsRepository phieuNhapsRepository;
    private PhieuXuatsRepository phieuXuatsRepository;

    @Autowired
    public PhieuThuChisServiceImpl(PhieuThuChisRepository hdrRepo,
                                   UserProfileRepository userProfileRepository,
                                   NhaCungCapsRepository nhaCungCapsRepository,
                                   NhaThuocsRepository nhaThuocsRepository,
                                   InOutPaymentReceiverNoteRepository inOutPaymentReceiverNoteRepository,
                                   KhachHangsRepository khachHangsRepository,
                                   PhieuNhapsRepository phieuNhapsRepository,
                                   PhieuXuatsRepository phieuXuatsRepository) {
        super(hdrRepo);
        this.hdrRepo = hdrRepo;
        this.khachHangsRepository = khachHangsRepository;
        this.userProfileRepository = userProfileRepository;
        this.nhaCungCapsRepository = nhaCungCapsRepository;
        this.nhaThuocsRepository = nhaThuocsRepository;
        this.inOutPaymentReceiverNoteRepository = inOutPaymentReceiverNoteRepository;
        this.phieuNhapsRepository = phieuNhapsRepository;
        this.phieuXuatsRepository = phieuXuatsRepository;
    }

    @Override
    public Page<PhieuThuChis> searchPage(PhieuThuChisReq req) throws Exception {
        Pageable pageable = PageRequest.of(req.getPaggingReq().getPage(), req.getPaggingReq().getLimit());
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        Page<PhieuThuChis> phieuThuChis = hdrRepo.searchPage(req, pageable);
        for (PhieuThuChis ptc : phieuThuChis.getContent()) {
            if (ptc.getCreatedByUserId() != null && ptc.getCreatedByUserId() > 0) {
                Optional<UserProfile> userProfile = userProfileRepository.findById(ptc.getCreatedByUserId());
                userProfile.ifPresent(profile -> ptc.setCreatedByUserText(profile.getTenDayDu()));
            }
            if (ptc.getCustomerId() != null && ptc.getCustomerId() > 0) {
                Optional<KhachHangs> khachHang = khachHangsRepository.findById(ptc.getCustomerId());
                khachHang.ifPresent(khachHangs -> ptc.setCustomerText(khachHangs.getTenKhachHang()));
            }
            if (ptc.getSupplierId() != null && ptc.getSupplierId() > 0) {
                Optional<NhaCungCaps> nhaCungCaps = nhaCungCapsRepository.findById(ptc.getSupplierId());
                nhaCungCaps.ifPresent(cungCaps -> ptc.setNhaCungCapMaNhaCungCapText(cungCaps.getTenNhaCungCap()));
            }
            if (ptc.getNhanVienId() != null && ptc.getNhanVienId() > 0) {
                Optional<UserProfile> nhanViens = userProfileRepository.findById(ptc.getNhanVienId());
                nhanViens.ifPresent(userProfile -> ptc.setNhanVienText(userProfile.getTenDayDu()));
            }
        }
        return phieuThuChis;
    }

    @Override
    public List<PhieuThuChis> searchList(PhieuThuChisReq req) throws Exception {
        req.setRecordStatusId(RecordStatusContains.ACTIVE);
        List<PhieuThuChis> phieuThuChis = hdrRepo.searchList(req);
        for (PhieuThuChis ptc : phieuThuChis) {
            if (ptc.getCreatedByUserId() != null && ptc.getCreatedByUserId() > 0) {
                Optional<UserProfile> userProfile = userProfileRepository.findById(ptc.getCreatedByUserId());
                userProfile.ifPresent(profile -> ptc.setCreatedByUserText(profile.getTenDayDu()));
            }
            if (ptc.getCustomerId() != null && ptc.getCustomerId() > 0) {
                Optional<KhachHangs> khachHang = khachHangsRepository.findById(ptc.getCustomerId());
                khachHang.ifPresent(khachHangs -> ptc.setCustomerText(khachHangs.getTenKhachHang()));
            }
            if (ptc.getNhaCungCapMaNhaCungCap() != null && ptc.getNhaCungCapMaNhaCungCap() > 0) {
                Optional<NhaCungCaps> nhaCungCaps = nhaCungCapsRepository.findById(ptc.getNhaCungCapMaNhaCungCap());
                nhaCungCaps.ifPresent(cungCaps -> ptc.setNhaCungCapMaNhaCungCapText(cungCaps.getTenNhaCungCap()));
            }
            if (ptc.getNhanVienId() != null && ptc.getNhanVienId() > 0) {
                Optional<UserProfile> nhanViens = userProfileRepository.findById(ptc.getNhanVienId());
                nhanViens.ifPresent(userProfile -> ptc.setNhanVienText(userProfile.getTenDayDu()));
            }
        }
        return phieuThuChis;
    }

    @Override
    public PhieuThuChis create(PhieuThuChisReq req) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");

        List<Long> receiverNoteIds = req.getReceiverNoteId() > 0 ? List.of(req.getReceiverNoteId()) : req.getReceiverNoteIds();
        if (req.getLoaiPhieu() == InOutCommingType.Incomming || req.getLoaiPhieu() == InOutCommingType.InReturnSupplier) {
            List<PhieuXuats> deliveryNoteService = phieuXuatsRepository.findByNhaThuocMaNhaThuocAndIdInAndIsDebt(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), receiverNoteIds, false).stream().toList();
            if (!deliveryNoteService.isEmpty()) {
                throw new Exception("Phiếu này đã được thanh toán bạn vui lòng kiểm tra lại.");
            }
        } else if (req.getLoaiPhieu() == InOutCommingType.Outcomming || req.getLoaiPhieu() == InOutCommingType.OutReturnCustomer) {
            List<PhieuNhaps> receiptNoteService = phieuNhapsRepository.findByNhaThuocMaNhaThuocAndIdInAndIsDebt(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), receiverNoteIds, false).stream().toList();
            if (!receiptNoteService.isEmpty()) {
                throw new Exception("Phiếu này đã được thanh toán bạn vui lòng kiểm tra lại.");
            }
        }

        PhieuThuChis e = new PhieuThuChis();
        BeanUtils.copyProperties(req, e, "id");
        e.setActive(true);
        e.setNhaThuocMaNhaThuoc(getLoggedUser().getNhaThuoc().getMaNhaThuoc());
        e.setKhachHangMaKhachHang(e.getCustomerId());
        e.setNhaCungCapMaNhaCungCap(e.getSupplierId());
        e.setUserProfileUserId(getLoggedUser().getId());
        e.setStoreId(getLoggedUser().getNhaThuoc().getId());
        if (e.getRecordStatusId() == null) {
            e.setRecordStatusId(RecordStatusContains.ACTIVE);
        }
        // Apple current time cho ngày tạo
        LocalDateTime ngayTao = LocalDateTime.ofInstant(e.getNgayTao().toInstant(), ZoneId.systemDefault());
        LocalDateTime ngayTaoWithCurrentTime = LocalDateTime.of(ngayTao.toLocalDate(), LocalTime.now());
        e.setNgayTao(Date.from(ngayTaoWithCurrentTime.atZone(ZoneId.systemDefault()).toInstant()));
        e.setSoPhieu(getSoPhieuThuChi(req.getLoaiPhieu()));
        e.setCreated(new Date());
        e.setCreatedByUserId(getLoggedUser().getId());
        e = hdrRepo.save(e);
        // save chi tiết
        List<InOutPaymentReceiverNote> chiTiets = new ArrayList<>();

        BigDecimal paymentAmount = req.getAmount();
        StringBuilder dienGiai = new StringBuilder();
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        if (req.getLoaiPhieu() == InOutCommingType.Incomming || req.getLoaiPhieu() == InOutCommingType.InReturnSupplier) {
            List<PhieuXuats> deliveryNoteService = phieuXuatsRepository.findByNhaThuocMaNhaThuocAndIdInAndRecordStatusIdOrderByNgayXuat(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), receiverNoteIds, RecordStatusContains.ACTIVE).stream().toList();
            for (PhieuXuats px : deliveryNoteService) {
                InOutPaymentReceiverNote chiTiet = new InOutPaymentReceiverNote();
                chiTiet.setDrugStoreCode(getLoggedUser().getNhaThuoc().getMaNhaThuoc());
                chiTiet.setInOutCommingNoteId(e.getId());
                chiTiet.setIsDeleted(false);
                chiTiet.setReceiverNoteTypeId(e.getLoaiPhieu() == InOutCommingType.Incomming ? ENoteType.Delivery : ENoteType.ReturnToSupplier);
                chiTiet.setCreated(new Date());
                chiTiet.setCreatedByUserId(getLoggedUser().getId());
                chiTiet.setStoreId(getLoggedUser().getNhaThuoc().getId());

                BigDecimal debtAmount = px.getTongTien()
                        .subtract(px.getDaTra())
                        .subtract(px.getDiscount())
                        .subtract(px.getPaymentScoreAmount())
                        .subtract(px.getDebtPaymentAmount());
                if (debtAmount.compareTo(paymentAmount) <= 0) {
                    px.setIsDebt(false);
                    px.setDebtPaymentAmount(px.getTongTien()
                            .subtract(px.getDaTra())
                            .subtract(px.getDiscount())
                            .subtract(px.getPaymentScoreAmount()));
                    phieuXuatsRepository.save(px);

                    paymentAmount = paymentAmount.subtract(debtAmount);
                    dienGiai.append(String.format("%s; ", px.getSoPhieuXuat()));
                    chiTiet.setDebtPaymentAmount(debtAmount);
                    chiTiet.setReceiverNoteId(px.getId());
                    chiTiets.add(chiTiet);
                } else {
                    px.setIsDebt(true);
                    px.setDebtPaymentAmount(px.getDebtPaymentAmount().add(paymentAmount));
                    phieuXuatsRepository.save(px);

                    dienGiai.append(String.format("%s - Đã trả được %s", px.getSoPhieuXuat(), moneyFormatter.format(px.getDebtPaymentAmount())));
                    chiTiet.setDebtPaymentAmount(paymentAmount);
                    chiTiet.setReceiverNoteId(px.getId());
                    chiTiets.add(chiTiet);
                }
                if (paymentAmount.compareTo(BigDecimal.ZERO) <= 0) break;
            }
        } else if (req.getLoaiPhieu() == InOutCommingType.Outcomming || req.getLoaiPhieu() == InOutCommingType.OutReturnCustomer) {
            List<PhieuNhaps> receiptNoteService = phieuNhapsRepository.findByNhaThuocMaNhaThuocAndIdInAndRecordStatusIdOrderByNgayNhap(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), receiverNoteIds, RecordStatusContains.ACTIVE).stream().toList();
            for (PhieuNhaps pn : receiptNoteService) {
                InOutPaymentReceiverNote chiTiet = new InOutPaymentReceiverNote();
                chiTiet.setDrugStoreCode(getLoggedUser().getNhaThuoc().getMaNhaThuoc());
                chiTiet.setInOutCommingNoteId(e.getId());
                chiTiet.setIsDeleted(false);
                chiTiet.setReceiverNoteTypeId(e.getLoaiPhieu() == InOutCommingType.Outcomming ? ENoteType.Receipt : ENoteType.ReturnFromCustomer);
                chiTiet.setCreated(new Date());
                chiTiet.setCreatedByUserId(getLoggedUser().getId());
                chiTiet.setStoreId(getLoggedUser().getNhaThuoc().getId());

                BigDecimal debtAmount = pn.getTongTien()
                        .subtract(pn.getDaTra())
                        .subtract(pn.getDiscount())
                        .subtract(pn.getDebtPaymentAmount());
                if (debtAmount.compareTo(paymentAmount) <= 0) {
                    pn.setIsDebt(false);
                    pn.setDebtPaymentAmount(pn.getTongTien()
                            .subtract(pn.getDaTra())
                            .subtract(pn.getDiscount()));
                    phieuNhapsRepository.save(pn);

                    paymentAmount = paymentAmount.subtract(debtAmount);
                    dienGiai.append(String.format("%s; ", pn.getSoPhieuNhap()));
                    chiTiet.setDebtPaymentAmount(debtAmount);
                    chiTiet.setReceiverNoteId(pn.getId());
                    chiTiets.add(chiTiet);
                } else {
                    pn.setIsDebt(true);
                    pn.setDebtPaymentAmount(pn.getDebtPaymentAmount().add(paymentAmount));
                    phieuNhapsRepository.save(pn);

                    dienGiai.append(String.format("%s - Đã trả được %s", pn.getSoPhieuNhap(), moneyFormatter.format(pn.getDebtPaymentAmount())));
                    chiTiet.setDebtPaymentAmount(paymentAmount);
                    chiTiet.setReceiverNoteId(pn.getId());
                    chiTiets.add(chiTiet);
                }
                if (paymentAmount.compareTo(BigDecimal.ZERO) <= 0) break;
            }
        }
        inOutPaymentReceiverNoteRepository.saveAll(chiTiets);
        if (!dienGiai.isEmpty()) {
            e.setDienGiai(String.format("Đã trả cho phiếu: %s", dienGiai));
            if (!req.getDienGiai().isEmpty()) {
                e.setDienGiai(String.format("%s (%s)", e.getDienGiai(), req.getDienGiai()));
            }
            e = hdrRepo.save(e);
        }
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
        } else {
            if (optional.get().getRecordStatusId() != RecordStatusContains.ACTIVE) {
                throw new Exception("Không tìm thấy dữ liệu.");
            }
        }

        // Apple current time cho ngày tạo
        LocalDateTime ngayTao = LocalDateTime.ofInstant(req.getNgayTao().toInstant(), ZoneId.systemDefault());
        LocalDateTime ngayTaoWithCurrentTime = LocalDateTime.of(ngayTao.toLocalDate(), LocalTime.now());
        req.setNgayTao(Date.from(ngayTaoWithCurrentTime.atZone(ZoneId.systemDefault()).toInstant()));

        boolean normalUser = "User".equals(userInfo.getNhaThuoc().getRole());

        ApplicationSetting autoLockNotesAfterDays = getSetting(StoreSettingKeys.AutoLockNotesAfterDays);
        if (autoLockNotesAfterDays.getActivated() && Integer.parseInt(autoLockNotesAfterDays.getSettingValue()) >= 0 && normalUser) {
            LocalDate minNoteDate = LocalDate.now();
            minNoteDate = minNoteDate.minusDays(Long.parseLong(autoLockNotesAfterDays.getSettingValue()));
            LocalDate noteDateUpdate = req.getId() <= 0 ? LocalDate.from(ngayTaoWithCurrentTime) : LocalDate.ofInstant(optional.get().getCreated().toInstant(), ZoneId.systemDefault());
            LocalDate nextDate = LocalDate.now().plusDays(1);
            if (noteDateUpdate.isBefore(minNoteDate) || (noteDateUpdate.isEqual(nextDate) && req.getId() <= 0)) {
                String msg = noteDateUpdate.isEqual(nextDate) ?
                        String.format("Ngày trên phiếu không hợp lệ. Ngày trên phiếu không được lớn hơn '%s'.", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))) :
                        String.format("Ngày trên phiếu không hợp lệ. Ngày trên phiếu không được nhỏ hơn '%s'.", minNoteDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                throw new Exception(msg);
            }
        }

        Optional<InOutPaymentReceiverNote> optDetail = inOutPaymentReceiverNoteRepository.findFirstByInOutCommingNoteIdAndDrugStoreCode(req.getId(), req.getNhaThuocMaNhaThuoc());
        BigDecimal debtAmount;
        String dienGiai = "";
        NumberFormat moneyFormatter = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
        if (optDetail.isPresent()) {
            // Save chi tiết
            debtAmount = optDetail.get().getDebtPaymentAmount();
            optDetail.get().setDebtPaymentAmount(req.getAmount());
            inOutPaymentReceiverNoteRepository.save(optDetail.get());

            if (optional.get().getLoaiPhieu() == InOutCommingType.Incomming || optional.get().getLoaiPhieu() == InOutCommingType.InReturnSupplier) {
                Optional<PhieuXuats> phieuXuats = phieuXuatsRepository.findById(optDetail.get().getReceiverNoteId());
                if (phieuXuats.isPresent() && phieuXuats.get().getRecordStatusId() == RecordStatusContains.ACTIVE) {
                    PhieuXuats px = phieuXuats.get();
                    px.setDebtPaymentAmount(px.getDebtPaymentAmount().subtract(debtAmount));
                    BigDecimal debtLoan = px.getTongTien()
                            .subtract(px.getDaTra())
                            .subtract(px.getDiscount())
                            .subtract(px.getPaymentScoreAmount())
                            .subtract(px.getDebtPaymentAmount());
                    if (debtLoan.compareTo(req.getAmount()) > 0) {
                        px.setIsDebt(true);
                        px.setDebtPaymentAmount(px.getDebtPaymentAmount().add(req.getAmount()));
                    } else {
                        px.setIsDebt(false);
                        px.setDebtPaymentAmount(px.getTongTien()
                                .subtract(px.getDaTra())
                                .subtract(px.getDiscount())
                                .subtract(px.getPaymentScoreAmount()));
                    }
                    phieuXuatsRepository.save(px);
                    dienGiai = String.format("Đã trả cho phiếu: %s (%s)", px.getSoPhieuXuat(), moneyFormatter.format(req.getAmount()));
                }
            } else if (optional.get().getLoaiPhieu() == InOutCommingType.Outcomming || optional.get().getLoaiPhieu() == InOutCommingType.OutReturnCustomer) {
                Optional<PhieuNhaps> phieuNhaps = phieuNhapsRepository.findById(optDetail.get().getReceiverNoteId());
                if (phieuNhaps.isPresent() && phieuNhaps.get().getRecordStatusId() == RecordStatusContains.ACTIVE) {
                    PhieuNhaps pn = phieuNhaps.get();
                    pn.setDebtPaymentAmount(pn.getDebtPaymentAmount().subtract(debtAmount));
                    BigDecimal debtLoan = pn.getTongTien()
                            .subtract(pn.getDaTra())
                            .subtract(pn.getDiscount())
                            .subtract(pn.getDebtPaymentAmount());
                    if (debtLoan.compareTo(req.getAmount()) > 0) {
                        pn.setIsDebt(true);
                        pn.setDebtPaymentAmount(pn.getDebtPaymentAmount().add(req.getAmount()));
                    } else {
                        pn.setIsDebt(false);
                        pn.setDebtPaymentAmount(pn.getTongTien()
                                .subtract(pn.getDaTra())
                                .subtract(pn.getDiscount()));
                    }
                    phieuNhapsRepository.save(pn);
                    dienGiai = String.format("Đã trả cho phiếu: %s (%s)", pn.getSoPhieuNhap(), moneyFormatter.format(req.getAmount()));
                }
            }
        }
        PhieuThuChis e = optional.get();
        BeanUtils.copyProperties(req, e, "id", "created", "createdByUserId");
        e.setDienGiai(req.getDienGiai().isEmpty() ? dienGiai : req.getDienGiai());
        e.setModified(new Date());
        e.setModifiedByUserId(getLoggedUser().getId());
        e.setUserProfileUserId(getLoggedUser().getId());
        e.setKhachHangMaKhachHang(e.getCustomerId());
        e.setNhaCungCapMaNhaCungCap(e.getSupplierId());
        if (req.getRecordStatusId() == null) req.setRecordStatusId(RecordStatusContains.ACTIVE);
        e = hdrRepo.save(e);
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
            userProfile.ifPresent(profile -> optional.get().setCreatedByUserText(profile.getTenDayDu()));
        }
        if (optional.get().getCustomerId() != null && optional.get().getCustomerId() > 0) {
            Optional<KhachHangs> khachHang = khachHangsRepository.findById(optional.get().getCustomerId());
            khachHang.ifPresent(khachHangs -> optional.get().setCustomerText(khachHangs.getTenKhachHang()));
            khachHang.ifPresent(khachHangs -> optional.get().setDiaChiKhacHangText(khachHangs.getDiaChi()));
        }
        if (optional.get().getSupplierId() != null && optional.get().getSupplierId() > 0) {
            Optional<NhaCungCaps> nhaCungCaps = nhaCungCapsRepository.findById(optional.get().getSupplierId());
            nhaCungCaps.ifPresent(cungCaps -> optional.get().setNhaCungCapMaNhaCungCapText(cungCaps.getTenNhaCungCap()));
        }
        if (optional.get().getNhanVienId() != null && optional.get().getNhanVienId() > 0) {
            Optional<UserProfile> nhanViens = userProfileRepository.findById(optional.get().getNhanVienId());
            nhanViens.ifPresent(userProfile -> optional.get().setNhanVienText(userProfile.getTenDayDu()));
        }
        if (optional.get().getMaCoSo() != null) {
            Optional<NhaThuocs> nhaThuocs = nhaThuocsRepository.findByMaNhaThuoc(optional.get().getMaCoSo());
            nhaThuocs.ifPresent(thuocs -> optional.get().setNhaThuocs(thuocs));
        }
        return optional.get();
    }

    @Override
    public boolean delete(Long id) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null)
            throw new Exception("Bad request.");

        PhieuThuChis phieuThuChis = detail(id);
        List<InOutPaymentReceiverNote> chiTiets = inOutPaymentReceiverNoteRepository.findByInOutCommingNoteId(id);
        if (phieuThuChis.getLoaiPhieu() == InOutCommingType.Incomming || phieuThuChis.getLoaiPhieu() == InOutCommingType.InReturnSupplier) {
            for (InOutPaymentReceiverNote chiTiet : chiTiets) {
                Optional<PhieuXuats> phieuXuats = phieuXuatsRepository.findById(chiTiet.getReceiverNoteId());
                if (phieuXuats.isPresent() && phieuXuats.get().getRecordStatusId() == RecordStatusContains.ACTIVE) {
                    PhieuXuats px = phieuXuats.get();
                    BigDecimal debtPaymentAmount = px.getDebtPaymentAmount()
                            .subtract(chiTiet.getDebtPaymentAmount());
                    if (debtPaymentAmount.compareTo(BigDecimal.ZERO) <= 0) {
                        debtPaymentAmount = BigDecimal.ZERO;
                    }
                    px.setDebtPaymentAmount(debtPaymentAmount);
                    px.setIsDebt(true);
                    phieuXuatsRepository.save(px);
                }
            }
        } else if (phieuThuChis.getLoaiPhieu() == InOutCommingType.Outcomming || phieuThuChis.getLoaiPhieu() == InOutCommingType.OutReturnCustomer) {
            for (InOutPaymentReceiverNote chiTiet : chiTiets) {
                Optional<PhieuNhaps> phieuNhaps = phieuNhapsRepository.findById(chiTiet.getReceiverNoteId());
                if (phieuNhaps.isPresent() && phieuNhaps.get().getRecordStatusId() == RecordStatusContains.ACTIVE) {
                    PhieuNhaps pn = phieuNhaps.get();
                    BigDecimal debtPaymentAmount = pn.getDebtPaymentAmount()
                            .subtract(chiTiet.getDebtPaymentAmount());
                    if (debtPaymentAmount.compareTo(BigDecimal.ZERO) <= 0) {
                        debtPaymentAmount = BigDecimal.ZERO;
                    }
                    pn.setDebtPaymentAmount(debtPaymentAmount);
                    pn.setIsDebt(true);
                    phieuNhapsRepository.save(pn);
                }
            }
        }
        hdrRepo.delete(phieuThuChis);
        inOutPaymentReceiverNoteRepository.deleteAll(chiTiets);
        return true;
    }

    @Override
    public Long getSoPhieuThuChi(Integer loaiPhieu) throws Exception {
        List<PhieuThuChis> phieuThuChis = hdrRepo.findByNhaThuocMaNhaThuocAndLoaiPhieu(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), loaiPhieu).stream().toList();
        long maxNumber = 0L;
        if (!phieuThuChis.isEmpty()) {
            maxNumber = phieuThuChis.stream().max(Comparator.comparing(PhieuThuChis::getSoPhieu)).get().getSoPhieu();
        }
        return maxNumber + 1L;
    }

    @Override
    public DebtInfoRes<PhieuXuats> getInComingCustomerDebt(Long phieuThuChiId, Long customerId) throws Exception {
        DebtInfoRes<PhieuXuats> res = new DebtInfoRes<>();
        BigDecimal debtAmount = BigDecimal.ZERO;
        BigDecimal returnAmount = BigDecimal.ZERO;

        // Lấy danh sách phiếu bán cho khách hàng đã chọn
        List<Integer> typePx = List.of(ENoteType.Delivery, ENoteType.InitialDebt);
        List<Long> statusPx = List.of(RecordStatusContains.ACTIVE);
        List<PhieuXuats> deliveryNoteService = phieuXuatsRepository.findByNhaThuocMaNhaThuocAndKhachHangMaKhachHangAndMaLoaiXuatNhapInAndRecordStatusIdInOrderByNgayXuat(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), customerId, typePx, statusPx).stream().toList();

        if (phieuThuChiId > 0) {
            // Nếu sửa phiếu lấy trong list detail
            List<InOutPaymentReceiverNote> inOutPaymentReceiverNotes = inOutPaymentReceiverNoteRepository.findByInOutCommingNoteId(phieuThuChiId);
            List<Long> deliveryNoteIds = inOutPaymentReceiverNotes.stream()
                    .map(InOutPaymentReceiverNote::getReceiverNoteId)
                    .toList();

            deliveryNoteService = deliveryNoteService
                    .stream()
                    .filter(x -> deliveryNoteIds.contains(x.getId()))
                    .toList();
        } else {
            // Nếu tạo phiếu lấy trong list phiếu nhập của khách còn nợ
            deliveryNoteService = deliveryNoteService
                    .stream()
                    .filter(x ->
                            (Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                                    .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDiscount()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getPaymentScoreAmount()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO))
                                    .compareTo(BigDecimal.ZERO) > 0)
                    )
                    .toList();

            List<PhieuNhaps> returnNoteCus = phieuNhapsRepository.findByNhaThuocMaNhaThuocAndKhachHangMaKhachHangAndLoaiXuatNhapMaLoaiXuatNhapAndRecordStatusIdOrderByNgayNhap(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), customerId, ENoteType.ReturnFromCustomer, RecordStatusContains.ACTIVE)
                    .stream()
                    .filter(x ->
                            (Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                                    .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO))
                                    .compareTo(BigDecimal.ZERO) > 0)
                    )
                    .toList();

            if (!returnNoteCus.isEmpty()) {
                returnAmount = returnNoteCus.stream()
                        .map(x -> Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                                .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                                .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO)))
                        .reduce(BigDecimal.ZERO, BigDecimal::add);
            }
        }

        if (!deliveryNoteService.isEmpty()) {
            deliveryNoteService = deliveryNoteService
                    .stream()
                    .peek(x -> x.setDebtAmount(
                            Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                                    .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDiscount()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getPaymentScoreAmount()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO)))
                    )
                    .peek(x -> {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate = formatter.format(x.getNgayXuat());
                        x.setNoteInfo(String.format("%s - %s", formattedDate, x.getSoPhieuXuat()));
                    })
                    .toList();

            debtAmount = deliveryNoteService.stream()
                    .map(PhieuXuats::getDebtAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        res.setDebtNotes(deliveryNoteService);
        res.setDebtAmount(debtAmount);
        res.setReturnAmount(returnAmount);
        return res;
    }

    @Override
    public DebtInfoRes<PhieuNhaps> getOutReturnCustomerDebt(Long phieuThuChiId, Long customerId) throws Exception {
        DebtInfoRes<PhieuNhaps> res = new DebtInfoRes<>();
        BigDecimal debtAmount = BigDecimal.ZERO;

        List<PhieuNhaps> returnFromCustomerNoteService = phieuNhapsRepository.findByNhaThuocMaNhaThuocAndKhachHangMaKhachHangAndLoaiXuatNhapMaLoaiXuatNhapAndRecordStatusIdOrderByNgayNhap(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), customerId, ENoteType.ReturnFromCustomer, RecordStatusContains.ACTIVE).stream().toList();
        if (phieuThuChiId > 0) {
            List<InOutPaymentReceiverNote> inOutPaymentReceiverNotes = inOutPaymentReceiverNoteRepository.findByInOutCommingNoteId(phieuThuChiId);
            List<Long> returnFromCustomerNoteIds = inOutPaymentReceiverNotes.stream()
                    .map(InOutPaymentReceiverNote::getReceiverNoteId)
                    .toList();

            returnFromCustomerNoteService = returnFromCustomerNoteService
                    .stream()
                    .filter(x -> returnFromCustomerNoteIds.contains(x.getId()))
                    .toList();
        } else {
            returnFromCustomerNoteService = returnFromCustomerNoteService
                    .stream()
                    .filter(x -> (Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                            .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                            .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO))
                            .compareTo(BigDecimal.ZERO) > 0)
                    )
                    .toList();
        }

        if (!returnFromCustomerNoteService.isEmpty()) {
            returnFromCustomerNoteService = returnFromCustomerNoteService
                    .stream()
                    .peek(x -> x.setDebtAmount(
                            Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                                    .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO)))
                    )
                    .peek(x -> {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate = formatter.format(x.getNgayNhap());
                        x.setNoteInfo(String.format("%s - %s", formattedDate, x.getSoPhieuNhap()));
                    })
                    .toList();

            debtAmount = returnFromCustomerNoteService.stream()
                    .map(PhieuNhaps::getDebtAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        res.setDebtNotes(returnFromCustomerNoteService);
        res.setDebtAmount(debtAmount);
        return res;
    }

    @Override
    public DebtInfoRes<PhieuNhaps> getOutComingSupplierDebt(Long phieuThuChiId, Long supplierId) throws Exception {
        DebtInfoRes<PhieuNhaps> res = new DebtInfoRes<>();
        BigDecimal debtAmount = BigDecimal.ZERO;
        BigDecimal returnAmount = BigDecimal.ZERO;

        // Lấy danh sách phiếu nhập của nhà cung cấp đã chọn
        List<Integer> typePn = List.of(ENoteType.Receipt, ENoteType.InitialDebt);
        List<Long> statusPn = List.of(RecordStatusContains.ACTIVE);
        List<PhieuNhaps> receiptNoteService = phieuNhapsRepository.findByNhaThuocMaNhaThuocAndNhaCungCapMaNhaCungCapAndLoaiXuatNhapMaLoaiXuatNhapInAndRecordStatusIdInOrderByNgayNhap(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), supplierId, typePn, statusPn).stream().toList();

        if (phieuThuChiId > 0) {
            // Nếu sửa phiếu lấy trong list detail
            List<InOutPaymentReceiverNote> inOutPaymentReceiverNotes = inOutPaymentReceiverNoteRepository.findByInOutCommingNoteId(phieuThuChiId);
            List<Long> receiptNoteIds = inOutPaymentReceiverNotes.stream()
                    .map(InOutPaymentReceiverNote::getReceiverNoteId)
                    .toList();

            receiptNoteService = receiptNoteService
                    .stream()
                    .filter(x -> receiptNoteIds.contains(x.getId()))
                    .toList();
        } else {
            // Nếu tạo phiếu lấy trong list phiếu nhập còn nợ nhà cung cấp
            receiptNoteService = receiptNoteService
                    .stream()
                    .filter(x ->
                            (Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                                    .add(Optional.ofNullable(x.getVat()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDiscount()).orElse((BigDecimal.ZERO)))
                                    .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse((BigDecimal.ZERO))))
                                    .compareTo(BigDecimal.ZERO) > 0)
                    .toList();

            // Lấy danh sách phiếu trả hàng tới nhà cung cấp đã chọn
            List<PhieuXuats> returnNoteSup = phieuXuatsRepository.findByNhaThuocMaNhaThuocAndNhaCungCapMaNhaCungCapAndMaLoaiXuatNhapAndRecordStatusIdOrderByNgayXuat(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), supplierId, ENoteType.ReturnToSupplier, RecordStatusContains.ACTIVE)
                    .stream()
                    .filter(x ->
                            (Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                                    .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO))
                                    .compareTo(BigDecimal.ZERO)) > 0)
                    .toList();

            if (!returnNoteSup.isEmpty()) {
                debtAmount = debtAmount.subtract(returnNoteSup.stream()
                        .map(x -> Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                                .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                                .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO)))
                        .reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        }

        if (!receiptNoteService.isEmpty()) {
            receiptNoteService = receiptNoteService
                    .stream()
                    .peek(x -> x.setDebtAmount(
                            Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                                    .add(Optional.ofNullable(x.getVat()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDiscount()).orElse(BigDecimal.ZERO))
                                    .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO))))
                    .peek(x -> {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate = formatter.format(x.getNgayNhap());
                        x.setNoteInfo(String.format("%s - %s", formattedDate, x.getSoPhieuNhap()));
                    })
                    .toList();

            debtAmount = receiptNoteService.stream()
                    .map(PhieuNhaps::getDebtAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        res.setDebtNotes(receiptNoteService);
        res.setDebtAmount(debtAmount);
        res.setReturnAmount(returnAmount);
        return res;
    }


    @Override
    public DebtInfoRes<PhieuXuats> getInReturnSupplierDebt(Long phieuThuChiId, Long supplierId) throws Exception {
        DebtInfoRes<PhieuXuats> res = new DebtInfoRes<>();
        BigDecimal debtAmount = BigDecimal.ZERO;

        List<PhieuXuats> returnToSupplierNoteService = phieuXuatsRepository.findByNhaThuocMaNhaThuocAndNhaCungCapMaNhaCungCapAndMaLoaiXuatNhapAndRecordStatusIdOrderByNgayXuat(getLoggedUser().getNhaThuoc().getMaNhaThuoc(), supplierId, ENoteType.ReturnToSupplier, RecordStatusContains.ACTIVE)
                .stream()
                .toList();
        if (phieuThuChiId > 0) {
            List<InOutPaymentReceiverNote> inOutPaymentReceiverNotes = inOutPaymentReceiverNoteRepository.findByInOutCommingNoteId(phieuThuChiId);
            List<Long> returnToSupplierNoteIds = inOutPaymentReceiverNotes.stream()
                    .map(InOutPaymentReceiverNote::getReceiverNoteId)
                    .toList();
            returnToSupplierNoteService = returnToSupplierNoteService
                    .stream()
                    .filter(x -> returnToSupplierNoteIds.contains(x.getId()))
                    .toList();
        } else {
            returnToSupplierNoteService = returnToSupplierNoteService
                    .stream()
                    .filter(x -> (Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                            .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                            .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO))
                            .compareTo(BigDecimal.ZERO) > 0)
                    )
                    .toList();
        }

        if (!returnToSupplierNoteService.isEmpty()) {
            returnToSupplierNoteService = returnToSupplierNoteService
                    .stream()
                    .peek(x -> x.setDebtAmount(Optional.ofNullable(x.getTongTien()).orElse(BigDecimal.ZERO)
                            .subtract(Optional.ofNullable(x.getDaTra()).orElse(BigDecimal.ZERO))
                            .subtract(Optional.ofNullable(x.getDebtPaymentAmount()).orElse(BigDecimal.ZERO)))
                    )
                    .peek(x -> {
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                        String formattedDate = formatter.format(x.getNgayXuat());
                        x.setNoteInfo(String.format("%s - %s", formattedDate, x.getSoPhieuXuat()));
                    })
                    .toList();

            debtAmount = returnToSupplierNoteService.stream()
                    .map(PhieuXuats::getDebtAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
        }

        res.setDebtNotes(returnToSupplierNoteService);
        res.setDebtAmount(debtAmount);
        return res;
    }

    @Override
    public ReportTemplateResponse preview(HashMap<String, Object> hashMap) throws Exception {
        Profile userInfo = this.getLoggedUser();
        if (userInfo == null) {
            throw new Exception("Bad request.");
        }
        try {
            PhieuThuChis phieuThuChis = this.detail(FileUtils.safeToLong(hashMap.get("id")));
            String loai = FileUtils.safeToString(hashMap.get("loai"));
            String templatePath = "/template/thuChi/";
            phieuThuChis.setBangChu(FileUtils.convertToWords(phieuThuChis.getAmount()));
            phieuThuChis.setLoaiPhieuText("PHIẾU THU");
            phieuThuChis.setNameHeader("Họ tên người nhận tiền");
            phieuThuChis.setNameSignature("Người nhận tiền");
            switch (loai) {
                case FileUtils.InKhachLeA5:
                    templatePath += "RptPhieuThuA5.docx";
                    break;
                case FileUtils.InKhachQuen:
                    if (phieuThuChis.getNhaThuocMaNhaThuoc().equals("4563")) {
                        templatePath += "RptPhieuThuA4_4563.docx";
                        phieuThuChis.setBangChu(FileUtils.convertToWords(phieuThuChis.getAmount()));
                    }
                    if (phieuThuChis.getLoaiPhieu() == InOutCommingType.OtherIncomming || phieuThuChis.getLoaiPhieu() == InOutCommingType.OtherOutcomming || phieuThuChis.getLoaiPhieu() == InOutCommingType.BusinessCosts) {
                        templatePath += "RptPhieuThuChiKhac.docx";
                    } else if (phieuThuChis.getLoaiPhieu() == InOutCommingType.Incomming) {
                        templatePath += "RptPhieuThu.docx";
                    } else if (phieuThuChis.getLoaiPhieu() == InOutCommingType.Outcomming) {
                        templatePath += "RptPhieuChi.docx";
                    }
                    break;
                default:
                    break;
            }
            this.setTruong(userInfo, phieuThuChis, loai);
            InputStream templateInputStream = FileUtils.templateInputStream(templatePath);
            return FileUtils.convertDocxToPdf(templateInputStream, phieuThuChis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private void setTruong(Profile userInfo, PhieuThuChis phieuThuChis, String loai) {
        phieuThuChis.setNhaThuocMaNhaThuocText(userInfo.getNhaThuoc().getTenNhaThuoc());
        phieuThuChis.setDiaChiNhaThuocText(userInfo.getNhaThuoc().getDiaChi());
        phieuThuChis.setSdtNhaThuocText(userInfo.getNhaThuoc().getDienThoai());
        if (loai.equals(FileUtils.InKhachLeA5)) {
            if (phieuThuChis.getLoaiPhieu() == InOutCommingType.Incomming || phieuThuChis.getLoaiPhieu() == InOutCommingType.OtherIncomming) {
                phieuThuChis.setNameHeader("Họ tên người nộp tiền");
                phieuThuChis.setNameSignature("Người nộp tiền");
            } else if (phieuThuChis.getLoaiPhieu() == InOutCommingType.Outcomming || phieuThuChis.getLoaiPhieu() == InOutCommingType.OtherOutcomming || phieuThuChis.getLoaiPhieu() == InOutCommingType.BusinessCosts) {
                phieuThuChis.setLoaiPhieuText("PHIẾU CHI");
            }
        }
        if (loai.equals(FileUtils.InKhachQuen)) {
            if (phieuThuChis.getLoaiPhieu() == InOutCommingType.Incomming || phieuThuChis.getLoaiPhieu() == InOutCommingType.Outcomming) {
                try {
                    DebtInfoRes<PhieuXuats> debtInfoRes = this.getInComingCustomerDebt(phieuThuChis.getId(), phieuThuChis.getKhachHangMaKhachHang());
                    phieuThuChis.setDebtAmount(debtInfoRes.getDebtAmount() != null ? debtInfoRes.getDebtAmount() : new BigDecimal(0));
                    phieuThuChis.setReturnAmount(debtInfoRes.getDebtAmount() != null ? debtInfoRes.getDebtAmount() : new BigDecimal(0));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                if (phieuThuChis.getLoaiPhieu() == InOutCommingType.BusinessCosts) {
                    phieuThuChis.setType("Chi phí kinh doanh");
                }else if (phieuThuChis.getLoaiPhieu() == InOutCommingType.OtherOutcomming){
                    phieuThuChis.setType("Chi khác");
                } else {
                    phieuThuChis.setType("Thu khác");
                }
                phieuThuChis.setCusType(phieuThuChis.getLoaiPhieu() == InOutCommingType.OtherIncomming ? "Người nộp" : "Người nhận");
            }
        }

    }
}
