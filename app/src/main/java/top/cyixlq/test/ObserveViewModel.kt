package top.cyixlq.test

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.ObservableInt

class ObserveViewModel : BaseObservable() {

    private var firstName = "y"
    private var lastName = "c"
    val age = ObservableInt(17)

    // 这里要加上这个标签，在set方法中BR才能找到对应属性
    @Bindable
    fun getFirstName(): String {
        return firstName
    }

    @Bindable
    fun getLastName():String {
        return lastName
    }

    fun setFirstName(name:String) {
        this.firstName = name
        notifyPropertyChanged(BR.firstName)
    }

    fun setLastName(name:String) {
        this.lastName = name
        notifyPropertyChanged(BR.lastName)
    }

    // 改姓的方法
    fun changeLastName() {
        setLastName("薛")
    }

}