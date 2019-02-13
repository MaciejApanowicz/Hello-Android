package pl.maciejapanowicz.silentmodetoggle.util;

import android.media.AudioManager;

public class RingerHelper {
    //private to prevent users from creating a RingerHelper object
    private RingerHelper () {}

    /**
     * Toggles the phone's silent mode.
     */

    public static void performToggle (AudioManager audioManager){
   // If the phone is currently silent, make it not silence. If it's currently normal - silence it.
     audioManager.setRingerMode(
             isPhoneSilent(audioManager)
             ? AudioManager.RINGER_MODE_NORMAL
             : AudioManager.RINGER_MODE_SILENT
     );
    }

    /**
     * Returns whether the phone is currently in silent mode.
     */
    public static boolean isPhoneSilent (AudioManager audioManager) {
        return audioManager.getRingerMode()
                ==AudioManager.RINGER_MODE_SILENT;
    }

}
