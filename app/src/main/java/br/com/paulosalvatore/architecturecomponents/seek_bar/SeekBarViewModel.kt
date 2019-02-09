package br.com.paulosalvatore.architecturecomponents.seek_bar

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SeekBarViewModel : ViewModel() {
    var seekbarValue = MutableLiveData<Int>()
}
