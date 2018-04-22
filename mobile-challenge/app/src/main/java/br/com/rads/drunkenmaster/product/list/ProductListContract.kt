package br.com.rads.drunkenmaster.product.list

import br.com.rads.drunkenmaster.geocode.PocAddress
import br.com.rads.drunkenmaster.product.Product

interface ProductListContract {

    interface View {
        fun hideProgress()
        fun showError()
        fun showProductList(productList: List<Product>?)
        fun startProductDetailActivity(product: Product)
    }

    interface Presenter {
        fun loadProductList(pocAddress: PocAddress)
    }

}