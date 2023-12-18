/*
 * Copyright (c) 2022-2023 Universitat Politècnica de València
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