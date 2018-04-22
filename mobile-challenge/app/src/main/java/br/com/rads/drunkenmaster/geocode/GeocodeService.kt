package br.com.rads.drunkenmaster.geocode

interface GeocodeService {
    fun searchAddress(address: String,
                      addressFound: (List<PocAddress>) -> Unit,
                      addressNotFound: () -> Unit)
}