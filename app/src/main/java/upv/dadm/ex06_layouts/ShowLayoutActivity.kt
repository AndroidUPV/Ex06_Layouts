/*
 * Copyright (c) 2022
 * David de Andrés and Juan Carlos Ruiz
 * Development of apps for mobile devices
 * Universitat Politècnica de València
 */

package upv.dadm.ex06_layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Displays some View arrange using the given layout.
 */
class ShowLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Display the selected layout
        setContentView(intent.getIntExtra(LAYOUT, R.layout.activity_show_vertical))
        // Change the activity's title
        title = intent.getStringExtra(TITLE) ?: getString(R.string.no_title)
    }
}