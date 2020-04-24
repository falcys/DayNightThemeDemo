package com.falc.daynightthemedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.falc.daynightthemedemo.picasso.CircleTransformation
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Picasso.get().load(R.drawable.golden_retriever).transform(CircleTransformation()).into(ivPhoto)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        menu?.findItem(R.id.night_mode)?.isChecked = App.instance?.themeManager?.getTheme()!!
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.night_mode -> {
                item.isChecked = !item.isChecked
                App.instance?.themeManager?.setTheme(item.isChecked)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
