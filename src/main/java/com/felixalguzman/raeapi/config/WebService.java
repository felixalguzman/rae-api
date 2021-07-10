package com.felixalguzman.raeapi.config;

import com.felixalguzman.raeapi.Constants;
import com.felixalguzman.raeapi.api.Api;
import com.felixalguzman.raeapi.config.UDRAEConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.Base64;
import java.util.concurrent.TimeUnit;


@Service
public class WebService {

    private static final String CACHE_CONTROL = "Cache-Control";

    private final Retrofit retrofit;
    private final UDRAEConfig udraeConfig;


    WebService() {
        this.udraeConfig = UDRAEConfig.getDefaultUDRAEConfig();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        this.retrofit = new Retrofit.Builder()
                .client(provideOkHttpClient())
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public String getBAHeader() {
        return "Basic " + Base64.getEncoder().encodeToString("p682JghS3:aGfUdCiE434".getBytes());
    }


    private OkHttpClient provideOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .addInterceptor(logging)
//                .addInterceptor(provideOfflineCacheInterceptor(context))
//                .addNetworkInterceptor(provideCacheInterceptor())
//                .cache(provideCache(context))

                .connectTimeout(udraeConfig.getConnectTimeout(), TimeUnit.SECONDS)
//                .sslSocketFactory(getSSLSocketFactory(context))
                .build();
    }

//    private SSLSocketFactory getSSLSocketFactory(@NonNull Context context) {
//        try {
//            KeyStore trustedStore = KeyStore.getInstance("BKS");
//            trustedStore.load(context.getResources().openRawResource(R.raw.bks_cert), "private".toCharArray());
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
//            trustManagerFactory.init(trustedStore);
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            sslContext.init(null, trustManagerFactory.getTrustManagers(), null);
//            return sslContext.getSocketFactory();
//        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException | KeyManagementException ignored) {
//        }
//        return null;
//    }

//    private Cache provideCache() {
//        Cache cache = null;
//        try {
//            cache = new Cache(new File(context.getCacheDir(), udraeConfig.getCacheFolderName()),
//                    udraeConfig.getCacheSize());
//        } catch (Exception ignored) {
//        }
//        return cache;
//    }

    private Interceptor provideCacheInterceptor() {
        return chain -> {
            Response response = chain.proceed(chain.request());

            CacheControl cacheControl = new CacheControl.Builder()
                    .maxAge(udraeConfig.getCacheDuration(), TimeUnit.DAYS)
                    .build();

            return response.newBuilder()
                    .header(CACHE_CONTROL, cacheControl.toString())
                    .build();
        };
    }

    private Interceptor provideOfflineCacheInterceptor() {
        return chain -> {
            Request request = chain.request();

//                if (!InternetUtils.isInternetAvailable(context)) {
//                    CacheControl cacheControl = new CacheControl.Builder()
//                            .maxStale(udraeConfig.getOfflineCacheDuration(), TimeUnit.DAYS)
//                            .build();

            request = request.newBuilder()
//                    .cacheControl(cacheControl)
                    .build();

            return chain.proceed(request);
        };

    }

    public Api getApiInterface() {
        return this.retrofit.create(Api.class);
    }
}
