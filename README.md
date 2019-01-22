# HerolteVibrations
Workaround App that sets the vibration intensity on lineageOS 14.1 herolte devices (Samsung Galaxy S7).

LineageOS currently provides not vibration intensity setting for herolte devices. This App uses root access to directly write a custom value.

This app is in a early development stage. Changes made to the vibration intensity setting are currently not permanent. After each reboot they need to be set again.

A current build can be downloaded [here](https://github.com/plan5/HerolteVibrations/blob/master/app/release/app-release.apk?raw=true)

**This App requires root access. This means you should have rooted your phone and installed su.** 

Also, you trust me on this and you shouldn't trust unverified sources with root access. Check the code or choose the 'direct' way: Install any Terminal Emulator App, run `su` to gain root privileges. Then run `echo 4000 > /sys/devices/virtual/timed_output/vibrator/intensity`. This will set a much lower vibration strength than the default of 8000. Play with the values (or the app) to see what suits you best.
