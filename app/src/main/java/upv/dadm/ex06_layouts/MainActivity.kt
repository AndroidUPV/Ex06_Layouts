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

// Launch activity to display a Linearlayout with vertical orientation
package upv.dadm.ex06_layouts

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import upv.dadm.ex06_layouts.databinding.ActivityMainBinding

// Constants for sending information to ShowLayoutActivity
const val LAYOUT = "upv.dadm.ex06_layouts.LAYOUT"
const val TITLE = "upv.dadm.ex06_layouts.TITLE"

/**
 * Several Button let the user launch an activity that will display some View arranged
 * according to the selected kind of layout.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Get the automatically generated view binding for the layout resource
        val binding = ActivityMainBinding.inflate(layoutInflater)
        // Enable edge-to-edge display
        enableEdgeToEdge()        // Set the activity content to the root element of the generated view
        setContentView(binding.root)
        // Prevent the layout from overlapping with system bars in edge-to-edge display
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Set OnClickListener for all Buttons

        // Launch activity to display a LinearLayout with vertical orientation
        binding.bVertical.setOnClickListener {
            launchShowLayoutActivity(
                R.layout.activity_show_vertical,
                getString(R.string.vertical)
            )
        }

        // Launch activity to display a LinearLayout with horizontal orientation
        binding.bHorizontal.setOnClickListener {
            launchShowLayoutActivity(
                R.layout.activity_show_horizontal,
                getString(R.string.horizontal)
            )
        }

        // Launch activity to display a layout with nested layouts
        binding.bNested.setOnClickListener {
            launchShowLayoutActivity(
                R.layout.activity_show_nested,
                getString(R.string.nested)
            )
        }

        // Launch activity to display a RelativeLayout (deprecated)
        binding.bRelative.setOnClickListener {
            launchShowLayoutActivity(
                R.layout.activity_show_relative,
                getString(R.string.relative)
            )
        }

        // Launch activity to display a ConstraintLayout (use instead of RelativeLayout)
        binding.bConstraint.setOnClickListener {
            launchShowLayoutActivity(
                R.layout.activity_show_constraint,
                getString(R.string.constraint)
            )
        }

        // Launch activity to display a FrameLayout
        binding.bFrame.setOnClickListener {
            launchShowLayoutActivity(
                R.layout.activity_show_frame,
                getString(R.string.frame)
            )
        }

        // Launch activity to display a TableLayout
        binding.bTable.setOnClickListener {
            launchShowLayoutActivity(
                R.layout.activity_show_table,
                getString(R.string.table)
            )
        }

        // Launch activity to display a Gridlayout
        binding.bGrid.setOnClickListener {
            launchShowLayoutActivity(
                R.layout.activity_show_grid,
                getString(R.string.grid)
            )
        }
    }

    // Starts the activity with the selected layout and title
    private fun launchShowLayoutActivity(layout: Int, title: String) {
        startActivity(
            Intent(this@MainActivity, ShowLayoutActivity::class.java)
                .putExtra(LAYOUT, layout)
                .putExtra(TITLE, title)
        )
    }
}