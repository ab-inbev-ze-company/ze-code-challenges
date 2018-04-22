package br.com.rads.drunkenmaster.graphql

import br.com.rads.drunkenmaster.common.BASE_URL
import br.com.rads.drunkenmaster.common.TimeAdapters
import br.com.rads.drunkenmaster.type.CustomType
import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient


object GraphqlProvider {

    private var apolloClient: ApolloClient

    init {
        val okHttpClient = OkHttpClient.Builder()
                .build()

        apolloClient = ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .addCustomTypeAdapter(CustomType.DATETIME, TimeAdapters.dateTimeAdapter())
                .addCustomTypeAdapter(CustomType.TIME, TimeAdapters.timeAdapter())
                .build()
    }

    fun provideGraphql(): ApolloClient {
        return apolloClient
    }
}