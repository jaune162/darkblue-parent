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

import org.dblue.application.jpa.BaseJpaRepository;
import org.dblue.application.module.resource.infrastructure.entity.ResourceGroup;
import org.dblue.application.module.resource.infrastructure.query.ResourceGroupQuery;
import org.dblue.application.module.resource.infrastructure.query.impl.ResourceGroupQueryImpl;
import org.springframework.lang.NonNull;

import java.util.Optional;
/**
 * 资源组
 *
 * @author xie jin
 * @since 1.0.0  2024-07-02 17:27:01
 */
public interface ResourceGroupRepository extends BaseJpaRepository<ResourceGroup, String> {
    /**
     * 获取资源分组分平台
     *
     * @param resourceGroupId 分组ID
     * @param platform        平台
     */
    Optional<ResourceGroup> findByResourceGroupIdAndPlatform(
            @NonNull String resourceGroupId, @NonNull Integer platform);

    /**
     * 根据资源组名称查询
     * @param groupName 资源组名称
     * @param platform 平台
     * @return 资源组
     */
    Optional<ResourceGroup> findByGroupNameAndPlatform(@NonNull String groupName, @NonNull Integer platform);


    /**
     * 更新查询用
     * @param groupName 资源组名称
     * @param platform 平台
     * @param resourceGroupId 资源组ID
     * @return  资源组
     */
    Optional<ResourceGroup> findByGroupNameAndPlatformAndResourceGroupIdNot(
            @NonNull String groupName, @NonNull Integer platform, @NonNull String resourceGroupId);


    default ResourceGroupQuery createQuery() {
        return new ResourceGroupQueryImpl(this);
    }
}