package data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "d1c633ae9a8479a1b0330da283cbb35a"
// http://api.weatherstack.com/current?access_key=401a9454ac9a7b0327a6a43a2bc742cc&query=New%20York&lang=en
interface ApixuWeatherApiService {

    @GET("current.json")
    fun getCurrentWeather(@Query ("q") location: String,

    ): Deferred<CurrentWeatherResponse>

    companion object {
        operator fun invoke (): ApixuWeatherApiService {
           val requestInterceptor = Interceptor {
               chain ->
               val url = chain.request()
                       .url()
                       .newBuilder()
                       .addQueryParameter("key", API_KEY)
                       .build()
               val request = chain.request()
                       .newBuilder()
                       .url(url)
                       .build()
               return@Interceptor chain.proceed(request)
           }

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    .build()

            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://api.weatherstack.com/")
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApixuWeatherApiService::class.java)

        }
    }
}