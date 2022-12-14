package space.jacksonmonteiro.flickerbrowser

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import space.jacksonmonteiro.flickerbrowser.databinding.ActivityPhotoDetailsBinding

class PhotoDetailsActivity : BaseActivity() {
    private lateinit var binding: ActivityPhotoDetailsBinding

    private lateinit var photoTitle: TextView
    private lateinit var photoAuthor: TextView
    private lateinit var photoTags: TextView
    private lateinit var photoItem: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPhotoDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        activateToolbar(true)

        val photo = intent.getParcelableExtra<Photo>(PHOTO_TRANSFER) as Photo
        photoTitle = findViewById(R.id.photo_title)
        photoAuthor = findViewById(R.id.photo_author)
        photoTags = findViewById(R.id.photo_tags)
        photoItem = findViewById(R.id.photo_image)

        photoTitle.text = photo.title
        photoAuthor.text = photo.author
        photoTags.text = photo.tags

        Picasso.get().load(photo.link)
            .error(R.drawable.ic_placeholder)
            .placeholder(R.drawable.ic_placeholder)
            .into(photoItem)
    }
}