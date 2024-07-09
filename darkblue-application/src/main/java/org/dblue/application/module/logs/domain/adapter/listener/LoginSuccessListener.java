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
package org.dblue.application.module.logs.domain.adapter.listener;

import org.dblue.application.module.logs.domain.service.LoginLogDomainService;
import org.dblue.security.event.LoginSuccessEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监控登录成功的事件
 *
 * @author Wang Chengwei
 * @since 1.0.0
 */
@Component
public class LoginSuccessListener implements ApplicationListener<LoginSuccessEvent> {

    private final LoginLogDomainService loginLogDomainService;

    public LoginSuccessListener(LoginLogDomainService loginLogDomainService) {
        this.loginLogDomainService = loginLogDomainService;
    }

    @Override
    public void onApplicationEvent(LoginSuccessEvent event) {
        this.loginLogDomainService.add(event.getUser().getUserId(), event.getLoginPlatform(), event.getLoginType(), event.getRequest());
    }
}