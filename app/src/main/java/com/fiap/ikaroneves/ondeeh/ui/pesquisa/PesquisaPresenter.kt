package com.fiap.ikaroneves.ondeeh.ui.pesquisa

import com.fiap.ikaroneves.ondeeh.base.BasePresenter
import com.fiap.ikaroneves.ondeeh.network.EnderecoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PesquisaPresenter(pesquisaView: PesquisaView) : BasePresenter<PesquisaView>(pesquisaView) {

    @Inject

    lateinit var enderecoAPI: EnderecoAPI

    private var  subscription: Disposable? = null

    fun pesquisar(cep: String) {

        subscription = enderecoAPI
                .pesquisar(cep)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnTerminate {  }
                .subscribe(
                        {
                            endereco -> view.atualizaEndereco(endereco)},
                        {
                            view.showError("Erro Desconhecido")}
                )
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        subscription?.dispose()
    }
}