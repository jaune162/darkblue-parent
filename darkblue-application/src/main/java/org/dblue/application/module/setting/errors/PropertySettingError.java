/*
 * Copyright (c) 2023-2024. the original authors and DBLUE.ORG
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dblue.application.module.setting.errors;

import lombok.Getter;
import org.dblue.common.error.ErrorInfo;

/**
 * @author Wang Chengwei
 * @since 1.0.0
 */
@Getter
public enum PropertySettingError implements ErrorInfo {

    PROPERTY_CODE_EXIST("PROPERTY_001", "参数编码已存在"),
    NOT_EXIST("PROPERTY_002", "参数信息不存在"),
    VALUE_SCOPE_RESOLVE_ERROR("PROPERTY_003", "取值范围解析异常"),

    ;
    private final String errorCode;
    private final String errorMessage;

    PropertySettingError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}