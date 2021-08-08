package com.example.retrofit.network

import com.google.gson.annotations.SerializedName

data class ResponseMain (
         @SerializedName ("time") var time :Time,


         @SerializedName ("disclaimer") var disclaimer:String,

         @SerializedName ("chartName") var chartName:String,

         @SerializedName ("bpi") var bpi: Currencies)


       data class Currency ( var code:String,var symbol :String,var rate :String, var description:String,
                             var rate_float:Float)
       data class Time (var updated:String,var updatedISO:String,var updateduk:String)
       data class Currencies (var USD:Currency,
                              var GBP:Currency,
                              var EUR:Currency )