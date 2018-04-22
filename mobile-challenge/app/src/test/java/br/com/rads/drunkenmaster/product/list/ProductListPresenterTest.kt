package br.com.rads.drunkenmaster.product.list

import br.com.rads.drunkenmaster.geocode.PocAddress
import br.com.rads.drunkenmaster.product.Product
import com.nhaarman.mockito_kotlin.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ProductListPresenterTest {

    private val POC_ADDRESS = PocAddress("address", 0.0, 0.0)
    private val PRODUCT = Product("name", "desc", "imageUrl", 0.0f)

    private lateinit var presenter: ProductListPresenter
    private val view = mock<ProductListContract.View>()
    private val service = mock<ProductListService>()

    @Before
    fun setUp() {
        presenter = ProductListPresenter(view, service)
    }

    @Test
    fun loadProductListSuccess() {
        presenter.loadProductList(POC_ADDRESS)
        val successCaptor = argumentCaptor<(List<Product>?) -> Unit>()
        val products = mock<List<Product>>()
        verify(service, times(1)).loadProductList(eq(POC_ADDRESS), successCaptor.capture(), any())
        successCaptor.firstValue.invoke(products)
        verify(view, times(1)).hideProgress()
        verify(view, times(1)).showProductList(products)
    }

    @Test
    fun loadProductListFail() {
        presenter.loadProductList(POC_ADDRESS)
        val errorCaptor = argumentCaptor<() -> Unit>()
        verify(service, times(1)).loadProductList(eq(POC_ADDRESS), any(), errorCaptor.capture())
        errorCaptor.firstValue.invoke()
        verify(view, times(1)).hideProgress()
        verify(view, times(1)).showError()
    }

    @Test
    fun productSelected() {
        presenter.productSelected(PRODUCT)
        verify(view, times(1)).startProductDetailActivity(eq(PRODUCT))
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(view, service)
    }
}