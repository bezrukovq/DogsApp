package com.example.dogsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dogsapp.R
import com.example.dogsapp.di.component.AppComponent
import com.example.dogsapp.di.component.DaggerAppComponent
import com.example.dogsapp.di.module.AppModule
import com.example.dogsapp.di.module.NetModule
import com.example.dogsapp.di.module.ServiceModule
import com.example.dogsapp.view.fragments.dogsList.RecyclerFragment

class MainActivity : AppCompatActivity() {
    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
                appComponent = DaggerAppComponent.builder()
                    .appModule(AppModule(this.application))
                    .netModule(NetModule())
                    .serviceModule(ServiceModule())
                    .build()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, RecyclerFragment.newInstance())
                .commit()
        }
    }
}
