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

package org.dblue.application.module.role.infrastructure.repository;

import org.dblue.application.module.role.infrastructure.entiry.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * @author xie jin
 */
public interface RoleMenuRepository extends JpaRepository<RoleMenu, String> {

    /**
     * 根据菜单ID查询
     * @param menuId 菜单ID
     * @return 角色菜单
     */
    List<RoleMenu> findByMenuId(@NonNull String menuId);


    /**
     * 根据角色ID删除关联信息
     * @param roleId 角色ID
     */
    void deleteByRoleId(@NonNull String roleId);
}