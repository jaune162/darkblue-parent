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
package org.dblue.core.mybatis.query;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * MyBatis 查询对象基类
 *
 * @author Wang Chengwei
 * @since 1.0.0
 * @param <T> 实体类型
 */
public abstract class AbstractBaseQuery<T> implements BaseQuery<T> {

    /**
     * 查询条件
     */
    protected final LambdaQueryWrapper<T> queryWrapper = new LambdaQueryWrapper<>();

    /**
     * 查询 Mapper
     */
    private final BaseMapper<T> mapper;

    protected AbstractBaseQuery(BaseMapper<T> mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<T> list() {
        return this.mapper.selectList(this.queryWrapper);
    }

    @Override
    public IPage<T> page(long page, long pageSize) {
        IPage<T> pageInfo = new Page<>(page, pageSize);
        return this.mapper.selectPage(pageInfo, this.queryWrapper);
    }

    @Override
    public T single() {
        return this.mapper.selectOne(this.queryWrapper);
    }
}