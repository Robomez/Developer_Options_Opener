package com.example.developeroptionsopener

import android.content.Intent
import android.provider.Settings
import android.provider.Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS
import android.provider.Settings.ACTION_DEVICE_INFO_SETTINGS
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.widget.Toast

class MyQSTileService: TileService() {

    override fun onTileAdded() {
        super.onTileAdded()

        qsTile.state = Tile.STATE_INACTIVE
        qsTile.updateTile()
    }

    override fun onClick() {
        super.onClick()


        if (Settings.Secure.getInt(this.contentResolver,
                Settings.Global.DEVELOPMENT_SETTINGS_ENABLED, 0) != 0) {
            val intent = Intent(ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            startActivityAndCollapse(intent)
        } else {
            Toast
                .makeText(this, "Dev options disabled!", Toast.LENGTH_LONG)
                .show()

            val intent = Intent(ACTION_DEVICE_INFO_SETTINGS)
                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivityAndCollapse(intent)
        }

    }
}