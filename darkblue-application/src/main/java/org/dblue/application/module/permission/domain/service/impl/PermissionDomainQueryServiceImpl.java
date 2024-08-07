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

package org.dblue.application.module.permission.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.dblue.application.commons.db.jpa.Conditions;
import org.dblue.application.module.permission.application.dto.PermissionPageDto;
import org.dblue.application.module.permission.domain.service.PermissionDomainQueryService;
import org.dblue.application.module.permission.errors.PermissionErrors;
import org.dblue.application.module.permission.infrastructure.entiry.Permission;
import org.dblue.application.module.permission.infrastructure.entiry.PermissionResource;
import org.dblue.application.module.permission.infrastructure.repository.PermissionRepository;
import org.dblue.application.module.permission.infrastructure.repository.PermissionResourceRepository;
import org.dblue.common.exception.ServiceException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 权限领域查询服务
 *
 * @author xie jin
 * @since 1.0.0  2024/6/17 下午2:58
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PermissionDomainQueryServiceImpl implements PermissionDomainQueryService {

    private final PermissionRepository permissionRepository;
    private final PermissionResourceRepository permissionResourceRepository;


    /**
     * 查询菜单下权限
     *
     * @param menuId 菜单ID
     * @return 数量
     */
    @Override
    public long countByMenuId(String menuId) {
        return permissionRepository.countByMenuId(menuId);
    }

    /**
     * 分页查询权限信息
     *
     * @param query 查询条件
     * @return 权限列表
     */
    @Override
    public Page<Permission> findByPage(PermissionPageDto query) {
        return this.permissionRepository.createQuery()
                                        .menuId(query.getMenuId(), Conditions::isNotEmpty)
                                        .platform(query.getPlatform())
                                        .permissionCodeLike(query.getPermissionCode())
                                        .permissionNameLike(query.getPermissionName())
                                        .orderByCreateTime(true)
                                        .page(query.toJpaPage());
    }

    /**
     * 权限信息
     *
     * @param permissionId 权限ID
     * @return 权限信息
     */
    @Override
    public Permission getOne(String permissionId) {
        if (StringUtils.isBlank(permissionId)) {
            throw new ServiceException(PermissionErrors.PERMISSION_ID_IS_NOT_BLANK);
        }
        Optional<Permission> optional = permissionRepository.findById(permissionId);
        if (optional.isEmpty()) {
            throw new ServiceException(PermissionErrors.PERMISSION_IS_NOT_FOUND);
        }
        return optional.get();
    }


    /**
     * 根据资源ID查询权限信息
     *
     * @param resourceId 资源ID
     * @return 权限
     */
    @Override
    public List<Permission> getPermissionByResourceId(String resourceId) {
        if (StringUtils.isBlank(resourceId)) {
            return List.of();
        }
        List<Permission> permissionList = permissionRepository.getPermissionByResourceId(resourceId);

        if (CollectionUtils.isEmpty(permissionList)) {
            return List.of();
        }
        return permissionList;
    }

    /**
     * 根据角色ID获取权限
     *
     * @param roleIdSet 角色ID
     * @return 权限
     */
    @Override
    public List<Permission> getPermissionByRoleId(Set<String> roleIdSet) {
        if (CollectionUtils.isEmpty(roleIdSet)) {
            return List.of();
        }
        return permissionRepository.getPermissionByRoleId(roleIdSet);
    }

    /**
     * 根据菜单ID获取权限
     *
     * @param menuIdSet 菜单ID
     * @return 权限
     */
    @Override
    public List<Permission> getPermissionByMenuId(Set<String> menuIdSet) {
        if (CollectionUtils.isEmpty(menuIdSet)) {
            return List.of();
        }
        return permissionRepository.findByMenuIdIn(menuIdSet);
    }

    /**
     * 根据权限ID获取权限
     *
     * @param permissionIdSet 权限
     * @return 权限
     */
    @Override
    public List<Permission> getPermissionByPermissionIds(Set<String> permissionIdSet) {
        return permissionRepository.findAllById(permissionIdSet);
    }

    /**
     * 获取全部权限
     *
     * @return 权限
     */
    @Override
    public List<Permission>
    getAll() {
        return permissionRepository.findAll();
    }

    /**
     * 根据权限ID获取资源数量
     *
     * @param permissionIdSet 权限ID
     * @return key:权限ID value:数量
     */
    @Override
    public Map<String, Long> getResourceNumByPermissionIds(Set<String> permissionIdSet) {
        List<PermissionResource> permissionResourceList = permissionResourceRepository.findAllByPermissionIdIn(permissionIdSet);
        if (CollectionUtils.isEmpty(permissionResourceList)) {
            return Map.of();
        }

        return permissionResourceList.stream()
                                     .collect(Collectors.groupingBy(PermissionResource::getPermissionId, Collectors.counting()));

    }
}
