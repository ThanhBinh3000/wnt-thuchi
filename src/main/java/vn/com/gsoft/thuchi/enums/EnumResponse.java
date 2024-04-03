package vn.com.gsoft.thuchi.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EnumResponse {
	RESP_SUCC(0, "Thành công"), RESP_FAIL(1, "Lỗi hệ thống");

	private final int value;

	private final String description;

	EnumResponse(int value, String description) {
		this.value = (byte) value;
		this.description = description;
	}

	@JsonValue
	public int getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}

	@JsonCreator
	public static EnumResponse fromValue(int value) {
		for (EnumResponse v : EnumResponse.values()) {
			if (v.getValue() == value) {
				return v;
			}
		}
		return null;
	}
}
