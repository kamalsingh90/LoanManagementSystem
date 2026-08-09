package com.example.lms.data.repository;

import com.example.lms.data.local.LoanDao;
import com.example.lms.data.local.PaymentDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class LoanRepository_Factory implements Factory<LoanRepository> {
  private final Provider<LoanDao> lProvider;

  private final Provider<PaymentDao> pProvider;

  public LoanRepository_Factory(Provider<LoanDao> lProvider, Provider<PaymentDao> pProvider) {
    this.lProvider = lProvider;
    this.pProvider = pProvider;
  }

  @Override
  public LoanRepository get() {
    return newInstance(lProvider.get(), pProvider.get());
  }

  public static LoanRepository_Factory create(Provider<LoanDao> lProvider,
      Provider<PaymentDao> pProvider) {
    return new LoanRepository_Factory(lProvider, pProvider);
  }

  public static LoanRepository newInstance(LoanDao l, PaymentDao p) {
    return new LoanRepository(l, p);
  }
}
