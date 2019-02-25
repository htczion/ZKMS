# ZKMS (Zion Key Management Service)

## 1. Introduction
ZKMS (Zion Key Management Service) is a SDK which allows users to control the seed more safety. Currently, HTC Exodus’s built-in HTC Exodus Wallet App has exported some APIs for this ZKMS SDK, all the secure operation (enter pin, show seed, sign transaction) will be operated on the trust OS and all secure data will not be exposed on android world.

## 2. Environment setup
ZKMS SDK packaged as an AAR file that can be imported to your android App project easily.

### 2.1 Put ZKMS SDK .AAR to lib folder
Copy the .AAR file which provided by HTC to your APP project lib path
```
<Project Name>\app\libs\HtcWalletSDK-release.aar
```

### 2.2 Config and Sync your build.gradle
Set dependencies in build.gradle
```
dependencies {
...
compile(name:'htcwalletsdk-release', ext:'aar')
...
}
```

### 2.3 Build your wallet APP
Press the “Make project” button or following command below to build your APP
```
./gradlew assembleRelease
```
