package vn.com.gsoft.thuchi.model.system;

import lombok.Data;

import java.util.List;

@Data
public class BaseRequest {
	private Long id;
	private String maNhaThuoc;
	private Long userIdQueryData;
	private String textSearch;
	private Long recordStatusId;
	private List<Long> recordStatusIds;
	private PaggingReq paggingReq;
	private Boolean dataDelete;
}