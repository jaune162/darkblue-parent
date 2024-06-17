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

package org.dblue.application.module.permission.domain;


/**
 * 权限领域查询服务
 *
 * @author xie jin
 * @since 1.0.0  2024/6/17 下午2:55
 */
public interface PermissionDomainQueryService {


    /**
     * 查询菜单下权限
     * @param menuId 菜单ID
     * @return 数量
     */
    long countByMenuId( String menuId);
}
