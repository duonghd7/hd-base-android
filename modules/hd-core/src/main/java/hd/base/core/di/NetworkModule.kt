package hd.base.core.di

import okhttp3.ConnectionSpec
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

/**
 * Create on 24/01/2022
 * @author duonghd
 */

object NetworkModule {
    inline fun <reified T> init(
        isDebug: Boolean,
        timeOut: Long,
        baseUrl: String,
        services: List<Class<T>>
    ): Module {
        return module {

            single {
                val clientBuilder = OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        try {
                            val request = chain.request()
                            val requestBuilder = request.newBuilder()
                            requestBuilder.addHeader("Accept", "application/json")
                            requestBuilder.addHeader("Content-Type", "application/json")
                            return@addInterceptor chain.proceed(requestBuilder.build())
                        } catch (e: UnknownHostException) {
                            e.printStackTrace()
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                        return@addInterceptor chain.proceed(chain.request())
                    }
                /**
                 * --Add interceptor--
                 * */
                if (isDebug) {
                    val okHttpLog = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
                    clientBuilder.addInterceptor(okHttpLog)
                }
                clientBuilder.readTimeout(timeOut, TimeUnit.SECONDS)
                clientBuilder.writeTimeout(timeOut, TimeUnit.SECONDS)
                clientBuilder.connectTimeout(timeOut, TimeUnit.SECONDS)
                clientBuilder.connectionSpecs(listOf(ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT))
                clientBuilder.build()
            }

            single {
                val okHttpClient = get<OkHttpClient>()
                Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }

            services.forEach { service ->
                single {
                    val retrofit = get<Retrofit>()
                    retrofit.create(service)
                }
            }
        }
    }
}