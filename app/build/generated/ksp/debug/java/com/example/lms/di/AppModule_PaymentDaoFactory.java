package com.example.lms.di;

import com.example.lms.data.local.AppDatabase;
import com.example.lms.data.local.PaymentDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_PaymentDaoFactory implements Factory<PaymentDao> {
  private final Provider<AppDatabase> dProvider;

  public AppModule_PaymentDaoFactory(Provider<AppDatabase> dProvider) {
    this.dProvider = dProvider;
  }

  @Override
  public PaymentDao get() {
    return paymentDao(dProvider.get());
  }

  public static AppModule_PaymentDaoFactory create(Provider<AppDatabase> dProvider) {
    return new AppModule_PaymentDaoFactory(dProvider);
  }

  public static PaymentDao paymentDao(AppDatabase d) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.paymentDao(d));
  }
}
