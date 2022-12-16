package space.jacksonmonteiro.flickerbrowser

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
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

        Log.d(TAG, ".onCreateOptionsMenu: $componentName")
        Log.d(TAG, ".onCreateOptionsMenu: hint is ${searchView?.queryHint}")
        Log.d(TAG, ".onCreateOptionsMenu: $searchableInfo")

        searchView?.isIconified = true
        return true
    }
}