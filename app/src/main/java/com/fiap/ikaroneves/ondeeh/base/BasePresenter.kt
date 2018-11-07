package com.fiap.ikaroneves.ondeeh.base

import com.fiap.ikaroneves.ondeeh.injection.component.DaggerPresenterInjector
import com.fiap.ikaroneves.ondeeh.injection.component.PresenterInjector
import com.fiap.ikaroneves.ondeeh.injection.module.ContextModule
import com.fiap.ikaroneves.ondeeh.injection.module.NetworkModule
import com.fiap.ikaroneves.ondeeh.ui.pesquisa.PesquisaPresenter

abstract class BasePresenter<out V : BaseView>(protected val view: V) {

    private val injector: PresenterInjector = DaggerPresenterInjector
            .builder()
            .baseView(view)
            .contextModule(ContextModule)
            .networkModule(NetworkModule)
            .build()

    init { inject()
    }

    open fun onViewCreated(){

    }

    open fun onViewDestroyed(){

    }

    private fun inject() {
        when(this) {
            is PesquisaPresenter -> injector.inject( this)

        }


    }
}