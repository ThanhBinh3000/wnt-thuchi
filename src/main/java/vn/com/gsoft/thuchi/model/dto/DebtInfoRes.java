package vn.com.gsoft.thuchi.model.dto;

import lombok.Data;
import vn.com.gsoft.thuchi.entity.PhieuNhaps;
import vn.com.gsoft.thuchi.entity.PhieuXuats;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Data
public class DebtInfoRes<T> {
    private BigDecimal debtAmount;
    private BigDecimal returnAmount;
    private List<T> debtNotes;
}
