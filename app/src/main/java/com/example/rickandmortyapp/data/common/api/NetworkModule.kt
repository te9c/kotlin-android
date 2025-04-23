package com.example.rickandmortyapp.data.common.api

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.json

object NetworkModule {
    val publicClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            json()
        }
    }
}