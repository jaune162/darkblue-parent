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
import org.dblue.application.module.permission.application.dto.PermissionAddDto;
import org.dblue.application.module.permission.application.dto.PermissionUpdateDto;
import org.dblue.application.module.permission.domain.service.PermissionDomainService;
import org.dblue.application.module.permission.errors.PermissionErrors;
import org.dblue.application.module.permission.infrastructure.entiry.Permission;
import org.dblue.application.module.permission.infrastructure.repository.PermissionRepository;
import org.dblue.common.exception.ServiceException;
import org.dblue.common.id.Snowflake;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 权限领域服务
 *
 * @author xie jin
 * @since 1.0.0  2024/6/14 下午3:06
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class PermissionDomainServiceImpl implements PermissionDomainService {
    private final PermissionRepository permissionRepository;


    /**
     * 权限添加
     *
     * @param permissionAddDto 权限信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(PermissionAddDto permissionAddDto) {
        Optional<Permission> optionalPermission = permissionRepository.findByPermissionCode(permissionAddDto.getPermissionCode());
        if (optionalPermission.isPresent()) {
            throw new ServiceException(PermissionErrors.PERMISSION_EXITS);
        }
        Permission permission = new Permission();
        BeanUtils.copyProperties(permissionAddDto,permission);
        permission.setPermissionId(Snowflake.stringId());
        permissionRepository.save(permission);

    }

    /**
     * 权限更新
     *
     * @param permissionUpdateDto 权限信息
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void update(PermissionUpdateDto permissionUpdateDto) {
        Optional<Permission> optional = permissionRepository.findById(permissionUpdateDto.getPermissionId());
        if (optional.isEmpty()) {
            throw new ServiceException(PermissionErrors.PERMISSION_IS_NOT_FOUND);
        }
        BeanUtils.copyProperties(permissionUpdateDto, optional.get());
        permissionRepository.save(optional.get());
    }

    /**
     * 权限删除
     *
     * @param id 权限id
     */
    @Override
    public void delete(String id) {

        permissionRepository.deleteById(id);

    }
}