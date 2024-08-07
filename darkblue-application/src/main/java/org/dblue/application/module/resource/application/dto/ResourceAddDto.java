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

package org.dblue.application.module.resource.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.dblue.common.validation.annotation.EnumValues;
import org.dblue.core.enums.PlatformEnum;

/**
 * 资源添加
 *
 * @author xie jin
 * @since 1.0.0  2024-07-02 17:27:58
 */
@Schema(description = "资源添加")
@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceAddDto extends ResourceDto {


    /**
     * 资源组ID
     */
    @Schema(description = "资源组ID")
    @Size(max = 64)
    private String resourceGroupId;


    /**
     * 适用平台(1-PC；2-APP)
     */
    @Schema(description = "适用平台(1-PC；2-APP)从菜单代入")
    @NotNull(message = "适用平台不能为空")
    @EnumValues(message = "适用平台字段不正确", clazz = PlatformEnum.class)
    private Integer platform;


}