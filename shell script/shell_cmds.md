#### switch alternative gcc version
```
# switch to gcc-5
sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-5 100
sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-4.8 50
#sudo update-alternatives --install /usr/bin/g++ g++ /usr/bin/g++-5 100
#sudo update-alternatives --install /usr/bin/g++ g++ /usr/bin/g++-4.8 50

# switch to gcc-4.8
sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-5 50
sudo update-alternatives --install /usr/bin/gcc gcc /usr/bin/gcc-4.8 100
#sudo update-alternatives --install /usr/bin/g++ g++ /usr/bin/g++-5 50
#sudo update-alternatives --install /usr/bin/g++ g++ /usr/bin/g++-4.8 50
```

#### show cpu/memory profile
```
# list hw
lshw

# CPU core counts(including Hyper Thread, HT)
sudo cat /proc/cpuinfo | grep "model name" | wc -l

# CPU version and number of physical CPUs
sudo dmidecode -t processor | grep "Version:"

# memory size
sudo cat /proc/meminfo | grep "Total"

# number of physical Memories
sudo dmidecode -t memory | grep "Size:"
```

#### format sdcard
```
$ sudo fdisk -l

    Disk /dev/sde: 29.7 GiB, 31914983424 bytes, 62333952 sectors
    Units: sectors of 1 * 512 = 512 bytes
    Sector size (logical/physical): 512 bytes / 512 bytes
    I/O size (minimum/optimal): 512 bytes / 512 bytes
    Disklabel type: gpt
    Disk identifier: D6E4D686-5A19-4C75-A3EE-D8CD080B2752

    Device        Start      End  Sectors  Size Type
    /dev/sde1     16384    24575     8192    4M unknown
    /dev/sde2     24576    32767     8192    4M unknown
    /dev/sde3     32768   131071    98304   48M unknown
    /dev/sde4    131072   229375    98304   48M unknown
    /dev/sde5    229376  3899391  3670016  1.8G unknown
    /dev/sde6   3899392  7569407  3670016  1.8G unknown
    /dev/sde7   7569408  7577599     8192    4M unknown
    /dev/sde8   7577600  7581695     4096    2M unknown
    /dev/sde9   7581696  7583743     2048    1M unknown
    /dev/sde10  7585792  8110079   524288  256M unknown
    /dev/sde11  8110080  8634367   524288  256M unknown
    /dev/sde12  8634368 58703871 50069504 23.9G unknown
    /dev/sde13 58703872 58705919     2048    1M Microsoft basic data
    /dev/sde14 58707968 58710015     2048    1M unknown
    /dev/sde15 58712064 58714111     2048    1M unknown

$ sudo fdisk /dev/sde

    p : list partition
    d : delete partition
    w : write partition table
```

#### mount net drive
```
# mount net drive
sudo umount /media/ting/netDrive/WindowsShare/Home_NbAspire/Share
sudo mount -t cifs -o username="***",password="***",rw,users,uid=1000,gid=1000 //*ip*/Share /media/ting/netDrive/WindowsShare/Home_NbAspire/Share
```

#### miscellaneous
```
# show PATH in a human-readable way
tr ':' '\n' <<< "$PATH"

# list directory size
du -shc ./* | sort -rn
```
