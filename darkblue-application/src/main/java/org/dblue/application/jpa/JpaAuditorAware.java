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

package org.dblue.application.jpa;

import org.dblue.security.user.SecurityUser;
import org.dblue.security.utils.SecurityUtils;
import org.springframework.data.domain.AuditorAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * JPA审计字段
 *
 * @author xie jin
 * @since 1.0.0  2024/6/14 下午4:18
 */
@Component
public class JpaAuditorAware implements AuditorAware<String> {
    /**
     * Returns the current auditor of the application.
     *
     * @return the current auditor.
     */
    @NonNull
    @Override
    public Optional<String> getCurrentAuditor() {
        SecurityUser securityUser = SecurityUtils.getUserByAuditor();
        if (securityUser == null) {
            return Optional.empty();
        }
        return Optional.of(securityUser.getUserId());

    }
}
