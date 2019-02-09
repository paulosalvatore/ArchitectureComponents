package br.com.paulosalvatore.architecturecomponents.seek_bar


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import br.com.paulosalvatore.architecturecomponents.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SeekBarFragment : Fragment() {

    private lateinit var seekBar: SeekBar
    private lateinit var seekBarViewModel: SeekBarViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_seek_bar, container, false)

        seekBar = root.findViewById(R.id.seekBar)

        activity?.let {
            seekBarViewModel = ViewModelProviders.of(it).get(SeekBarViewModel::class.java)

            subscribeSeekBar()
        }

        return root
    }

    private fun subscribeSeekBar() {
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    seekBarViewModel.seekbarValue.value = progress
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        seekBarViewModel.seekbarValue.observe(this, Observer {
            seekBar.progress = it
        })
    }
}
