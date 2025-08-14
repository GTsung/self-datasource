package com.self.datasource.second.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum DbTypeEnum {

    R(0, "READ"),
    W(1, "WRITE"),
    ;

    private final int code;

    private final String desc;

}
