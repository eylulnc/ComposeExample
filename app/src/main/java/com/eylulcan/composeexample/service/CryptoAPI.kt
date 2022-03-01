package com.eylulcan.composeexample.service

import com.eylulcan.composeexample.model.Crypto
import com.eylulcan.composeexample.model.CryptoList
import retrofit2.http.GET

interface CryptoAPI {

 @GET("/atilsamancioglu/IA32-CryptoComposeData/main/cryptolist.json")
 suspend fun getList() : CryptoList


 @GET("/atilsamancioglu/IA32-CryptoComposeData/main/crypto.json")
 suspend fun getCrypto() : Crypto
}