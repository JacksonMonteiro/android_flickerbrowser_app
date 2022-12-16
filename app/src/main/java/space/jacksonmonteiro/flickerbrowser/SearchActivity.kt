package space.jacksonmonteiro.flickerbrowser

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.preference.PreferenceManager
import space.jacksonmonteiro.flickerbrowser.databinding.ActivitySearchBinding

class SearchActivity : BaseActivity() {
    private val TAG = "SearchActivity"

    private lateinit var binding: ActivitySearchBinding
    private var searchView: SearchView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate starts")
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activateToolbar(true)
        Log.d(TAG, "onCreate ends")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Log.d("TAG", ".onCreateOptionsMenu started")
        menuInflater.inflate(R.menu.menu_search, menu)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.app_bar_search).actionView as SearchView

        var searchableInfo = searchManager.getSearchableInfo(componentName)
        searchView?.setSearchableInfo(searchableInfo)

        searchView?.isIconified = true
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d(TAG, ".onQueryTextSubmit called")

                val sharedPrefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
                sharedPrefs.edit().putString(FLICKR_QUERY, query).apply()
                searchView?.clearFocus()

                finish()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        searchView?.setOnCloseListener {
            finish()
            false
        }
        return true
    }


}