package vn.com.gsoft.thuchi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.com.gsoft.thuchi.model.dto.DebtInfoRes;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "InOutPaymentReceiverNote")
public class InOutPaymentReceiverNote extends BaseEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "InOutCommingNoteId")
    private Long inOutCommingNoteId;
    @Column(name = "ReceiverNoteId")
    private Long receiverNoteId;
    @Column(name = "IsDeleted")
    private Boolean isDeleted;
    @Column(name = "DrugStoreCode")
    private String drugStoreCode;
    @Column(name = "ReceiverNoteTypeId")
    private Integer receiverNoteTypeId;
    @Column(name = "StoreId")
    private Long storeId;
    @Column(name = "DebtPaymentAmount")
    private BigDecimal debtPaymentAmount;
    @Transient
    private PhieuNhaps phieuNhaps;
    @Transient
    private PhieuXuats phieuXuats;
    @Transient
    private BigDecimal debtAmount;
}

