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

package org.dblue.application.module.usergroup.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 用户组
 *
 * @author xie jin
 * @since 1.0.0  2024-07-10 14:55:43
 */
@Data
public class UserGroupDto {
    /**
     * 用户组名称
     */
    @Schema(description = "用户组名称")
    @Size(max = 200)
    @NotBlank(message = "用户组名称不能为空")
    private String userGroupName;

    /**
     * 排序字段
     */
    @Schema(description = "排序字段")
    @NotNull(message = "排序字段不能为空")
    private Integer sortNum;

}