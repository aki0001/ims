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
package com.sample.detail;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sample.data.entity.Account;

/**
 * @author Akinobu
 *
 */
public class AccountDetails implements UserDetails {

  private static final long serialVersionUID = -4245329432709566384L;
  private Account account;
  private Collection<GrantedAuthority> authorities;

  public AccountDetails(Account account, Collection<GrantedAuthority> authorities) {
    this.account = account;
    this.authorities = authorities;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return this.authorities;
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return this.account.getEMail();
  }

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    return this.account.getPassword();
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return false;
  }
}
