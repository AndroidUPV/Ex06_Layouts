/*
 * Copyright (c) 2022-2024 Universitat Politècnica de València
 * Authors: David de Andrés and Juan Carlos Ruiz
 *          Fault-Tolerant Systems
 *          Instituto ITACA
 *          Universitat Politècnica de València
 *
 * Distributed under MIT license
 * (See accompanying file LICENSE.txt)
 */

package upv.dadm.ex06_layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * Displays some View arrange using the given layout.
 */
class ShowLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Enable edge-to-edge display
        enableEdgeToEdge()        // Display the selected layout
        setContentView(intent.getIntExtra(LAYOUT, R.layout.activity_show_vertical))
        // Get side margins in pixels
        val sideMarginPx = resources.getDimensionPixelSize(R.dimen.side_margins)
        // Prevent the layout from overlapping with system bars in edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.top)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(sideMarginPx, systemBars.top, sideMarginPx, systemBars.bottom)
            insets
        }
        // Change the activity's title
        title = intent.getStringExtra(TITLE) ?: getString(R.string.no_title)
    }
}