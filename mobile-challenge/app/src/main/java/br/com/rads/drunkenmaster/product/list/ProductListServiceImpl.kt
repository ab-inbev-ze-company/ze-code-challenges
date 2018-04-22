package br.com.rads.drunkenmaster.product.list

import br.com.rads.drunkenmaster.PocCategorySearchQuery
import br.com.rads.drunkenmaster.PocSearchMethodQuery
import br.com.rads.drunkenmaster.geocode.PocAddress
import br.com.rads.drunkenmaster.graphql.GraphqlProvider
import br.com.rads.drunkenmaster.product.Product
import com.apollographql.apollo.ApolloQueryCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.rx2.Rx2Apollo
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*

class ProductListServiceImpl : ProductListService {

    override fun loadProductList(pocAddress: PocAddress,
                                 productListLoaded: (List<Product>?) -> Unit,
                                 errorCallback: () -> Unit) {
        Rx2Apollo.from(loadPoc(pocAddress))
                .flatMap {
                    return@flatMap searchProducts(it.data()?.pocSearch()?.get(0)?.id())
                }
                .flatMap {
                    return@flatMap productsParsed(it.data()?.poc()?.products())
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            productListLoaded(it)
                        },
                        {
                            errorCallback()
                        })
    }

    private fun loadPoc(pocAddress: PocAddress): ApolloQueryCall<PocSearchMethodQuery.Data> {
        return GraphqlProvider
                .provideGraphql()
                .query(
                        PocSearchMethodQuery.builder()
                                .lat(pocAddress.lat.toString())
                                .lng(pocAddress.lng.toString())
                                .now(Date())
                                .algorithm("NEAREST")
                                .build()
                )
    }

    private fun searchProducts(id: String?): Observable<Response<PocCategorySearchQuery.Data>> {
        return if (id != null) {
            Rx2Apollo.from(GraphqlProvider
                    .provideGraphql()
                    .query(PocCategorySearchQuery
                            .builder()
                            .id(id)
                            .search("")
                            .categoryId(0)
                            .build()
                    )
            )
        } else {
            Observable.empty()
        }
    }

    private fun productsParsed(products: List<PocCategorySearchQuery.Product>?) =
            Observable.just(products?.map {
                Product.from(it)
            })
}