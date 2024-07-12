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

package org.dblue.application.module.dictionary.domain.service;

import org.dblue.application.module.dictionary.application.vo.DictionaryItemPageVo;
import org.dblue.application.module.dictionary.infrastructure.entity.Dictionary;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * 字典领域查询服务层
 *
 * @author xie jin
 * @since 1.0.0  2024/7/12 下午2:13
 */
public interface DictionaryDomainQueryService {

    /**
     * 获取全部字典信息
     *
     * @return 字典信息
     */
    List<Dictionary> getAll();


    /**
     * 获取树形字典项
     *
     * @param dictionaryId 字典ID
     * @return 字典
     */
    List<Dictionary> getItemTree(String dictionaryId);

    /**
     * 字典项分页
     *
     * @param itemPageVo 查询参数
     * @return 字典项
     */
    Page<Dictionary> page(DictionaryItemPageVo itemPageVo);
}