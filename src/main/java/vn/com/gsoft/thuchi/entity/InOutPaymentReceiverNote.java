package vn.com.gsoft.thuchi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "InOutPaymentReceiverNote")
public class InOutPaymentReceiverNote {
    @Id
    @Column(name = "Id")
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
    private Long receiverNoteTypeId;
    @Column(name = "StoreId")
    private Long storeId;
    @Column(name = "DebtPaymentAmount")
    private BigDecimal debtPaymentAmount;
}

