  package com.android.votechain.common.data.cloud.cloud;

  import okhttp3.OkHttpClient;
  import okhttp3.logging.HttpLoggingInterceptor;
  import retrofit2.Retrofit;
  import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
  import retrofit2.converter.gson.GsonConverterFactory;

  /**
   * 04/05/16.
   */
  public abstract class ApiClient<T> {

    public T apiService;

    public ApiClient() {
      initRetrofit();
    }

    private void initRetrofit() {
      Retrofit retrofit = retrofitBuilder();
      apiService = retrofit.create(getApiService());
    }

    private Retrofit retrofitBuilder() {
      return new Retrofit.Builder().baseUrl(getBaseURL())
          .addConverterFactory(GsonConverterFactory.create())
          .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
          .client(createClientDefault())
          .build();
    }

    private OkHttpClient createClientDefault() {

      HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
      httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
    }

    protected abstract Class<T> getApiService();

    protected abstract String getBaseURL();
  }
