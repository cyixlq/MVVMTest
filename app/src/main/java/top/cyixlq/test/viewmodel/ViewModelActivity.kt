package top.cyixlq.test.viewmodel

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_view_model.*
import top.cyixlq.test.R
import top.cyixlq.test.databinding.ActivityViewModelBinding

class ViewModelActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        val userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        val binding = DataBindingUtil.setContentView<ActivityViewModelBinding>(this, R.layout.activity_view_model)
        // Java代码
        // ActivityViewModelBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_view_model)

        binding.viewModel = userViewModel
        // java代码
        // binding.setViewModel(userViewModel)

        // 创建Factory对象
        val factory = MessageViewModelFactory(Message("我是通过有参构造函数直接初始化的信息内容",
                "我是通过有参构造函数直接构造出来的信息发送人"))
        // 通过Factory对象初始化带参构造函数的ViewModel
        val messageViewModel = ViewModelProviders.of(this, factory).get(MessageViewModel::class.java)
        // 将MessageViewModel实例赋值给xml中的msg
        binding.msg = messageViewModel

        // 让xml内绑定的LiveData和Observer建立连接，也正是因为这段代码，让LiveData能感知Activity的生命周期
        binding.setLifecycleOwner(this)
        bt_vm.setOnClickListener {
            userViewModel.user.value = User("李四", 22, 1)
        }
        // java代码
        // findViewById(R.id.bt_vm).setOnClickListener(new View.OnClickListener() {
        //     userViewModel.user.setValue(new User("李四", 22, 1))
        // })
    }

    /*private lateinit var tv: TextView
    private lateinit var bt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        tv = findViewById(R.id.tv_vm)
        bt = findViewById(R.id.bt_vm)
        val userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        // 监听ViewModel中user的变化，当它变化时，将TextView重新设置文字
        userViewModel.user.observe(this, Observer {
            tv.text = it?.name
        })
        // 为按钮设置点击事件，点击后设置user的值
        bt.setOnClickListener{
            val user = User("张三", 21, 1)
            userViewModel.user.value = user
            // Java代码
            // userViewModel.user.setValue(user)
        }
    }*/
}
