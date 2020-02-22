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
import javax.persistence.Table;

/**
 * @author Akinobu
 *
 */
@Entity
@Table(name = "account")
public class Account implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -5519459218530995686L;
  @Id
  @Column(name = "account_id")
  private Integer accountId;
  @Column(name = "password")
  private String password;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "last_name")
  private String lastName;
  @Column(name = "e_mail")
  private String eMail;
  @Column(name = "enable")
  private Integer enable;
  @Column(name = "display_name")
  private String displayName;

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
   * @return the password
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return this.firstName;
  }

  /**
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return this.lastName;
  }

  /**
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * @return the eMail
   */
  public String getEMail() {
    return this.eMail;
  }

  /**
   * @param eMail the eMail to set
   */
  public void setEMail(String eMail) {
    this.eMail = eMail;
  }

  /**
   * @return the enable
   */
  public Integer getEnable() {
    return this.enable;
  }

  /**
   * @param enable the enable to set
   */
  public void setEnable(Integer enable) {
    this.enable = enable;
  }

  /**
   * @return the displayName
   */
  public String getDisplayName() {
    return this.displayName;
  }

  /**
   * @param displayName the displayName to set
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

}
