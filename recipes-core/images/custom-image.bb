SUMMARY = "My custom Linux image."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image
inherit extrausers

# Set rootfs to 200 MiB by default
IMAGE_OVERHEAD_FACTOR ?= "1.0"
IMAGE_ROOTFS_SIZE ?= "204800"

# Change root password
EXTRA_USERS_PARAMS = "\
  usermod -P 'toor'  root \
  "

# Add custom application
IMAGE_INSTALL += "gettemp"

# Add kernel module for USB WiFi driver
IMAGE_INSTALL += "kernel-module-rtl8xxxu \
		  linux-firmware-rtl8192cu \
		  dhcp-client \
		  iw \
		  wpa-supplicant \
		  wireless-regdb-static" 

# Autoload WiFi driver on boot
KERNEL_MODULE_AUTOLOAD += "rtl8xxxu" 
