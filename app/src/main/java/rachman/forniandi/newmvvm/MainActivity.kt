package rachman.forniandi.newmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import rachman.forniandi.newmvvm.databinding.ActivityMainBinding
import rachman.forniandi.newmvvm.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel:CityViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //viewModel = ViewModelProvider(this).get(CityViewModel::class.java)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        viewModel.getCityData().observe(this, Observer{city->
            binding.imgCity.setImageDrawable(
                ResourcesCompat.getDrawable(resources,city.img,applicationContext.theme)
            )
            binding.txtCityName.text = city.name
            binding.txtCityPopulation.text = city.population.toString()
        })
    }
}