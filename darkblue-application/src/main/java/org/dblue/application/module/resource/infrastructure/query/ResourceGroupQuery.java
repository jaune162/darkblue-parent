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
package org.dblue.application.module.resource.infrastructure.query;

import org.dblue.application.commons.db.jpa.BaseJpaQuery;
import org.dblue.application.module.resource.infrastructure.entity.ResourceGroup;
import org.dblue.core.enums.PlatformEnum;

/**
 * @author Wang Chengwei
 * @since 1.0.0
 */
public interface ResourceGroupQuery extends BaseJpaQuery<ResourceGroup> {

    ResourceGroupQuery platform(Integer platform);

    ResourceGroupQuery platform(PlatformEnum platform);

    ResourceGroupQuery resourceGroupId(String resourceGroupId);

    ResourceGroupQuery groupName(String groupName);

    ResourceGroupQuery groupNameLike(String groupName);

    ResourceGroupQuery orderBySortNum();
}
