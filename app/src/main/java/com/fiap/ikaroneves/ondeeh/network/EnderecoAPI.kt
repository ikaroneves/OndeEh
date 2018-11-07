package com.fiap.ikaroneves.ondeeh.network

import com.fiap.ikaroneves.ondeeh.model.Endereco
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface EnderecoAPI {
    @GET("/ws/{cep}/json")
    fun pesquisar(@Path("cep") cep: String): Observable<Endereco>
}