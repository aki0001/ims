/**
 * Copyright 2020 Akinobu,Oshima
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
package com.sample.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sample.service.AccountDetailsService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  private static final String[] PUBLIC_MATCHERS = { "/css/**", "/js/**", "/webjars/**", "/static/**" };

  @Autowired
  private AccountDetailsService accountDetailsService;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
    return bcpe;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers(PUBLIC_MATCHERS) //
        .permitAll() //
        .anyRequest().authenticated();
    http.formLogin().loginPage("/account/login") // ログインのビュー
        .loginProcessingUrl("/login") // 認証処理が実行される
        .usernameParameter("username") // ユーザー名
        .passwordParameter("password") // パスワード
        .successForwardUrl("/incident/top") // ログイン成功時のURL
        .failureUrl("/account/login?error") // ログイン失敗時のURL
        .permitAll();
    http.logout().logoutUrl("/logout") //
        .logoutSuccessUrl("/account/login")//
        .permitAll();
  }

  @Autowired
  public void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(accountDetailsService).passwordEncoder(passwordEncoder());
  }

}
