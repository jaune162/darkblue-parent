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

package org.dblue.application.module.department.domain.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.dblue.application.module.department.domain.service.DepartmentDomainQueryService;
import org.dblue.application.module.department.errors.DepartmentErrors;
import org.dblue.application.module.department.infrastructure.entity.Department;
import org.dblue.application.module.department.infrastructure.query.DepartmentQuery;
import org.dblue.application.module.department.infrastructure.repository.DepartmentRepository;
import org.dblue.common.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 部门领域查询服务
 *
 * @author xie jin
 * @since 1.0.0  2024/6/21 下午1:34
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentDomainQueryServiceImpl implements DepartmentDomainQueryService {

    private final DepartmentRepository departmentRepository;
    /**
     * 获取全部部门
     *
     * @return 部门信息
     */
    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    /**
     * 获取单个部门信息
     *
     * @param departmentId 部门ID
     * @return 部门信息
     */
    @Override
    public Department getOne(String departmentId) {
        if(StringUtils.isBlank(departmentId)){
            throw new ServiceException(DepartmentErrors.DEPARTMENT_ID_IS_NOT_BLANK);
        }
        Optional<Department> optional = departmentRepository.findById(departmentId);
        if (optional.isEmpty()) {
            throw new ServiceException(DepartmentErrors.DEPARTMENT_IS_NOT_FOUND);
        }
        return optional.get();
    }

    @Override
    public DepartmentQuery createQuery() {
        return this.departmentRepository.createQuery();
    }
}
