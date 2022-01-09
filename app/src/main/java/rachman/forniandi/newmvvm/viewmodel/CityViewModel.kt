package rachman.forniandi.newmvvm.viewmodel
import android.app.Application
import android.os.Handler
import android.os.Looper
import android.os.Looper.loop
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rachman.forniandi.newmvvm.model.City
import rachman.forniandi.newmvvm.model.CityDataProvider

class CityViewModel(application: Application): AndroidViewModel(application) {
    private val cityData = MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex = 0
    private val delay = 2000L

    init {
        loop()
        Log.d("CityViewModel",application.toString())
        Log.d("CityViewModel",application.filesDir.toString())
    }

    fun getCityData(): LiveData<City> = cityData
    private fun loop(){
        Handler(Looper.getMainLooper()).postDelayed({
            updateCity()
        },delay)
    }

    private fun updateCity() {
        currentIndex++
        currentIndex %= cities.size
        cityData.value = cities[currentIndex]

        loop()
    }
}