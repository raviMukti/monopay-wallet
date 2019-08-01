package com.example.monolith.model.service;

import com.example.monolith.validation.BalanceMustEnough;
import com.example.monolith.validation.MemberMustExists;
import com.example.monolith.validation.MerchantMustExists;
import com.example.monolith.validation.data.BalanceData;
import com.example.monolith.validation.data.MemberData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@MemberMustExists(message = "MustExists")
@BalanceMustEnough(message = "MustEnough", withPoint = true)
public class PurchaseTransactionServiceRequest implements MemberData, BalanceData {

  @NotBlank(message = "NotBlank")
  private String memberId;

  @NotBlank(message = "NotBlank")
  @MerchantMustExists(message = "MustExists")
  private String merchantId;

  @NotNull(message = "NotNull")
  @Min(message = "TooSmall", value = 1L)
  private Long total;

}