package br.com.rads.drunkenmaster.product.list

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import br.com.rads.drunkenmaster.common.Extras
import br.com.rads.drunkenmaster.common.invisible
import br.com.rads.drunkenmaster.common.visible
import br.com.rads.drunkenmaster.geocode.PocAddress
import br.com.rads.drunkenmaster.product.Product
import br.com.rads.drunkenmaster.product.detail.ProductDetailActivity
import kotlinx.android.synthetic.main.activity_product_list.*
import rads.com.br.drunkenmaster.R


class ProductListActivity : AppCompatActivity(),
        ProductListContract.View {

    private val presenter = ProductListPresenter(this, ProductListServiceImpl())
    private val productAdapter = ProductListAdapter(mutableListOf(), presenter)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_list)
        val pocAddress = intent.getParcelableExtra(Extras.POC_ADDRESS_EXTRA) as PocAddress
        title = pocAddress.fullAddress
        presenter.loadProductList(pocAddress)

        recyclerView2.apply {
            setHasFixedSize(false)
            layoutManager = GridLayoutManager(this@ProductListActivity, 2)
            adapter = productAdapter
        }
    }

    override fun hideProgress() {
        product_list_progressBar.invisible()
    }

    override fun showError() {
        error_textView.visible()
    }

    override fun showProductList(productList: List<Product>?) {
        runOnUiThread {
            productList?.let {
                productAdapter.addAll(it)
            }
        }
    }

    override fun startProductDetailActivity(product: Product) {
        startActivity(Intent(this@ProductListActivity, ProductDetailActivity::class.java)
                .putExtra(Extras.PRODUCT_EXTRA, product))
    }
}
