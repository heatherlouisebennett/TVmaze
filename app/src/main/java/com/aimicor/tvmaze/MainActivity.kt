package com.aimicor.tvmaze

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aimicor.tvmaze.interactor.TvMazeInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TvMazeInteractor().listOfShowsObservable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
            {list ->

            },
            {error ->

            }
        )
    }
}
