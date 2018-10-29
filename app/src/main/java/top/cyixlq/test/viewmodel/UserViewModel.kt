package top.cyixlq.test.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

// 新建ViewModel类
class UserViewModel : ViewModel() {
    val user = MutableLiveData<User>()
}