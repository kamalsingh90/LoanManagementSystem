package com.example.lms.ui;

import com.example.lms.data.repository.LoanRepository;
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
public final class LmsViewModel_Factory implements Factory<LmsViewModel> {
  private final Provider<LoanRepository> repoProvider;

  public LmsViewModel_Factory(Provider<LoanRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public LmsViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static LmsViewModel_Factory create(Provider<LoanRepository> repoProvider) {
    return new LmsViewModel_Factory(repoProvider);
  }

  public static LmsViewModel newInstance(LoanRepository repo) {
    return new LmsViewModel(repo);
  }
}
