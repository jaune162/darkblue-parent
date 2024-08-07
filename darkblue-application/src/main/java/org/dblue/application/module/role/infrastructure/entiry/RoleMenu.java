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

package org.dblue.application.module.role.infrastructure.entiry;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.dblue.application.jpa.AbstractCreateAuditingEntity;

/**
 * 角色菜单
 */
@Getter
@Setter
@Entity
@Table(name = "tb_sys_role_menu")
public class RoleMenu extends AbstractCreateAuditingEntity {
    /**
     * 角色菜单id
     */
    @Id
    @Size(max = 64)
    @Column(name = "role_menu_id", nullable = false, length = 64)
    private String roleMenuId;

    /**
     * 角色id
     */
    @Size(max = 64)
    @Column(name = "role_id", length = 64)
    private String roleId;

    /**
     * 菜单id
     */
    @Size(max = 64)
    @Column(name = "menu_id", length = 64)
    private String menuId;


}