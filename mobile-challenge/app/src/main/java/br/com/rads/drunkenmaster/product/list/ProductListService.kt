package br.com.rads.drunkenmaster.product.list

import br.com.rads.drunkenmaster.geocode.PocAddress
import br.com.rads.drunkenmaster.product.Product

interface ProductListService {

    fun loadProductList(pocAddress: PocAddress,
                        productListLoaded: (List<Product>?) -> Unit,
                        errorCallback: () -> Unit)

}