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

package org.dblue.application.module.menu.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 菜单更新
 */
@EqualsAndHashCode(callSuper = true)
@Schema(description = "菜单")
@Data
public class MenuUpdateDto extends MenuDto{
    /**
     * 菜单ID
     */
    @NotBlank(message = "菜单ID不能为空")
    private String menuId;

    /**
     * 是否可用
     */
    @Schema(description = "是否可用")
    @NotNull(message = "是否可用不能为空")
    private Boolean isEnable;

}