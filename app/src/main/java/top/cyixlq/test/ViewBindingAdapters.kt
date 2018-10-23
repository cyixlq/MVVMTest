package top.cyixlq.test

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

@BindingAdapter(value = ["imgUrl", "app:bgRes"], requireAll = false)
fun setImgUrl(view: ImageView, url: String, res: Int) {
    Glide.with(view).load(url).into(view)
    view.setBackgroundResource(res)
}