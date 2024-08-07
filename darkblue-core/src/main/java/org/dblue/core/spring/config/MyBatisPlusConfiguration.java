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
package org.dblue.core.spring.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.dblue.core.mybatis.AutoSetCreateUpdateInfoInnerInterceptor;
import org.dblue.core.mybatis.ExtensionBatchInsertInjector;
import org.dblue.core.mybatis.UserContext;
import org.dblue.core.spring.config.properties.CoreConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis 配置信息
 *
 * @author Wang Chengwei
 * @since 1.0.0
 */
@Configuration
@ConditionalOnClass(MybatisConfiguration.class)
public class MyBatisPlusConfiguration {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(
            CoreConfigProperties coreConfigProperties,
            @Autowired(required = false) UserContext userContext) {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        if (coreConfigProperties.isEnableOptimisticLocker()) {
            interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        }
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        if (coreConfigProperties.isAutoSetCreateUpdateInfo()) {
            interceptor.addInnerInterceptor(new AutoSetCreateUpdateInfoInnerInterceptor(userContext));
        }
        return interceptor;
    }

    @Bean
    public ExtensionBatchInsertInjector extensionBatchInsertInjector() {
        return new ExtensionBatchInsertInjector();
    }
}