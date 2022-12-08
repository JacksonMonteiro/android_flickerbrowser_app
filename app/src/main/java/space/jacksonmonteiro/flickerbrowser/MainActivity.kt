package space.jacksonmonteiro.flickerbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getRawData = GetRawData()
        getRawData.execute("https://api.flickr.com/services/feeds/photos_public.gne?tags=android,oreo&format=json&nojsoncallback=1")

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.example -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onDownloadingComplete(data: String, status: DownloadStatus) {
        if (status == DownloadStatus.OK) {
            Log.d(TAG, "onDownloadComplete called data is $data")
        } else {
            Log.d(TAG, "onDownloadCompleted failed with status $status. Error message is $data")
        }
    }
}