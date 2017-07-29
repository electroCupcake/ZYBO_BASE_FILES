TARGETS = console-setup resolvconf mountkernfs.sh hostname.sh x11-common udev keyboard-setup networking urandom hwclock.sh mountdevsubfs.sh checkroot.sh mountall.sh checkfs.sh checkroot-bootclean.sh mountnfs-bootclean.sh mountnfs.sh bootmisc.sh mountall-bootclean.sh procps
INTERACTIVE = console-setup udev keyboard-setup checkroot.sh checkfs.sh
udev: mountkernfs.sh
keyboard-setup: mountkernfs.sh udev
networking: resolvconf mountkernfs.sh urandom procps
urandom: hwclock.sh
hwclock.sh: mountdevsubfs.sh
mountdevsubfs.sh: mountkernfs.sh udev
checkroot.sh: hwclock.sh mountdevsubfs.sh hostname.sh keyboard-setup
mountall.sh: checkfs.sh checkroot-bootclean.sh
checkfs.sh: checkroot.sh
checkroot-bootclean.sh: checkroot.sh
mountnfs-bootclean.sh: mountnfs.sh
mountnfs.sh: networking
bootmisc.sh: mountnfs-bootclean.sh mountall-bootclean.sh checkroot-bootclean.sh udev
mountall-bootclean.sh: mountall.sh
procps: mountkernfs.sh udev
