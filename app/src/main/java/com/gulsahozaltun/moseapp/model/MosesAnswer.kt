package com.gulsahozaltun.moseapp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MosesAnswer(
    @SerializedName("moses")
    @Expose
    var moses:List<Moses>
) {
}