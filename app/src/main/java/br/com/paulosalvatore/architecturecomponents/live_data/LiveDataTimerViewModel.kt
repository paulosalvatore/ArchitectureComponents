package br.com.paulosalvatore.architecturecomponents.live_data

import android.os.SystemClock
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class LiveDataTimerViewModel : ViewModel() {
    companion object {
        private const val ONE_SECOND = 1000L
    }

    val elapsedTime = MutableLiveData<Long>()

    init {
        val initialTime = SystemClock.elapsedRealtime()
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                val newValue = (SystemClock.elapsedRealtime() - initialTime) / 1000
                elapsedTime.postValue(newValue)
            }
        }, ONE_SECOND, ONE_SECOND)
    }
}

