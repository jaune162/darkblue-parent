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

package org.dblue.application.module.resource.application.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 资源组更新
 *
 * @author xie jin
 * @since 1.0.0  2024-07-02 16:32:47
 */
@Schema(description = "资源组更新")
@EqualsAndHashCode(callSuper = true)
@Data
public class ResourceGroupUpdateDto extends ResourceGroupDto{

    /**
     * 资源组ID
     */
    @Schema(description = "资源组ID")
    @Id
    @Size(max = 64)
    @NotBlank(message = "资源组ID不能为空")
    private String resourceGroupId;

}