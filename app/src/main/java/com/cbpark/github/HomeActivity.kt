package com.cbpark.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.cbpark.github.databinding.ActivityHomeBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeActivity : AppCompatActivity() {

    private val bind: ActivityHomeBinding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private val recyclerViewAdapter = RepoRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bind.root)

        val intentData = intent.getStringExtra("data").toString()

        bind.tvUserName.text = intentData

        bind.rvRepo.layoutManager = LinearLayoutManager(this@HomeActivity)
        bind.rvRepo.adapter = recyclerViewAdapter

        val disposable = GithubClient().getApi().getRepos(intentData)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { items -> recyclerViewAdapter.update(items)}
    }
}