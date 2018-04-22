package br.com.rads.drunkenmaster.home

import br.com.rads.drunkenmaster.geocode.GeocodeService
import br.com.rads.drunkenmaster.geocode.PocAddress
import com.nhaarman.mockito_kotlin.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class HomePresenterTest {

    private val ADDRESS_TO_SEARCH = "address"
    private val ADDRESS_TO_SELECT = PocAddress("address", 0.0, 0.0)

    private lateinit var presenter: HomePresenter
    private val view = mock<HomeContract.View>()
    private val geocode = mock<GeocodeService>()

    @Before
    fun setUp() {
        presenter = HomePresenter(view, geocode)
    }

    @Test
    fun searchAddressSuccess() {
        presenter.searchAddress(ADDRESS_TO_SEARCH)

        val successCaptor = argumentCaptor<(List<PocAddress>) -> Unit>()
        val list = mock<List<PocAddress>>()

        verify(view, times(1)).showLoading()
        verify(geocode, times(1)).searchAddress(eq(ADDRESS_TO_SEARCH), successCaptor.capture(), any())
        successCaptor.firstValue.invoke(list)
        verify(view, times(1)).hideLoading()
        verify(view, times(1)).addressFound(list)

    }

    @Test
    fun searchAddressFail() {
        presenter.searchAddress(ADDRESS_TO_SEARCH)

        val errorCaptor = argumentCaptor<() -> Unit>()

        verify(view, times(1)).showLoading()
        verify(geocode, times(1)).searchAddress(eq(ADDRESS_TO_SEARCH), any(), errorCaptor.capture())
        errorCaptor.firstValue.invoke()
        verify(view, times(1)).hideLoading()
        verify(view, times(1)).addressNotFound()

    }

    @Test
    fun onAddressSelected() {
        presenter.addressSelected(ADDRESS_TO_SELECT)
        verify(view, times(1)).startProductListActivity(eq(ADDRESS_TO_SELECT))
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(view, geocode)
    }
}