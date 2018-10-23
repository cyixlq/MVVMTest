package top.cyixlq.test

import android.annotation.SuppressLint
import android.databinding.BindingConversion
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
@BindingConversion
fun convertIntToString(value: Long): String {
    val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return formatter.format(value)
}