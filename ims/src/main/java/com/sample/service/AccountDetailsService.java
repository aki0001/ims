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
package com.sample.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sample.data.entity.Account;
import com.sample.data.entity.Authority;
import com.sample.data.entity.Role;
import com.sample.data.repository.AccountRepository;
import com.sample.data.repository.AuthorityRepository;
import com.sample.data.repository.RoleRepository;
import com.sample.detail.AccountDetails;

/**
 * @author Akinobu
 *
 */

@Service
@Transactional
public class AccountDetailsService implements UserDetailsService {

  @Autowired
  private AccountRepository accountRepository;
  @Autowired
  private AuthorityRepository authorityRepository;
  @Autowired
  private RoleRepository roleRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (username == null || "".equals(username)) {
      throw new UsernameNotFoundException("E-Mail is empty");
    }

    Account account = accountRepository.findByEMail(username).get(0);
    if (account == null) {
      throw new UsernameNotFoundException("Account not found: " + username);
    }

    if (account.getEnable() != 1) {
      throw new UsernameNotFoundException("Account not found: " + username);
    }

    AccountDetails accountDetails = new AccountDetails(account, getAuthorities(account));

    return accountDetails;
  }

  private Collection<GrantedAuthority> getAuthorities(Account account) {

    List<Authority> authorities = authorityRepository.findByAccountId(account.getAccountId());
    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    ;
    for (Authority authority : authorities) {
      Role role = roleRepository.fineByRoleId(authority.getRoleId());
      grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
    }
    return grantedAuthorities;
  }

}
