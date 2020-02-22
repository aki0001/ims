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
package com.sample.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author Akinobu
 *
 */
@Entity
@Table(name = "authority")
@IdClass(AuthorityId.class)
public class Authority implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 5662432224393181084L;

  @Column(name = "account_id")
  private Integer accountId;
  @Column(name = "role_id")
  private Integer roleId;

  /**
   * @return the accountId
   */
  @Id
  public Integer getAccountId() {
    return this.accountId;
  }

  /**
   * @param accountId the accountId to set
   */
  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }

  /**
   * @return the roleId
   */
  @Id
  public Integer getRoleId() {
    return this.roleId;
  }

  /**
   * @param roleId the roleId to set
   */
  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

}
