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
package org.dblue.core.web;

/**
 * 分页参数
 *
 * @author Wang Chengwei
 * @since 1.0.0
 */
public interface PageParam {

    /**
     * 获取当前页码
     *
     * @return 当前页码
     */
    Long getPage();

    /**
     * 获取每页记录数
     *
     * @return 每页记录数
     */
    Long getPageSize();
}
