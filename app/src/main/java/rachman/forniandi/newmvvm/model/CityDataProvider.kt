package rachman.forniandi.newmvvm.model

import rachman.forniandi.newmvvm.R

class CityDataProvider {

    private val cities = arrayListOf<City>()

    init {
        cities.add(City("Bangkok", R.drawable.bangkok,321300000))
        cities.add(City("Beijing", R.drawable.beijing, 677244740))
        cities.add(City("London", R.drawable.london,325456464))
        cities.add(City("New York", R.drawable.newyork,43587587))
        cities.add(City("Paris", R.drawable.paris,323426))
        cities.add(City("Rio de janeiro", R.drawable.rio,774498))
        cities.add(City("Rome", R.drawable.rome,343532))
        cities.add(City("Singapore", R.drawable.singapore,13232))
        cities.add(City("Sydney", R.drawable.sydney,634544))
        cities.add(City("Tokyo", R.drawable.tokyo,324555))
    }

    fun getCities() = cities
}