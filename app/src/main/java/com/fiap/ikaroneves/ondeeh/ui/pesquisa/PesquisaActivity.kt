package com.fiap.ikaroneves.ondeeh.ui.pesquisa

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.fiap.ikaroneves.ondeeh.R
import com.fiap.ikaroneves.ondeeh.base.BaseActivity
import com.fiap.ikaroneves.ondeeh.model.Endereco
import com.fiap.ikaroneves.ondeeh.ui.pesquisa.PesquisaPresenter
import com.fiap.ikaroneves.ondeeh.ui.pesquisa.PesquisaView

class PesquisaActivity : BaseActivity<PesquisaPresenter>(), PesquisaView {
    override fun atualizaEndereco(endereco: Endereco) {
        Toast.makeText(this,
                endereco.logradouro,
                Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: String) {
        Toast.makeText(this,
                error,
                Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        Toast.makeText(this,
                "Carregando",
                Toast.LENGTH_SHORT).show()
    }

    override fun hideLoading() {
        Toast.makeText(this,
                "Fui",
                Toast.LENGTH_SHORT).show()
    }

   override fun instantiatePresenter(): PesquisaPresenter {
       return PesquisaPresenter(this)
   }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesquisa)

        presenter.pesquisar("06413730")
    }
}
