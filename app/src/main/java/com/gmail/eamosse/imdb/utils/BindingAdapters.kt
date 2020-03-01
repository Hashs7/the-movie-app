package com.gmail.eamosse.imdb.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.gmail.eamosse.imdb.R
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions



@BindingAdapter(value = ["bindImage", "radius"], requireAll = false)
fun bindImage(imageView: ImageView, url: String?, radius: Int? = null) {
    if(url == null) return
    var requestOptions = RequestOptions().transforms(CenterCrop())
    if (radius != null) {
        requestOptions = requestOptions.transforms(CenterCrop(), RoundedCorners(radius))
    }
    Glide.with(imageView)
        .load("https://image.tmdb.org/t/p/original/$url")
        .placeholder(R.drawable.ic_launcher_background)
        .error(R.drawable.ic_launcher_foreground)
        .apply(requestOptions)
        .into(imageView)
}
