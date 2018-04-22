package br.com.rads.drunkenmaster.home

import br.com.rads.drunkenmaster.geocode.GeocodeService
import br.com.rads.drunkenmaster.geocode.PocAddress

class HomePresenter(val view: HomeContract.View,
                    val geocodeService: GeocodeService)
    : HomeContract.Presenter, AddressesAdapter.AddressSelectedListener {

    override fun searchAddress(address: String) {
        view.showLoading()
        geocodeService.searchAddress(address,
                {
                    view.hideLoading()
                    view.addressFound(it)
                },
                {
                    view.hideLoading()
                    view.addressNotFound()
                })
    }

    //region Address Selected Listener
    override fun addressSelected(pocAddress: PocAddress) {
        view.startProductListActivity(pocAddress)
    }
    //endregion

}