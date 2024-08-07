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
package org.dblue.common.enums;

import java.util.Objects;

/**
 * 状态
 *
 * @author Wang Chengwei
 * @since 1.0.0
 */
public interface EnumState {

    /**
     * 获取状态值
     *
     * @return 状态值
     */
    int getValue();

    /**
     * 获取状态名称
     *
     * @return 状态名称
     */
    String getName();

    /**
     * 状态判断
     *
     * @param value 传入的状态
     * @return true-一致；false-不一致
     */
    default boolean equalsTo(Integer value) {
        return Objects.equals(this.getValue(), value);
    }
}
