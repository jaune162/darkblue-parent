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

package org.dblue.application.module.role.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * 角色设置权限
 *
 * @author xie jin
 * @since 1.0.0  2024-07-02 14:00:39
 */
@Data
public class RolePermissionDto {

    /**
     * 角色id
     */
    @Size(max = 64)
    @NotBlank(message = "角色ID不能为空")
    private String roleId;

    /**
     * 菜单信息
     */
    @Schema(description = "菜单信息")
    private List<String> menuIdList;

    /**
     * 权限信息
     */
    @Schema(description = "权限信息")
    private List<String> permissionList;

}