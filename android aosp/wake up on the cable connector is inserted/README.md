Log :
```
    [ 6898.042469] rk_gmac-dwmac fe300000.ethernet eth0: Link is Up - 1Gbps/Full - flow control rx/tx
    08-15 06:56:33.613 464 485 I EthernetTracker: interfaceLinkStateChanged, iface: eth0, up: true
    08-15 06:56:33.613 464 570 D EthernetNetworkFactory: updateInterfaceLinkState, iface: eth0, up: true
```

Trigger point : ethernet state change

* [frameworks/base/services/core/java/com/android/server/NetworkManagementService.java](http://androidxref.com/9.0.0_r3/xref/frameworks/base/services/core/java/com/android/server/NetworkManagementService.java#462)

  ```
    458    /**
    459     * Notify our observers of an interface link state change
    460     * (typically, an Ethernet cable has been plugged-in or unplugged).
    461     */
    462    private void notifyInterfaceLinkStateChanged(String iface, boolean up) {
    463        invokeForAllObservers(o -> o.interfaceLinkStateChanged(iface, up));
    464    }
  ```

Wake up device API :

* [PowerManagerService.java](http://androidxref.com/9.0.0_r3/xref/frameworks/base/services/core/java/com/android/server/power/PowerManagerService.java#4272)
  ```
    IPowerManager pm = IPowerManager.Stub.asInterface(
            ServiceManager.getService(Context.POWER_SERVICE));

    @Override // Binder call
    public void wakeUp(long eventTime, String reason, String opPackageName) {
        if (eventTime > SystemClock.uptimeMillis()) {
            throw new IllegalArgumentException("event time must not be in the future");
        }

        mContext.enforceCallingOrSelfPermission(
                android.Manifest.permission.DEVICE_POWER, null);

        final int uid = Binder.getCallingUid();
        final long ident = Binder.clearCallingIdentity();
        try {
            wakeUpInternal(eventTime, reason, uid, opPackageName, uid);
        } finally {
            Binder.restoreCallingIdentity(ident);
        }
    }
  ```



* [PowerManager.java](http://androidxref.com/9.0.0_r3/xref/frameworks/base/core/java/android/os/PowerManager.java#935)

  ```
    PowerManager powerManager = mContext.getSystemService(PowerManager.class);

    905    /**
    906     * Forces the device to wake up from sleep.
    907     * <p>
    908     * If the device is currently asleep, wakes it up, otherwise does nothing.
    909     * This is what happens when the power key is pressed to turn on the screen.
    910     * </p><p>
    911     * Requires the {@link android.Manifest.permission#DEVICE_POWER} permission.
    912     * </p>
    913     *
    914     * @param time The time when the request to wake up was issued, in the
    915     * {@link SystemClock#uptimeMillis()} time base.  This timestamp is used to correctly
    916     * order the wake up request with other power management functions.  It should be set
    917     * to the timestamp of the input event that caused the request to wake up.
    918     *
    919     * @see #userActivity
    920     * @see #goToSleep
    921     *
    922     * @removed Requires signature permission.
    923     */
    924    public void wakeUp(long time) {
    925        try {
    926            mService.wakeUp(time, "wakeUp", mContext.getOpPackageName());
    927        } catch (RemoteException e) {
    928            throw e.rethrowFromSystemServer();
    929        }
    930    }
    931
  ```

<br/>


> base on aosp android 9