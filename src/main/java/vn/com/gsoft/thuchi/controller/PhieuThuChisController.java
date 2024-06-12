package vn.com.gsoft.thuchi.controller;


import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.com.gsoft.thuchi.constant.PathContains;
import vn.com.gsoft.thuchi.model.dto.PhieuThuChisReq;
import vn.com.gsoft.thuchi.model.system.BaseResponse;
import vn.com.gsoft.thuchi.service.PhieuThuChisService;
import vn.com.gsoft.thuchi.util.system.ResponseUtils;

import java.util.HashMap;


@Slf4j
@RestController
@RequestMapping(PathContains.URL_PHIEU_THU_CHI)
public class PhieuThuChisController {

    @Autowired
    PhieuThuChisService service;


    @PostMapping(value = PathContains.URL_SEARCH_PAGE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> colection(@RequestBody PhieuThuChisReq objReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.searchPage(objReq)));
    }


    @PostMapping(value = PathContains.URL_SEARCH_LIST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> colectionList(@RequestBody PhieuThuChisReq objReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.searchList(objReq)));
    }


    @PostMapping(value = PathContains.URL_CREATE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> insert(@Valid @RequestBody PhieuThuChisReq objReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.create(objReq)));
    }


    @PostMapping(value = PathContains.URL_UPDATE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BaseResponse> update(@Valid @RequestBody PhieuThuChisReq objReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.update(objReq)));
    }


    @GetMapping(value = PathContains.URL_DETAIL, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> detail(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.detail(id)));
    }


    @PostMapping(value = PathContains.URL_DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> delete(@Valid @RequestBody PhieuThuChisReq idSearchReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.delete(idSearchReq.getId())));
    }

    @PostMapping(value = "/get-so-phieu-thu-chi", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> getSoPhieuThuChi(@Valid @RequestBody PhieuThuChisReq idSearchReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.getSoPhieuThuChi(idSearchReq.getLoaiPhieu())));
    }

    @PostMapping(value = "/get-in-coming-customer-debt", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> getInComingCustomerDebt(@Valid @RequestBody PhieuThuChisReq idSearchReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.getInComingCustomerDebt(idSearchReq.getId(), idSearchReq.getCustomerId())));
    }

    @PostMapping(value = "/get-out-return-customer-debt", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> getOutReturnCustomerDebt(@Valid @RequestBody PhieuThuChisReq idSearchReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.getOutReturnCustomerDebt(idSearchReq.getId(), idSearchReq.getCustomerId())));
    }

    @PostMapping(value = "/get-out-coming-supplier-debt", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> getOutComingSupplierDebt(@Valid @RequestBody PhieuThuChisReq idSearchReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.getOutComingSupplierDebt(idSearchReq.getId(), idSearchReq.getSupplierId())));
    }

    @PostMapping(value = "/get-in-return-supplier-debt", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> getInReturnSupplierDebt(@Valid @RequestBody PhieuThuChisReq idSearchReq) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.getInReturnSupplierDebt(idSearchReq.getId(), idSearchReq.getSupplierId())));
    }

    @PostMapping(value = PathContains.URL_PREVIEW, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<BaseResponse> preview(@RequestBody HashMap<String, Object> body) throws Exception {
        return ResponseEntity.ok(ResponseUtils.ok(service.preview(body)));
    }
}
