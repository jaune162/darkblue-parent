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

package org.dblue.application.module.role.application.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.dblue.application.module.permission.infrastructure.entiry.Permission;
import org.springframework.beans.BeanUtils;


/**
 * 角色权限
 *
 * @author xie jin
 * @since 1.0.0  2024-07-08 10:52:47
 */
@Schema(description = "角色权限")
@Data
public class RolePermissionVo {
    /**
     * 权限ID
     */
    @Schema(description = "权限ID")
    private String permissionId;

    /**
     * 菜单ID
     */
    @Schema(description = "菜单ID")
    private String menuId;


    /**
     * 权限名称
     */
    @Schema(description = "权限名称")
    private String permissionName;

    /**
     * 权限标识
     */
    @Schema(description = "权限标识")
    private String permissionCode;


    public static RolePermissionVo of(Permission permission) {
        RolePermissionVo vo = new RolePermissionVo();
        BeanUtils.copyProperties(permission, vo);
        return vo;
    }


}