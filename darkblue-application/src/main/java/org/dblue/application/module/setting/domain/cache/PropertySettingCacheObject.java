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
package org.dblue.application.module.setting.domain.cache;

import lombok.Data;
import org.dblue.application.module.setting.infrastructure.entity.PropertySetting;
import org.springframework.beans.BeanUtils;

/**
 * @author Wang Chengwei
 * @since 1.0.0
 */
@Data
public class PropertySettingCacheObject {
    /**
     * 属性ID
     */
    private String propertyId;

    /**
     * 参数编码
     */
    private String propertyCode;

    /**
     * 参数名称
     */
    private String propertyName;

    /**
     * 参数说明
     */
    private String remark;

    /**
     * 参数类型（系统枚举定义）
     */
    private Integer type;

    /**
     * 参数默认值
     */
    private String defaultValue;

    /**
     * 参数当前值
     */
    private String value;

    /**
     * 单位
     */
    private String unit;

    public static PropertySettingCacheObject of(PropertySetting propertySetting) {
        PropertySettingCacheObject cacheObject = new PropertySettingCacheObject();
        BeanUtils.copyProperties(propertySetting, cacheObject);
        return cacheObject;
    }
}