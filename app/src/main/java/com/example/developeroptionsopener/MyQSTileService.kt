package com.example.developeroptionsopener

import android.content.Intent
import android.provider.Settings
import android.service.quicksettings.Tile
import android.service.quicksettings.TileService
import android.util.Log
import android.widget.Toast

class MyQSTileService: TileService() {

    override fun onTileAdded() {
        super.onTileAdded()

        qsTile.state = Tile.STATE_INACTIVE
        qsTile.updateTile()
    }

    override fun onClick() {
        super.onClick()

        val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
            .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        startActivityAndCollapse(intent)
    }
}