package com.example.lms.di;

import com.example.lms.data.local.AppDatabase;
import com.example.lms.data.local.LoanDao;
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
public final class AppModule_LoanDaoFactory implements Factory<LoanDao> {
  private final Provider<AppDatabase> dProvider;

  public AppModule_LoanDaoFactory(Provider<AppDatabase> dProvider) {
    this.dProvider = dProvider;
  }

  @Override
  public LoanDao get() {
    return loanDao(dProvider.get());
  }

  public static AppModule_LoanDaoFactory create(Provider<AppDatabase> dProvider) {
    return new AppModule_LoanDaoFactory(dProvider);
  }

  public static LoanDao loanDao(AppDatabase d) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.loanDao(d));
  }
}
