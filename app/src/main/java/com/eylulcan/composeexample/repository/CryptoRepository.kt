package com.eylulcan.composeexample.repository

import com.eylulcan.composeexample.model.Crypto
import com.eylulcan.composeexample.model.CryptoList
import com.eylulcan.composeexample.service.CryptoAPI
import com.eylulcan.composeexample.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api: CryptoAPI
){
    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getList()
        } catch(e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto()
        } catch(e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
}