package entity.dylandog;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public enum EdizioneEnum {
	COLLEZIONE_BOOK("Collezione Book"), REGOLARE("Regolare");

	private String code;

	// Map string codes to enum intannces to allow to retrive the enum
	// instance from the string code
	private static final Map<String, EdizioneEnum> ENUM_MAP;
	static {
		Map<String, EdizioneEnum> map = new ConcurrentHashMap<>();
		for (EdizioneEnum instance : EdizioneEnum.values()) {
			map.put(instance.getCode(), instance);
		}
		ENUM_MAP = Collections.unmodifiableMap(map);
	}

	private EdizioneEnum(String code) {
		this.code = code;
	}

	public static EdizioneEnum get(String name) throws Exception {
		if (!ENUM_MAP.containsKey(name))
			throw new Exception("Codice Edizione non trovato");
		return ENUM_MAP.get(name);
	}

	public String getCode() {
		return code;
	}

}
