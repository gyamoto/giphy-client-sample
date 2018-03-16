package com.gyamoto.giphy.ui.databinding

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.TransitionOptions
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("android:centerCropImageUrl")
fun ImageView.setCenterCropImageUrl(url: String) {
    setImageUrl(url, RequestOptions().centerCrop())
}

fun ImageView.setImageUrl(
        url: String,
        requestOptions: RequestOptions = RequestOptions(),
        transitionOptions: TransitionOptions<*, Drawable> = withCrossFade()) {

    Glide.with(context)
            .load(url)
            .apply(requestOptions)
            .transition(transitionOptions)
            .into(this)
}
