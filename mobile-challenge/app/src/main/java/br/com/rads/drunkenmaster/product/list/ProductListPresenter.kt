package br.com.rads.drunkenmaster.product.list

import br.com.rads.drunkenmaster.geocode.PocAddress
import br.com.rads.drunkenmaster.product.Product

class ProductListPresenter(private val view: ProductListContract.View,
                           private val service: ProductListService)
    : ProductListContract.Presenter, ProductListAdapter.ProductSelectedListener {

    override fun loadProductList(pocAddress: PocAddress) {
        service.loadProductList(pocAddress,
                {
                    view.hideProgress()
                    view.showProductList(it)
                },
                {
                    view.hideProgress()
                    view.showError()
                })
    }


    //region ProductSelectedListener
    override fun productSelected(product: Product) {
        view.startProductDetailActivity(product)
    }
    //endregion

}