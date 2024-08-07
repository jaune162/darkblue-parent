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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

/**
 * 绑定权限
 *
 * @author xie jin
 * @since 1.0.0  2024-07-17 10:05:10
 */
@Schema(description = "绑定权限")
@Data
public class ResourcePermissionDto {

    /**
     * 资源ID
     */
    @Schema(description = "资源ID")
    @NotBlank(message = "资源ID不能为空")
    private String resourceId;


    /**
     * 权限ID
     */
    @Schema(description = "权限ID")
    @NotEmpty(message = "权限ID不能为空")
    private List<String> permissionIdList;


}