package smallmouth.hellokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.widget.ImageView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class ImageActivity : AppCompatActivity() {

    private lateinit var glideImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scrollView {
            verticalLayout {
                imageView(R.drawable.ic_android) {
                    backgroundColor = ContextCompat.getColor(context, R.color.red)
                }.lparams(width = wrapContent, height = wrapContent)

                imageView(R.drawable.ic_android)
                        .lparams(width = wrapContent, height = wrapContent) {
                            gravity = Gravity.CENTER
                            backgroundColor = ContextCompat.getColor(context, R.color.gray)
                        }

                imageView {
                    scaleType = ImageView.ScaleType.CENTER_CROP

                    Glide.with(context)
                            .load("http://placehold.it/256x256")
                            .into(this)
                }.lparams(width = matchParent, height = wrapContent)

                glideImg = imageView {
                    scaleType = ImageView.ScaleType.CENTER
                }.lparams(width = matchParent, height = wrapContent)

            }.lparams(width = matchParent, height = matchParent)
        }

        Glide.with(this)
                .load("http://placehold.it/256x256")
                .into(glideImg)
    }
}
