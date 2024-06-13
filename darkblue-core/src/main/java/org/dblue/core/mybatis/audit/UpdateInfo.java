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
package org.dblue.core.mybatis.audit;

import java.time.LocalDateTime;

/**
 * updateTime 和 updateUser 字段
 *
 * @author Wang Chengwei
 * @since 1.0.0
 */
public interface UpdateInfo {

    /**
     * Get update user's userId
     *
     * @return update user's userId
     */
    String getUpdateUser();

    /**
     * Set update user's userId
     *
     * @param updateUser update user's userId
     */
    void setUpdateUser(String updateUser);

    /**
     * Get update time
     *
     * @return update time
     */
    LocalDateTime getUpdateTime();

    /**
     * Set update time
     *
     * @param updateTime update Time
     */
    void setUpdateTime(LocalDateTime updateTime);
}
