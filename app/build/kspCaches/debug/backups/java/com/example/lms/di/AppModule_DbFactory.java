package com.example.lms.di;

import android.content.Context;
import com.example.lms.data.local.AppDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_DbFactory implements Factory<AppDatabase> {
  private final Provider<Context> cProvider;

  public AppModule_DbFactory(Provider<Context> cProvider) {
    this.cProvider = cProvider;
  }

  @Override
  public AppDatabase get() {
    return db(cProvider.get());
  }

  public static AppModule_DbFactory create(Provider<Context> cProvider) {
    return new AppModule_DbFactory(cProvider);
  }

  public static AppDatabase db(Context c) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.db(c));
  }
}
