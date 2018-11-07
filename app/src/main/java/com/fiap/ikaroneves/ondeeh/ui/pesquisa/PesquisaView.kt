package com.fiap.ikaroneves.ondeeh.ui.pesquisa

import android.support.annotation.StringRes
import com.fiap.ikaroneves.ondeeh.base.BaseView
import com.fiap.ikaroneves.ondeeh.model.Endereco

interface PesquisaView : BaseView {
    fun atualizaEndereco(endereco: Endereco) fun showError(error: String)
    fun showError(@StringRes errorResId: Int) { this.showError(getContext().getString(errorResId))
    }
    fun showLoading()
    fun hideLoading()
}