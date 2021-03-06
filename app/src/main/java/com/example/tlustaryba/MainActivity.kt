package com.example.tlustaryba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    lateinit var toggle : ActionBarDrawerToggle
    lateinit var drawerLayout : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout  = findViewById(R.id.dawerLayout)
        val navView : NavigationView = findViewById(R.id.nav_view)


        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navView.setNavigationItemSelectedListener {

            it.isChecked = true
            when(it.itemId){
                R.id.nav_account -> replaceFragment(konto_fragment(), it.title.toString())
                R.id.nav_friends -> replaceFragment(freinds_fragment(), it.title.toString())
                R.id.nav_mess -> replaceFragment(messeges_fragment(), it.title.toString())
                R.id.nav_logout -> Toast.makeText(applicationContext, "Clicked wyloguj", Toast.LENGTH_SHORT).show()
                R.id.nav_atlas -> replaceFragment(atlas_fragment(), it.title.toString())
                R.id.nav_poradnik -> replaceFragment(poradnik_fragment(), it.title.toString())
                R.id.nav_map ->replaceFragment(map_fragment(), it.title.toString())
                R.id.nav_ranking -> replaceFragment(ranking_fragment(), it.title.toString())
                R.id.nav_calc -> replaceFragment(calc_fragment(), it.title.toString())
            }
            true

        }
    }

    private fun replaceFragment(fragment: Fragment, title : String){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        fragmentTransaction.commit()
        drawerLayout.closeDrawers()
        setTitle(title)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}