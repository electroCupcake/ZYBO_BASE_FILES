Your SD Card should have the following partitions:

1. FAT32 of 32 MB to 64 MB, and label "BOOTFS"
2. EXT4 of 500 MB or more, and label "ROOTFS"

BOOTFS: Contains all files needed for bootfs.
Use: Copy any old way you like to the BOOTFS partition.

ROOTFS: Contains a lzma archive with files needed for rootfs.
Use: sudo tar --lzma -xvpf /path/to/backup.tar.lzma -C /location/of/rootfs --numeric-owner
  
Operating System Details:
USERNAME: zybo
PASSWORD: zybo
System Type: Ubuntu 16.04 ARM

If sudo in /usr/bin becomes an issue, set its chmod to 4775.

No SD card image at the moment, the signel file for github would
be too large.