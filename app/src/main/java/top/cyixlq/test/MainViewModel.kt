package top.cyixlq.test

import android.databinding.*
import android.util.Log

class MainViewModel {
    // var name = "张三"
    val name = ObservableField<String>("张三")

    // var age = 15
    var age = ObservableInt(15)

    var isMan = true

    val text = ObservableField<String>("")

    val imgUrl = "https://gss0.bdstatic.com/-4o3dSag_xI4khGkpoWK1HF6hhy/baike/w%3D268%3Bg%3D0/sign=4f7bf38ac3fc1e17fdbf8b3772ab913e/d4628535e5dde7119c3d076aabefce1b9c1661ba.jpg"

    // 因为涉及双向绑定，这里必须是可观察的数据类型
    val num = ObservableInt(1)

    fun log() {
        Log.d("MyTAG", "按钮被点击了一下")
    }

    fun convertSex(): String {
        var result = "性别："
        val sex = if (isMan) "男" else "女"
        return result + sex
    }

    fun oneYearLater() {
        // age++
        val lastAge = age.get()
        age.set(lastAge + 1)
        Log.d("MyTAG", "年龄：${age.get()}")
    }
}