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

package org.dblue.core.enums;

import lombok.Getter;
import org.dblue.common.enums.EnumType;

/**
 * 适用平台
 *
 * @author xie jin
 * @since 1.0.0  2024/6/14 下午5:19
 */
@Getter
public enum PlatformEnum implements EnumType {

    /**
     *
     */
    PC(1,"PC"),
    APP(2,"APP"),
    ;

    private final int value;
    private final String name;


    PlatformEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
}
