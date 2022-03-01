package com.eylulcan.composeexample.viewmodel

import androidx.lifecycle.ViewModel
import com.eylulcan.composeexample.model.Crypto
import com.eylulcan.composeexample.repository.CryptoRepository
import com.eylulcan.composeexample.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
) : ViewModel() {

    suspend fun getCrypto(id: String): Resource<Crypto> {
        return repository.getCrypto(id)
    }
}