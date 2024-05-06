package vn.com.gsoft.thuchi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import vn.com.gsoft.thuchi.entity.PhieuThuChis;
import vn.com.gsoft.thuchi.model.dto.PhieuThuChisReq;
import vn.com.gsoft.thuchi.model.system.PaggingReq;
import vn.com.gsoft.thuchi.model.system.Profile;
import vn.com.gsoft.thuchi.service.PhieuThuChisService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Slf4j
class PhieuThuChisServiceImplTest {
    @Autowired
    private PhieuThuChisService phieuThuChisService;
    @BeforeAll
    static void beforeAll() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Profile p = new Profile();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(p, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @Test
    void searchPage() throws Exception {
        PhieuThuChisReq phieuDuTruReq = new PhieuThuChisReq();
        PaggingReq paggingReq = new PaggingReq();
        paggingReq.setPage(0);
        paggingReq.setLimit(10);
        phieuDuTruReq.setPaggingReq(paggingReq);
        Page<PhieuThuChis> sampleNotes = phieuThuChisService.searchPage(phieuDuTruReq);
        assert sampleNotes != null;
    }

    @Test
    void detail() throws Exception {
        PhieuThuChis detail = phieuThuChisService.detail(10119l);
        assert detail != null;
    }
}