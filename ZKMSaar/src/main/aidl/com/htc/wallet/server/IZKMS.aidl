// IZKMS.aidl
package com.htc.wallet.server;
import com.htc.wallet.server.PublicKeyHolderParcel;
import com.htc.wallet.server.ByteArrayHolderParcel;

/**
 * ZKMS SDK for Wallet APP development
 *
 * @version 2.0.0
 *
 * @since   2019/02/21
 *
 * @comment
 *   version control, modify since and version every SDK release
 *   ID.__.__  : major version, arch changed or target release, ex: architecture changed, or DVT to PVT ...
 *   __.ID.__  : minor version, interface changed, ROM update required, ex: exported API, targetSdk, java interface ...
 *   __.__.ID  : sub-minor version, self-changed,  ex: internal method, field, .so changed ...
 *   __.__.__a : alpha
 *   __.__.__b : beta
 *
 *  You should increase minor version if any modification made in this file.
 *
 * Created by hawk_wei
 */

// Declare any non-default types here with import statements
interface IZKMS {
    int init(int processId, String ZKMS_version);
    String getModuleVersion();
    String getApiVersion();
    long register(String wallet_name, String sha256);
    int isRooted();
    int createSeed(long unique_id);
    int restoreSeed(long unique_id);
    int showSeed(long unique_id);
    int clearSeed(long unique_id);
    int isSeedExists(long unique_id);
    int getTZIDHash(inout ByteArrayHolderParcel ext_idhash);
    int changePIN(long unique_id);
    int confirmPIN(long unique_id, int resId);
    PublicKeyHolderParcel getSendPublicKey(long unique_id, int coinType);
    PublicKeyHolderParcel getSendPublicKeyWithIdx(long unique_id, int coinType, int index);
    PublicKeyHolderParcel getReceivePublicKey(long unique_id, int coinType);
    PublicKeyHolderParcel getReceivePublicKeyWithIdx(long unique_id, int coinType, int index);
    int signMessage(long unique_id, int coin_type, String strJson , inout ByteArrayHolderParcel byteArrayHolder);
    int signTransaction(long unique_id, int coin_type, float rates, String strJson , inout ByteArrayHolderParcel byteArrayHolder);
    int unregister(String wallet_name, String sha256, long unique_id);
    int deinit(int processId);
    int getLastError();
}
