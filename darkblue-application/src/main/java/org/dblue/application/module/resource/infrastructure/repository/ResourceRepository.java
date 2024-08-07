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

package org.dblue.application.module.resource.infrastructure.repository;

import com.querydsl.core.BooleanBuilder;
import org.apache.commons.lang3.StringUtils;
import org.dblue.application.jpa.BaseJpaRepository;
import org.dblue.application.module.resource.application.dto.ResourcePageDto;
import org.dblue.application.module.resource.infrastructure.entity.QResource;
import org.dblue.application.module.resource.infrastructure.entity.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QSort;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 资源
 *
 * @author xie jin
 * @since 1.0.0  2024-07-02 17:26:36
 */
public interface ResourceRepository extends BaseJpaRepository<Resource, String> {

    /**
     * 判断资源组下是否有资源
     *
     * @param resourceGroupId 资源组ID
     * @return 是否存在
     */
    boolean existsByResourceGroupId(@NonNull String resourceGroupId);

    /**
     * 添加排重用
     *
     * @param resourceUrl 资源地址
     * @return 资源
     */
    Optional<Resource> findByResourceUrl(
            @NonNull String resourceUrl);


    /**
     * 更新排重用
     *
     * @param resourceUrl 资源地址
     * @param resourceId   资源ID
     * @return 资源
     */
    Optional<Resource> findByResourceUrlAndResourceIdNot(
            @NonNull String resourceUrl,
            @NonNull String resourceId);


    /**
     * 分页查询
     *
     * @param pageDto  查询参数
     * @param pageable 分页参数
     * @return 资源
     */
    default Page<Resource> page(ResourcePageDto pageDto, Pageable pageable) {
        BooleanBuilder builder = new BooleanBuilder();
        if (StringUtils.isNotBlank(pageDto.getResourceGroupId())) {
            builder.and(QResource.resource.resourceGroupId.eq(pageDto.getResourceGroupId()));
        }
        if (StringUtils.isNotBlank(pageDto.getResourceName())) {
            builder.and(QResource.resource.resourceName.contains(pageDto.getResourceName()));
        }
        if (StringUtils.isNotBlank(pageDto.getResourceUrl())) {
            builder.and(QResource.resource.resourceUrl.contains(pageDto.getResourceUrl()));
        }
        if (StringUtils.isNotBlank(pageDto.getController())) {
            builder.and(QResource.resource.controller.contains(pageDto.getController()));
        }
        if (StringUtils.isNotBlank(pageDto.getMethod())) {
            builder.and(QResource.resource.method.contains(pageDto.getMethod()));
        }
        if (Objects.nonNull(pageDto.getIsAuthedAccess())) {
            builder.and(QResource.resource.isAuthedAccess.eq(pageDto.getIsAuthedAccess()));
        }
        if (pageDto.getPlatform() != null) {
            builder.and(QResource.resource.platform.eq(pageDto.getPlatform()));
        }
        QSort qSort = new QSort(QResource.resource.createTime.desc());
        return page(builder, pageable, qSort);
    }

    /**
     * 根据权限ID 查询资源信息
     *
     * @param permissionId 权限ID
     * @return 资源信息
     */
    default List<Resource> getResourceByPermissionId(String permissionId) {
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(QResource.resource.permissionResourceList.any().permissionId.eq(permissionId));
        return getList(builder);
    }

}