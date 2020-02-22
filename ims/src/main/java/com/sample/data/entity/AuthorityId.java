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

/**
 * @author Akinobu
 *
 */
public class AuthorityId implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 8458469571639947434L;
  private Integer accountId;
  private Integer roleId;

  /**
   * @return the accountId
   */
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
  public Integer getRoleId() {
    return this.roleId;
  }

  /**
   * @param roleId the roleId to set
   */
  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  public int hashCode() {
    int result;
    result = getAccountId().hashCode();
    result = 29 * result + getRoleId().hashCode();
    return result;
  }

  public boolean equals(Object other) {
    if (this == other)
      return true;
    if (!(other instanceof Authority))
      return false;

    final Authority authority = (Authority) other;

    if (!authority.getAccountId().equals(getAccountId()))
      return false;
    if (!authority.getRoleId().equals(getRoleId()))
      return false;

    return true;
  }
}
