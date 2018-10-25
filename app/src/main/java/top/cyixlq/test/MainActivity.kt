package top.cyixlq.test

import android.databinding.DataBindingUtil
import android.databinding.Observable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import top.cyixlq.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        // java代码
        // ActionBar actionBar = getActionBar();
        // if (actionBar != null) actionBar.hide()
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // 第一种将数据填充到xml文件中的方法(代码在下面这行)，我们直接实例化了一个MainViewModel赋值给BR资源中一个叫viewModel的变量
        // binding.setVariable(BR.viewModel, MainViewModel())
        // 以下是一些说明：
        // BR就是前文提到的DataBinding资源，像R文件一样自动生成，记录所有xml中data标签内的变量名称，有点像控件id的感觉
        // viewModel来自布局文件中data标签内的variable标签中的name

        // 第二种将数据填充到xml文件中的方法(代码在下面这行),viewModel这个变量名视你在xml中variable标签中的name而定
        binding.viewModel = MainViewModel()
        // 假如你的name为user,并且class名称也为User的话(name和class的名称不一定要相同)
        // 那么代码就是binding.user = User()

        // java 代码如下
        // binding.setViewModel(new MainViewModel())
        // binding.setUser(new User())
        val observeViewModel = ObserveViewModel()
        binding.observeViewModel = observeViewModel

        // 给按钮设置点击监听事件
        binding.btnAddAge.setOnClickListener {
            val lastAge = observeViewModel.age.get()
            observeViewModel.age.set(lastAge + 1)
        }
        // 监听ObserveViewModel中值的变化并进行回调处理
        observeViewModel.age.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(observable: Observable, i: Int) {
                binding.age.text = observeViewModel.age.get().toString()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        // 在Activity销毁时记得解绑，以免内存泄漏
        binding.unbind()
    }
}
