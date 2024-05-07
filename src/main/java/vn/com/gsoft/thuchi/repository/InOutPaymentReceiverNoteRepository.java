package vn.com.gsoft.thuchi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import vn.com.gsoft.thuchi.entity.InOutPaymentReceiverNote;

import java.util.List;

@Repository
public interface InOutPaymentReceiverNoteRepository extends CrudRepository<InOutPaymentReceiverNote, Long> {
    public List<InOutPaymentReceiverNote> findByInOutCommingNoteId(Long inOutCommingNoteId);
}